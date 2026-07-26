package spring_learn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_learn.demo.entity.BSession;

public interface ISessionRepository extends JpaRepository<BSession,String> {

}
