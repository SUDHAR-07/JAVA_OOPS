import java.util.ArrayList;
import java.util.Scanner;

public class MarkedClass {
    final private ArrayList<Task> todolist;

    Scanner susan = new Scanner(System.in);
    public MarkedClass(ArrayList<Task> todolist){
        this.todolist = todolist;
    }

    public void markAsComplete(Task task){
        task.setCompleted(true);
    }
    public void execute(){
        System.out.println("Enter task to be marked as completed");
        String taskToMark = susan.nextLine().toLowerCase();
        boolean found = false;
        for (Task task : todolist) {
            if (task.getTaskName().equalsIgnoreCase(taskToMark)) {
                found = true;
                markAsComplete(task); // Call the markAsComplete method and pass the task
                System.out.println("Task marked as completed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("The entered task is not present.");
        }
    }
}
