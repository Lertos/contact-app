import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response = "-";

        boolean phoneNumber = isValidPhoneNumber("1-555-555-5555", "cell");
        boolean phoneNumber2 = isValidPhoneNumber("1-555-555-5555", "cell");
        System.out.println(phoneNumber);
        System.out.println(phoneNumber2);

        while(!response.equalsIgnoreCase("q")) {

        }
    }

    private static boolean isValidPhoneNumber(String number, String phoneType) {
        try {
            PhoneNumber pn = new PhoneNumber(number, phoneType);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}