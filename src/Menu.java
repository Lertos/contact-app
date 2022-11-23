import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum MenuKey {
    MAIN_MENU,
    ADD_CONTACT,
    REMOVE_CONTACT,
    EDIT_CONTACT,
    OUTPUT_CONTACTS,
    DELETE_LIST
}

public class Menu {

    private ContactList contactList;
    private Scanner scanner;

    public Menu(ContactList contactList) {
        this.contactList = contactList;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        switchState(MenuKey.MAIN_MENU);
    }

    public void switchState(MenuKey state) {
        switch (state) {
            case MAIN_MENU:
                menuMain();
                break;
            case ADD_CONTACT:
                menuAddContact();
                break;
            case REMOVE_CONTACT:
                menuRemoveContact();
                break;
            case EDIT_CONTACT:
                menuEditContact();
                break;
            case OUTPUT_CONTACTS:
                menuOutputContacts();
                break;
            case DELETE_LIST:
                menuDeleteContacts();
                break;
        }
    }

    private void menuMain() {
        /*
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
        */
    }

    private void menuAddContact() {

    }

    private void menuRemoveContact() {

    }

    private void menuEditContact() {

    }

    private void menuOutputContacts() {

    }

    private void menuDeleteContacts() {

    }

    private class MenuOptionList {

        private List<MenuOption> menuOptionList;

        public MenuOptionList() {
            this.menuOptionList = new ArrayList<>();
        }

        public void addMenuOption(MenuOption menuOption) {
            this.menuOptionList.add(menuOption);
        }

        public void outputMenuOptions() {
            for(MenuOption menuOption : menuOptionList) {
                System.out.println(menuOption.toString());
            }
        }

    }

    private class MenuOption {

        private String keyOption;
        private MenuOption menuOption;
        private String optionText;

        public MenuOption(String keyOption, MenuOption menuOption, String optionText) {
            this.keyOption = keyOption;
            this.menuOption = menuOption;
            this.optionText = optionText;
        }

        @Override
        public String toString() {
            return keyOption + " - " + optionText;
        }
    }


}
