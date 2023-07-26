import java.util.*;

public class RemoveTask{
    final private ArrayList<Task> todoList;

    Scanner susan = new Scanner(System.in);
    public RemoveTask(ArrayList<Task> todoList) {
        this.todoList = todoList;
    }

    public void execute(){
        System.out.println("Enter task to be removed");
        String taskToRemove = susan.nextLine().toLowerCase();
        Iterator<Task> iterator = todoList.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskName().equalsIgnoreCase(taskToRemove)) {
                iterator.remove(); // Safely remove the task using the iterator
                System.out.println("The task is successfully removed");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("The entered task is not present");
        }
    }
}



