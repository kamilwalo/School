package org.school.swing;

import com.toedter.calendar.JDateChooser;
import org.school.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CheckingPresence extends FrameOptions {
    private JPanel mainPanel;
    private JComboBox subjectComboBox;
    private JComboBox yearComboBox;
    private JTable studentTable;
    private JPanel optionsPanel;
    private JPanel tablePanel;
    private JButton backDonTSaveButton;
    private JButton saveBackButton;
    private JTextField textField1;
    private JPanel datePanel;

    private Calendar cld = Calendar.getInstance();
    private JDateChooser jdc = new JDateChooser(cld.getTime());

    public CheckingPresence(){
        super();
        setContentPane(mainPanel);
        setVisible(true);
        optionsPanel.setPreferredSize(new Dimension(450,100));

        jdc.setDateFormatString("dd/MM/yyyy");
        add(jdc);
        datePanel.add(jdc);

        setData();

        backDonTSaveButton.addActionListener(e -> {
            dispose();
            new MainWindow();
        });
        subjectComboBox.addActionListener(e -> {
            setTable();
        });
        yearComboBox.addActionListener(e -> {
            setTable();
        });
    }

    private void setTable() {
        if(subjectComboBox.getSelectedIndex()!=0 && yearComboBox.getSelectedIndex()!=0){
            startSession();
            List subjectList = session.createQuery("select s.idSubject from Subjects s join s.lecturers l where l.lecturerId=:lecturerId")
                    .setParameter("lecturerId", Account.getIdLecturer()).getResultList();
            stopSession();
            int idSubject = (int) subjectList.get(subjectComboBox.getSelectedIndex()-1);
            Year year = (Year) yearComboBox.getItemAt(yearComboBox.getSelectedIndex());
            System.out.println(year);
        }
    }

    private void setData() {
        setSubjects();
        setYear();
    }

    private void setYear() {
        startSession();
        List yearList = session.createQuery("select distinct sd.yearOfStartingStudy from StudentDetail sd").getResultList();
        stopSession();
        yearComboBox.addItem("-choose year-");
        for (Object year : yearList)
            yearComboBox.addItem(year);
    }

    private void setSubjects() {
        startSession();
        List subjectList = session.createQuery("select concat(s.nameOfSubject,' ', s.typeOfSubjects) from Subjects s join s.lecturers l where l.lecturerId=:lecturerId")
                .setParameter("lecturerId", Account.getIdLecturer()).getResultList();
        stopSession();
        subjectComboBox.addItem("-Choose subject-");
        for (Object subject : subjectList)
            subjectComboBox.addItem(subject);
    }
}
