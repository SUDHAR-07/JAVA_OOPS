import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
public class AddTask implements getUser{
    final private ArrayList<Task> todoList;
    Scanner susan = new Scanner(System.in);

    public AddTask(ArrayList<Task> todoList) {
        this.todoList = todoList;
    }


    public void execute() {
        String newTaskName = getTaskName();
        String dueDateStr = getDate();
        boolean isCompleted = false;
        LocalDate dueDate = LocalDate.parse(dueDateStr);
        todoList.add(new Task(newTaskName.toLowerCase(), isCompleted,dueDate));
        System.out.println(newTaskName + " is added");
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


    @Override
    public String getTaskName() {
        String taskName;
        while (true) {
            System.out.println("Enter task");
            taskName = susan.nextLine();
            if (taskName.isEmpty() || taskName.trim().length() == 0) {
                System.out.println("INVALID Input please enter again");
            } else if (isTaskPresent(taskName)) {
                System.out.println("Task is present already");
            } else {
                System.out.println("task name added successfully");
                return taskName;
            }
        }
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
        for (Task task : todoList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return true;
            }
        }
        return false;
    }
}
