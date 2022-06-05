package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageSendResponseDTO implements BaseResponseDTO {
    @JsonProperty("m_id")
    private Integer messageId;

}
