import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class EditClass implements getUser {
    final private ArrayList<Task> todolist;

    Scanner susan = new Scanner(System.in);
    public EditClass(ArrayList<Task> todolist){
        this.todolist = todolist;
    }

    public void execute(){
        System.out.println("Enter task to be edited");
        String oldTask = susan.nextLine().toLowerCase();
        boolean found = false;
        for (Task task : todolist) {
            if (task.getTaskName().equalsIgnoreCase(oldTask)) {
                found = true;
                System.out.println("Enter new task to be updated");
                String newTask = susan.nextLine();
                String date = getDate();
                LocalDate dueDate = LocalDate.parse(date);
                task.setTaskName(newTask);
                task.setCompleted(false);
                task.setDueDate(dueDate);
                break;
            }
        }
        if (found) {
            System.out.println("Task updated successfully");
        } else {
            System.out.println("The entered task is not present");
        }
    }

    @Override
    public String getTaskName() {
        return null;
    }

    @Override
    public boolean getBooleanInput() {
        while (true) {
            try {
                System.out.println("Please enter 'true' or 'false': completion");
                return susan.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
                susan.nextLine(); // Consume the invalid input to avoid infinite loop
            }
        }
    }

    @Override
    public boolean isTaskPresent(String taskName) {
        return false;
    }

    @Override
    public String getDate() {
        while (true) {
            try {
                System.out.println("Enter date (YYYY-MM-DD):");
                String date = susan.nextLine();
                LocalDate.parse(date); // Validate the date format
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date in the format (YYYY-MM-DD).");
            }
        }
    }

}
