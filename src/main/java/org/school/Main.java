package org.school;


import com.mysql.cj.log.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.school.entity.*;
import org.school.swing.Login;
import org.school.swing.MainWindow;

public class Main{

    public static void main(String[] args) {
//        new MainWindow();
        new MainWindow();

//        DbConnector dbConnector = new DbConnector();
//        SessionFactory sf= dbConnector.getSf();
//        Session session = sf.getCurrentSession();
//
//        Degrees degrees = new Degrees();
//        degrees.setDegree(5);
//
//        Subjects subjects = new Subjects("Math","Lecture");
//
//        session.beginTransaction();
//
//        session.persist(subjects);
//
//        Student student = session.get(Student.class, 1);
//
//        degrees.setSubjects(subjects);
//        degrees.setStudent(student);
//
//        session.persist(degrees);
//
//        session.getTransaction().commit();
    }
}
