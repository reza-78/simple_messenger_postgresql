package ir.postgresql.simple_messenger_postgresql.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupMessagesGetResponseDTO {
    @JsonProperty("g_id")
    private Integer groupId;

    @JsonProperty("messages")
    private List<MessageResponseDTO> messageResponseDTOList;
}
