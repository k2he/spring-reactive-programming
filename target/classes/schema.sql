DROP TABLE IF EXISTS TRANSFER;

CREATE TABLE TRANSFER (
  id INT AUTO_INCREMENT PRIMARY KEY,
  originator VARCHAR(255),
  recipient VARCHAR(255),
  description VARCHAR(255)
);

INSERT INTO TRANSFER (originator, recipient, description) VALUES
  ('Sender A', 'Person 1', 'non-swift'),
  ('Sender B', 'Person 2', 'swift'),
  ('Sender C', 'Person 3', 'north bound money movement');