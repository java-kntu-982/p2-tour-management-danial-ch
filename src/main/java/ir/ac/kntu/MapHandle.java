package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;
import java.util.Objects;
import java.util.Scanner;

public class MapHandle {

    public static Tour findTour(String name) {
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getFullName().equals(name)) {
                return Main.tours.get(i);
            }
        }
        return null;
    }

    public static void showStartingCityOnMap(Person person) {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's starting city on map");
        name = input.nextLine();
        if (findTour(name) != null) {
            MapUtil.showMap(Objects.requireNonNull(findTour(name)).getStartingCity().getCityName());
        } else {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void showDestinationOnMap(Person person) {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's destination on map");
        name = input.nextLine();
        if (findTour(name) != null) {
            MapUtil.showMap(Objects.requireNonNull(findTour(name)).getDestination().getCityName());
        } else {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void showStartingCityAndDestinationOnMap(Person person) {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's starting city and destination on map");
        name = input.nextLine();
        if (findTour(name) != null) {
            MapUtil.showMap(Objects.requireNonNull(findTour(name)).getStartingCity().getCityName(), Objects.requireNonNull(findTour(name)).getDestination().getCityName());
        } else {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void showCurrentCityOnMap(Person person) {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the tour's full name");
        name = input.nextLine();
        Tour tour;
        if (findTour(name) == null) {
            System.out.println("The Tour wasn't found");
        } else {
            tour = findTour(name);
            System.out.println("Witch day do you want to see it's info?");
            int number = input.nextInt();
            assert tour != null;
            if (number >= tour.getTime()) {
                System.out.println("The number you entered is bigger than tour's total number on day");
            } else {
                System.out.println("To see today's visiting city press 1");
                System.out.println("To see today's visiting attraction press 2");
                int answer = input.nextInt();
                if (answer == 1) {
                    if (tour.getCountry().getName().equals("iran")) {
                        MapUtil.showMap(tour.getStartingCity().getCityName());
                    } else {
                        MapUtil.showMap(tour.cities.get(number - 1).getCityName());
                    }
                } else if (answer == 2) {
                    MapUtil.showMap(tour.getAttractions().get(number - 1).getName());
                }
            }
        }
        backToMenu(person);
    }

    public static void showAllCitiesOfTourOnMap(Person person) {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a tour's full name to show it's cities on map");
        name = input.nextLine();
        if (findTour(name) == null) {
            System.out.println("The Tour wasn't found");
        } else {
            for (int i = 0; i < Objects.requireNonNull(findTour(name)).getCities().size(); i++) {
                MapUtil.showMap(Objects.requireNonNull(findTour(name)).getCities().get(i).getCityName());
            }
        }
        backToMenu(person);
    }

    public static void showLocationOnMap(Person person) {
        //ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a location's name to show it on map");
        name = input.nextLine();
        MapUtil.showMap(name);
        backToMenu(person);
    }

    public static void showTwoCitiesOnMap(Person person) {
        //ClearScreen.cls();
        String city1, city2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first city's name to show it on map");
        city1 = input.nextLine();
        System.out.println("Enter second city's name to show it on map");
        city2 = input.nextLine();
        MapUtil.showMap(city1, city2);
        backToMenu(person);
    }

    public static void backToMenu(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to maps menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.mapsMenu(person);
        } else if (answer == 2) {
            Menu.mainMenu(person);
        }
    }
}
