package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Objects;

public class TourLeader {
    private int age;
    private String FName;
    private String LName;
    private String nationalCode;
    private String idNumber;
    private boolean married;
    private ir.ac.kntu.Date birthDate;
    private ir.ac.kntu.Date registerDate;
    private LinkedList<Location> knownLocations = new LinkedList<Location>();
    private LinkedList<Country> knownCountries = new LinkedList<>();
    private Tour currentTour;
    private ForeignTour foreignTour = null;
    private LocalTour localTour = null;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ForeignTour getForeignTour() {
        return foreignTour;
    }

    public void setForeignTour(ForeignTour foreignTour) {
        this.foreignTour = foreignTour;
    }

    public LocalTour getLocalTour() {
        return localTour;
    }

    public void setLocalTour(LocalTour localTour) {
        this.localTour = localTour;
    }

    public LinkedList<Country> getKnownCountries() {
        return knownCountries;
    }

    public void setKnownCountries(LinkedList<Country> knownCountries) {
        this.knownCountries = knownCountries;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String fName) {
        this.FName = fName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String lName) {
        this.LName = lName;
    }

    public String getNationalCode() {
        return nationalCode;
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

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public ir.ac.kntu.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(ir.ac.kntu.Date birthDate) {
        this.birthDate = birthDate;
    }

    public ir.ac.kntu.Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(ir.ac.kntu.Date registerDate) {
        this.registerDate = registerDate;
    }

    public LinkedList<Location> getKnownLocations() {
        return knownLocations;
    }

    public void setKnownLocations(LinkedList<Location> knownLocations) {
        this.knownLocations = knownLocations;
    }

    public Tour getCurrentTour() {
        return currentTour;
    }

    public void setCurrentTour(Tour currentTour) {
        this.currentTour = currentTour;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourLeader that = (TourLeader) o;
        return married == that.married &&
                Objects.equals(FName, that.FName) &&
                Objects.equals(LName, that.LName) &&
                Objects.equals(nationalCode, that.nationalCode) &&
                Objects.equals(idNumber, that.idNumber) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(registerDate, that.registerDate) &&
                Objects.equals(knownLocations, that.knownLocations) &&
                Objects.equals(knownCountries, that.knownCountries) &&
                Objects.equals(currentTour, that.currentTour) &&
                Objects.equals(foreignTour, that.foreignTour) &&
                Objects.equals(localTour, that.localTour);
    }

    public int hashCode() {
        return Objects.hash(FName, LName, nationalCode, idNumber, married, birthDate, registerDate, knownLocations, knownCountries, currentTour, foreignTour, localTour);
    }

    public String toString() {
        StringBuilder countries = new StringBuilder();
        StringBuilder cities = new StringBuilder();
        for (int i = 0; i < this.getKnownCountries().size(); i++) {
            countries.append(this.getKnownCountries().get(i).getName()).append(",");
        }
        for (int i = 0; i < this.getKnownLocations().size(); i++) {
            cities.append(this.getKnownLocations().get(i).getCityName()).append(",");
        }
        return "FName='" + FName + '\'' +
                ", LName='" + LName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", married=" + married +
                ", birthDate=" + birthDate +
                ", registerDate=" + registerDate +
                ", knownLocations=" + countries.toString() + cities.toString() +
                ", currentTour=" + currentTour;
    }
}
