package ir.postgresql.simple_messenger_postgresql.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupCreationRequestDTO implements BaseRequestDTO{
    @JsonProperty("g_name")
    private String groupName;
}
