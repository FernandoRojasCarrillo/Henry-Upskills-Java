
-- Create the database Proyecto_Integrador
CREATE SCHEMA IF NOT EXISTS Proyecto_Integrador;

-------------------------------------------------------------------

-- Create the table UserTable before creating the CategoryTable or the ExpenseTable
CREATE TABLE IF NOT EXISTS Proyecto_Integrador.UserTable (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

-------------------------------------------------------------------

-- Insert users into the table

INSERT INTO Proyecto_Integrador.UserTable(name, email, password)
VALUES('Thomas smith', 'thomas@email.com', 'thomas'),
      ('Jane Smith', 'jane@email.com', 'jane');