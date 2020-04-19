package ir.ac.kntu;

public class Employee extends Person {

    private int baseSalary;
    private Date registerDate;

    public Employee(String userName, String passWord, String email, String phoneNumber, int baseSalary, Date registerDate) {
        super(userName, passWord, email, phoneNumber,3);
        this.baseSalary = baseSalary;
        this.registerDate = registerDate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
