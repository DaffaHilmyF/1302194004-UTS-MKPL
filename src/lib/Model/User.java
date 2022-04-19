package lib.Model;

public class User {
    public enum Gender {
        MALE, FEMALE
    }

    private String firstName;
    private String lastName;
    private String address;
    private Gender gender;

    public User(String firstName, String lastName, String address, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public Gender getGender() {
        return this.gender;
    }
}
