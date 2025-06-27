public class Task {
    private final String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed   = false;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String status = completed ? "[Done]" : "[ ]";
        return status + " " + description;
    }
}
