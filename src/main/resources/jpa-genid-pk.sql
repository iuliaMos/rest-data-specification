
CREATE TABLE IF NOT EXISTS part1(
    id INT NOT NULL,
    name VARCHAR(250),
    createdon TIMESTAMP NOT NULL,
    CONSTRAINT part1_pk PRIMARY KEY (id, createdon))
    PARTITION BY RANGE (createdon);

CREATE TABLE IF NOT EXISTS part2(
    id INT NOT NULL,
    name VARCHAR(250),
    createdon TIMESTAMP NOT NULL,
    CONSTRAINT part2_pk PRIMARY KEY (id, createdon))
    PARTITION BY RANGE (createdon);

CREATE TABLE part1_default PARTITION OF part1 DEFAULT;
CREATE TABLE part2_default PARTITION OF part2 DEFAULT;

CREATE TABLE IF NOT EXISTS part1_part2(
    part1_id INT NOT NULL,
    part1_createdon TIMESTAMP NOT NULL,
    part2_id INT NOT NULL,
    part2_createdon TIMESTAMP NOT NULL,
    CONSTRAINT part1_part2_pk PRIMARY KEY (part1_id, part1_createdon, part2_id, part2_createdon))
    PARTITION BY RANGE (part1_createdon);
CREATE TABLE part1_createdon PARTITION OF part1_part2 DEFAULT;

CREATE TABLE part1_2022_07 PARTITION OF part1 FOR VALUES FROM ('2022-07-01 00:00:00') TO ('2022-07-31 23:59:59');
CREATE TABLE part1_2022_06 PARTITION OF part1 FOR VALUES FROM ('2022-06-01 00:00:00') TO ('2022-06-30 23:59:59');
CREATE TABLE part1_2022_05 PARTITION OF part1 FOR VALUES FROM ('2022-05-01 00:00:00') TO ('2022-05-31 23:59:59');

CREATE TABLE part2_2022_07 PARTITION OF part2 FOR VALUES FROM ('2022-07-01 00:00:00') TO ('2022-07-31 23:59:59');
CREATE TABLE part2_2022_06 PARTITION OF part2 FOR VALUES FROM ('2022-06-01 00:00:00') TO ('2022-06-30 23:59:59');
CREATE TABLE part2_2022_05 PARTITION OF part2 FOR VALUES FROM ('2022-05-01 00:00:00') TO ('2022-05-31 23:59:59');

CREATE TABLE part1_part2_2022_07 PARTITION OF part1_part2 FOR VALUES FROM ('2022-07-01 00:00:00') TO ('2022-07-31 23:59:59');
CREATE TABLE part1_part2_2022_06 PARTITION OF part1_part2 FOR VALUES FROM ('2022-06-01 00:00:00') TO ('2022-06-30 23:59:59');
CREATE TABLE part1_part2_2022_05 PARTITION OF part1_part2 FOR VALUES FROM ('2022-05-01 00:00:00') TO ('2022-05-31 23:59:59');

CREATE SEQUENCE part1_seq  INCREMENT 1 START 10;
CREATE SEQUENCE part2_seq  INCREMENT 1 START 10;

INSERT INTO part1 (id, name, createdon) VALUES (nextval('part1_seq'), 'name1', '2022-05-20 18:10:00');
INSERT INTO part1 (id, name, createdon) VALUES (nextval('part1_seq'), 'name2', '2022-06-20 08:20:03');
INSERT INTO part1 (id, name, createdon) VALUES (nextval('part1_seq'), 'name3', '2022-07-14 22:20:03');

INSERT INTO part2 (id, name, createdon) VALUES (nextval('part2_seq'), 'name11', '2022-05-17 18:10:00');
INSERT INTO part2 (id, name, createdon) VALUES (nextval('part2_seq'), 'name22', '2022-06-05 08:20:03');
INSERT INTO part2 (id, name, createdon) VALUES (nextval('part2_seq'), 'name33', '2022-07-27 22:20:03');
