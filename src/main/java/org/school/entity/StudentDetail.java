package org.school.entity;



import org.school.entity.Coverters.YearConverter;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "student_detail")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student_detail", nullable = false)
    private Integer studentDetailId;

    @OneToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @Column(name = "major")
    private String major;

    @Column(name = "phone")
    private String phone;

    @Column(name = "year_of_starting_study")
    @Convert(converter = YearConverter.class)
    private Year yearOfStartingStudy;

    public StudentDetail() {
    }

    public StudentDetail(Student student, String adres, String phone, Year admissionYear) {
        this.student = student;
        this.major = adres;
        this.phone = phone;
        this.yearOfStartingStudy = admissionYear;
    }

    public void setStudentDetailId(Integer studentDetailId) {
        this.studentDetailId = studentDetailId;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setYearOfStartingStudy(Year yearOfStartingStudy) {
        this.yearOfStartingStudy = yearOfStartingStudy;
    }

    public Year getYearOfStartingStudy() {
        return yearOfStartingStudy;
    }

    public String getPhone() {
        return phone;
    }

    public int getStudentDetailId() {
        return studentDetailId;
    }

    public String getMajor() {
        return major;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "studentDetailId=" + studentDetailId +
                ", student=" + student +
                ", adres='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", admissionYear=" + yearOfStartingStudy +
                '}';
    }
}
