package spring_learn.demo.DAL.DAOImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import spring_learn.demo.DAL.DAO.ISessionDAO;
import spring_learn.demo.entity.BSession;
import spring_learn.demo.repository.ISessionRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionDAOImpl implements ISessionDAO {

    private final ISessionRepository iSessionRepository;



    @Override
    public Optional<BSession> findById(String id) {
        return iSessionRepository.findById(id);
    }

    @Override
    public Page<BSession> findAll(Pageable pageable) {
        return iSessionRepository.findAll(pageable);
    }

    @Override
    public BSession save(BSession session) {
        return iSessionRepository.save(session);
    }

    @Override
    public void deleteById(String id) {
        iSessionRepository.deleteById(id);
    }


}
