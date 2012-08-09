CREATE TABLE Contact
(
    id			INT PRIMARY KEY AUTO_INCREMENT,
    firstname	VARCHAR(30),
    lastname	VARCHAR(30),
    telephone	VARCHAR(15),
    email		VARCHAR(30),
    age			INT,
    birthDate	datetime,
    created		TIMESTAMP DEFAULT NOW()
);

alter table contact add column birthDate datetime;