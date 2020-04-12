package ir.ac.kntu;

import java.util.LinkedList;

public class Location {
    private String cityName;
    private LinkedList<Attraction> attractions = new LinkedList<Attraction>();
    private boolean show = true;
    private Country country = null;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LinkedList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(LinkedList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Location{" +
                "cityName='" + cityName + '\'' +
                ", attractions=" + attractions +
                '}';
    }

    Location() {
    }
}
