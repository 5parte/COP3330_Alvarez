import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        assertEquals(0, list.list.size());
        list.addItem(item);
        assertEquals(1, list.list.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "", "", "");
        list.addItem(item);
        assertThrows(IllegalArgumentException.class, () -> list.getItem(0).setFirstName(""));
    }

    @Test
    public void editingItemFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.getItem(0).setFirstName("firstName"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        list.addItem(item);
        list.getItem(0).setFirstName("newFirstName");
        list.getItem(0).setLastName("newLastName");
        list.getItem(0).setPhoneNumber("235-711-1317");
        list.getItem(0).setEmail("newName@email.com");
        assertEquals("newFirstName", item.firstName);
        assertEquals("newLastName", item.lastName);
        assertEquals("235-711-1317", item.phoneNumber);
        assertEquals("newName@email.com", item.email);
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        list.addItem(item);
        list.getItem(0).setFirstName("");
        assertEquals("", item.firstName);
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "", "", "");
        list.addItem(item);
        list.getItem(0).setLastName("");
        assertEquals("", item.lastName);
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        list.addItem(item);
        list.getItem(0).setPhoneNumber("");
        assertEquals("", item.phoneNumber);
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        list.addItem(item);
        list.getItem(0).setEmail("");
        assertEquals("", item.email);
    }

    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        assertEquals(0, list.list.size());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        list.addItem(item);
        assertEquals(1, list.list.size());
        list.removeItem(0);
        assertEquals(0, list.list.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        assertThrows(IndexOutOfBoundsException.class,() -> list.removeItem(0));
    }
    @Test
    public void savedContactListCanBeLoaded() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        list.addItem(item);
        list.saveList("contacts.txt", list);
        ContactList savedList = list.loadList("contacts.txt");
        assertEquals(list.list.size(), savedList.list.size());
        assertEquals(list.getItem(0).firstName, savedList.getItem(0).firstName);
        assertEquals(list.getItem(0).lastName, savedList.getItem(0).lastName);
        assertEquals(list.getItem(0).phoneNumber, savedList.getItem(0).phoneNumber);
        assertEquals(list.getItem(0).email, savedList.getItem(0).email);
    }
}