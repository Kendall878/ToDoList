public class User {
    private final String name;
    private final TaskList taskList = new TaskList();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        taskList.addTask(description);
    }

    public boolean markTaskCompleted(int index) {
        return taskList.markTaskCompleted(index);
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
    }
}
