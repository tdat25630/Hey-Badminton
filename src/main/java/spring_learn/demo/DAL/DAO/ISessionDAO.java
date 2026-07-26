package spring_learn.demo.DAL.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring_learn.demo.entity.BSession;

import java.util.Optional;

public interface ISessionDAO {
    Optional<BSession> findById(String id);
    Page<BSession> findAll(Pageable pageable);
    BSession save(BSession session);
    void deleteById(String id);
}
