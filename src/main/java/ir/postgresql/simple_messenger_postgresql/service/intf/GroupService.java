package ir.postgresql.simple_messenger_postgresql.service.intf;

import ir.postgresql.simple_messenger_postgresql.dto.request.GroupCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.request.MessageSendRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupCreationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupMessagesGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.MessageSendResponseDTO;

public interface GroupService {
    GroupGetResponseDTO getGroup(Integer groupId);
    GroupCreationResponseDTO createGroup(GroupCreationRequestDTO requestDTO);
    MessageSendResponseDTO sendMessage(Integer groupId, MessageSendRequestDTO requestDTO);
    GroupMessagesGetResponseDTO getGroupMessages(Integer groupId, Integer userId);
}
