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