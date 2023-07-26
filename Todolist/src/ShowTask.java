import java.util.ArrayList;

public class ShowTask {
    private ArrayList<Task> todolist;

    private int taskNumber = 1;
    public ShowTask(ArrayList<Task> todolist){
        this.todolist = todolist;
    }
    public void execute(){
        System.out.println("------ALL TASKS-------");
        for (Task task : todolist) {
            task.showTask(taskNumber);
            taskNumber++;// Use the showTask() method of Task to display individual tasks
        }
        taskNumber=1;
    }
}
