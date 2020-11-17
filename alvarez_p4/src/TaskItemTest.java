import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("title", "is description", "invalid", false));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "is description", "2001-03-03", false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitleAndDueDate() {
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        assertDoesNotThrow(() -> item);
        assertEquals("title", item.title);
        assertEquals("is description", item.description);
        assertEquals("2001-03-03", item.dueDate);
        assertEquals(false, item.completed);
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        assertThrows(IllegalArgumentException.class, () -> item.setDueDate("invalid"));
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        item.setDueDate("2020-11-13");
        assertEquals("2020-11-13",item.dueDate);
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        assertThrows(IllegalArgumentException.class, () -> item.setTitle(""));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem item = new TaskItem("title", "is description", "2001-03-03", false);
        item.setTitle("new Title");
        assertEquals("new Title",item.title);
    }

}