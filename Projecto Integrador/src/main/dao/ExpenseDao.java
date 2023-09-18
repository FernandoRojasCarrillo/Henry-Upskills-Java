package main.dao;

import main.dao.dto.ExpenseDto;

import java.util.List;

public interface ExpenseDao {

    ExpenseDto getExpenseById(int expenseId);

    List<ExpenseDto> getExpensesByForeignKey(int categoryKey);
    List<ExpenseDto> getAllExpenses(int userKey);

    void insertExpense(ExpenseDto expenseDto);

    void updateExpense(ExpenseDto expenseDto);

    void deleteExpensed(int expenseId);
}
