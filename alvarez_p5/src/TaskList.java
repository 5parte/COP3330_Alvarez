import java.util.ArrayList;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class TaskList implements Serializable {
    protected ArrayList<TaskItem> list = new ArrayList<TaskItem>();

    void addItem(TaskItem newItem) {
        this.list.add(newItem);
    }

    void removeItem(int index) {
        if (isIndexValid(index)) {
            this.list.remove(index);
        }
        else {
            throw new IndexOutOfBoundsException("WARNING: index is not valid; must access an existing item");
        }
    }

    TaskItem getItem(int index) {
        if (isIndexValid(index)) {
            return this.list.get(index);
        }
        else {
            throw new IndexOutOfBoundsException("WARNING: index is not valid; must access an existing item");
        }
    }

    void setItem(int index, TaskItem Item) {
        this.list.set(index, Item);
    }

    private Boolean isIndexValid(int index) {
        return index <= this.list.size();
    }

    void saveList(String fileName, TaskList list) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(list);
            output.close();
            System.out.println("task list has been saved");
        }
        catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    TaskList loadList(String pathName) {
        try {
            FileInputStream fileStream = new FileInputStream(pathName);
            ObjectInputStream input = new ObjectInputStream(fileStream);
            TaskList list = (TaskList) input.readObject();
            input.close();
            System.out.println("task list has been loaded");
            return list;
        }
        catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }
}
