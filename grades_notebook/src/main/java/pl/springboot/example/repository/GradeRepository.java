package pl.springboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.springboot.example.model.Grade;
import pl.springboot.example.model.Student;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{

    @Query("from Grade r inner join fetch r.studentId where r.studentId= :studentId")
    List<Grade> findByStudentId(@Param("studentId") Student id);

}
