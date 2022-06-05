package ir.postgresql.simple_messenger_postgresql.control;

import ir.postgresql.simple_messenger_postgresql.dto.request.UserCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.request.UserRegistrationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserCreationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.UserRegistrationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    private ResponseEntity<UserCreationResponseDTO> createUser(@RequestBody UserCreationRequestDTO requestDTO) {
        return new ResponseEntity<>(userService.createUser(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserGetResponseDTO> getUser(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/{userId}/registration")
    private ResponseEntity<UserRegistrationResponseDTO> register(@PathVariable Integer userId, @RequestBody UserRegistrationRequestDTO requestDTO) {
        return new ResponseEntity<>(userService.register(userId, requestDTO.getGroupId()), HttpStatus.CREATED);
    }
}
