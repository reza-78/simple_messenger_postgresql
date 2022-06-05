package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GroupResponseDTO {
    @JsonProperty("g_id")
    private final Integer groupId;
    @JsonProperty("g_name")
    private final String groupName;
}
