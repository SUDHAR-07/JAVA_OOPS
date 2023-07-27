import java.time.LocalDate;

public class Task {

    String TaskName;
    boolean completed;
    private LocalDate dueDate;
    boolean prioritize;
    public boolean isPrioritize() {
        return prioritize;
    }

    public void setPrioritize(boolean prioritize) {
        this.prioritize = prioritize;
    }

    public Task(String taskName){
        this.TaskName = taskName;
    }
    public Task(String taskName, boolean completed,LocalDate dueDate) {
        this.TaskName = taskName;
        this.completed = completed;
        this.dueDate = dueDate;
    }


    public void showTask(int taskNumber) {
        System.out.println("TASK-NAME " + taskNumber + ") " + TaskName);
        System.out.println("Is Task completed - " + completed);
        if (dueDate != null) {
            System.out.println("Due Date: " + dueDate);
        }
    }
    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
