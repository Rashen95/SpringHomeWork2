package ru.geekbrains.SpringHomeWork2;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DBProcessor {
    public String process(String query) {
        try (Connection c = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)) {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);
            StringBuilder resultBuilder = new StringBuilder();
            while (rs.next()) {
                String nameBook = rs.getString("name");
                resultBuilder.append("\"").append(nameBook).append("\"").append(", ");
            }
            resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length() - 1);
            return resultBuilder.toString();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}