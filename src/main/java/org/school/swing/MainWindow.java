package org.school.swing;

import org.school.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends FrameOptions {
    private JButton showStudentsButton;
    private JButton timeSheetButton;
    private JButton showLecturersButton;
    private JButton showSubjectsButton;
    private JLabel mainMenuLabel;
    private JPanel mainMenuPanel;
    private JPanel leftPanel;
    private JLabel accountInfoJLabel;


    public MainWindow()  {
        super();

        setContentPane(mainMenuPanel);
        mainMenuLabel.setFont(new Font("Times New Roman",Font.BOLD,60));

        accountInfoJLabel.setText("You are logged as "+ Account.getName()+" "+Account.getSurname());

        setVisible(true);

        showStudentsButton.addActionListener(e -> {
            new ShowStudents();
            dispose();
        });
        timeSheetButton.addActionListener(e -> {
            dispose();
            new CheckingPresence();
        });
    }
}
