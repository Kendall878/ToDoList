import java.util.Scanner;

public class Main {
    private static final int MAX_USERS = 10;
    private static final User[] users  = new User[MAX_USERS];
    private static int userCount       = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== To-Do List Manager ===");
            System.out.println("1. Create user");
            System.out.println("2. Add task to user");
            System.out.println("3. Mark task completed");
            System.out.println("4. View user's tasks");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = safeInt(sc);

            switch (choice) {
                case 1:
                    createUser(sc);
                    break;
                case 2:
                    addTaskToUser(sc);
                    break;
                case 3:
                    markTaskDone(sc);
                    break;
                case 4:
                    viewTasks(sc);
                    break;
                case 5:
                    System.out.println("Bye Bye");
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }

    /* Menu actions */

    private static void createUser(Scanner sc) {
        if (userCount == MAX_USERS) {
            System.out.println("User limit reached.");
            return;
        }
        System.out.print("Enter new user name: ");
        String name = sc.nextLine().trim();
        if (findUser(name) != null) {
            System.out.println("That name is already taken.");
            return;
        }
        users[userCount++] = new User(name);
        System.out.println("User \"" + name + "\" created.");
    }

    private static void addTaskToUser(Scanner sc) {
        User u = promptUser(sc);
        if (u == null) return;
        System.out.print("Enter task description: ");
        String desc = sc.nextLine().trim();
        u.addTask(desc);
        System.out.println("Task added.");
    }

    private static void markTaskDone(Scanner sc) {
        User u = promptUser(sc);
        if (u == null) return;
        u.printTasks();
        System.out.print("Enter task number to mark completed: ");
        int idx = safeInt(sc);
        if (u.markTaskCompleted(idx))
            System.out.println("Marked as completed.");
        else
            System.out.println("Invalid task number.");
    }

    private static void viewTasks(Scanner sc) {
        User u = promptUser(sc);
        if (u != null) u.printTasks();
    }

    /*helpers*/

    private static User promptUser(Scanner sc) {
        if (userCount == 0) {
            System.out.println("No users yet.");
            return null;
        }
        System.out.print("Enter user name: ");
        String name = sc.nextLine().trim();
        User u = findUser(name);
        if (u == null) System.out.println("User not found.");
        return u;
    }

    private static User findUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name))
                return users[i];
        }
        return null;
    }

    /** Read integer or return -1 if bad input */
    private static int safeInt(Scanner sc) {
        String line = sc.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
