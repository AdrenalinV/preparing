CREATE SCHEMA IF NOT EXISTS cinema;
DROP TABLE IF EXISTS cinema.tickets;
DROP TABLE IF EXISTS cinema.sessions;
DROP TABLE IF EXISTS cinema.films;

CREATE TABLE IF NOT EXISTS cinema.films (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    duration TIME NOT NULL DEFAULT '01:00:00',
    base_price DECIMAL );

INSERT INTO cinema.films (name,duration,base_price)
VALUES  ('Resident Evil: Welcome to Raccoon City','01:47:00',200.00),
        ('House of Gucci','02:38:00',150.00),
        ('The Untitled Matrix Film','02:28:00',250.00);

CREATE TABLE IF NOT EXISTS cinema.sessions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_film BIGINT NOT NULL REFERENCES cinema.films(id),
    session_time DATETIME NOT NULL,
    additional_price DECIMAL DEFAULT 0.00);

INSERT INTO cinema.sessions (id_film, session_time,additional_price )
VALUES  (3,'2021-11-28 10:10:00',0.30),
        (2,'2021-11-28 13:15:00',0.70),
        (3,'2021-11-28 16:20:00',0.70),
        (2,'2021-11-28 19:25:00',1.00),
        (1,'2021-11-28 22:30:00',1.00);

CREATE TABLE IF NOT EXISTS cinema.tickets(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_session BIGINT NOT NULL REFERENCES cinema.sessions(id));

INSERT INTO cinema.tickets(id_session)
VALUES  (1),
        (1),
        (2),
        (2),
        (3),
        (3),
        (3),
        (4),
        (4),
        (5);

