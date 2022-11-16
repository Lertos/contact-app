enum PhoneType {
    Home,
    Cell,
    Work
}

public class PhoneNumber {

    private final String phoneNumber;
    private final PhoneType phoneType;

    public PhoneNumber(String phoneNumber, String phoneType) {
        if (isInvalidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Phone number is not valid!");
        }

        this.phoneNumber = phoneNumber;
        this.phoneType = getPhoneType(phoneType);

        if (this.phoneType == null) {
            throw new IllegalArgumentException("Phone type is not valid!");
        }
    }

    private boolean isInvalidPhoneNumber(String phoneNumber) {

    }

    private PhoneType getPhoneType(String phoneType) {

        return null;
    }

}
