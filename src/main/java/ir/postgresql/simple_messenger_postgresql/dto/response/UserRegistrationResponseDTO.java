package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRegistrationResponseDTO implements BaseResponseDTO {
    @JsonProperty("u_id")
    private final Integer userId;
    @JsonProperty("g_id")
    private final Integer groupId;
}
