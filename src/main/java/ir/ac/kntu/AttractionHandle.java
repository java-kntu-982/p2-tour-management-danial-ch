package ir.ac.kntu;

import java.util.Scanner;

public class AttractionHandle {

    public static void seeAllAttractions(Person person) {
        //ClearScreen.cls();
        for (int i = 0; i < Main.attractions.size(); i++) {
            System.out.println((i + 1) + ")" + Main.attractions.get(i).getName());
        }
        backToMenu(person);
    }

    public static void addAttractionBase(Attraction attraction) {
        Scanner input = new Scanner(System.in);
        String name;
        int choice, i;
        System.out.println("Enter attraction's name");
        name = input.nextLine();
        System.out.println("Choose a city in witch attraction is in");
        for (i = 0; i < Main.cities.size(); i++) {
            System.out.println((i + 1) + ")" + Main.cities.get(i).getCityName());
        }
        while (true) {
            choice = input.nextInt() - 1;
            if (choice > Main.cities.size()) {
                System.out.println("Number is not valid please try again");
                continue;
            }
            break;
        }
        for (i = 0; i < Main.cities.size(); i++) {
            if (choice == i) {
                Main.cities.get(i).getAttractions().add(attraction);
            }
        }
        attraction.setName(name);
    }

    public static void addAttraction(Person person) {
        //ClearScreen.cls();
        Attraction attraction = new Attraction();
        addAttractionBase(attraction);
        Main.attractions.add(attraction);
        System.out.println("Attraction added successfully");
        backToMenu(person);
    }

    public static void editAnAttraction(Person person) {
        //ClearScreen.cls();
        boolean flag = false;
        String tempName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter attraction's name");
        tempName = input.nextLine();
        for (int j = 0; j < Main.attractions.size(); j++) {
            if (Main.attractions.get(j).getName().equals(tempName)) {
                Attraction attraction = Main.attractions.get(j);
                addAttractionBase(attraction);
                System.out.println("Attraction edited successfully");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Attraction wasn't found");
        }
        backToMenu(person);
    }

    public static void deleteAnAttraction(Person person) {
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
        backToMenu(person);
    }

    public static void backToMenu(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to attraction menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.attractionsMenu(person);
        } else if (answer == 2) {
            Menu.mainMenu(person);
        }
    }
}
