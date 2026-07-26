package spring_learn.demo.DAL.DAOImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import spring_learn.demo.DAL.DAO.ISessionParticipantDAO;
import spring_learn.demo.entity.SessionParticipant;
import spring_learn.demo.repository.ISessionParticipantRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionParticipantDAOImpl implements ISessionParticipantDAO {

    private final ISessionParticipantRepository iSessionParticipantRepository;


    @Override
    public Optional<SessionParticipant> findById(String id) {
        return iSessionParticipantRepository.findById(id);
    }

    @Override
    public SessionParticipant save(SessionParticipant sessionParticipant) {
        return iSessionParticipantRepository.save(sessionParticipant);
    }

    @Override
    public void deleteById(String id) {
        iSessionParticipantRepository.deleteById(id);
    }


    @Override
    public Page<SessionParticipant> findAll(Pageable pageable) {
        return iSessionParticipantRepository.findAll(pageable);
    }
}
