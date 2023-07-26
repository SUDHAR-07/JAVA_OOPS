import java.util.*;

public class TodoListApp {
    Scanner susan = new Scanner(System.in);
    ArrayList<Task> Todo = new ArrayList<>();

    public void getChoice() {
        System.out.println("1. ADD TASK");
        System.out.println("2. REMOVE TASK");
        System.out.println("3. EDIT TASK");
        System.out.println("4. SHOW TASKS");
        System.out.println("5. MARK AS COMPLETE");
        System.out.println("6. FILTER BY TASK STATUS");
        System.out.println("7. SET-PRIORITIZE");
        System.out.println("8. FILTER TASK BY PRIORITIZE");
        System.out.println("9. EXIT");
        try {
            int s = susan.nextInt();
            susan.nextLine();
            switch (s) {
                case 1 -> {
                    AddTask addTask = new AddTask(Todo);
                    addTask.execute();
                    getChoice();
                }
                case 2 -> {
                    RemoveTask removeTask = new RemoveTask(Todo);
                    removeTask.execute();
                    getChoice();
                }
                case 3 -> {
                    EditClass editClass = new EditClass(Todo);
                    editClass.execute();
                    getChoice();
                }
                case 4 -> {
                    ShowTask showTask = new ShowTask(Todo);
                    showTask.execute();
                    getChoice();
                }
                case 5->{
                    MarkedClass markedClass = new MarkedClass(Todo);
                    markedClass.execute();
                    getChoice();
                }
                case 6 ->{
                    FilteredTask filteredTask = new FilteredTask(Todo);
                    filteredTask.execute();
                    getChoice();
                }
                case 7 ->{
                    System.out.println("Enter task to be prioritize");
                    String taskName = susan.nextLine();
                    Task task = new Task(taskName);
                    task.setPrioritize(true);
                    getChoice();
                }
                case 8 ->{
                    FilteredTask filteredTask = new FilteredTask(Todo);
                    filteredTask.prioritize();
                    getChoice();
                }
                case 9 -> {
                    System.out.println("THANK YOU ");
                    System.exit(0);
                }
                default -> {
                    System.out.println("INVALID OPTION");
                    getChoice();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            susan.nextLine();
            getChoice();
        }
    }

    public static void main(String[] args) {
        TodoListApp obj = new TodoListApp();
        obj.getChoice();
//        user obj1 = (user) new TodoListApp();
//        obj1.setUserName("SUSAN");
//        obj1.getChoice();
//        user obj1 = new user("STUDY",false);
//        String demo = obj1.getTaskName();
//        System.out.println(demo);
    }

}
