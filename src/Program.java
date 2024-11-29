import java.util.Scanner;

public class Program {

    public void todoApp() {

        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        userService.createAccount();
                        break;
                    case 2:
                        userService.login();
                        break;
                    case 3:
                        taskService.addTask();
                        break;
                    case 4:
                        taskService.viewTasks();
                        break;
                    case 5:
                        taskService.updateTaskStatus();
                        break;
                    case 6:
                        taskService.deleteTask();
                        break;
                    case 7:
                        userService.logout();
                        break;
                    case 8:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void showMenu() {
        System.out.println("\nWelcome to TODO App!");
        System.out.println("1. Create an Account");
        System.out.println("2. Login");
        System.out.println("3. Add TODO");
        System.out.println("4. View TODOs");
        System.out.println("5. Update Task Status");
        System.out.println("6. Delete task");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
}
