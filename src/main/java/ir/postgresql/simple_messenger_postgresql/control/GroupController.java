package ir.postgresql.simple_messenger_postgresql.control;

import ir.postgresql.simple_messenger_postgresql.dto.request.GroupCreationRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.request.MessageSendRequestDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupCreationResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.GroupMessagesGetResponseDTO;
import ir.postgresql.simple_messenger_postgresql.dto.response.MessageSendResponseDTO;
import ir.postgresql.simple_messenger_postgresql.service.impl.GroupServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupServiceImpl groupService;

    @GetMapping("/{id}")
    private ResponseEntity<GroupGetResponseDTO> getGroup(@PathVariable Integer id) {
        return new ResponseEntity<>(groupService.getGroup(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<GroupCreationResponseDTO> createGroup(@RequestBody GroupCreationRequestDTO requestDTO) {
        return new ResponseEntity<>(groupService.createGroup(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/{groupId}/messages")
    private ResponseEntity<MessageSendResponseDTO> sendMessage(@PathVariable Integer groupId, @RequestBody MessageSendRequestDTO requestDTO) {
        return new ResponseEntity<>(groupService.sendMessage(groupId, requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{groupId}/messages")
    private ResponseEntity<GroupMessagesGetResponseDTO> getGroupMessages(@PathVariable Integer groupId, @RequestParam(required = false) Integer userId) {
        return new ResponseEntity<>(groupService.getGroupMessages(groupId, userId), HttpStatus.OK);
    }


}
