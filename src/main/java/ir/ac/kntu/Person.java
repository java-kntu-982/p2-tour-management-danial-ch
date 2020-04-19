package ir.ac.kntu;

public class Person {
    protected String userName;
    protected String passWord;
    protected String email;
    protected String phoneNumber;
    protected int accessLevel;

    public Person(String userName, String passWord, String email, String phoneNumber, int accessLevel) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public Person() {
    }
}
