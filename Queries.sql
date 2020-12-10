CREATE TABLE Admin (
    ID int PRIMARY KEY AUTO_INCREMENT,
    Username varchar(255) NOT NULL,
    Password varchar(255) NOT NULL
);

CREATE TABLE Puzzle (
    ID int Primary KEY AUTO_INCREMENT, 
    Image1 VARCHAR(255) NOT NULL, 
    Image2 VARCHAR(255) NOT NULL, 
    Image3 VARCHAR(255) NOT NULL, 
    Image4 VARCHAR(255) NOT NULL, 
    Answer VARCHAR(255) NOT NULL UNIQUE
);
