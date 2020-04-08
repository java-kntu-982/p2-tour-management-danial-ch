package ir.ac.kntu;
import ir.ac.kntu.maputil.MapUtil;

import java.util.*;

public class Menu {
    public static void mainMenu(){
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to see tour leaders menu");
        System.out.println("Enter 2 to see tours menu");
        System.out.println("Enter 3 to see attractions menu");
        System.out.println("Enter 4 to see maps menu");
        System.out.println("Enter 5 to see locations menu");
        int answer=input.nextInt();
        switch (answer){
            case 1:
                tourLeaderMenu();break;
            case 2:
                tourMenu();break;
            case 3:
                attractionsMenu();break;
            case 4:
                mapsMenu();break;
            case 5:
                locationsMenu();break;
        }
    }

    public static void tourLeaderMenu(){
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to see all the leaders");
        System.out.println("Enter 2 to add a leader");
        System.out.println("Enter 3 to delete a leader");
        System.out.println("Enter 4 to edit a leader");
        System.out.println("Enter 5 search in leaders");
        System.out.println("Enter 6 to go back to main menu");
        int answer=input.nextInt();
        switch (answer){
            case 1:
                TourLeaderHandle.seeAllLeaders();break;
            case 2:
                TourLeaderHandle.addLeader();break;
            case 3:
                TourLeaderHandle.deleteLeader();break;
            case 4:
                TourLeaderHandle.editLeader();break;
            case 5:
                TourLeaderHandle.searchInTourLeaders();break;
            case 6:
                mainMenu();break;
        }
    }

    public static void tourMenu(){
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to see all the tour types");
        System.out.println("Enter 2 to see all the tours");
        System.out.println("Enter 3 to add a tour type");
        System.out.println("Enter 4 to add a tour");
        System.out.println("Enter 5 to edit tour type");
        System.out.println("Enter 6 to edit tour");
        System.out.println("Enter 7 to delete a tour");
        System.out.println("Enter 8 to search in tour types");
        System.out.println("Enter 9 to search in tours");
        System.out.println("Enter 10 to go back to main menu");
        int answer=input.nextInt();
        switch (answer){
            case 1:
                TourHandle.seeAllTourTypes();break;
            case 2:
                TourHandle.seeAllTours();break;
            case 3:
                TourHandle.addTourTypeMain();break;
            case 4:
                TourHandle.addTourMain();break;
            case 5:
                TourHandle.editTourType();break;
            case 6:
                TourHandle.editTour();break;
            case 7:
                TourHandle.deleteTour();break;
            case 8:
                TourHandle.searchTourType();break;
            case 9:
                TourHandle.searchInTours();break;
            case 10:
                mainMenu();break;
        }
    }

    public static void attractionsMenu(){
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to see all the attractions");
        System.out.println("Enter 2 to add an attraction");
        System.out.println("Enter 3 to edit an attraction");
        System.out.println("Enter 4 to delete an attraction");
        System.out.println("Enter 5 to go back to main menu");
        int answer=input.nextInt();
        switch (answer){
            case 1:
                AttractionHandle.seeAllAttractions();break;
            case 2:
                AttractionHandle.addAttraction();break;
            case 3:
                AttractionHandle.editAnAttraction();break;
            case 4:
                AttractionHandle.deleteAnAttraction();break;
            case 5:
                mainMenu();break;
        }
    }

    public static void mapsMenu(){
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to show starting city of a tour on map");
        System.out.println("Enter 2 to show destination of a tour on map");
        System.out.println("Enter 3 to show starting city and destination of a tour on map");
        System.out.println("Enter 4 to show current city of a tour on map(only for foreign tours)");
        System.out.println("Enter 5 to show all the cities of a tour on map(only for foreign tours)");
        System.out.println("Enter 6 to show a location on a map");
        System.out.println("Enter 7 to show two cities on map");
        System.out.println("Enter 8 to go back to main menu");
        int answer=input.nextInt();
        switch (answer){
            case 1:
                MapHandle.showStartingCityOnMap();break;
            case 2:
                MapHandle.showDestinationOnMap();break;
            case 3:
                MapHandle.showStartingCityAndDestinationOnMap();break;
            case 4:
                MapHandle.showCurrentCityOnMap();break;
            case 5:
                MapHandle.showAllCitiesOfTourOnMap();break;
            case 6:
                MapHandle.showLocationOnMap();break;
            case 7:
                MapHandle.showTwoCitiesOnMap();break;
            case 8:
                mainMenu();break;
        }
    }

    public static void locationsMenu(){
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to see all the locations");
        System.out.println("Enter 2 to add a country");
        System.out.println("Enter 3 to add a city");
        System.out.println("Enter 4 to delete a country");
        System.out.println("Enter 5 to delete a city");
        System.out.println("Enter 6 to edit a country");
        System.out.println("Enter 7 to go back to main menu");
        int answer=input.nextInt();
        switch (answer){
            case 1:
                LocationHandle.seeAllLocations();break;
            case 2:
                LocationHandle.addCountry();break;
            case 3:
                LocationHandle.addCity();break;
            case 4:
                LocationHandle.deleteCountry();break;
            case 5:
                LocationHandle.deleteCity();break;
            case 6:
                LocationHandle.editCountry();break;
            case 7:
                mainMenu();break;
        }
    }
}
