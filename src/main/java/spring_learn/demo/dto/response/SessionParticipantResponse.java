package spring_learn.demo.dto.response;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionParticipantResponse {
    private String sessionId;
    private String userId;
    private String guestName;
    private boolean guestGender;
    private String guestLevel;
}
