import main.dao.impl.CategoryDaoImpl;
import main.dao.impl.ExpenseDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.entities.User;

import java.util.Scanner;

import static main.functions.AppMenu.appMenu;
import static main.functions.UserRegistration.UserRegistration;

public class ExpenseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User CURRENT_USER = new User();

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
        ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();

        try {

            boolean userRegistration = UserRegistration(scanner, userDaoImpl, CURRENT_USER);
            //boolean userRegistration = true;
            if (CURRENT_USER.isLoggedIn() && userRegistration) {
                System.out.println("Welcome " + CURRENT_USER.getName() + ", nice to have you here.");
                System.out.println("🎉 🎉 🎉 🎉\n");

                appMenu(CURRENT_USER);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }


}