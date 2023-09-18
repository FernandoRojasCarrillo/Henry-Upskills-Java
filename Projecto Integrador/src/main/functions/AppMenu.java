package main.functions;

import main.entities.User;

import java.util.Scanner;

import static main.functions.EnterNewExpenses.enterNewExpenses;
import static main.functions.ShowExpenses.ShowAllExpenses;
import static main.functions.ShowExpenses.showExpensesTotal;

public class AppMenu {

    public static void appMenu(User CURRENT_USER) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("APP MENU\n");

        System.out.println("Enter 'MY EXPENSES' to see all your expenses");
        System.out.println("Enter 'TOTAL' to see the sum of all of your expenses");
        System.out.println("Enter 'ADD EXPENSE' to add one or more expenses to the list");
        System.out.println("Enter 'EXIT' to exit the application\n");

        String option = scanner.nextLine();
        switch (option.toUpperCase()) {
            case "MY EXPENSES" -> ShowAllExpenses(CURRENT_USER);
            case "TOTAL" -> showExpensesTotal(CURRENT_USER);
            case "ADD EXPENSE" -> enterNewExpenses(CURRENT_USER);
            case "EXIT" -> System.out.println("You have exit the application successfully");
            default -> {
                System.out.println("Command not recognise, please try again.\n");
                appMenu(CURRENT_USER);
            }
        }

        scanner.close();
    }
}
