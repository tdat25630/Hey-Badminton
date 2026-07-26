package spring_learn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_learn.demo.entity.SessionParticipant;

public interface ISessionParticipantRepository extends JpaRepository<SessionParticipant, String> {

}
