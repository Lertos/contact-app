import java.util.HashMap;
import java.util.Map;

enum MenuState {
    MAIN,
    ADD_CONTACT,
    REMOVE_CONTACT,
    EDIT_CONTACT,
    OUTPUT_CONTACTS,
    DELETE_LIST
}

public class Menu {

    private MenuState currentState;
    private Map<Integer, MenuState> menuStates = new HashMap<>();

    public Menu() {
        this.currentState = MenuState.MAIN;

        this.menuStates.put(1, MenuState.MAIN);
        this.menuStates.put(2, MenuState.ADD_CONTACT);
        this.menuStates.put(3, MenuState.REMOVE_CONTACT);
        this.menuStates.put(4, MenuState.EDIT_CONTACT);
        this.menuStates.put(5, MenuState.OUTPUT_CONTACTS);
        this.menuStates.put(6, MenuState.DELETE_LIST);
    }

    public boolean switchState(int stateIndex) {
        switch (stateIndex) {
            case 1 :
                stateMainMenu();
                return true;
            case 2 :
                stateAddContact();
                return true;
            case 3 :
                stateRemoveContact();
                return true;
            case 4 :
                stateEditContact();
                return true;
            case 5 :
                stateOutputContacts();
                return true;
            case 6 :
                stateDeleteContacts();
                return true;
            default :
                System.out.println("The given index was not valid");
                return false;
        }
    }

    private void stateMainMenu() {

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
