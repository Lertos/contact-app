import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<Contact> contactList;

    public ContactList() {
        this.contactList = new ArrayList<>();
    }

    public void emptyContactList() {
        contactList.clear();
    }

    public boolean addContact(String name, String cellNumber, String homeNumber) {
        if (nameExists(name)) {
            System.out.println("That contact name already exists.");
            return false;
        } else if (cellNumberExists(cellNumber)) {
            System.out.println("That cell number already exists.");
            return false;
        } else if (homeNumberExists(homeNumber)) {
            System.out.println("That home number already exists.");
            return false;
        }

        PhoneNumber newCellNumber = null;
        PhoneNumber newHomeNumber = null;

        if (cellNumber != "") {
            newCellNumber = Main.isValidPhoneNumber(cellNumber, "cell");

            if (newCellNumber == null)
                return false;
        }

        if (homeNumber != "") {
            newHomeNumber = Main.isValidPhoneNumber(homeNumber, "home");

            if (newHomeNumber == null)
                return false;
        }

        if (newCellNumber == null && newHomeNumber == null)
            return false;

        Contact newContact = new Contact(name, newCellNumber, newHomeNumber);
        contactList.add(newContact);

        return true;
    }

    public boolean removeContact(int index) {
        if (contactList.size() < index || index < 0) {
            System.out.println("The id provided does not exist.");
            return false;
        }

        contactList.remove(index);
        return true;
    }

    public boolean updateContactName(int index, String newName) {
        if (contactList.size() < index || index < 0) {
            System.out.println("The id provided does not exist.");
            return false;
        }

        if (nameExists(newName)) {
            System.out.println("That contact name already exists.");
            return false;
        }

        contactList.get(index).setName(newName);
        return true;
    }

    public boolean updateCellNumber(int index, String newNumber) {
        if (contactList.size() < index || index < 0) {
            System.out.println("The id provided does not exist.");
            return false;
        }

        if (cellNumberExists(newNumber)) {
            System.out.println("That cell number already exists.");
            return false;
        }

        PhoneNumber newCellNumber = null;

        if (newNumber != "") {
            newCellNumber = Main.isValidPhoneNumber(newNumber, "cell");

            if (newCellNumber == null)
                return false;
        }

        contactList.get(index).setCellNumber(newCellNumber);
        return true;
    }

    public boolean updateHomeNumber(int index, String newNumber) {
        if (contactList.size() < index || index < 0) {
            System.out.println("The id provided does not exist.");
            return false;
        }

        if (homeNumberExists(newNumber)) {
            System.out.println("That home number already exists.");
            return false;
        }

        PhoneNumber newHomeNumber = null;

        if (newNumber != "") {
            newHomeNumber = Main.isValidPhoneNumber(newNumber, "cell");

            if (newHomeNumber == null)
                return false;
        }

        contactList.get(index).setHomeNumber(newHomeNumber);
        return true;
    }

    private boolean nameExists(String name) {
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    private boolean cellNumberExists(String cellNumber) {
        for (Contact contact : contactList) {
            if (contact.getCellNumber().toString().equalsIgnoreCase(cellNumber))
                return true;
        }
        return false;
    }

    private boolean homeNumberExists(String homeNumber) {
        for (Contact contact : contactList) {
            if (contact.getHomeNumber().toString().equalsIgnoreCase(homeNumber))
                return true;
        }
        return false;
    }

}
