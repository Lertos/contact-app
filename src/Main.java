import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response = "-";

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