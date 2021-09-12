package org.school.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "time_sheet")
public class TimeSheet {

    @Id
    @Column(name = "id_time_sheet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTimeSheet;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lecturer")
    private Lecturer lecturer;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    private Subjects subjects;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private Boolean presence;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private Date data;


    public TimeSheet() {
    }

    public TimeSheet(Student student, Lecturer lecturer) {
        this.student = student;
        this.lecturer = lecturer;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Integer getIdTimeSheet() {
        return idTimeSheet;
    }

    public void setIdTimeSheet(Integer idTimeSheet) {
        this.idTimeSheet = idTimeSheet;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
