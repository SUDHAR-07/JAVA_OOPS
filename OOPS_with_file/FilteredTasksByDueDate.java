import java.time.LocalDate;
import java.util.ArrayList;

public class FilteredTasksByDueDate implements FilterByDueDate{
   final private ArrayList<Task> todolist;
   public FilteredTasksByDueDate(ArrayList<Task> todolist){
       this.todolist = todolist;
   }
//   public void execute(){
//       filterTaskByDueDate();
//   }
    @Override
    public void filterTaskByDueDate(LocalDate date) {
        System.out.println("------TASKS FILTERED BY DUE DATE-------");
        int taskNumber = 1;
        for (Task task : todolist) {
            if (task.getDueDate() != null && task.getDueDate().equals(date)) {
                task.showTask(taskNumber);
                taskNumber++;
            }
        }
        if (taskNumber == 1) {
            System.out.println("No tasks found with the specified due date.");
        }
    }

    @Override
    public void filterTaskbyStatus(boolean isCompleted) {

    }

    @Override
    public void filterTaskbyprioritize(boolean isPrioritize) {

    }
}
