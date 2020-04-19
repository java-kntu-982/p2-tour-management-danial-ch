package ir.ac.kntu;

import java.util.LinkedList;

public class TourType {
    protected String name;
    protected TravelMethod travelMethod;
    protected int time;
    protected int minAttendants;
    protected int maxAttendants;
    protected int price;
    protected Country country;
    protected LinkedList<City> cities = new LinkedList<>();

    public LinkedList<City> getCities() {
        return cities;
    }

    public void setCities(LinkedList<City> cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public String toString() {
        return  name + ":{" +
                ", travelMethod=" + travelMethod +
                ", time=" + time +
                ", minAttendants=" + minAttendants +
                ", maxAttendants=" + maxAttendants +
                ", price=" + price +
                ", country=" + country +
                '}';
    }
}
