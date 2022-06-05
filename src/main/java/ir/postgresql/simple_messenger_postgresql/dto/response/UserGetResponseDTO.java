package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserGetResponseDTO implements BaseResponseDTO {
    @JsonProperty("username")
    private final String username;

    @JsonProperty("groups")
    private final List<GroupResponseDTO> groups;
}
