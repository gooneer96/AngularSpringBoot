package pl.springboot.example.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "grade")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Grade {

    private long id;
    private float grade;
    private String note;

    public Student studentId;

    public Subject subjectId;

    public Grade() {

    }

    public Grade(float grade, String note, Student studentId, Subject subjectId) {
        this.grade = grade;
        this.note = note;
        this.studentId=studentId;
        this.subjectId=subjectId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "grade", nullable = false)
    public float getGrade() {
        return grade;
    }
    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Column(name = "note", nullable = false)
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public Student getStudentId() {
        return studentId;
    }
    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "id", nullable = false)
    public Subject getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }


    @Override
    public String toString() {
        return "Grade [id=" + id + ", grade=" + grade + ", note=" + note + "]";
    }

}
