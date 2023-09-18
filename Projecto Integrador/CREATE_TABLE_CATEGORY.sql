
-- Create the database Proyecto_Integrador
CREATE SCHEMA IF NOT EXISTS Proyecto_Integrador;

-------------------------------------------------------------------

-- Create the table CategoryTable before creating the ExpenseTable
CREATE TABLE IF NOT EXISTS Proyecto_Integrador.CategoryTable (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    user_key INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_key) REFERENCES UserTable(user_id)
);

-------------------------------------------------------------------

-- Insert categories into the table
INSERT INTO Proyecto_Integrador.CategoryTable(user_key, name)
VALUES (1, 'Groceries'), (2, 'SchoolAssets')