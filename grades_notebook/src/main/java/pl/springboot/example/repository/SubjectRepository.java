package pl.springboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.springboot.example.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
