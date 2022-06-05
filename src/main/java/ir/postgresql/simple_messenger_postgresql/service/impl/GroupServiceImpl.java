package ir.postgresql.simple_messenger_postgresql.service.impl;

import ir.postgresql.simple_messenger_postgresql.dto.request.GroupCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.request.MessageSendRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupCreationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupMessagesGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.MessageSendResponseDTO;
import ir.postgresql.simple_messenger_postgresql.model.Group;
import ir.postgresql.simple_messenger_postgresql.model.Message;
import ir.postgresql.simple_messenger_postgresql.model.User;
import ir.postgresql.simple_messenger_postgresql.repository.GroupRepository;
import ir.postgresql.simple_messenger_postgresql.repository.MessageRepository;
import ir.postgresql.simple_messenger_postgresql.repository.UserRepository;
import ir.postgresql.simple_messenger_postgresql.service.intf.GroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static ir.postgresql.simple_messenger_postgresql.util.DTOBuilderUtils.*;
import static ir.postgresql.simple_messenger_postgresql.util.EntityBuilderUtils.*;

@Service
@AllArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Override
    public GroupGetResponseDTO getGroup(Integer groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        return buildGroupGetResponseDTO(group, group.getMembers());
    }

    @Override
    public GroupCreationResponseDTO createGroup(GroupCreationRequestDTO requestDTO) {
        Group group = groupRepository.save(buildGroup(requestDTO));
        log.info("group with name {} created", group.getName());
        return new GroupCreationResponseDTO(group.getId(), group.getName());
    }

    @Override
    public MessageSendResponseDTO sendMessage(Integer groupId, MessageSendRequestDTO requestDTO) {
        User sender = userRepository.findById(requestDTO.getSenderId()).orElseThrow();
        Group group = groupRepository.findById(groupId).orElseThrow();
        if (isUserRegistered(group, sender.getId())) {
            Message message = messageRepository.save(buildMessage(requestDTO, sender, group));
            log.info("message with context {} sent", message.getContext());
            return new MessageSendResponseDTO(message.getId());
        }
        return null;
    }

    @Override
    public GroupMessagesGetResponseDTO getGroupMessages(Integer groupId, Integer userId) {
        List<Message> messageList;
        Group group = groupRepository.findById(groupId).orElseThrow();
        if (userId != null) {
            User sender = userRepository.findById(userId).orElseThrow();
            messageList = messageRepository.findAllByGroupAndSender(group, sender);
        } else {
            messageList = group.getMessages();
        }
        return buildGroupMessagesGetResponseDTO(groupId, messageList);
    }

    private boolean isUserRegistered(Group group, Integer userId) {
        for (User member : group.getMembers())
            if (member.getId().equals(userId))
                return true;
        log.warn("user with id {} try to send message to group {} without registration", userId, group.getId());
        return false;
    }

}
