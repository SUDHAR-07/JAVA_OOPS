import java.io.*;
import java.util.ArrayList;

public class TaskManager {
    private final String fileName;

    public TaskManager(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Task> readTasksFromFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> objList) {
                for (Object item : objList) {
                    if (item instanceof Task) {
                        tasks.add((Task) item);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            // If the file does not exist or any other exception occurs during read, return an empty list
            System.out.println("No previous data found. Starting with an empty task list.");
        }
        return tasks;
    }

    public void saveTasksToFile(ArrayList<Task> tasks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tasks);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving tasks to file.");
        }
    }
}
