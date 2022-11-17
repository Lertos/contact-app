import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response = "-";

        try {
            PhoneNumber pn = new PhoneNumber("1-555-555-5555", "cell");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        while(!response.equalsIgnoreCase("q")) {

        }
    }
}