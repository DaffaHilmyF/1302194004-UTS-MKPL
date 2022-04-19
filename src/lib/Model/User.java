package lib.Model;

public class User {
    public enum Gender {
        MALE, FEMALE
    }

    private Name name;
    private String address;
    private Gender gender;
    private boolean isForeigner;

    public User(Name name, String address, Gender gender, boolean isForeigner) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.setForeigner(isForeigner);
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public void setForeigner(boolean isForeigner) {
        this.isForeigner = isForeigner;
    }

    public void setFirstName(Name name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Name getFirstName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Gender getGender() {
        return this.gender;
    }
}
