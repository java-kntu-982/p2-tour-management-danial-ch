package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Objects;

public class Country {
    private String name;
    private LinkedList<Location> locations=new LinkedList<>();
    private boolean show=true;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Location> getLocations() {
        return locations;
    }

    public void setLocations(LinkedList<Location> locations) {
        this.locations = locations;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(locations, country.locations);
    }

    public int hashCode() {
        return Objects.hash(name, locations);
    }

    Country(){}
}
