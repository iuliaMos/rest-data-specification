INSERT INTO department (id, name, country) VALUES
(1, 'HR', 'Romania'),
(2, 'Marketing', 'Romania'),
(3, 'Operations', 'Romania'),
(4, 'Finance', 'Romania'),
(5, 'Sales', 'Romania'),
(6, 'Purchase', 'Romania'),
(7, 'R&D', 'Romania'),
(8, 'HR', 'Germany'),
(9, 'Marketing', 'Germany'),
(10, 'Operations', 'Germany'),
(11, 'Finance', 'Germany'),
(12, 'Sales', 'Germany'),
(13, 'Purchase', 'Germany'),
(14, 'R&D', 'Germany'),
(15, 'HR', 'UK'),
(16, 'Marketing', 'UK'),
(17, 'Operations', 'UK'),
(18, 'Finance', 'UK'),
(19, 'Sales', 'UK'),
(20, 'Purchase', 'UK'),
(21, 'R&D', 'UK');


INSERT INTO employee (id, name, department_id, age) VALUES
(1, 'Ioan Popescu', 1, null),
(2, 'Ioan Andreescu', 2, null),
(3, 'Ioan Stefanescu', 4, null),
(4, 'Ioan Marinescu', 1, null),
(5, 'Ioan Maria', 6, null),
(6, 'Ioan Marin', 7, null),
(7, 'Ana Smith', 7, 45),
(8, 'Corneliu Popescu', 7, null),
(9, 'Sorina Marin', 7, null),
(10, 'Ina Popescu', 7, 37),
(11, 'Alina Ionescu', 7, 28),
(12, 'Cristian Andrei', 7, 42),
(13, 'Ana Stefanescu', 7, null),
(14, 'Maria Ionescu', 7, 41);


INSERT INTO employee2 (id, name, department_id, age) VALUES
(1, 'Empl2 Popescu', 7, 44),
(2, 'Empl2 Andreescu', 18, 55),
(3, 'Empl2 Stefanescu', 18, 22);

INSERT INTO parent (id, name) VALUES
     (1, 'Ana Popescu'),
     (2, 'Emil Andreescu'),
     (3, 'Andrei Stefanescu');

INSERT INTO child (id, name) VALUES
  (1, 'Alina'),
  (2, 'Maria'),
  (3, 'Ion');

INSERT INTO parent_child(parent_id, child_id)
VALUES (1,1);