package ir.ac.kntu;

import java.util.LinkedList;

public class TourLeader extends Person{
    private int age;
    private String fName;
    private String lName;
    private String nationalCode;
    private String idNumber;
    private boolean married;
    private Date birthDate;
    private Date registerDate;
    private LinkedList<City> knownCities = new LinkedList<>();
    private LinkedList<Country> knownCountries = new LinkedList<>();
    private Tour currentTour;

    public Date getRegisterDate() {
        return registerDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public TourLeader() {
        this.accessLevel=2;
    }

    public LinkedList<City> getKnownCities() {
        return knownCities;
    }

    public void setKnownCities(LinkedList<City> knownCities) {
        this.knownCities = knownCities;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LinkedList<Country> getKnownCountries() {
        return knownCountries;
    }

    public void setKnownCountries(LinkedList<Country> knownCountries) {
        this.knownCountries = knownCountries;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setBirthDate(ir.ac.kntu.Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setRegisterDate(ir.ac.kntu.Date registerDate) {
        this.registerDate = registerDate;
    }


    public Tour getCurrentTour() {
        return currentTour;
    }

    public void setCurrentTour(Tour currentTour) {
        this.currentTour = currentTour;
    }

    public String toString() {
        return ", FName='" + fName + '\'' +
                ", LName='" + lName + '\'' +
                ", age=" + age + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", married=" + married;
    }
}
