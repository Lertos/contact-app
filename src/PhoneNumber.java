import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum PhoneType {
    Home,
    Cell,
    Work
}

public class PhoneNumber {

    private final String phoneNumber;
    private final PhoneType phoneType;

    public PhoneNumber(String phoneNumber, String phoneType) {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Phone number is not valid! Format is: x-xxx-xxx-xxxx");
        }

        this.phoneNumber = phoneNumber;
        this.phoneType = getPhoneType(phoneType);

        if (this.phoneType == null) {
            throw new IllegalArgumentException("Phone type is not valid!");
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d-\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d$");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }

    public PhoneType getPhoneType(String phoneType) {
        for (PhoneType pt : PhoneType.values()) {
            if (pt.name().equalsIgnoreCase(phoneType)) {
                return pt;
            }
        }
        return null;
    }

}
