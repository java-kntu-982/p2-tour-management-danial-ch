package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.Scanner;

public class MapHandle {

    public static LocalTour findLocalTour(String name) {
        //ClearScreen.cls();
        for (int i = 0; i < Main.localTours.size(); i++) {
            if (Main.localTours.get(i).getFullName().equals(name)) {
                return Main.localTours.get(i);
            }
        }
        return null;
    }

    public static ForeignTour findForeignTour(String name) {
        //ClearScreen.cls();
        for (int i = 0; i < Main.foreignTours.size(); i++) {
            if (Main.foreignTours.get(i).getFullName().equals(name)) {
                return Main.foreignTours.get(i);
            }
        }
        return null;
    }

    public static void showStartingCityOnMap() {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's starting city on map");
        name = input.nextLine();
        if (findLocalTour(name) == null) {
            if (findForeignTour(name) == null) {
                System.out.println("The Tour wasn't found");
            } else {
                MapUtil.showMap(findForeignTour(name).getStartingCity().getCityName());
            }
        } else {
            MapUtil.showMap(findLocalTour(name).getLocation().getCityName());
        }
        backToMenu();
    }

    public static void showDestinationOnMap() {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's destination on map");
        name = input.nextLine();
        if (findLocalTour(name) == null) {
            if (findForeignTour(name) == null) {
                System.out.println("The Tour wasn't found");
            } else {
                MapUtil.showMap(findForeignTour(name).getDestination().getCityName());
            }
        } else {
            MapUtil.showMap(findLocalTour(name).getLocation().getCityName());
        }
        backToMenu();
    }

    public static void showStartingCityAndDestinationOnMap() {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's starting city and destination on map");
        name = input.nextLine();
        if (findLocalTour(name) == null) {
            if (findForeignTour(name) == null) {
                System.out.println("The Tour wasn't found");
            } else {
                MapUtil.showMap(findForeignTour(name).getStartingCity().getCityName());
                MapUtil.showMap(findForeignTour(name).getDestination().getCityName());
            }
        } else {
            MapUtil.showMap(findLocalTour(name).getLocation().getCityName());
        }
        backToMenu();
    }

    public static void showCurrentCityOnMap() {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the tour's full name");
        name = input.nextLine();
        ForeignTour tour;
        if (findForeignTour(name) == null) {
            System.out.println("The Tour wasn't found");
        } else {
            tour = findForeignTour(name);
            System.out.println("Witch day do you want to see it's info?");
            int number = input.nextInt();
            if (number >= tour.getTime()) {
                System.out.println("The number you entered is bigger than tour's total number on day");
            } else {
                System.out.println("To see today's visiting city press 1");
                System.out.println("To see today's visiting attraction press 2");
                int answer = input.nextInt();
                switch (answer) {
                    case 1:
                        MapUtil.showMap(tour.getAttractions().get(number).getCity());
                        break;
                    case 2:
                        MapUtil.showMap(tour.getAttractions().get(number).getName());
                        break;
                }
            }
        }
        backToMenu();
    }

    public static void showAllCitiesOfTourOnMap() {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's cities on map");
        name = input.nextLine();
        if (findForeignTour(name) == null) {
            System.out.println("The Tour wasn't found");
        } else {
            for (int i = 0; i < findForeignTour(name).getLocations().size(); i++) {
                MapUtil.showMap(findForeignTour(name).getLocations().get(i).getCityName());
            }
        }
        backToMenu();
    }

    public static void showLocationOnMap() {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a location's name to show it on map");
        name = input.nextLine();
        MapUtil.showMap(name);
        backToMenu();
    }

    public static void showTwoCitiesOnMap() {
        //ClearScreen.cls();
        String city1, city2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first city's name to show it on map");
        city1 = input.nextLine();
        System.out.println("Enter second city's name to show it on map");
        city2 = input.nextLine();
        MapUtil.showMap(city1, city2);
        backToMenu();
    }

    public static void backToMenu() {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to maps menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.mapsMenu();
        } else if (answer == 2) {
            Menu.mainMenu();
        }
    }
}
