package org.school.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @Column(name = "id_lecturer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lecturerId;

    @Column(name = "name_lecturer")
    private String name;

    @Column(name = "surname_lecturer")
    private String surname;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "subjects_lecturers", joinColumns = @JoinColumn(name = "id_lecturer"),inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private List<Subjects> subjects;

    public Lecturer() {
    }

    public Lecturer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
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

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subjects subject){
        if(subjects==null) subjects = new ArrayList<>();
        subjects.add(subject);
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId=" + lecturerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
