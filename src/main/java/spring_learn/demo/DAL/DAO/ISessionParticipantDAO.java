package spring_learn.demo.DAL.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring_learn.demo.entity.SessionParticipant;

import java.util.Optional;


public interface ISessionParticipantDAO {
    Optional<SessionParticipant> findById(String id);
    SessionParticipant save(SessionParticipant sessionParticipant);
    void deleteById(String id);
    Page<SessionParticipant> findAll(Pageable pageable);

}
