package main.functions;

import main.dao.dto.CategoryDto;
import main.dao.dto.ExpenseDto;
import main.dao.dto.UserDto;
import main.dao.impl.CategoryDaoImpl;
import main.dao.impl.ExpenseDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.entities.User;

import java.util.Scanner;

import static main.functions.AppMenu.appMenu;

public class EnterNewExpenses {

    public static void enterNewExpenses(User CURRENT_USER) {
        Scanner scanner = new Scanner(System.in);

        ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();
        CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
        UserDaoImpl userDaoImpl = new UserDaoImpl();

        System.out.println("How many expenses would you like to add? 🤔\n");

        int expensesAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("Perfect");

        while (expensesAmount <= 0) {
            System.out.println("Expenses amount invalid, please enter a positive number grater than '0'");
            expensesAmount = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 1; i <= expensesAmount; i++) {
            System.out.println("Expense #" + i + ", enter a category");
            String expenseCategoryName = scanner.nextLine();
            System.out.println("Expense #" + i + ", enter the amount");
            Double expenseAmount = Double.valueOf(scanner.nextLine());
            while (  expenseAmount < 0 ) {
                System.out.println("Expense amount invalid");
                System.out.println("please enter a valid amount, 000.000");
                expenseAmount = Double.valueOf(scanner.nextLine());
            }
            System.out.println("Expense #" + i + ", enter the date (YYYY-MM-DD)");
            String expenseDate = scanner.nextLine();
            String[] dateStringSplit = expenseDate.split("-");
            while (dateStringSplit.length != 3) {
                System.out.println("Date format invalid,");
                System.out.println("please enter a valid date format: (YYYY-MM-DD)");

                expenseDate = scanner.nextLine();
                dateStringSplit = expenseDate.split("-");
            }

            // Insert the category in the DataBase
            CategoryDto newCategory = new CategoryDto(expenseCategoryName);
            UserDto userFromDataBase = userDaoImpl.getUserByEmail(CURRENT_USER.getEmail());
            CategoryDto categoryFromDataBase = categoryDaoImpl.getCategoryByName(
                    expenseCategoryName,
                    userFromDataBase.getUser_id()
            );

            if (categoryFromDataBase == null) {
                // Create the category if it does not exist
                categoryDaoImpl.insertCategory(newCategory, userFromDataBase.getUser_id());
                categoryFromDataBase = categoryDaoImpl.getCategoryByName(expenseCategoryName, userFromDataBase.getUser_id());
            }

            // Insert the expense in the DataBase
            ExpenseDto newExpense = new ExpenseDto(
                    userFromDataBase.getUser_id(), // User foreign kry
                    categoryFromDataBase.getCategory_id(), // Category foreign key
                    expenseAmount, // Expense amount
                    expenseDate // Expense date
            );

            expenseDaoImpl.insertExpense(newExpense);
            System.out.println("Done 😉👍");
        }

        if (expensesAmount == 1) {
            System.out.println("Expense created successfully");
        } else {
            System.out.println("Expenses created successfully");
        }

        appMenu(CURRENT_USER);

        scanner.close();
    }
}
