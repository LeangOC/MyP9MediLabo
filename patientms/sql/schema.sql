CREATE DATABASE  IF NOT EXISTS `patientdb`;
USE patientdb;
DROP TABLE IF EXISTS patient;
CREATE TABLE IF NOT EXISTS patient(
    id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(25),
    lastname VARCHAR(25),
    birthdate DATE,
    gender CHAR,
    address VARCHAR(25),
    phone_number VARCHAR(25),
    primary key (id)
);


