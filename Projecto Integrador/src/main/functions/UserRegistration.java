package main.functions;

import main.dao.dto.UserDto;
import main.dao.impl.UserDaoImpl;
import main.entities.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    public static boolean UserRegistration(
            Scanner scanner,
            UserDaoImpl userDaoImpl,
            User CURRENT_USER
    ) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

        System.out.println("Type 'LOGIN' if you have an account already,");
        System.out.println("type 'CREATE ACCOUNT' to create your own account");
        System.out.println("or type 'EXIT' to finished the application.\n");
        String nextLine = scanner.nextLine();

        if (nextLine.equalsIgnoreCase("CREATE ACCOUNT")) {
            System.out.println("Please enter your full name:");
            String NAME = scanner.nextLine();
            System.out.println("Thanks, now please enter your email:");
            String EMAIL = scanner.nextLine();
            Matcher matcher = pattern.matcher(EMAIL);
            while (!matcher.matches()) {
                System.out.println("Email format invalid, please try again");
                EMAIL = scanner.nextLine();
                matcher = pattern.matcher(EMAIL);
            }

            System.out.println("Great, finally please enter your password");
            String PASSWORD = scanner.nextLine();

            UserDto userFromDB = userDaoImpl.getUserByEmail(EMAIL);

            while (userFromDB != null) {
                System.out.println("Apologies, user email " + EMAIL + " already exist");
                System.out.println("Please enter another one:\n");

                System.out.println("New email:");
                EMAIL = scanner.nextLine();

                matcher = pattern.matcher(EMAIL);
                while (!matcher.matches()) {
                    System.out.println("Email format invalid, please try again");
                    EMAIL = scanner.nextLine();
                    matcher = pattern.matcher(EMAIL);
                }

                System.out.println("Password:");
                PASSWORD = scanner.nextLine();

                userFromDB = userDaoImpl.getUserByEmail(EMAIL);
            }

            UserDto newUser = new UserDto(NAME, EMAIL, PASSWORD);
            userDaoImpl.inserUser(newUser);

            CURRENT_USER.setName(NAME);
            CURRENT_USER.setEmail(EMAIL);
            CURRENT_USER.setPassword(PASSWORD);
            CURRENT_USER.setLoggedIn(true);

            System.out.println("Account created successfully");
            return true;

        } else if (nextLine.equalsIgnoreCase("LOGIN")) {

            System.out.println("USER EMAIL:");
            String EMAIL = scanner.nextLine();

            Matcher matcher = pattern.matcher(EMAIL);
            while (!matcher.matches()) {
                System.out.println("Email format invalid, please try again");
                EMAIL = scanner.nextLine();
                matcher = pattern.matcher(EMAIL);
            }

            System.out.println("PASSWORD");
            String PASSWORD = scanner.nextLine();

            UserDto userLogged = userDaoImpl.getUserByEmail(EMAIL);

            while(
                    userLogged == null ||
                            !userLogged.getPassword().equalsIgnoreCase(PASSWORD)
            ) {
                System.out.println("Something went wrong,");
                System.out.println("user email or password incorrect, please try again\n");

                System.out.println("USER EMAIL:");
                EMAIL = scanner.nextLine();

                matcher = pattern.matcher(EMAIL);
                while (!matcher.matches()) {
                    System.out.println("Email format invalid, please try again");
                    EMAIL = scanner.nextLine();
                    matcher = pattern.matcher(EMAIL);
                }

                System.out.println("PASSWORD");
                PASSWORD = scanner.nextLine();

                userLogged = userDaoImpl.getUserByEmail(EMAIL);
            }

            CURRENT_USER.setName(userLogged.getName());
            CURRENT_USER.setEmail(userLogged.getEmail());
            CURRENT_USER.setPassword(userLogged.getPassword());
            CURRENT_USER.setLoggedIn(true);

            System.out.println("Log in successful");
            return true;

        } else if (nextLine.equalsIgnoreCase("EXIT")) {
            System.out.println("You have exit the application successfully");
            return false;
        } else {
            System.out.println("Command not recognise, please try again.\n");
            return UserRegistration(scanner, userDaoImpl, CURRENT_USER);
        }
    }
}
