package org.school.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;

    @Column(name = "name_student")
    private String name;

    @Column (name = "surname_student")
    private String surname;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "student_subject",joinColumns = @JoinColumn(name = "id_student"),inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private List<Subjects>subjects;

    @OneToMany(mappedBy = "student",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch = FetchType.LAZY)
    private List<Degrees> degrees;

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addSubjects(Subjects subject){
        if(subjects==null) subjects = new ArrayList<>();
        subjects.add(subject);
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public List<Degrees> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degrees> degrees) {
        this.degrees = degrees;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addDegree(Degrees degree){
        if(degrees==null)degrees= new ArrayList<>();
        degrees.add(degree);
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
