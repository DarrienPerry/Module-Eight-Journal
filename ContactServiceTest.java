import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void contactCanBeAdded() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        assertDoesNotThrow(() -> service.addContact(contact));
    }

    @Test
    void duplicateContactIdCannotBeAdded() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        Contact contact2 = new Contact(
                "12345",
                "John",
                "Smith",
                "9876543210",
                "456 Oak Street"
        );

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(contact2));
    }

    @Test
void contactCanBeDeleted() {
    ContactService service = new ContactService();

    Contact contact = new Contact(
            "12345",
            "Darrien",
            "Perry",
            "1234567890",
            "123 Main Street"
    );

    service.addContact(contact);
    service.deleteContact("12345");

    assertThrows(IllegalArgumentException.class, () ->
            service.deleteContact("12345"));
}

    @Test
    void firstNameCanBeUpdated() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateFirstName("12345", "John");

        assertEquals("John", contact.getFirstName());
    }

    @Test
    void lastNameCanBeUpdated() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateLastName("12345", "Smith");

        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void phoneCanBeUpdated() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updatePhone("12345", "9876543210");

        assertEquals("9876543210", contact.getPhone());
    }

    @Test
    void addressCanBeUpdated() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateAddress("12345", "456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }
}