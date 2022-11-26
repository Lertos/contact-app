import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactListTest {

    private ContactList contactList;

    @Before
    public void setup() {
         contactList = new ContactList();
         contactList.addContact("Dee", "1-555-555-5555", "1-666-666-6666");
    }

    @Test
    public void size() {
        assertEquals(1, contactList.size());
    }

    @Test
    public void emptyContactList() {
        assertEquals(1, contactList.size());

        contactList.emptyContactList();

        assertEquals(0, contactList.size());
    }

    @Test
    public void addContact() {
        assertEquals(1, contactList.size());

        //Testing duplicate names not being allowed
        assertFalse(contactList.addContact("Dee", "1-555-555-5556", "1-666-666-6667"));

        //Testing duplicate cell number not being allowed
        assertFalse(contactList.addContact("Jack", "1-555-555-5555", "1-666-666-6667"));

        //Testing duplicate cell number not being allowed
        assertFalse(contactList.addContact("Sally", "1-555-555-5557", "1-666-666-6666"));

        //Testing incorrect phone format
        assertFalse(contactList.addContact("Russell", "56-565-56", "1-666-666-6667"));

        //Testing correct format
        assertFalse(contactList.addContact("Bree", "1-444-444-4444", "1-777-777-7777"));
    }

    @Test
    public void removeContact() {
    }

    @Test
    public void updateContactName() {
    }

    @Test
    public void updateCellNumber() {
    }

    @Test
    public void updateHomeNumber() {
    }
}