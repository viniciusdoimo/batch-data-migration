DROP TABLE IF EXISTS client;
CREATE TABLE client(id INT, name VARCHAR(500),email VARCHAR(500),dateBirth DATETIME,age INT, PRIMARY KEY(id));
DROP TABLE IF EXISTS account;
CREATE TABLE account(id INT, clientId INT,agency INT, account INT, bank INT , PRIMARY KEY(id));

