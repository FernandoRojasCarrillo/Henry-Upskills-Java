
-- Create the database Proyecto_Integrador
CREATE SCHEMA IF NOT EXISTS Proyecto_Integrador;

-------------------------------------------------------------------

-- Create the table ExpenseTable
CREATE TABLE IF NOT EXISTS Proyecto_Integrador.ExpenseTable (
    expense_id INT PRIMARY KEY AUTO_INCREMENT,
    user_key INT NOT NULL,
    category_key INT NOT NULL,
    amount DOUBLE NOT NULL,
    date VARCHAR(10),
    FOREIGN KEY (user_key) REFERENCES UserTable(user_id),
    FOREIGN KEY (category_key) REFERENCES CategoryTable(category_id)
);

-------------------------------------------------------------------

-- Insert expenses into the table
INSERT INTO Proyecto_Integrador.ExpenseTable (user_key, category_key, amount, date)
VALUES (1, 1, 300.000, '2023-08-04'), (1, 1, 200.000, '2023-08-04'),
       (2, 2, 350.000, '2023-08-05'), (2, 2, 150.000, '2023-08-04')