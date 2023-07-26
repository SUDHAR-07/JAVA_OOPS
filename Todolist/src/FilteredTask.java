import java.util.ArrayList;
import java.util.Scanner;

public class FilteredTask implements Filter{
    final private ArrayList<Task> todolist;

    Scanner susan = new Scanner(System.in);

    public FilteredTask(ArrayList<Task> todolist){
        this.todolist = todolist;
    }

    public void execute(){
        System.out.println("1. Filter by Completed tasks");
        System.out.println("2. Filter by Non-Completed tasks");
        int filterOption = susan.nextInt();
        susan.nextLine();
        switch (filterOption) {
            case 1 -> filterTaskbyStatus(true); // Filter by completed tasks
            case 2 -> filterTaskbyStatus(false); // Filter by incomplete tasks
            default -> System.out.println("Invalid filter option.");
        }
    }
    public void prioritize(){
        System.out.println("1. Filter by Prioritized tasks");
        System.out.println("2. Filter by Non-Prioritized tasks");
        int filterOption = susan.nextInt();
        susan.nextLine();
        switch (filterOption) {
            case 1 -> filterTaskbyprioritize(true); // Filter by completed tasks
            case 2 -> filterTaskbyprioritize(false); // Filter by incomplete tasks
            default -> System.out.println("Invalid filter option.");
        }
    }

    @Override
    public void filterTaskbyStatus(boolean isCompleted) {
        System.out.println("------TASKS FILTERED BY STATUS-------");
        int taskNumber = 1;
        for (Task task : todolist) {
            if (task.isCompleted() == isCompleted) {
                task.showTask(taskNumber);
                taskNumber++;
            }
        }
        if (taskNumber == 1) {
            System.out.println("No tasks found with the specified status.");
        }
    }

    @Override
    public void filterTaskbyprioritize(boolean isPrioritize) {
        System.out.println("TASKS FILTERED BY PRIORITIZE");
        int taskNumber = 1;
        for(Task task : todolist){
            if(task.isPrioritize() == isPrioritize){
                task.showTask(taskNumber);
                taskNumber++;
            }
        }
        if(taskNumber == 1){
            System.out.println("No task found with the prioritize");
        }
    }
}
