package ir.postgresql.simple_messenger_postgresql.service.impl;

import ir.postgresql.simple_messenger_postgresql.dto.request.UserCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserCreationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserRegistrationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.model.Group;
import ir.postgresql.simple_messenger_postgresql.model.User;
import ir.postgresql.simple_messenger_postgresql.repository.GroupRepository;
import ir.postgresql.simple_messenger_postgresql.repository.UserRepository;
import ir.postgresql.simple_messenger_postgresql.service.intf.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static ir.postgresql.simple_messenger_postgresql.util.DTOBuilderUtils.*;
import static ir.postgresql.simple_messenger_postgresql.util.EntityBuilderUtils.*;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @Override
    public UserGetResponseDTO getUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return buildUserGetResponseDTO(user, user.getGroups());
    }

    @Override
    public UserCreationResponseDTO createUser(UserCreationRequestDTO requestDTO) {
        User user = userRepository.save(buildUser(requestDTO));
        log.info("user with username {} created", user.getUsername());
        return new UserCreationResponseDTO(user.getId(), user.getUsername());
    }

    @Override
    public UserRegistrationResponseDTO register(Integer userId, Integer groupId) {
        User user = userRepository.findById(userId).orElseThrow();
        Group group = groupRepository.findById(groupId).orElseThrow();
        addGroupToUserGroups(user, group);
        log.info("user {} registered in group {}", user.getUsername(), group.getName());
        return new UserRegistrationResponseDTO(userId, groupId);
    }

    private void addGroupToUserGroups(User user, Group group) {
        List<Group> groups = user.getGroups();
        groups.add(group);
        user.setGroups(groups);
        userRepository.save(user);
    }

}
