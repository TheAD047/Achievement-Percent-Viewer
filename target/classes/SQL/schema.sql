CREATE DATABASE GC200489790;

USE GC200489790;

CREATE TABLE games (
                       steamGameID INT NOT NULL PRIMARY KEY,
                       gameName VARCHAR(100) NOT NULL,
                       publisher VARCHAR(100) NOT NULL,
                       releaseYear INT NOT NULL
);

CREATE TABLE achievements(
                             achievementID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                             steamGameID INT NOT NULL,
                             achievementName VARCHAR(256) NOT NULL,
                             percent DOUBLE NOT NULL,
                             FOREIGN KEY (steamGameID) REFERENCES games(steamGameID)
);