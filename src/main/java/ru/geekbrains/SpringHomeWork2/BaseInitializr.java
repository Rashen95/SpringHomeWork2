package ru.geekbrains.SpringHomeWork2;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BaseInitializr {
    public void create() {
        try (Connection c = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)) {
            Statement st = c.createStatement();
            st.execute("DROP SCHEMA IF EXISTS rashen_schema CASCADE;");
            st.execute("CREATE SCHEMA rashen_schema;");
            st.execute("""
                    CREATE TABLE IF NOT EXISTS rashen_schema.books (
                        id          bigserial PRIMARY KEY,
                        name        varchar(100) NOT NULL,
                        author      varchar(100) NOT NULL);""");
            st.execute("""
                    INSERT INTO rashen_schema.books (name, author) VALUES
                        ('Война и мир', 'Лев Толстой'),
                        ('Анна Каренина', 'Лев Толстой'),
                        ('Детство', 'Лев Толстой'),
                        ('Капитанская дочка', 'Александр Пушкин'),
                        ('Евгений Онегин', 'Александр Пушкин'),
                        ('Сказки', 'Александр Пушкин'),
                        ('Бородино', 'Михаил Лермонтов'),
                        ('Мцыри', 'Михаил Лермонтов'),
                        ('Демон', 'Михаил Лермонтов'),
                        ('Герой нашего времени', 'Михаил Лермонтов');""");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}