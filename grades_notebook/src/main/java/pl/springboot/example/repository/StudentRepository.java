package pl.springboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.springboot.example.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
