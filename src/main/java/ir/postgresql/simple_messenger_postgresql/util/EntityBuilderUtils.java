package ir.postgresql.simple_messenger_postgresql.util;

import ir.postgresql.simple_messenger_postgresql.dto.request.GroupCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.request.MessageSendRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.request.UserCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.model.Group;
import ir.postgresql.simple_messenger_postgresql.model.Message;
import ir.postgresql.simple_messenger_postgresql.model.User;

import java.util.List;

public class EntityBuilderUtils {
    public static User buildUser(UserCreationRequestDTO requestDTO) {
        return User.builder()
                .username(requestDTO.getUsername())
                .groups(List.of())
                .build();
    }

    public static Group buildGroup(GroupCreationRequestDTO requestDTO) {
        return Group.builder()
                .name(requestDTO.getGroupName())
                .members(List.of())
                .build();
    }

    public static Message buildMessage(MessageSendRequestDTO requestDTO, User sender, Group group) {
        return Message.builder()
                .context(requestDTO.getContext())
                .sender(sender)
                .group(group)
                .build();
    }
}
