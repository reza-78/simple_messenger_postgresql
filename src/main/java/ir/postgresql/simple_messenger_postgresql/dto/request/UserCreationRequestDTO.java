package ir.postgresql.simple_messenger_postgresql.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserCreationRequestDTO implements BaseRequestDTO{
    @JsonProperty("username")
    private String username;
}
