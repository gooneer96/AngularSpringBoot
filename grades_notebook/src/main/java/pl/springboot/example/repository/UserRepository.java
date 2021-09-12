package pl.springboot.example.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.springboot.example.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByLogin(String login);

}
