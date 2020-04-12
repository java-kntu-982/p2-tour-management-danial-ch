package ir.ac.kntu;

import java.util.Scanner;

public class AttractionHandle {

    public static void seeAllAttractions() {
        //ClearScreen.cls();
        for (int i = 0; i < Main.attractions.size(); i++) {
            System.out.println((i + 1) + ")" + Main.attractions.get(i).toString());
        }
        backToMenu();
    }

    public static void addAttraction() {
        //ClearScreen.cls();
        String name, city;
        int choice, i;
        Scanner input = new Scanner(System.in);
        Attraction attraction = new Attraction();
        System.out.println("Enter attraction's name");
        name = input.nextLine();
        System.out.println("Choose a city in witch attraction is in");
        for (i = 0; i < Main.locations.size(); i++) {
            System.out.println((i + 1) + ")" + Main.locations.get(i).getCityName());
        }
        while (true) {
            choice = input.nextInt() - 1;
            if (choice > Main.locations.size()) {
                System.out.println("Number is not valid please try again");
                continue;
            }
            break;
        }
        for (i = 0; i < Main.locations.size(); i++) {
            if (choice == i) {
                city = Main.locations.get(i).getCityName();
                attraction.setCity(city);
            }
        }
        attraction.setName(name);
        Main.attractions.add(attraction);
        Main.locations.get(i).getAttractions().add(attraction);
        System.out.println("Attraction added successfully");
        backToMenu();
    }

    public static void editAnAttraction() {
        //ClearScreen.cls();
        boolean flag = false;
        String name, city, tempName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter attraction's name");
        tempName = input.nextLine();
        for (int j = 0; j < Main.attractions.size(); j++) {
            if (Main.attractions.get(j).getName().equals(tempName)) {
                Attraction attraction = Main.attractions.get(j);
                int choice;
                System.out.println("Enter attraction's new name");
                name = input.nextLine();
                System.out.println("Choose a new city in witch attraction is in");
                for (int i = 0; i < Main.locations.size(); i++) {
                    System.out.println((i + 1) + ")" + Main.locations.get(i).getCityName());
                }
                while (true) {
                    choice = input.nextInt() - 1;
                    if (choice > Main.locations.size()) {
                        System.out.println("Number is not valid please try again");
                        continue;
                    }
                    break;
                }
                for (int i = 0; i < Main.locations.size(); i++) {
                    if (choice == i) {
                        city = Main.locations.get(i).getCityName();
                        attraction.setCity(city);
                    }
                }
                attraction.setName(name);
                System.out.println("Attraction edited successfully");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Attraction wasn't found");
        }
        backToMenu();
    }

    public static void deleteAnAttraction() {
        //ClearScreen.cls();
        boolean flag = false;
        String tempName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter attraction's name");
        tempName = input.nextLine();
        for (int i = 0; i < Main.attractions.size(); i++) {
            if (Main.attractions.get(i).getName().equals(tempName)) {
                Main.attractions.remove(i);
                System.out.println("Attraction deleted successfully");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Attraction wasn't found");
        }
        backToMenu();
    }

    public static void backToMenu() {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to attraction menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.attractionsMenu();
        } else if (answer == 2) {
            Menu.mainMenu();
        }
    }
}
