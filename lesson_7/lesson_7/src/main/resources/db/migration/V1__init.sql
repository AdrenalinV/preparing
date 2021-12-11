DROP TABLE IF EXISTS students;
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT DEFAULT 0);

INSERT INTO students (name, age)
 VALUES ('Petr Ivanov',25),
    ('Ivan Petrov',22),
    ('Oly Sidorova',23);