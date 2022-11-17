public class Contact {

    private String name;
    private String email;
    private PhoneNumber cellNumber;
    private PhoneNumber homeNumber;

    public Contact(String name, String email, PhoneNumber cellNumber, PhoneNumber homeNumber) {
        this.name = name;
        this.email = email;
        this.cellNumber = cellNumber;
        this.homeNumber = homeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhoneNumber getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(PhoneNumber cellNumber) {
        this.cellNumber = cellNumber;
    }

    public PhoneNumber getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(PhoneNumber homeNumber) {
        this.homeNumber = homeNumber;
    }
}
