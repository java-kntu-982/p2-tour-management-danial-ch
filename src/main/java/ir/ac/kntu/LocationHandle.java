package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Scanner;

public class LocationHandle {

    public static void seeAllLocations(Person person) {
        ////ClearScreen.cls();
        System.out.println("Cities:");
        for (int i = 0; i < Main.cities.size(); i++) {
            System.out.println((i + 1) + ")" + Main.cities.get(i).getCityName());
        }
        System.out.println("Countries:");
        for (int i = 0; i < Main.countries.size(); i++) {
            System.out.println((i + 1) + ")" + Main.countries.get(i).getName());
        }
        backToMenu(person);
    }

    public static void addCountryBase(Country country) {
        Scanner input = new Scanner(System.in);
        String name;
        LinkedList<City> cities = new LinkedList<>();
        System.out.println("Enter country's name");
        name = input.nextLine();
        System.out.println("choose country's locations");
        while (true) {
            int tempLocation, i;
            ////ClearScreen.cls();
            for (i = 0; i < Main.cities.size(); i++) {
                System.out.println((i + 1) + ")" + Main.cities.get(i).getCityName());
            }
            System.out.println((i + 1) + ")Enter " + (i + 1) + " to finish");
            tempLocation = input.nextInt();
            if (tempLocation == i + 1) {
                break;
            }
            for (int j = 0; j < Main.cities.size(); j++) {
                if (i == j) {
                    cities.add(Main.cities.get(j));
                }
            }
        }
        country.setName(name);
        country.setLocations(cities);
    }

    public static void addCountry(Person person) {
        ////ClearScreen.cls();
        Country country = new Country();
        addCountryBase(country);
        Main.countries.add(country);
        System.out.println("Country added successfully");
        backToMenu(person);
    }

    public static void addCity(Person person) {
        ////ClearScreen.cls();
        String name;
        Scanner input = new Scanner(System.in);
        City city = new City();
        System.out.println("Enter city's name");
        name = input.nextLine();
        city.setCityName(name);
        Main.cities.add(city);
        backToMenu(person);
    }

    public static void deleteCountry(Person person) {
        ////ClearScreen.cls();
        String name;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter country's name");
        name = input.nextLine();
        for (int i = 0; i < Main.countries.size(); i++) {
            if (Main.countries.get(i).getName().equals(name)) {
                Main.countries.remove(i);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Country deleted successfully");
        } else {
            System.out.println("Country wasn't found");
        }
        backToMenu(person);
    }

    public static void deleteCity(Person person) {
        ////ClearScreen.cls();
        String name;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter city's name");
        name = input.nextLine();
        for (int i = 0; i < Main.cities.size(); i++) {
            if (Main.cities.get(i).getCityName().equals(name)) {
                Main.cities.remove(i);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("City deleted successfully");
        } else {
            System.out.println("City wasn't found");
        }
        backToMenu(person);
    }

    public static void editCountry(Person person) {
        Scanner input = new Scanner(System.in);
        String name;
        boolean flag = false;
        System.out.println("Enter country's name to edit it");
        name = input.nextLine();
        for (int i = 0; i < Main.countries.size(); i++) {
            if (Main.countries.get(i).getName().equals(name)) {
                addCountryBase(Main.countries.get(i));
                flag = true;
                System.out.println("Country edited successfully");
            }
        }
        if (!flag) {
            System.out.println("Country wasn't found");
        }
        backToMenu(person);
    }

    public static void backToMenu(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to locations menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.locationsMenu(person);
        } else if (answer == 2) {
            Menu.mainMenu(person);
        }
    }
}
