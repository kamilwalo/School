package org.school.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ShowStudents extends FrameOptions {
    private JPanel mainPanel;
    private JButton backToMainMenuButton;
    private JTable listOfStudentsTable;
    private JTable listOfDetailsTable;
    private JLabel titleJLabel;
    private JTextField searchStudentTextField;
    private JButton searchButton;

    /*
    * @param students contains list of students, which are in the db. The point of this param is to not take
    * the data from db every time, when user need that.
    * */

    private List students;

    public ShowStudents(){
        super();
        setContentPane(mainPanel);
        setDataToStudentTable();
        titleJLabel.setFont(new Font("Times New Roman",Font.BOLD,40));

        setVisible(true);

        backToMainMenuButton.addActionListener(e -> {
            new MainWindow();
            dispose();
        });


        listOfStudentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDataToStudentDetailTable(listOfStudentsTable.getSelectedRow());
            }
        });
        searchButton.addActionListener(e -> searchForUser());
    }


    //this method is looking for student by username/surname/idStudent
    private void searchForUser() {
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"id_student","name","surname"},0);
        listOfStudentsTable.setModel(dtm);

        startSession();
        students = session.createQuery("select s.idStudent, s.name, s.surname from Student s " +
                        "where s.name like :text or s.surname like :text or s.idStudent like :text")
                .setParameter("text","%"+searchStudentTextField.getText()+"%")
                .getResultList();
        stopSession();

        for (Object student : students)
            dtm.addRow((Object[]) student);
    }

    //this method is adding data to detailTable, which click user
    private void setDataToStudentDetailTable(int selectedRow) {
            DefaultTableModel dtm = new DefaultTableModel(new String[]{"1", "2"}, 0);
            listOfDetailsTable.setModel(dtm);

            startSession();
            Object[] student = (Object[]) session.createQuery("select sd.major, sd.phone,sd.yearOfStartingStudy from StudentDetail sd " +
                            "join sd.student s where s.idStudent=:idStudent")
                    .setParameter("idStudent", ((Object[]) students.get(selectedRow))[0])
                    .getSingleResult();
            stopSession();

            List<Object[]> list = new ArrayList<>();

            list.add(new String[]{"Major", String.valueOf(student[0])});
            list.add(new String[]{"Phone", String.valueOf(student[1])});
            list.add(new String[]{"Year of starting study", String.valueOf(student[2])});

            for (Object[] objects : list)
                dtm.addRow(objects);
    }

    private void setDataToStudentTable() {
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"id_student","name","surname"},0);
        listOfStudentsTable.setModel(dtm);

        startSession();
        students = session.createQuery("select s.idStudent, s.name, s.surname from Student s").getResultList();
        stopSession();

        for (Object student : students)
            dtm.addRow((Object[]) student);
    }
}
