package ir.postgresql.simple_messenger_postgresql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class CreationResponseDTO implements BaseResponseDTO{
    private Integer id;
}
