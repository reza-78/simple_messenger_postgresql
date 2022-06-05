package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserCreationResponseDTO extends CreationResponseDTO{
    @JsonProperty("username")
    private final String username;

    public UserCreationResponseDTO(@JsonProperty("u_id") Integer id, String username) {
        super(id);
        this.username = username;
    }
}
