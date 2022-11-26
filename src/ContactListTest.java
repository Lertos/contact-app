import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactListTest {

    private ContactList contactList;

    @Before
    public void setup() {
         contactList = new ContactList();
         contactList.addContact("Dee", "1-555-555-5555", "1-666-666-6666");

        assertEquals(1, contactList.size());
    }

    @Test
    public void emptyContactList() {
        contactList.emptyContactList();

        assertEquals(0, contactList.size());
    }

    @Test
    public void addContact() {
        //Testing duplicate names not being allowed
        assertFalse(contactList.addContact("Dee", "1-555-555-5556", "1-666-666-6667"));

        //Testing duplicate cell number not being allowed
        assertFalse(contactList.addContact("Jack", "1-555-555-5555", "1-666-666-6667"));

        //Testing duplicate cell number not being allowed
        assertFalse(contactList.addContact("Sally", "1-555-555-5557", "1-666-666-6666"));

        //Testing incorrect phone format
        assertFalse(contactList.addContact("Russell", "56-565-56", "1-666-666-6667"));

        //Testing correct format
        assertTrue(contactList.addContact("Bree", "1-444-444-4444", "1-777-777-7777"));
    }

    @Test
    public void removeContact() {
        //Testing an incorrect index
        assertFalse(contactList.removeContact(10));
        assertFalse(contactList.removeContact(-1));

        //Testing correct index
        assertTrue(contactList.removeContact(0));

        assertEquals(0, contactList.size());
    }

    @Test
    public void updateContactName() {
        //Testing changing to an existing name which is incorrect
        assertTrue(contactList.addContact("Jack", "1-555-555-5556", "1-666-666-6667"));

        assertFalse(contactList.updateContactName(0, "Jack"));

        //Testing a correct change
        assertTrue(contactList.updateContactName(0, "Sally"));

        //Testing trying to change a name when the list is empty
        contactList.emptyContactList();

        assertFalse(contactList.updateContactName(0, "Jim"));
    }

    @Test
    public void updateCellNumber() {
    }

    @Test
    public void updateHomeNumber() {
    }
}