public class Contact {

    private String name;
    private PhoneNumber cellNumber;
    private PhoneNumber homeNumber;

    public Contact(String name, PhoneNumber cellNumber, PhoneNumber homeNumber) {
        this.name = name;
        this.cellNumber = cellNumber;
        this.homeNumber = homeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "NAME: " + name + "\t" + cellNumber.toString() + "\t" + homeNumber.toString();
    }
}
