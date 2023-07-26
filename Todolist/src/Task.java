public class Task {

    String TaskName;
    boolean completed;

    boolean prioritize;
    public boolean isPrioritize() {
        return prioritize;
    }

    public void setPrioritize(boolean prioritize) {
        this.prioritize = prioritize;
    }

    public Task(String taskName, boolean completed) {
        TaskName = taskName;
        this.completed = completed;
    }


    public void showTask(int taskNumber) {
        System.out.println("TASK-NAME " + taskNumber + ") " + TaskName);
        System.out.println("Is Task completed - " + completed);
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
}
