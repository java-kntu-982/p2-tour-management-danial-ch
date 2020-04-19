package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Scanner;

public class TourLeaderHandle {

    public static void seeAllLeaders(Person person) {
        //ClearScreen.cls();
        for (int i = 0; i < Main.tourLeaders.size(); i++) {
            System.out.println((i + 1) + ")" + Main.tourLeaders.get(i).toString());
        }
        backToMenu(person);
    }

    public static void addLeaderBase(TourLeader tourLeader){
        Scanner input = new Scanner(System.in);
        String fName, lName, nationalCode, idNumber, temp;
        int birthYear, birthMonth, birthDay, registerYear, registerMonth, registerDay,i;
        boolean married = false;
        Date birthDate, registerDate;
        LinkedList<City> knownCities = new LinkedList<>();
        LinkedList<Country> knownCountries = new LinkedList<>();
        System.out.println("Enter first name");
        fName = input.nextLine();
        System.out.println("Enter last name");
        lName = input.nextLine();
        System.out.println("Enter national code name");
        nationalCode = input.nextLine();
        System.out.println("Enter ID number name");
        idNumber = input.nextLine();
        System.out.println("Is he/she married?(y/n)");
        temp = input.nextLine();
        if (temp.equals("y")) {
            married = true;
        }
        System.out.println("Enter birth year");
        birthYear = input.nextInt();
        System.out.println("Enter birth month");
        birthMonth = input.nextInt();
        System.out.println("Enter birth day");
        birthDay = input.nextInt();
        birthDate = new Date(birthYear, birthMonth, birthDay);
        System.out.println("Enter register year");
        registerYear = input.nextInt();
        System.out.println("Enter register month");
        registerMonth = input.nextInt();
        System.out.println("Enter register day");
        registerDay = input.nextInt();
        registerDate = new Date(registerYear, registerMonth, registerDay);
        System.out.println("Enter a city's number to add it to tour leader's known locations");
        while (true) {
            int tempLocation;
            for (i = 0; i < Main.cities.size(); i++) {
                System.out.println((i + 1) + ") " + Main.cities.get(i).getCityName());
            }
            System.out.println((i + 1) + ")Enter " + (i + 1) + " to finish");
            tempLocation = input.nextInt();
            if (tempLocation == i + 1) {
                break;
            }
            for (int j = 0; j < Main.cities.size(); j++) {
                if (i - 1 == j) {
                    knownCities.add(Main.cities.get(j));
                }
            }
        }
        System.out.println("Enter a country's number to add it to tour leader's known countries");
        while (true) {
            int tempLocation;
            for (i = 0; i < Main.countries.size(); i++) {
                System.out.println((i + 1) + ")" + Main.countries.get(i).getName());
            }
            System.out.println((i + 1) + ")Enter " + (i + 1) + " to finish");
            tempLocation = input.nextInt();
            if (tempLocation == i + 1) {
                break;
            }
            for (int j = 0; j < Main.countries.size(); j++) {
                if (i - 1 == j) {
                    knownCountries.add(Main.countries.get(j));
                }
            }
        }
        tourLeader.setLName(lName);
        tourLeader.setFName(fName);
        tourLeader.setNationalCode(nationalCode);
        tourLeader.setIdNumber(idNumber);
        tourLeader.setAge(2020-birthYear);
        tourLeader.setKnownCountries(knownCountries);
        tourLeader.setKnownCities(knownCities);
        tourLeader.setRegisterDate(registerDate);
        tourLeader.setBirthDate(birthDate);
        tourLeader.setMarried(married);
        tourLeader.setCurrentTour(null);
    }

    public static void addLeader(Person person) {
        //ClearScreen.cls();
        int i;
        TourLeader tourLeader = new TourLeader();
        String username ="", password="", email="", phoneNumber="";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to add a tour leader from basics");
        System.out.println("Enter 2 to complete an already available leader");
        int initialChoice=input.nextInt();
        if(initialChoice==1){
            for(i=0;i<Main.people.size();i++){
                if(Main.people.get(i).getAccessLevel()==2){
                    System.out.println((i+1)+")"+Main.people.get(i).userName);
                }
            }
            int tourLeaderChoice=input.nextInt()-1;
            for(i=0;i<Main.people.size();i++){
                if(Main.people.get(i).getAccessLevel()==2){
                    if(tourLeaderChoice==i){
                        username=Main.people.get(i).userName;
                        password=Main.people.get(i).passWord;
                        email=Main.people.get(i).email;
                        phoneNumber=Main.people.get(i).phoneNumber;
                        Person prs=new Person(username,password,email,phoneNumber,2);
                        Main.people.add(prs);
                    }
                }
            }
        } else{
            System.out.println("Enter username");
            username = input.nextLine();
            System.out.println("Enter password");
            password = input.nextLine();
            System.out.println("Enter email");
            email = input.nextLine();
            System.out.println("Enter phone number");
            phoneNumber = input.nextLine();
        }
        tourLeader.userName=username;
        tourLeader.passWord=password;
        tourLeader.email=email;
        tourLeader.phoneNumber=phoneNumber;
        addLeaderBase(tourLeader);
        Main.tourLeaders.add(tourLeader);
        System.out.println("Tour leader added successfully");
        backToMenu(person);
    }

