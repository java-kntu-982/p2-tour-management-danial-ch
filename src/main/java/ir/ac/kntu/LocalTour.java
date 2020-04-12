package ir.ac.kntu;

import java.util.LinkedList;

public class LocalTour extends Tour {
    private String fullName;
    private TourLeader tourLeader;
    private Date startingDate;
    private Date finishingDate;
    private LinkedList<Attraction> attractions = new LinkedList<>();
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LinkedList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(LinkedList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String toString() {
        return "LocalTour{" +
                "fullName='" + fullName + '\'' +
                ", tourLeader=" + tourLeader +
                ", startingDate=" + startingDate +
                ", finishingDate=" + finishingDate +
                ", attractions=" + attractions +
                ", location=" + location +
                '}';
    }

    public String customToString() {
        String lastName = tourLeader.getLName();
        return "tour name='" + fullName + '\'' +
                ", startingDate=" + startingDate +
                ", finishingDate=" + finishingDate +
                ", tour leader=" + lastName;
    }

    LocalTour() {
    }
}
