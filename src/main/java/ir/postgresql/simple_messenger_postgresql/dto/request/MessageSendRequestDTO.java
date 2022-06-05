package ir.postgresql.simple_messenger_postgresql.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageSendRequestDTO implements BaseRequestDTO {
    @JsonProperty("s_id")
    private Integer senderId;

    @JsonProperty("ctx")
    private String context;
}
