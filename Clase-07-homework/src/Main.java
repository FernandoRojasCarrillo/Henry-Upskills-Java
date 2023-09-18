import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Map> Tasks = new ArrayList<>();

        showMenu(Tasks);
    }

    public static void addNewTask(List<Map> tasks) {
        Scanner scanner = new Scanner(System.in);
        try {
            do {

                System.out.println("To go back to the menu write (MENU)");
                System.out.println("Create a new task!\n");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("MENU")) {
                    break;
                }

                Map<String, String> newTask = new HashMap<>();
                newTask.put("id", String.valueOf(tasks.size()));
                newTask.put("task", userInput);
                newTask.put("completed", "false");

                tasks.add(newTask);
                System.out.println("Task created successfully 😉\n");
            } while (true);

            showMenu(tasks);
        } catch (InputMismatchException error) {
            System.out.println("There was an error, please try again!");
            addNewTask(tasks);
        }
        scanner.close();
    }

    public static void showAllTasks(List<Map> tasks) {
        System.out.println("------------------------------- \n");

        System.out.println("ALL THE TASKS CREATED \n");

        tasks.forEach((task) -> {
            System.out.println("Task ID: " + task.get("id") + ", Task: " + task.get("task") + ", Completed: " + task.get("completed"));
        });

        System.out.println("\n -------------------------------");
        showMenu(tasks);
    }

    public static void exitApplication() {
        System.out.println("\n You exist the application, I hope to see you again!! 😀👋");
    }

    public static void markTaskAsCompleted(List<Map> tasks) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ready!, to mark a task as completed enter de task's ID");
            String taskId = scanner.nextLine();

            for (Map task : tasks) {
                if (task.get("id").equals(taskId)) {
                    task.put("completed", "true");
                }
            }

            System.out.println("Task mark as completed, good job 😉👍");

            showMenu(tasks);
        } catch (InputMismatchException error) {
            System.out.println("ERROR, task's id does not exist!!!");
            showMenu(tasks);
        }
        scanner.close();

    }

    public static void deleteTask(List<Map> tasks) {
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("\n To delete a task enter the task's ID \n");
            String taskId = scanner.nextLine();

            for (Map task : tasks) {
                if (task.get("id").equals(taskId)) {
                    tasks.remove(task);
                    break;
                }
            }

            showMenu(tasks);
        } catch (InputMismatchException error) {
            System.out.println("ERROR, the task's id does not exist!!!");
            showMenu(tasks);
        }
        scanner.close();
    }

    public static void showMenu(List<Map> tasks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n APPLICATION MENU \n");

        System.out.println("(A): Create a new task");
        System.out.println("(B): Mark a task as complete by ID");
        System.out.println("(C): Delete a task by ID");
        System.out.println("(D): Show all the tasks");
        System.out.println("(E): Exit application\n");

        String optionEntered = scanner.nextLine();

        switch (optionEntered.toUpperCase()) {
            case "A" -> addNewTask(tasks);
            case "B" -> markTaskAsCompleted(tasks);
            case "C" -> deleteTask(tasks);
            case "D" -> showAllTasks(tasks);
            case "E" -> exitApplication();
            default -> showMenu(tasks);
        }

        scanner.close();
    }
}