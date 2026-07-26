package spring_learn.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SessionParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "session_id")
    private BSession sessionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String guestName;

    private boolean guestGender;

    private String guestLevel;

}
