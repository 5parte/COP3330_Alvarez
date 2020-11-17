import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        assertEquals(0, list.list.size());
        list.addItem(item);
        assertEquals(1, list.list.size());
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        list.addItem(item);
        list.getItem(0).setTitle("newTitle");
        list.getItem(0).setDescription("is new description");
        list.getItem(0).setDueDate("2020-11-13");
        list.getItem(0).setCompleted(true);
        assertEquals(item, list.getItem(0));
    }

    @Test
    public void editingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.getItem(0).setTitle("newTitle"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getItem(0).setDescription("is new description"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getItem(0).setDueDate("2020-11-13"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getItem(0).setCompleted(true));
    }

    @Test
    public void gettingTaskItemSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        list.addItem(item);
        assertEquals(item, list.getItem(0));
    }

    @Test
    public void gettingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.getItem(0));
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        list.addItem(item);
        assertEquals(1, list.list.size());
        list.removeItem(0);
        assertEquals(0, list.list.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeItem(0));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        list.addItem(item);
        list.saveList("tasks.txt", list);
        TaskList savedList = list.loadList("tasks.txt");
        assertEquals(list.list.size(), savedList.list.size());
        assertEquals(list.getItem(0).title, savedList.getItem(0).title);
        assertEquals(list.getItem(0).description, savedList.getItem(0).description);
        assertEquals(list.getItem(0).dueDate, savedList.getItem(0).dueDate);
        assertEquals(list.getItem(0).completed, savedList.getItem(0).completed);
    }
}