    public static void deleteLeader(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        System.out.println("Enter tour leader's ID number to delete him/her from system");
        String idNumber = input.nextLine();
        for (int i = 0; i < Main.tourLeaders.size(); i++) {
            if (Main.tourLeaders.get(i).getIdNumber().equals(idNumber)) {
                Main.tourLeaders.remove(i);
                System.out.println("Tour leader deleted successfully");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Tour leader wasn't found");
        }
        backToMenu(person);
    }

    public static void editLeader(Person person) {
        //ClearScreen.cls();
        boolean flag=false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter tour leader's ID number to edit him/her");
        String idNumberTemp = input.nextLine();
        for (int k = 0; k < Main.tourLeaders.size(); k++) {
            if (Main.tourLeaders.get(k).getIdNumber().equals(idNumberTemp)) {
                TourLeader tourLeader = Main.tourLeaders.get(k);
                addLeaderBase(tourLeader);
                System.out.println("Tour leader edited successfully");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Tour leader wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInTourLeaders(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 Search By first name");
        System.out.println("Enter 2 Search By last name");
        System.out.println("Enter 3 Search By known locations");
        System.out.println("Enter 4 Search By age");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                searchByFName(person);
                break;
            case 2:
                searchByLName(person);
                break;
            case 3:
                searchByKnownLocations(person);
                break;
            case 4:
                searchByAge(person);
                break;
        }
        backToMenu(person);
    }

    public static void searchByFName(Person person) {
        //ClearScreen.cls();
        String fName;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name");
        fName = input.nextLine();
        for (int i = 0; i < Main.tourLeaders.size(); i++) {
            if (Main.tourLeaders.get(i).getFName().equals(fName)) {
                System.out.println(Main.tourLeaders.get(i).toString());
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Tour leader wasn't found");
        }
        backToMenu(person);
    }

    public static void searchByLName(Person person) {
        //ClearScreen.cls();
        String lName;
        boolean flag = false;
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter last name");
        lName = input.nextLine();
        for (int i = 0; i < Main.tourLeaders.size(); i++) {
            if (Main.tourLeaders.get(i).getLName().equals(lName)) {
                System.out.println(Main.tourLeaders.get(i).toString());
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Tour leader wasn't found");
        }
        backToMenu(person);
    }

    public static void searchByKnownLocations(Person person) {
        //ClearScreen.cls();
        City city = new City();
        Country country = new Country();
        boolean flag = false;
        int i, answer, j, choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to Search in countries");
        System.out.println("Enter 2 to Search in cities");
        choice = input.nextInt();
        System.out.println("Choose one of the locations below");
        if (choice == 1) {
            for (i = 0; i < Main.countries.size(); i++) {
                System.out.println((i + 1) + ")" + Main.countries.get(i).getName());
            }
            answer = input.nextInt();
            for (i = 0; i < Main.countries.size(); i++) {
                if (i == answer) {
                    country = Main.countries.get(i);
                    break;
                }
            }
            for (i = 0; i < Main.tourLeaders.size(); i++) {
                for (j = 0; j < Main.tourLeaders.get(i).getKnownCountries().size(); j++) {
                    if (Main.tourLeaders.get(i).getKnownCountries().get(j).equals(country)) {
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag = true;
                        break;
                    }
                }
            }
        } else if (choice == 2) {
            for (i = 0; i < Main.cities.size(); i++) {
                System.out.println((i + 1) + ")" + Main.cities.get(i).getCityName());
            }
            answer = input.nextInt();
            for (i = 0; i < Main.cities.size(); i++) {
                if (i == answer) {
                    city = Main.cities.get(i);
                    break;
                }
            }
            for (i = 0; i < Main.tourLeaders.size(); i++) {
                for (j = 0; j < Main.tourLeaders.get(i).getKnownCities().size(); j++) {
                    if (Main.tourLeaders.get(i).getKnownCities().get(j).equals(city)) {
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag = true;
                        break;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("Tour leader wasn't found");
        }
        backToMenu(person);
    }

    public static void searchByAge(Person person) {
        //ClearScreen.cls();
        int answer, smallerThanNumber, biggerThanNumber;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        System.out.println("1)A certain number");
        System.out.println("2)Bigger than a number");
        System.out.println("3)Smaller than a number");
        System.out.println("4)Between two numbers");
        answer = input.nextInt();
        switch (answer) {
            case 1:
                int exactNumber;
                System.out.println("Enter number");
                exactNumber = input.nextInt();
                for (int i = 0; i < Main.tourLeaders.size(); i++) {
                    if (Main.tourLeaders.get(i).getAge() == exactNumber) {
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag = true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Enter a number smaller than the age");
                biggerThanNumber = input.nextInt();
                for (int i = 0; i < Main.tourLeaders.size(); i++) {
                    if (Main.tourLeaders.get(i).getAge() > biggerThanNumber) {
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag = true;
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Enter a number bigger than the age");
                smallerThanNumber = input.nextInt();
                for (int i = 0; i < Main.tourLeaders.size(); i++) {
                    if (Main.tourLeaders.get(i).getAge() < smallerThanNumber) {
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag = true;
                        break;
                    }
                }
                break;
            case 4:
                System.out.println("Enter a number bigger than the age");
                smallerThanNumber = input.nextInt();
                System.out.println("Enter a number smaller than the age");
                biggerThanNumber = input.nextInt();
                for (int i = 0; i < Main.tourLeaders.size(); i++) {
                    if (Main.tourLeaders.get(i).getAge() < smallerThanNumber && Main.tourLeaders.get(i).getAge() > biggerThanNumber) {
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag = true;
                        break;
                    }
                }
                break;
        }
        if (!flag) {
            System.out.println("Tour leader wasn't found");
        }
        backToMenu(person);
    }

    public static void backToMenu(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to tour leader menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.tourLeaderMenu(person);
        } else if (answer == 2) {
            Menu.mainMenu(person);
        }
    }
}
