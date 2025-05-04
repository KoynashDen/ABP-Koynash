-- Перевірка наявності бази даних
CREATE DATABASE IF NOT EXISTS olympiad;

-- Вибір бази даних
USE olympiad;

-- Створення таблиць (як раніше)
CREATE TABLE IF NOT EXISTS schools (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    address VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS participants (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255) NOT NULL,
    subject VARCHAR(255),
    score INT,
    school_id INT,
    CONSTRAINT fk_school
    FOREIGN KEY (school_id)
    REFERENCES schools(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
    );
