package ir.ac.kntu;

public class Attraction {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return "name='" + name + '\'' +
                ", city='" + city + '\'';
    }

    Attraction(){}
}
