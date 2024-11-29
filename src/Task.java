import java.time.LocalDate;

public class Task {
    private static int idCounter=0;
    private int taskId;
    private String taskName;
    private LocalDate taskDate;
    private String priority;
    private String status;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task(String taskName, LocalDate taskDate, String priority, User user) {
        this.taskId = ++idCounter;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.priority = priority;
        this.status = "Pending";
        this.user = user;
    }

    public int getTaskId() {return taskId;}
    public String getTaskName() {return taskName;}
    public LocalDate getTaskDate() {return taskDate;}
    public String getPriority() {return priority;}
    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDate=" + taskDate +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void printTask() {
        System.out.println(taskId + "  " + taskName + "  " + taskDate + "  " + priority);
    }
}
