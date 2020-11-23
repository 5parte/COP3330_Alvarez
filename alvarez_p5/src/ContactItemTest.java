import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        assertDoesNotThrow(() -> item);
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "");
        assertDoesNotThrow(() -> item);
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("", "lastName", "123-456-7891", "name@email.com");
        assertDoesNotThrow(() -> item);
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("firstName", "", "123-456-7891", "name@email.com");
        assertDoesNotThrow(() -> item);
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("firstName", "lastName", "", "name@email.com");
        assertDoesNotThrow(() -> item);
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        item.setFirstName("");
        item.setLastName("");
        item.setPhoneNumber("");
        assertThrows(IllegalArgumentException.class, () -> item.setEmail(""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        item.setFirstName("");
        assertEquals("", item.firstName);
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        item.setLastName("");
        assertEquals("", item.lastName);
    }

    @Test
    public void editingSucceedsWithBlankPhoneNumber() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        item.setPhoneNumber("");
        assertEquals("", item.phoneNumber);
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        item.setEmail("");
        assertEquals("", item.email);
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("firstName", "lastName", "123-456-7891", "name@email.com");
        item.setFirstName("newFirstName");
        item.setLastName("newLastName");
        item.setPhoneNumber("235-711-1317");
        item.setEmail("newName@email.com");
        assertEquals("newFirstName", item.firstName);
        assertEquals("newLastName", item.lastName);
        assertEquals("235-711-1317", item.phoneNumber);
        assertEquals("newName@email.com", item.email);
    }
}