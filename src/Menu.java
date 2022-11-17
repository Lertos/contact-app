import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

enum MenuState {
    MAIN,
    ADD_CONTACT,
    REMOVE_CONTACT,
    EDIT_CONTACT,
    OUTPUT_CONTACTS,
    DELETE_LIST
}

public class Menu {

    private ContactList contactList;
    private Scanner scanner;
    private MenuState currentState;
    private Map<Integer, MenuState> menuStates = new HashMap<>();
    private int maxStates;

    public Menu(ContactList contactList) {
        this.contactList = contactList;

        this.scanner = new Scanner(System.in);
        this.currentState = MenuState.MAIN;

        this.menuStates.put(1, MenuState.MAIN);
        this.menuStates.put(2, MenuState.ADD_CONTACT);
        this.menuStates.put(3, MenuState.REMOVE_CONTACT);
        this.menuStates.put(4, MenuState.EDIT_CONTACT);
        this.menuStates.put(5, MenuState.OUTPUT_CONTACTS);
        this.menuStates.put(6, MenuState.DELETE_LIST);

        this.maxStates = Integer.MIN_VALUE;

        for (Integer index : menuStates.keySet()) {
            if (index > this.maxStates)
                this.maxStates = index;
        }
    }

    public void start() {
        for (Map.Entry stateEntry : menuStates.entrySet()) {
            if (stateEntry.getValue() == MenuState.MAIN)
                switchState((int) stateEntry.getKey());
        }
    }

    public void switchState(int stateIndex) {
        switch (stateIndex) {
            case 1 :
                stateMainMenu();
                break;
            case 2 :
                stateAddContact();
                break;
            case 3 :
                stateRemoveContact();
                break;
            case 4 :
                stateEditContact();
                break;
            case 5 :
                stateOutputContacts();
                break;
            case 6 :
                stateDeleteContacts();
                break;
        }
    }

    private void stateMainMenu() {
        int chosenOption = -1;

        while (chosenOption < 0 || chosenOption > maxStates) {
            System.out.println("===MAIN MENU");
            for (Map.Entry stateEntry : menuStates.entrySet()) {
                String readableOption = stateEntry.getValue().toString().replace("_", " ");

                System.out.println("\t" + stateEntry.getKey() + " - " + readableOption);
            }

            System.out.println("\n Please pick your option by supplying a number.");

            chosenOption = scanner.nextInt();
            scanner.nextLine();
        }

        switchState(chosenOption);
    }

    private void stateAddContact() {

    }

    private void stateRemoveContact() {

    }

    private void stateEditContact() {

    }

    private void stateOutputContacts() {

    }

    private void stateDeleteContacts() {

    }


}
