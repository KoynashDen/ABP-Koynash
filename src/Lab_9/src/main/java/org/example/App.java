package org.example;

import org.example.dao.ParticipantDAO;
import org.example.dao.SchoolDAO;
import org.example.model.Participant;
import org.example.model.School;
import org.example.util.DBConnection;
import org.example.util.FlywayUtility;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App
{
    private JFrame frame;
    private JTable table;
    private ParticipantDAO participantDAO;
    private SchoolDAO schoolDAO;
    private Connection connection;

    public App() {
        initialize();
    }

    private void initialize() {
        FlywayUtility.runMigrations();
        connection = DBConnection.getConnection();
        schoolDAO = new SchoolDAO(connection);
        participantDAO = new ParticipantDAO(connection);

        frame = new JFrame();
        frame.setTitle("Olympiad Participants");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());

        table = new JTable();
        updateTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton btnAdd = new JButton("Add Participant");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter participant name:");
                String subject = JOptionPane.showInputDialog("Enter subject:");
                int score = Integer.parseInt(JOptionPane.showInputDialog("Enter score:"));
                School school = getSchoolFromUser();

                Participant participant = new Participant(0, name, subject, score, school);
                try {
                    participantDAO.addParticipant(participant);
                    updateTable();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buttonPanel.add(btnAdd);

        JButton btnDelete = new JButton("Delete Participant");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    System.out.println(table.getValueAt(selectedRow, 0));
                    int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                    try {
                        participantDAO.deleteParticipant(id);
                        updateTable();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a participant to delete.");
                }
            }
        });
        buttonPanel.add(btnDelete);
    }

    private void updateTable() {
        try {
            List<Participant> participants = participantDAO.getAllParticipants();
            String[][] data = new String[participants.size()][5];
            for (int i = 0; i < participants.size(); i++) {
                Participant participant = participants.get(i);
                data[i][0] = String.valueOf(participant.getId());
                data[i][1] = participant.getName();
                data[i][2] = participant.getSubject();
                data[i][3] = String.valueOf(participant.getScore());
                data[i][4] = participant.getSchool().getName();
            }

            String[] columns = {"ID", "Name", "Subject", "Score", "School"};
            table.setModel(new javax.swing.table.DefaultTableModel(data, columns));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private School getSchoolFromUser() {
        try {
            List<School> schools = schoolDAO.getAllSchools();
            if (schools.isEmpty()) {
                School newSchool = new School(1, "FIT", "Default Location");
                schoolDAO.addSchool(newSchool);
                schools.add(newSchool);
            }
            return schools.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
