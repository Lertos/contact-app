import java.util.*;

enum MenuKey {
    MAIN_MENU,
    ADD_CONTACT,
    REMOVE_CONTACT,
    EDIT_CONTACT,
    OUTPUT_CONTACTS,
    DELETE_LIST
}

public class Menu {

    private Map<MenuKey, MenuOptionList> menuOptionLists;
    private ContactList contactList;
    private Scanner scanner;

    public Menu(ContactList contactList) {
        this.menuOptionLists = new HashMap<>();
        this.contactList = contactList;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        //Create all the menu option lists
        MenuOptionList mainMenu = new MenuOptionList();
        MenuOptionList addContactMenu = new MenuOptionList();
        MenuOptionList removeContactMenu = new MenuOptionList();
        MenuOptionList editContactMenu = new MenuOptionList();

        //Fill each menu option list
        mainMenu.addMenuOption(new MenuOption("1", MenuKey.ADD_CONTACT, "Add a new contact"));
        mainMenu.addMenuOption(new MenuOption("2", MenuKey.EDIT_CONTACT, "Edit an existing contact"));
        mainMenu.addMenuOption(new MenuOption("3", MenuKey.REMOVE_CONTACT, "Remove an existing contact"));
        mainMenu.addMenuOption(new MenuOption("4", MenuKey.OUTPUT_CONTACTS, "Show all contacts"));
        mainMenu.addMenuOption(new MenuOption("5", MenuKey.DELETE_LIST, "Clear all contacts"));

        addContactMenu.addMenuOption(new MenuOption("1", MenuKey.MAIN_MENU, "Return to the main menu"));

        removeContactMenu.addMenuOption(new MenuOption("1", MenuKey.MAIN_MENU, "Return to the main menu"));

        editContactMenu.addMenuOption(new MenuOption("1", MenuKey.MAIN_MENU, "Return to the main menu"));

        //Add each menu option list to the master list
        menuOptionLists.put(MenuKey.MAIN_MENU, mainMenu);
        menuOptionLists.put(MenuKey.ADD_CONTACT, addContactMenu);
        menuOptionLists.put(MenuKey.REMOVE_CONTACT, removeContactMenu);
        menuOptionLists.put(MenuKey.EDIT_CONTACT, editContactMenu);

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

        public MenuKey getMenuFromKey(String response) {
            for(MenuOption menuOption : menuOptionList) {
                if(response.equalsIgnoreCase(menuOption.keyOption))
                    return menuOption.menuKey;
            }
            return null;
        }

        public void outputMenuOptions() {
            for(MenuOption menuOption : menuOptionList) {
                System.out.println(menuOption.toString());
            }
        }

    }

    private class MenuOption {

        private String keyOption;
        private MenuKey menuKey;
        private String optionText;

        public MenuOption(String keyOption, MenuKey menuKey, String optionText) {
            this.keyOption = keyOption;
            this.menuKey = menuKey;
            this.optionText = optionText;
        }

        @Override
        public String toString() {
            return keyOption + " - " + optionText;
        }
    }


}
