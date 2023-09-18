package main.dao.impl;

import main.dao.dto.ExpenseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ExpenseDaoImplTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private ExpenseDaoImpl expenseDaoImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        try {
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            expenseDaoImpl = new ExpenseDaoImpl(mockConnection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getExpenseById_ShouldReturnExpenseDto_WhenValidId() {
        try {
            // GIVEN
            int expenseId = 1;
            int userKey = 1;
            int categoryKey = 2;
            double amount = 100.000;
            String date = "2023-04-27";
            ExpenseDto expenseDto = new ExpenseDto(userKey, categoryKey, amount, date);

            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true);
            when(mockResultSet.getDouble("amount")).thenReturn(amount);
            when(mockResultSet.getString("date")).thenReturn(date);
            when(mockResultSet.getInt("category_key")).thenReturn(categoryKey);
            when(mockResultSet.getInt("user_key")).thenReturn(userKey);

            // WHEN
            ExpenseDto resultDto = expenseDaoImpl.getExpenseById(expenseId);

            // THEN
            verify(mockPreparedStatement).setInt(1, expenseId);
            verify(mockPreparedStatement).executeQuery();
            verify(mockResultSet).next();
            verify(mockResultSet).getInt("user_key");
            verify(mockResultSet).getInt("category_key");
            verify(mockResultSet).getDouble("amount");
            verify(mockResultSet).getString("date");

            // Assertions
            Assertions.assertNotNull(resultDto);
            Assertions.assertEquals(expenseDto.getAmount(), resultDto.getAmount());
            Assertions.assertEquals(expenseDto.getDate(), resultDto.getDate());
            Assertions.assertEquals(expenseDto.getUser_key(), resultDto.getUser_key());
            Assertions.assertEquals(expenseDto.getCategory_key(), resultDto.getCategory_key());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getExpensesByForeignKey_ShouldReturnExpenseDtos_WhenValidForeignKey() {
        try {
            // GIVEN
            int categoryKey = 3;
            List<ExpenseDto> expectedList = new ArrayList<>();

            expectedList = List.of(
                    new ExpenseDto(1, categoryKey, 200.000, "2023-05-04"),
                    new ExpenseDto(1, categoryKey, 700.000, "2023-04-27")
            );

            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true, false);
            when(mockResultSet.getDouble("amount")).thenReturn(200.000, 700.000);
            when(mockResultSet.getString("date")).thenReturn("2023-05-04", "2023-04-27");
            when(mockResultSet.getInt("category_key")).thenReturn(categoryKey, categoryKey);
            when(mockResultSet.getInt("user_key")).thenReturn(1, 1);

            // WHEN
            List<ExpenseDto> resultList = expenseDaoImpl.getExpensesByForeignKey(categoryKey);

            // THEN
            verify(mockPreparedStatement).executeQuery();
            verify(mockResultSet, times(2)).getInt("user_key");
            verify(mockResultSet, times(2)).getInt("category_key");
            verify(mockResultSet, times(2)).getDouble("amount");
            verify(mockResultSet, times(2)).getString("date");


            // Assertions
            Assertions.assertEquals(expectedList.size(), resultList.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllExpenses_ShouldReturnExpenseDtos_WhenDatabaseHasData() {
        try {
            // GIVEN
            int userKey = 1;
            List<ExpenseDto> expectedList = new ArrayList<>();
            expectedList = List.of(
                    new ExpenseDto(userKey, 1, 100.000, "2023-04-07"),
                    new ExpenseDto(userKey, 2, 200.000, "2023-05-23")
            );

            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true, false);
            when(mockResultSet.getInt("user_key")).thenReturn(userKey, userKey);
            when(mockResultSet.getInt("category_key")).thenReturn(1, 2);
            when(mockResultSet.getDouble("amount")).thenReturn(100.000, 200.000);
            when(mockResultSet.getString("date")).thenReturn("2023-04-07", "2023-05-23");

            // WHEN
            List<ExpenseDto> resultList = expenseDaoImpl.getAllExpenses(userKey);

            // THEN
            verify(mockPreparedStatement).executeQuery();
            verify(mockResultSet, times(2)).getInt("user_key");
            verify(mockResultSet, times(2)).getInt("category_key");
            verify(mockResultSet, times(2)).getDouble("amount");
            verify(mockResultSet, times(2)).getString("date");

            // Assertions
            Assertions.assertEquals(expectedList.size(), resultList.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void insertExpense_ShouldInsertExpense_WhenValidExpenseDto() {
        try {
            // GIVEN
            int userKey = 1;
            int categoryKey = 3;
            double amount = 200.000;
            String date = "2023-04-05";
            ExpenseDto expenseDto = new ExpenseDto(userKey, categoryKey, amount, date);

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            expenseDaoImpl.insertExpense(expenseDto);

            // THEN
            verify(mockPreparedStatement).setInt(1, userKey);
            verify(mockPreparedStatement).setInt(2, categoryKey);
            verify(mockPreparedStatement).setDouble(3, amount);
            verify(mockPreparedStatement).setString(4, date);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateExpense_ShouldUpdateExpense_WhenValidExpenseDto() {
        try {
            // GIVEN
            int userKey = 1;
            int categoryKey = 2;
            double amount = 300.123;
            String date = "2023-05-04";
            ExpenseDto expenseDto = new ExpenseDto(userKey, categoryKey, amount, date);

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            expenseDaoImpl.updateExpense(expenseDto);

            // THEN
            verify(mockPreparedStatement).setInt(1, userKey);
            verify(mockPreparedStatement).setInt(2, categoryKey);
            verify(mockPreparedStatement).setDouble(3, amount);
            verify(mockPreparedStatement).setString(4, date);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deleteExpensed_ShouldDeleteExpense_WhenValidId() {
        try {
            // GIVEN
            int expenseId = 1;

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            expenseDaoImpl.deleteExpensed(expenseId);

            // THEN
            verify(mockPreparedStatement).setInt(1, expenseId);
            verify(mockPreparedStatement).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}