package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Objects;

public class Tour extends TourType {
    protected String fullName;
    private City startingCity;
    private City destination;
    protected TourLeader tourLeader;
    protected Date startingDate;
    protected Date finishingDate;
    protected LinkedList<Attraction> attractions = new LinkedList<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public City getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(City startingCity) {
        this.startingCity = startingCity;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public TourLeader getTourLeader() {
        return tourLeader;
    }

    public void setTourLeader(TourLeader tourLeader) {
        this.tourLeader = tourLeader;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getFinishingDate() {
        return finishingDate;
    }

    public void setFinishingDate(Date finishingDate) {
        this.finishingDate = finishingDate;
    }

    public LinkedList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(LinkedList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tour tour = (Tour) o;
        return Objects.equals(fullName, tour.fullName) &&
                Objects.equals(startingCity, tour.startingCity) &&
                Objects.equals(destination, tour.destination) &&
                Objects.equals(tourLeader, tour.tourLeader) &&
                Objects.equals(startingDate, tour.startingDate) &&
                Objects.equals(finishingDate, tour.finishingDate) &&
                Objects.equals(attractions, tour.attractions);
    }

    public int hashCode() {
        return Objects.hash(fullName, startingCity, destination, tourLeader, startingDate, finishingDate, attractions);
    }

    public String toString() {
        return "Tour{" +
                "fullName='" + fullName + '\'' +
                ", tourLeader=" + tourLeader.getLName() +
                ", startingDate=" + startingDate +
                ", finishingDate=" + finishingDate +
                '}';
    }

    Tour() {
    }
}
