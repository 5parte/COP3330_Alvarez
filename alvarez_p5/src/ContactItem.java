import java.io.Serializable;

public class ContactItem implements Serializable {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email) {
        if (isContactValid(firstName, lastName, phoneNumber, email)) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }
        else
            throw new IllegalArgumentException("WARNING: contact is not valid; must contain at least one piece of contact info");
    }

    public void setFirstName(String firstName) {
        if(isContactValid(firstName, this.lastName, this.phoneNumber, this.email)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("WARNING: contact is no longer valid; must contain at least one piece of contact info");
        }
    }

    public void setLastName(String lastName) {
        if(isContactValid(this.firstName, lastName, this.phoneNumber, this.email)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("WARNING: contact is no longer valid; must contain at least one piece of contact info");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if(isContactValid(this.firstName, this.lastName, phoneNumber, this.email)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("WARNING: contact is no longer valid; must contain at least one piece of contact info");
        }
    }

    public void setEmail(String email) {
        if(isContactValid(this.firstName, this.lastName, this.phoneNumber, email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("WARNING: contact is no longer valid; must contain at least one piece of contact info");
        }
    }

    private Boolean isContactValid(String firstName, String lastName, String phoneNumber, String email) {
        if (firstName.equals("") && lastName.equals("") && phoneNumber.equals("") && email.equals(""))
            return false;
        else
            return true;
    }
}
