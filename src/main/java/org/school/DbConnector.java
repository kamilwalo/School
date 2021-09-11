package org.school;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.school.entity.*;

public class DbConnector {
    private final SessionFactory sf;

    public DbConnector(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).addAnnotatedClass(StudentDetail.class)
                .addAnnotatedClass(Lecturer.class).addAnnotatedClass(Subjects.class)
                .addAnnotatedClass(Degrees.class).addAnnotatedClass(Login.class);
        sf = configuration.buildSessionFactory();
    }

    public SessionFactory getSf() {
        return sf;
    }
}
