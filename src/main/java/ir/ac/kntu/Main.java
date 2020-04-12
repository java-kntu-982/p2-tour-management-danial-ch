package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.LinkedList;

public class Main {

    public static LinkedList<TourLeader> tourLeaders = new LinkedList<TourLeader>();
    public static LinkedList<Tour> tours = new LinkedList<Tour>();
    public static LinkedList<ForeignTour> foreignTours = new LinkedList<ForeignTour>();
    public static LinkedList<LocalTour> localTours = new LinkedList<LocalTour>();
    public static LinkedList<Attraction> attractions = new LinkedList<Attraction>();
    public static LinkedList<Location> locations = new LinkedList<Location>();
    public static LinkedList<Country> countries = new LinkedList<>();

    public static void main(String[] args) {
        Country iran = new Country();
        iran.setName("iran");
        countries.add(iran);
        Menu.mainMenu();
    }
}
