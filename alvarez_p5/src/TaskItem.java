import java.io.Serializable;

public class TaskItem implements Serializable {
    protected String title;
    protected String description;
    protected String dueDate;
    protected Boolean completed;

    public TaskItem (String title, String description, String dueDate, Boolean completed) {
        if(isTitleValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("title is not valid; must be at least 1 character long");
        }
        this.description = description;
        if(isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("due date is not valid; must be in the form YYYY-MM-DD");
        }
        this.completed = completed;
    }

    public void setTitle(String title) {
        if(isTitleValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("WARNING: title is not valid; must be at least 1 character long");
        }
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        if(isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("WARNING: due date is not valid; must be in the form YYYY-MM-DD");
        }
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    private Boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    private Boolean isDueDateValid(String dueDate) {
        return dueDate.matches("\\d{4}-\\d{2}-\\d{2}");
    }

}
