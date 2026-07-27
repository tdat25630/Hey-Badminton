package spring_learn.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring_learn.demo.entity.BSession;
import spring_learn.demo.entity.SessionParticipant;

public interface ISessionParticipantRepository extends JpaRepository<SessionParticipant, String> {


    @Query("SELECT sp FROM SessionParticipant sp WHERE sp.sessionId.id = :sessionId")
    Page<SessionParticipant> findBySessionId(@Param("sessionId") String sessionId, Pageable pageable);

}
