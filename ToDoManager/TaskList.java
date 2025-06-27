public class TaskList {
    private TaskNode head;
    private int size;

    /** Add a task to the *end* of the list */
    public void addTask(String description) {
        TaskNode newNode = new TaskNode(new Task(description));

        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /** Mark task at 1-based index as completed. Returns true if success. */
    public boolean markTaskCompleted(int index) {
        if (index < 1 || index > size) return false;

        TaskNode current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.task.markAsCompleted();
        return true;
    }

    /** Print every task with index, e.g. "1. [ ] Buy milk" */
    public void printTasks() {
        if (head == null) {
            System.out.println("   (no tasks)");
            return;
        }

        TaskNode current = head;
        int idx = 1;
        while (current != null) {
            System.out.println(idx + ". " + current.task);
            current = current.next;
            idx++;
        }
    }

    public int size() {
        return size;
    }
}
