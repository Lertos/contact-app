import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response = "-";

        PhoneNumber phoneNumber = isValidPhoneNumber("1-555-555-5555", "cell");
        PhoneNumber phoneNumber2 = isValidPhoneNumber("abcdef", "cell");
        System.out.println(phoneNumber);
        System.out.println(phoneNumber2);

        while(!response.equalsIgnoreCase("q")) {

        }
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