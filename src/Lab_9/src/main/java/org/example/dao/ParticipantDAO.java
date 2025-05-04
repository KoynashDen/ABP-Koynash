package org.example.dao;

import org.example.model.Participant;
import org.example.model.School;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {

    private Connection connection;

    public ParticipantDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Participant> getAllParticipants() throws SQLException {
        List<Participant> participants = new ArrayList<>();
        String query = "SELECT * FROM participants";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String subject = rs.getString("subject");
                int score = rs.getInt("score");
                int schoolId = rs.getInt("school_id");
                School school = getSchoolById(schoolId);
                participants.add(new Participant(id, name, subject, score, school));
            }
        }
        return participants;
    }

    public void addParticipant(Participant participant) throws SQLException {
        System.out.println(participant);
        String query = "INSERT INTO participants (name, subject, score, school_id) VALUES (?, ?, ?, ?)";
        System.out.println(query);
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getSubject());
            stmt.setInt(3, participant.getScore());
            stmt.setInt(4, participant.getSchool().getId());
            System.out.println(stmt.toString());
            stmt.executeUpdate();
        }
    }

    public void deleteParticipant(int id) throws SQLException {
        String query = "DELETE FROM participants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private School getSchoolById(int schoolId) throws SQLException {
        SchoolDAO schoolDAO = new SchoolDAO(connection);
        return schoolDAO.getSchoolById(schoolId);
    }
}
