import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void validContactShouldBeCreated() {
        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("12345", contact.getContactId());
        assertEquals("Darrien", contact.getFirstName());
        assertEquals("Perry", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void contactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Darrien", "Perry",
                        "1234567890", "123 Main Street"));
    }

    @Test
    void contactIdCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "Darrien", "Perry",
                        "1234567890", "123 Main Street"));
    }

    @Test
    void contactIdCannotBeUpdated() {
        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("12345", contact.getContactId());
    }

    @Test
    void firstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Perry",
                        "1234567890", "123 Main Street"));
    }

    @Test
    void firstNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Christopher", "Perry",
                        "1234567890", "123 Main Street"));
    }

    @Test
    void lastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", null,
                        "1234567890", "123 Main Street"));
    }

    @Test
    void lastNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", "Richardsons",
                        "1234567890", "123 Main Street"));
    }

    @Test
    void phoneMustBeExactly10Digits() {
        Contact contact = new Contact(
                "12345",
                "Darrien",
                "Perry",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    void phoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", "Perry",
                        null, "123 Main Street"));
    }

    @Test
    void phoneCannotHaveFewerThan10Digits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", "Perry",
                        "123456789", "123 Main Street"));
    }

    @Test
    void phoneCannotHaveMoreThan10Digits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", "Perry",
                        "12345678901", "123 Main Street"));
    }

    @Test
    void phoneMustContainOnlyDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", "Perry",
                        "12345abcde", "123 Main Street"));
    }

    @Test
    void addressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", "Perry",
                        "1234567890", null));
    }

    @Test
    void addressCannotBeLongerThan30Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Darrien", "Perry",
                        "1234567890",
                        "1234567890123456789012345678901"));
    }
}