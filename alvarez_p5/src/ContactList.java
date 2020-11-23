import java.util.ArrayList;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class ContactList implements Serializable {
    protected ArrayList<ContactItem> list = new ArrayList<ContactItem>();

    void addItem(ContactItem newItem) {
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

    ContactItem getItem(int index) {
        if (isIndexValid(index)) {
            return this.list.get(index);
        }
        else {
            throw new IndexOutOfBoundsException("WARNING: index is not valid; must access an existing item");
        }
    }

    private Boolean isIndexValid(int index) {
        return index <= this.list.size();
    }

    void saveList(String fileName, ContactList list) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(list);
            output.close();
            System.out.println("contact list has been saved");
        }
        catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    ContactList loadList(String pathName) {
        try {
            FileInputStream fileStream = new FileInputStream(pathName);
            ObjectInputStream input = new ObjectInputStream(fileStream);
            ContactList list = (ContactList) input.readObject();
            input.close();
            System.out.println("contact list has been loaded");
            return list;
        }
        catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }
}
