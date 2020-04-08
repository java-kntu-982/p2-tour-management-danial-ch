package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Objects;

public class Tour {
    private String name;
    private TravelMethod travelMethod;
    private int time;
    private int minAttendants;
    private int maxAttendants;
    private int price;
    private Country country;
    private LinkedList<Location> locations=new LinkedList<>();

    public Country getCountry() {

        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LinkedList<Location> getLocations() {
        return locations;
    }

    public void setLocations(LinkedList<Location> locations) {
        this.locations = locations;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMinAttendants() {
        return minAttendants;
    }

    public void setMinAttendants(int minAttendants) {
        this.minAttendants = minAttendants;
    }

    public int getMaxAttendants() {
        return maxAttendants;
    }

    public void setMaxAttendants(int maxAttendants) {
        this.maxAttendants = maxAttendants;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TravelMethod getTravelMethod() {
        return travelMethod;
    }

    public void setTravelMethod(TravelMethod travelMethod) {
        this.travelMethod = travelMethod;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return time == tour.time &&
                minAttendants == tour.minAttendants &&
                maxAttendants == tour.maxAttendants &&
                price == tour.price &&
                Objects.equals(name, tour.name) &&
                travelMethod == tour.travelMethod &&
                Objects.equals(country, tour.country) &&
                Objects.equals(locations, tour.locations);
    }

    public int hashCode() {
        return Objects.hash(name, travelMethod, time, minAttendants, maxAttendants, price, country, locations);
    }

    public String toString() {
        return name +
                "{" +
                "travelMethod=" + travelMethod +
                ", country=" + country.getName() +
                ", number of days=" + time +
                ", minAttendants=" + minAttendants +
                ", maxAttendants=" + maxAttendants +
                ", price=" + price +
                ", cities=" + locations +
                '}';
    }

    Tour(){}
}
