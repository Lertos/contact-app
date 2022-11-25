
public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Menu menu = new Menu(contactList);

        menu.start();
    }

    public static PhoneNumber isValidPhoneNumber(String number, String phoneType) {
        PhoneNumber pn = null;

        try {
            pn = new PhoneNumber(number, phoneType);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return pn;
    }
}