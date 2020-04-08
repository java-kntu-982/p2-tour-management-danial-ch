package ir.ac.kntu;

import java.util.LinkedList;

public class ForeignTour extends Tour {
    private String fullName;
    private Location startingCity;
    private Location destination;
    private TourLeader tourLeader;
    private Date startingDate;
    private Date finishingDate;
    private LinkedList<Attraction> attractions=new LinkedList<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Location getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(Location startingCity) {
        this.startingCity = startingCity;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
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

    public String toString() {
        return "ForeignTour{" +
                "fullName='" + fullName + '\'' +
                ", startingCity=" + startingCity +
                ", destination=" + destination +
                ", tourLeader=" + tourLeader +
                ", startingDate=" + startingDate +
                ", finishingDate=" + finishingDate +
                ", attractions=" + attractions +
                '}';
    }

    public String customToString() {
        String lastName=tourLeader.getLName();
        return "tour name='" + fullName + '\'' +
                ", startingDate=" + startingDate +
                ", finishingDate=" + finishingDate +
                ", tour leader=" + lastName;
    }

    ForeignTour(){}
}
