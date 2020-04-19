package ir.ac.kntu;

import java.util.*;

public class Menu {
    public static void mainMenu(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to see tour leaders menu");
        System.out.println("Enter 2 to see tours menu");
        System.out.println("Enter 3 to see attractions menu");
        System.out.println("Enter 4 to see maps menu");
        System.out.println("Enter 5 to see locations menu");
        System.out.println("Enter 6 to edit profile and people");
        System.out.println("Enter 7 to log out");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                tourLeaderMenu(person);
                break;
            case 2:
                tourMenu(person);
                break;
            case 3:
                attractionsMenu(person);
                break;
            case 4:
                mapsMenu(person);
                break;
            case 5:
                locationsMenu(person);
                break;
            case 6:
                peopleMenu(person);
                break;
            case 7:
                Main.login();
                break;
        }
        mainMenu(person);
    }

    public static void tourLeaderMenu(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to see all the leaders");
        System.out.println("Enter 2 search in leaders");
        System.out.println("Enter 3 to go back to main menu");
        if (person.getAccessLevel() == 4) {
            System.out.println("Enter 4 to add a leader");
            System.out.println("Enter 5 to delete a leader");
            System.out.println("Enter 6 to edit a leader");
        }
        int answer = input.nextInt();
        if (answer == 1) {
            TourLeaderHandle.seeAllLeaders(person);
        } else if (answer == 2) {
            TourLeaderHandle.searchInTourLeaders(person);
        } else if (answer == 3) {
            mainMenu(person);
        }
        if (person.getAccessLevel() > 1) {
            switch (answer) {
                case 4:
                    TourLeaderHandle.addLeader(person);
                    break;
                case 5:
                    TourLeaderHandle.deleteLeader(person);
                    break;
                case 6:
                    TourLeaderHandle.editLeader(person);
                    break;
            }
        } else {
            System.out.println("You don't have permission to access this section");
        }
    }

    public static void tourMenu(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to see all the tour types");
        System.out.println("Enter 2 to see all the tours");
        System.out.println("Enter 3 to search in tour types");
        System.out.println("Enter 4 to search in tours");
        System.out.println("Enter 5 to go back to main menu");
        if (person.getAccessLevel() > 1) {
            System.out.println("Enter 6 to add a tour");
            System.out.println("Enter 7 to edit tour");
        }
        if (person.getAccessLevel() == 4) {
            System.out.println("Enter 8 to add a tour type");
            System.out.println("Enter 9 to edit tour type");
            System.out.println("Enter 10 to delete a tour");
        }
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                TourHandle.seeAllTourTypes(person);
            case 2:
                TourHandle.seeAllTours(person);
                break;
            case 3:
                TourHandle.searchTourType(person);
                break;
            case 4:
                TourHandle.searchInTours(person);
                break;
            case 5:
                mainMenu(person);
                break;
        }
        if (person.getAccessLevel() > 1) {
            if (answer == 6) {
                TourHandle.addTour(person);
            } else if (answer == 7) {
                TourHandle.editTour(person);
            }
        } else {
            System.out.println("You don't have permission to access this section");
        }
        if (person.getAccessLevel() == 4) {
            if(answer==8){
                TourHandle.addTourType(person);
            } else if(answer==9){
                TourHandle.editTourType(person);
            } else {
                TourHandle.deleteTour(person);
            }
        } else {
            System.out.println("You don't have permission to access this section");
        }
    }

    public static void attractionsMenu(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to see all the attractions");
        System.out.println("Enter 2 to go back to main menu");
        if (person.getAccessLevel() == 4) {
            System.out.println("Enter 3 to add an attraction");
            System.out.println("Enter 4 to edit an attraction");
            System.out.println("Enter 5 to delete an attraction");
        }
        int answer = input.nextInt();
        if (answer == 1) {
            AttractionHandle.seeAllAttractions(person);
        } else if (answer == 2) {
            mainMenu(person);
        }
        if (person.getAccessLevel() == 4) {
            switch (answer) {
                case 3:
                    AttractionHandle.addAttraction(person);
                    break;
                case 4:
                    AttractionHandle.editAnAttraction(person);
                    break;
                case 5:
                    AttractionHandle.deleteAnAttraction(person);
                    break;
            }
        } else {
            System.out.println("You don't have permission to access this section");
        }
    }

    public static void mapsMenu(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to show starting city of a tour on map");
        System.out.println("Enter 2 to show destination of a tour on map");
        System.out.println("Enter 3 to show starting city and destination of a tour on map");
        System.out.println("Enter 4 to show current city of a tour on map(only for foreign tours)");
        System.out.println("Enter 5 to show all the cities of a tour on map(only for foreign tours)");
        System.out.println("Enter 6 to show a location on a map");
        System.out.println("Enter 7 to show two cities on map");
        System.out.println("Enter 8 to go back to main menu");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                MapHandle.showStartingCityOnMap(person);
                break;
            case 2:
                MapHandle.showDestinationOnMap(person);
                break;
            case 3:
                MapHandle.showStartingCityAndDestinationOnMap(person);
                break;
            case 4:
                MapHandle.showCurrentCityOnMap(person);
                break;
            case 5:
                MapHandle.showAllCitiesOfTourOnMap(person);
                break;
            case 6:
                MapHandle.showLocationOnMap(person);
                break;
            case 7:
                MapHandle.showTwoCitiesOnMap(person);
                break;
            case 8:
                mainMenu(person);
                break;
        }
    }

    public static void locationsMenu(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to see all the locations");
        System.out.println("Enter 2 to go back to main menu");
        if (person.getAccessLevel() == 4) {
            System.out.println("Enter 3 to add a country");
            System.out.println("Enter 4 to add a city");
            System.out.println("Enter 5 to delete a country");
            System.out.println("Enter 6 to delete a city");
            System.out.println("Enter 7 to edit a country");
        }
        int answer = input.nextInt();
        if (answer == 1) {
            LocationHandle.seeAllLocations(person);
        } else if (answer == 2) {
            mainMenu(person);
        }
        if (person.getAccessLevel() == 4) {
            switch (answer) {
                case 3:
                    LocationHandle.addCountry(person);
                    break;
                case 4:
                    LocationHandle.addCity(person);
                    break;
                case 5:
                    LocationHandle.deleteCountry(person);
                    break;
                case 6:
                    LocationHandle.deleteCity(person);
                    break;
                case 7:
                    LocationHandle.editCountry(person);
            }
        } else {
            System.out.println("You don't have permission to access this section");
        }
    }

    public static void peopleMenu(Person person) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to edit profile");
        if (person.getAccessLevel() > 1) {
            System.out.println("Enter 2 to edit customers' info");
            if (person.getAccessLevel() == 4) {
                System.out.println("Enter 3 to edit employees' info");
                System.out.println("Enter 4 to edit tour leaders' info");
                System.out.println("Enter 5 to edit admins' info");
            }
        }
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                PeopleHandle.editProfile(person);
                break;
            case 2:
                PeopleHandle.peopleActions(person, 2);
                break;
            case 3:
                PeopleHandle.peopleActions(person, 3);
                break;
            case 4:
                PeopleHandle.peopleActions(person, 4);
                break;
            case 5:
                PeopleHandle.peopleActions(person, 5);
                break;
        }
    }
}
