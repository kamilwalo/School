package org.school.swing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.school.DbConnector;

import javax.swing.*;
import java.awt.*;

public abstract class FrameOptions extends JFrame {
    protected DbConnector dbConnector = new DbConnector();
    protected SessionFactory sf = dbConnector.getSf();
    protected Session session = sf.getCurrentSession();


    protected FrameOptions(){
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("university");
    }

    protected void startSession(){
        session = sf.getCurrentSession();
        session.beginTransaction();
    }

    protected void stopSession(){
        session.getTransaction().commit();
    }

}
