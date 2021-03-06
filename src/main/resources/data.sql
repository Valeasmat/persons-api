
DROP TABLE IF EXISTS person_entity;

CREATE TABLE person_entity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    document VARCHAR(8) NOT NULL,
    fingerprint BOOLEAN NOT NULL,
    blacklist BOOLEAN NOT NULL
);

INSERT INTO person_entity( document, fingerprint, blacklist)
VALUES
('10000000',TRUE,FALSE),
('10000001',TRUE,FALSE),
('10000002',TRUE,TRUE),
('10000003',FALSE ,FALSE),
('10000004',FALSE,FALSE),
('10000005',FALSE,TRUE);
