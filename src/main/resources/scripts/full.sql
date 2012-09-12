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

CREATE TABLE Motivation
(
    id			INT PRIMARY KEY AUTO_INCREMENT,
    imageUrl	VARCHAR(255),
    likes		INT,
    dislikes	INT,
    shares		INT,
    subtitle	VARCHAR(127),
    title		VARCHAR(127),
    views		INT
);