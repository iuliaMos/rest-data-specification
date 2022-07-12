CREATE TABLE IF NOT EXISTS department(id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    country VARCHAR(250));

CREATE TABLE IF NOT EXISTS employee(
    id INT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    age INT,
    department_id INT,
    FOREIGN KEY(department_id) REFERENCES department(id));

CREATE TABLE IF NOT EXISTS employee2(
    id INT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    age INT,
    department_id INT,
    FOREIGN KEY(department_id) REFERENCES department(id));

CREATE TABLE IF NOT EXISTS parent(
    id INT PRIMARY KEY,
    name VARCHAR(250) NOT NULL);

CREATE TABLE IF NOT EXISTS child(
     id INT PRIMARY KEY,
     name VARCHAR(250) NOT NULL);

CREATE TABLE IF NOT EXISTS parent_child(
    parent_id INT NOT NULL REFERENCES parent(id),
    child_id INT NOT NULL REFERENCES child(id),
    PRIMARY KEY (parent_id, child_id));

CREATE OR REPLACE VIEW emp3 AS SELECT * FROM employee;