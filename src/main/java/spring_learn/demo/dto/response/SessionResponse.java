package spring_learn.demo.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionResponse {
    private String sessionId;
    private String description;
}
