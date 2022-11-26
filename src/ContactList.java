import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private final List<Contact> contactList;

    public ContactList() {
        this.contactList = new ArrayList<>();
    }

    public void emptyContactList() {
        contactList.clear();
    }

    public int size() {
        return contactList.size();
    }

    public Contact getContact(int index) {
        return contactList.get(index);
    }

    public void outputContactList() {
        int index = 0;

        for (Contact contact : contactList) {
            System.out.println(index + " - " + contact.toString());
            index++;
        }
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

        if (!cellNumber.isEmpty()) {
            newCellNumber = Main.isValidPhoneNumber(cellNumber, "cell");

            if (newCellNumber == null)
                return false;
        }

        if (!homeNumber.isEmpty()) {
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
        if (index >= contactList.size() || index < 0) {
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
        if (index >= contactList.size() || index < 0) {
            System.out.println("The id provided does not exist.");
            return false;
        }

        if (cellNumberExists(newNumber)) {
            System.out.println("That cell number already exists.");
            return false;
        }

        PhoneNumber newCellNumber = null;

        if (!newNumber.isEmpty()) {
            newCellNumber = Main.isValidPhoneNumber(newNumber, "cell");

            if (newCellNumber == null) {
                System.out.println("That is an invalid phone number");
                return false;
            }
        }

        contactList.get(index).setCellNumber(newCellNumber);
        return true;
    }

    public boolean updateHomeNumber(int index, String newNumber) {
        if (index >= contactList.size() || index < 0) {
            System.out.println("The id provided does not exist.");
            return false;
        }

        if (homeNumberExists(newNumber)) {
            System.out.println("That home number already exists.");
            return false;
        }

        PhoneNumber newHomeNumber = null;

        if (!newNumber.isEmpty()) {
            newHomeNumber = Main.isValidPhoneNumber(newNumber, "cell");

            if (newHomeNumber == null) {
                System.out.println("That is an invalid phone number");
                return false;
            }
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
            if (contact.getCellNumber().getPhoneNumber().equalsIgnoreCase(cellNumber))
                return true;
        }
        return false;
    }

    private boolean homeNumberExists(String homeNumber) {
        for (Contact contact : contactList) {
            if (contact.getHomeNumber().getPhoneNumber().equalsIgnoreCase(homeNumber))
                return true;
        }
        return false;
    }

}
