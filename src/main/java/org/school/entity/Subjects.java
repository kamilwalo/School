package org.school.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Integer idSubject;

    @Column(name = "name_of_subjcet")
    private String nameOfSubject;

    @Column(name = "type_od_subject")
    private String typeOfSubjects;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "subjects_lecturers", joinColumns = @JoinColumn(name = "id_subject"),inverseJoinColumns = @JoinColumn(name = "id_lecturer"))
    private List<Lecturer> lecturers;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "student_subject",joinColumns = @JoinColumn(name = "id_subject"),inverseJoinColumns = @JoinColumn(name = "id_student"))
    private List<Student> students;

    @OneToMany(mappedBy = "subjects", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch = FetchType.LAZY)
    private List<Degrees> degrees;

    public Subjects() {
    }

    public Subjects(String nameOfSubject, String typeOfSubjects) {
        this.nameOfSubject = nameOfSubject;
        this.typeOfSubjects = typeOfSubjects;
    }

    public List<Degrees> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degrees> degrees) {
        this.degrees = degrees;
    }

    public void addStudent(Student student){
        if(students== null) students = new ArrayList<>();
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }


    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public String getTypeOfSubjects() {
        return typeOfSubjects;
    }

    public void setTypeOfSubjects(String typeOfSubjects) {
        this.typeOfSubjects = typeOfSubjects;
    }

    public void addLecturer(Lecturer lecturerAdd){
        if(lecturers==null)lecturers = new ArrayList<>();
        lecturers.add(lecturerAdd);
    }

    public void addDegree(Degrees degree){
        if(degrees ==null) degrees = new ArrayList<>();
        degrees.add(degree);
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "id_subject=" + idSubject +
                ", nameOfSubject='" + nameOfSubject + '\'' +
                ", typeOfSubjects='" + typeOfSubjects + '\'' +
                ", lecturer=" + lecturers +
                '}';
    }
}
