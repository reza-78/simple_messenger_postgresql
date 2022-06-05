package ir.postgresql.simple_messenger_postgresql.util;

import ir.postgresql.simple_messenger_postgresql.dto.response.*;
import ir.postgresql.simple_messenger_postgresql.model.Group;
import ir.postgresql.simple_messenger_postgresql.model.Message;
import ir.postgresql.simple_messenger_postgresql.model.User;

import java.util.ArrayList;
import java.util.List;

public class DTOBuilderUtils {

    public static UserGetResponseDTO buildUserGetResponseDTO(User user, List<Group> groups) {
        return new UserGetResponseDTO(user.getUsername(), buildGroupResponseDTOList(groups));
    }

    public static GroupGetResponseDTO buildGroupGetResponseDTO(Group group, List<User> users) {
        return new GroupGetResponseDTO(group.getName(), buildUserResponseDTOList(users));
    }

    public static GroupMessagesGetResponseDTO buildGroupMessagesGetResponseDTO(Integer groupId, List<Message> messages) {
        return new GroupMessagesGetResponseDTO(groupId, buildMessageResponseDTOList(messages));
    }

    private static List<GroupResponseDTO> buildGroupResponseDTOList(List<Group> groups) {
        List<GroupResponseDTO> groupResponseDTOList = new ArrayList<>();
        for (Group group : groups) {
            groupResponseDTOList.add(new GroupResponseDTO(group.getId(), group.getName()));
        }
        return groupResponseDTOList;
    }

    private static List<UserResponseDTO> buildUserResponseDTOList(List<User> users) {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : users) {
            userResponseDTOList.add(new UserResponseDTO(user.getId(), user.getUsername()));
        }
        return userResponseDTOList;
    }

    private static List<MessageResponseDTO> buildMessageResponseDTOList(List<Message> messages) {
        List<MessageResponseDTO> messageResponseDTOList = new ArrayList<>();
        for (Message message : messages) {
            messageResponseDTOList.add(new MessageResponseDTO(message.getId(), message.getContext()));
        }
        return messageResponseDTOList;
    }
}
