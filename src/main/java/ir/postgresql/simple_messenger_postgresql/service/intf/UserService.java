package ir.postgresql.simple_messenger_postgresql.service.intf;


import ir.postgresql.simple_messenger_postgresql.dto.request.UserCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserCreationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserRegistrationResponseDTO;

public interface UserService {
    UserGetResponseDTO getUser(Integer userId);
    UserCreationResponseDTO createUser(UserCreationRequestDTO requestDTO);
    UserRegistrationResponseDTO register(Integer userId, Integer groupId);
}
