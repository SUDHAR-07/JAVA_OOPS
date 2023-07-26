import java.util.*;

public class TodoListApp implements Filter{

    Scanner susan = new Scanner(System.in);
    ArrayList<Task> Todo = new ArrayList<>();
    private int taskNumber = 1;
    public void markAsComplete(Task task){
        task.setCompleted(true);
    }
    private boolean isTaskPresent(String taskName) {
        for (Task task : Todo) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return true;
            }
        }
        return false;
    }
    public void setPrioritize(String taskName){
        for(Task task : Todo){
            if(task.getTaskName().equalsIgnoreCase(taskName)){
                task.setPrioritize(true);
            }
        }
    }
    public void showTask() {
        System.out.println("------ALL TASKS-------");
        for (Task task : Todo) {
            task.showTask(taskNumber);
            taskNumber++;// Use the showTask() method of Task to display individual tasks
        }
        taskNumber=1;
    }

    private String getTask(){
        String taskName;
        while (true) {
            System.out.println("Enter task");
            taskName = susan.nextLine();
            if (taskName.isEmpty() || taskName.trim().length() == 0) {
                System.out.println("INVALID Input please enter again");
            }else if(isTaskPresent(taskName)) {
                System.out.println("Task is present already");
            }else{
                System.out.println("task name added successfully");
                return taskName;
            }
        }
    }
    private boolean getBooleanInput() {
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
                    String newTask = getTask();
                    boolean f = getBooleanInput();
                    Todo.add(new Task(newTask.toLowerCase(), f));
                    System.out.println(newTask + " is added");
                    getChoice();
                }
                case 2 -> {
                    System.out.println("Enter task to be removed");
                    String rem = susan.nextLine().toLowerCase();
                    Iterator<Task> iterator = Todo.iterator();
                    boolean removed = false;
                    while (iterator.hasNext()) {
                        Task task = iterator.next();
                        if (task.getTaskName().equalsIgnoreCase(rem)) {
                            iterator.remove(); // Safely remove the task using the iterator
                            System.out.println("The task is successfully removed");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("The entered task is not present");
                    }
                    getChoice();
                }
                case 3 -> {
                    System.out.println("Enter task to be edited");
                    String oldTask = susan.nextLine().toLowerCase();
                    boolean found = false;
                    for (Task task : Todo) {
                        if (task.getTaskName().equalsIgnoreCase(oldTask)) {
                            found = true;
                            System.out.println("Enter new task to be updated");
                            String newTask = susan.nextLine();
                            boolean f = getBooleanInput();
                            task.setTaskName(newTask);
                            task.setCompleted(f);
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Task updated successfully");
                    } else {
                        System.out.println("The entered task is not present");
                    }
                    getChoice();
                }
                case 4 -> {
                    showTask();
                    getChoice();
                }
                case 5->{
                    System.out.println("Enter task to be marked as completed");
                    String taskToMark = susan.nextLine().toLowerCase();
                    boolean found = false;
                    for (Task task : Todo) {
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
                    getChoice();
                }
                case 6 ->{
                        System.out.println("1. Filter by completed tasks");
                        System.out.println("2. Filter by incomplete tasks");
                        int filterOption = susan.nextInt();
                        susan.nextLine();
                        switch (filterOption) {
                            case 1 -> filterTaskbyStatus(true); // Filter by completed tasks
                            case 2 -> filterTaskbyStatus(false); // Filter by incomplete tasks
                            default -> {
                                System.out.println("Invalid filter option.");
                                getChoice();
                            }
                        }
                        getChoice();
                }
                case 7 ->{
                    System.out.println("Enter task to be prioritize");
                    String taskName = susan.nextLine();
                    if(isTaskPresent(taskName)){
                        setPrioritize(taskName);
                    }else{
                        System.out.println("Task is not present");
                    }
                    getChoice();
                }
                case 8 ->{
                    System.out.println("1. Filter by Prioritized tasks");
                    System.out.println("2. Filter by Non-Prioritized tasks");
                    int filterOption = susan.nextInt();
                    susan.nextLine();
                    switch (filterOption) {
                        case 1 -> filterTaskbyprioritize(true); // Filter by completed tasks
                        case 2 -> filterTaskbyprioritize(false); // Filter by incomplete tasks
                        default -> {
                            System.out.println("Invalid filter option.");
                            getChoice();
                        }
                    }
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
//            System.out.println(e);
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

    @Override
    public void filterTaskbyStatus(boolean isCompleted) {
        System.out.println("------TASKS FILTERED BY STATUS-------");
        int taskNumber = 1;
        for (Task task : Todo) {
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
        for(Task task : Todo){
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
