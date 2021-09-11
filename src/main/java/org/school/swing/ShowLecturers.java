package org.school.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ShowLecturers extends FrameOptions {
    private JTable lecturersTable;
    private JTable subjectTable;
    private JButton backButton;
    private JPanel mainPanel;
    private JLabel titleLabel;

    /*
    * @param lecturers - contains list of lectures
    * */

    private List lecturers;

    public ShowLecturers(){
        super();
        setContentPane(mainPanel);

        setVisible(true);
        setDataToTable();
        subjectTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDataToLectureDetail(lecturersTable.getSelectedRow());
            }
        });
    }

    private void setDataToTable() {
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"id_student","name","surname"},0);
        lecturersTable.setModel(dtm);

        startSession();
        lecturers = session.createQuery("select l.lecturerId, l.name, l.surname from Lecturer l").getResultList();
        stopSession();

        for (Object lecturer : lecturers)
            dtm.addRow((Object[]) lecturer);
    }

    private void setDataToLectureDetail(int selectedRow){
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"1", "2"}, 0);
        subjectTable.setModel(dtm);

        startSession();
        List lecture = session.createQuery("select s.nameOfSubject, s.typeOfSubjects from Subjects s " +
                        "join s.lecturers l where l.lecturerId =:lecturerId")
                .setParameter("lecturerId", ((Object[]) lecturers.get(selectedRow))[0])
                .getResultList();
        stopSession();

        for (Object objects : lecture)
            dtm.addRow((Object[]) objects);
    }
}
