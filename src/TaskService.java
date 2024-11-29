import java.security.Provider;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskService {

    public static void addTask(){
        if (Storage.currentUser == null) {
            System.out.println("You are not logged in!");
            return;
        }

        System.out.print("Enter task name: ");
        String name = UserService.scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(UserService.scanner.nextLine());
        System.out.print("Enter priority (Low, Medium, High): ");
        String priority = UserService.scanner.nextLine();

        Task newTask = new Task(name,dueDate,priority, UserService.currentUser);
        Storage.tasks.add(newTask);
        System.out.println("Task created successfully!");
    }

    public static void viewTasks(){
        if (Storage.currentUser == null) {
            throw new RuntimeException("You are not logged in!");
        }
        if (Storage.tasks.isEmpty()) {
            throw new RuntimeException("There are no tasks to view!");
        }

        for (Task task : Storage.tasks) {
            if (task.getUser().equals(Storage.currentUser)) {
                task.printTask();
            }
        }
    }

    public static void updateTaskStatus(){
        if (Storage.currentUser == null) {
            throw new RuntimeException("You are not logged in!");
        }
        if (Storage.tasks.isEmpty()) {
            throw new RuntimeException("There are no tasks to update!");
        }

        viewTasks();

        System.out.print("Enter task ID: ");
        int id = UserService.scanner.nextInt();


        for (Task task : Storage.tasks) {
            if (task.getTaskId() == id) {
                System.out.print("Enter new status (Pending, In Progress, Completed): ");
                String status = UserService.scanner.nextLine();

                task.setStatus(status);
                System.out.println("Task status updated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask() {

        if (Storage.currentUser == null) {
            System.out.println("You are not logged in!");
            return;
        }
        if (Storage.tasks.isEmpty()) {
            System.out.println("There are no tasks to delete!");
        }

        viewTasks();

        System.out.print("Enter task ID: ");
        int id = UserService.scanner.nextInt();

        Storage.tasks.removeIf(task -> task.getTaskId() == id && task.getUser().equals(Storage.currentUser));
        System.out.println("Task deleted successfully!");
    }
}
