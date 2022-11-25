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

        addContactMenu.addMenuOption(new MenuOption("Q", MenuKey.MAIN_MENU, "Return to the main menu"));

        removeContactMenu.addMenuOption(new MenuOption("Q", MenuKey.MAIN_MENU, "Return to the main menu"));

        editContactMenu.addMenuOption(new MenuOption("Q", MenuKey.MAIN_MENU, "Return to the main menu"));

        //Add each menu option list to the master list
        menuOptionLists.put(MenuKey.MAIN_MENU, mainMenu);
        menuOptionLists.put(MenuKey.ADD_CONTACT, addContactMenu);
        menuOptionLists.put(MenuKey.REMOVE_CONTACT, removeContactMenu);
        menuOptionLists.put(MenuKey.EDIT_CONTACT, editContactMenu);

        System.out.println("Welcome to your contact list. To navigate through the list, type the numbers beside the available options.\n");

        switchState(MenuKey.MAIN_MENU);
    }

    public void switchState(MenuKey state) {
        if (state == null)
            state = MenuKey.MAIN_MENU;

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
        MenuOptionList mainMenu = menuOptionLists.get(MenuKey.MAIN_MENU);
        MenuKey menuKey = null;
        boolean givenValidKey = false;
        String response;

        while (!givenValidKey) {
            mainMenu.outputMenuOptions();

            response = scanner.nextLine();
            menuKey = mainMenu.getMenuFromKey(response);

            if(menuKey != null)
                givenValidKey = true;
            else
                System.out.println("\nThat was not a valid option\n");
        }

        switchState(menuKey);
    }

    private void menuAddContact() {
        MenuOptionList addContactMenu = menuOptionLists.get(MenuKey.ADD_CONTACT);
        MenuKey menuKey = MenuKey.MAIN_MENU;
        boolean givenValidKey = false;
        String response;

        while (!givenValidKey) {
            addContactMenu.outputMenuOptions();
            System.out.println("\nTo add a contact please enter in a name and two valid phone numbers.");
            System.out.println("Use the format: (NAME) (CELL PHONE) (HOME PHONE)");
            System.out.println("EXAMPLE: Jake 1-555-555-5555 1-444-444-4444\n");

            response = scanner.nextLine();
            menuKey = addContactMenu.getMenuFromKey(response);

            if(menuKey != null)
                givenValidKey = true;
            else {
                String[] pieces = response.split(" ");

                if(pieces.length < 3)
                    System.out.println("That was not a valid option");
                else {
                    if(contactList.addContact(pieces[0], pieces[1], pieces[2])) {
                        System.out.println("Your new contact has been added!");
                        givenValidKey = true;
                    } else {
                        System.out.println("That was an invalid format for a contact");
                    }
                }
            }
            System.out.println("");
        }

        switchState(menuKey);
    }

    private void menuRemoveContact() {
        MenuOptionList removeContactMenu = menuOptionLists.get(MenuKey.REMOVE_CONTACT);
        MenuKey menuKey = MenuKey.MAIN_MENU;
        boolean givenValidKey = false;
        String response;

        while (!givenValidKey) {
            removeContactMenu.outputMenuOptions();
            contactList.outputContactList();

            System.out.println("\nTo remove a contact please enter in the number shown at the start of the line for a contact.");

            response = scanner.nextLine();
            menuKey = removeContactMenu.getMenuFromKey(response);

            if(menuKey != null)
                givenValidKey = true;
            else {
                int contactIndex;
                try {
                    contactIndex = Integer.parseInt(response);

                    if (contactIndex < 0 || contactIndex >= contactList.size()) {
                        System.out.println("That was not a valid contact number. It must be between 0 and " + (contactList.size() - 1));
                    } else {
                        contactList.removeContact(contactIndex);
                        System.out.println("Your contact has been successfully removed!");
                        givenValidKey = true;
                    }
                } catch (Exception e) {
                    System.out.println("That was not a valid option");
                }
            }
            System.out.println("");
        }

        switchState(menuKey);
    }

    private void menuEditContact() {
        MenuOptionList editContactMenu = menuOptionLists.get(MenuKey.EDIT_CONTACT);
        MenuKey menuKey = MenuKey.MAIN_MENU;
        boolean givenValidKey = false;
        String response;

        while (!givenValidKey) {
            editContactMenu.outputMenuOptions();
            contactList.outputContactList();

            System.out.println("\nTo edit a contact please enter in the number shown at the start of the line for a contact.");

            response = scanner.nextLine();
            menuKey = editContactMenu.getMenuFromKey(response);

            if(menuKey != null)
                givenValidKey = true;
            else {
                int contactIndex;
                try {
                    contactIndex = Integer.parseInt(response);

                    if (contactIndex < 0 || contactIndex >= contactList.size()) {
                        System.out.println("That was not a valid contact number. It must be between 0 and " + (contactList.size() - 1));
                    } else {
                        boolean contactUpdated = updateContact(contactIndex);

                        if (contactUpdated) {
                            System.out.println("Your contact has been successfully updated!");
                            givenValidKey = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("That was not a valid option");
                }
            }
            System.out.println("");
        }

        switchState(menuKey);
    }

    private boolean updateContact(int contactIndex) {
        String response;
        int chosenOption;
        boolean isContactChosen = false;

        while(!isContactChosen) {
            System.out.println("You are currently editing the contact: " + contactList.getContact(contactIndex).toString() + "\n");
            System.out.println("1 - Change their name");
            System.out.println("2 - Change their cell number");
            System.out.println("3 - Change their home number");
            response = scanner.nextLine();

            try {
                chosenOption = Integer.parseInt(response);

                if (chosenOption < 1 || chosenOption > 3) {
                    System.out.println("That was not a valid contact number. It must be between 1 and 3");
                } else {
                    if (chosenOption == 1) {
                        System.out.println("Enter in the name you want to change it to: ");
                        response = scanner.nextLine();

                        return contactList.updateContactName(contactIndex, response);
                    } else if (chosenOption == 2) {
                        System.out.println("Enter in the new cell number you want to change it to: ");
                        response = scanner.nextLine();

                        return contactList.updateCellNumber(contactIndex, response);
                    } else if (chosenOption == 3) {
                        System.out.println("Enter in the new home number you want to change it to: ");
                        response = scanner.nextLine();

                        return contactList.updateHomeNumber(contactIndex, response);
                    }
                }
            } catch(Exception e) {
                if (response.equalsIgnoreCase("Q"))
                    return false;
                System.out.println("That was not a valid option");
            }
        }
        return true;
    }

    private void menuOutputContacts() {
        if (contactList.size() == 0)
            System.out.println("\nYou currently have no contacts to show");
        else
            contactList.outputContactList();

        System.out.println("");
        switchState(MenuKey.MAIN_MENU);
    }

    private void menuDeleteContacts() {
        contactList.emptyContactList();
        System.out.println("\nYour contact list is now empty");

        System.out.println("");
        switchState(MenuKey.MAIN_MENU);
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
