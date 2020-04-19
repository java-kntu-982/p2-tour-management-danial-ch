package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Objects;

public class Country {
    private String name;
    private LinkedList<City> cities = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<City> getLocations() {
        return cities;
    }

    public void setLocations(LinkedList<City> locations) {
        this.cities = locations;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(cities, country.cities);
    }

    public int hashCode() {
        return Objects.hash(name, cities);
    }

    Country() {
    }
}
