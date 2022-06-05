package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GroupGetResponseDTO implements BaseResponseDTO{
    @JsonProperty("g_name")
    private final String groupName;

    @JsonProperty("members")
    private final List<UserResponseDTO> members;
}
