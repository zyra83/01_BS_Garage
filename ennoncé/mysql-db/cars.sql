

DROP DATABASE IF EXISTS cars;
DROP DATABASE IF EXISTS CARS;
CREATE DATABASE CARS DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;

USE CARS;

SET NAMES 'utf8';

CREATE TABLE VOITURE(
        id_voiture  Varchar (36) NOT NULL ,
        mec_voiture DATE NOT NULL ,
        modele_voiture Varchar (36) NOT NULL ,
        puissance_voiture  Int (11) NOT NULL ,
        immat_voiture Varchar (36) NOT NULL ,
        PRIMARY KEY (id_voiture )
)ENGINE=InnoDB;


INSERT INTO VOITURE VALUES 
("7216f84e-8ad7-407f-af94-c2400f01656b", "2016-01-01", "Mégane", 1, "ST-010-080"),
("b1ea83f0-eac4-4c13-9e3a-8e18bc800ce7", "2015-01-01", "Clio", 1, "ST-010-081"),
("9e106b0c-3910-4581-bb7b-55f0d024fbbc", "2014-01-01", "106", 2, "ST-010-082"),
("59b59e7f-b41f-4aaa-99cb-cdba02a466a5", "2013-01-01", "Saxo", 3, "ST-010-083"),
("f9080d96-c341-4a36-9582-55bd9a8964fa", "2012-01-01", "Cayenne", 4, "ST-010-084"),
("5241f863-8e5b-4707-b48e-f21afb85182f", "2011-01-01", "Sandero", 4, "ST-010-085"),
("5241f863-8e5b-4707-b48e-f21afb8518f2", "2010-01-01", "Focus", 5, "ST-010-086");
