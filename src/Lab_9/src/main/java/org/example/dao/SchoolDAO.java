package org.example.dao;

import org.example.model.School;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {

    private Connection connection;

    public SchoolDAO(Connection connection) {
        this.connection = connection;
    }

    public List<School> getAllSchools() throws SQLException {
        List<School> schools = new ArrayList<>();
        String query = "SELECT * FROM schools";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                schools.add(new School(id, name, address));
            }
        }
        return schools;
    }

    public void addSchool(School school) throws SQLException {
        String query = "INSERT INTO schools (name, address) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, school.getName());
            stmt.setString(2, school.getAddress());
            stmt.executeUpdate();
        }
    }



    public School getSchoolById(int id) throws SQLException {
        String query = "SELECT * FROM schools WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                return new School(id, name, address);
            }
        }
        return null;
    }
}
