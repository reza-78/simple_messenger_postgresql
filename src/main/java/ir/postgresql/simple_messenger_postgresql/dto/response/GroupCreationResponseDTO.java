package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GroupCreationResponseDTO extends CreationResponseDTO{
    @JsonProperty("g_name")
    private final String groupName;

    public GroupCreationResponseDTO(@JsonProperty("g_id") Integer id, String groupName) {
        super(id);
        this.groupName = groupName;
    }
}
