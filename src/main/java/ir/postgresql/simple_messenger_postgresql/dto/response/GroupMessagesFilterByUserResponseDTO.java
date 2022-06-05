package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupMessagesFilterByUserResponseDTO {
    @JsonProperty("u_id")
    private Integer userId;
    @JsonProperty("u_messages")
    private List<MessageResponseDTO> messages;
}
