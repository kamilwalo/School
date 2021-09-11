package org.school.swing;

import org.hibernate.Session;
import org.school.DbConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends FrameOptions {
    private JButton showStudentsButton;
    private JButton showDegreesButton;
    private JButton showLecturersButton;
    private JButton showSubjcectsButton;
    private JLabel mainMenuLabel;
    private JPanel mainMenuPanel;



    public MainWindow()  {
        super();
        setContentPane(mainMenuPanel);
        mainMenuLabel.setFont(new Font("Times New Roman",Font.BOLD,60));

        setVisible(true);

        showStudentsButton.addActionListener(e -> {
            new ShowStudents();
            dispose();
        });
        showLecturersButton.addActionListener(e -> {
            new ShowLecturers();
            dispose();
        });
    }
}
