package ir.ac.kntu;

import java.util.LinkedList;

public class City {

    private String cityName;
    private LinkedList<Attraction> attractions = new LinkedList<>();

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

    public String attractionToStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Attraction attraction : attractions) {
            stringBuilder.append(attraction.getName()).append("-");
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return "name: " + cityName +
                "  attractions:" + attractionToStr();
    }

    City() {
    }
}
