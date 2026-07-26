package spring_learn.demo.dto.request;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionParticipantRequest {
    private String sessionId;
    private String userId;
    private String guestName;
    private boolean guestGender;
    private String guestLevel;
}
