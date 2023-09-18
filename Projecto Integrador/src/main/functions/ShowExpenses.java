package main.functions;

import main.dao.dto.CategoryDto;
import main.dao.dto.ExpenseDto;
import main.dao.dto.UserDto;
import main.dao.impl.CategoryDaoImpl;
import main.dao.impl.ExpenseDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.entities.Expense;
import main.entities.User;

import java.util.List;

import static main.functions.AppMenu.appMenu;

public class ShowExpenses {

    public static void ShowAllExpenses(User CURRENT_USER ) {
        CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
        ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDto UserFromDataBase = userDaoImpl.getUserByEmail(CURRENT_USER.getEmail());

        List<CategoryDto> allCategories = categoryDaoImpl.getAllCategories(UserFromDataBase.getUser_id());

        if (allCategories.size() != 0) {
            System.out.println("EXPENSES TABLE");
            allCategories.forEach(category -> {
                System.out.println("<<--------------------------------->>");
                System.out.println("Category: " + category.getName() + "\n");

                List<ExpenseDto> categoryExpenses = expenseDaoImpl.getExpensesByForeignKey(category.getCategory_id());
                List<Expense> expenses = categoryExpenses.stream()
                        .map(expense -> new Expense(expense.getAmount(), expense.getDate())).toList();
                expenses.forEach(System.out::println);
                System.out.println(">>--------------------------------->>");
            });
        } else {
            System.out.println("You haven't add expenses yet.");
        }

        List<ExpenseDto> expensesFromDb = expenseDaoImpl.getAllExpenses(UserFromDataBase.getUser_id());
        Double expensesTotal = expensesFromDb.stream()
                .mapToDouble(expense -> expense.getAmount())
                .sum();
        System.out.println("\nTOTAL EXPENSES AMOUNT");
        System.out.println(expensesTotal + "\n");

        appMenu(CURRENT_USER);
    }

    public static void showExpensesTotal(User CURRENT_USER) {
        ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDto UserFromDataBase = userDaoImpl.getUserByEmail(CURRENT_USER.getEmail());

        List<ExpenseDto> expensesFromDb = expenseDaoImpl.getAllExpenses(UserFromDataBase.getUser_id());
        Double expensesTotal = expensesFromDb.stream()
                .mapToDouble(expense -> expense.getAmount())
                .sum();
        System.out.println("\nTOTAL EXPENSES AMOUNT");
        System.out.println(expensesTotal + "\n");

        appMenu(CURRENT_USER);
    }
}
