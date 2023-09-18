package main.dao.impl;

import main.dao.ExpenseDao;
import main.dao.dto.ExpenseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main.config.jdbcConfig.getConnection;

public class ExpenseDaoImpl implements ExpenseDao {
    private final String GET_EXPENSE_BY_ID = "SELECT * FROM Proyecto_Integrador.ExpenseTable WHERE expense_id = ?";
    private final String GET_EXPENSE_BY_FOREIGN_KEY = "SELECT * FROM Proyecto_Integrador.ExpenseTable WHERE category_key = ?";
    private final String GET_ALL_EXPENSES = "SELECT * FROM Proyecto_Integrador.ExpenseTable WHERE user_key = ?";
    private final String INSERT_EXPENSE_INTO_DB = "INSERT INTO Proyecto_Integrador.ExpenseTable(user_key, category_key, amount, date) VALUES (?, ?, ?, ?)";
    private final String UPDATE_EXPENSE = "UPDATE Proyecto_Integrador.ExpenseTable SET user_key = ?, category_key = ?, amount = ?, date = ? WHERE expense_id = ?";
    private final String DELETE_EXPENSE = "DELETE FROM Proyecto_Integrador.ExpenseTable WHERE expense_id = ?";

    private final Connection connection;

    public ExpenseDaoImpl() {
      this.connection = getConnection();
    }

    public ExpenseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ExpenseDto getExpenseById(int expenseId) {
        try (PreparedStatement statement = connection.prepareStatement(GET_EXPENSE_BY_ID)) {
            statement.setInt(1, expenseId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResulSetToExpenseDto(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
    }

    @Override
    public List<ExpenseDto> getExpensesByForeignKey(int categoryKey) {
        List<ExpenseDto> expensesDto = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_EXPENSE_BY_FOREIGN_KEY)) {
            statement.setInt(1, categoryKey);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                expensesDto.add(mapResulSetToExpenseDto(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
        return expensesDto;
    }

    @Override
    public List<ExpenseDto> getAllExpenses(int userKey) {
        List<ExpenseDto> allExpenses = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(GET_ALL_EXPENSES)) {
            statement.setInt(1, userKey);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allExpenses.add(mapResulSetToExpenseDto(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
        return allExpenses;
    }

    @Override
    public void insertExpense(ExpenseDto expenseDto) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_EXPENSE_INTO_DB)) {
            statement.setInt(1, expenseDto.getUser_key());
            statement.setInt(2, expenseDto.getCategory_key());
            statement.setDouble(3, expenseDto.getAmount());
            statement.setString(4, expenseDto.getDate());

            int expenseCreated = statement.executeUpdate();
            if (expenseCreated == 0) {
                throw new RuntimeException("Expense created unsuccessfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
    }

    @Override
    public void updateExpense(ExpenseDto expenseDto) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_EXPENSE)) {
            statement.setInt(1, expenseDto.getUser_key());
            statement.setInt(2, expenseDto.getCategory_key());
            statement.setDouble(3, expenseDto.getAmount());
            statement.setString(4, expenseDto.getDate());
            statement.setInt(5, expenseDto.getExpense_id());

            int expenseUpdated = statement.executeUpdate();
            if (expenseUpdated == 0) {
                throw new RuntimeException("Error, expense updated unsuccessfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
    }

    @Override
    public void deleteExpensed(int expenseId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_EXPENSE)) {
            statement.setInt(1, expenseId);

            int expenseDeleted = statement.executeUpdate();
            if (expenseDeleted == 0) {
                throw new RuntimeException("Error, expense deleted unsuccessfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
    }

    private ExpenseDto mapResulSetToExpenseDto(ResultSet resultSet) {
        ExpenseDto expenseDto = new ExpenseDto();
        try {
            expenseDto.setExpense_id(resultSet.getInt("expense_id"));
            expenseDto.setUser_key(resultSet.getInt("user_key"));
            expenseDto.setCategory_key(resultSet.getInt("category_key"));
            expenseDto.setAmount(resultSet.getDouble("amount"));
            expenseDto.setDate(resultSet.getString("date"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return expenseDto;
    }
}
