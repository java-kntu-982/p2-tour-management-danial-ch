package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Scanner;

public class TourHandle {

    public static int compareDate(Date date1, Date date2) {
        if (date1.getYear() > date2.getYear()) {
            return 1;
        } else if (date2.getYear() > date1.getYear()) {
            return -1;
        } else {
            if (date1.getMonth() > date2.getMonth()) {
                return 1;
            } else if (date2.getMonth() > date1.getMonth()) {
                return -1;
            } else {
                if (date1.getDay() > date2.getDay()) {
                    return 1;
                } else if (date2.getDay() > date2.getDay()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void seeAllTourTypes(Person person) {
        ////ClearScreen.cls();
        for (int i = 0; i < Main.tours.size(); i++) {
            System.out.println((i + 1) + ")" + Main.tours.get(i).getName());
        }
        backToMenu(person);
    }

    public static void seeAllTours(Person person) {
        ////ClearScreen.cls();
        for (int i = 0; i < Main.tours.size(); i++) {
            System.out.println(Main.tours.get(i).toString());
        }
        backToMenu(person);
    }

    public static TourLeader chooseTourLeader(Date startingDate, Date finishingDate) {
        int tourLeaderChoice;
        Scanner input = new Scanner(System.in);
        int i;
        System.out.println("Choose on of the tour leaders");
        for (i = 0; i < Main.tourLeaders.size(); i++) {
            if (Main.tourLeaders.get(i).getCurrentTour() == null) {
                System.out.println((i + 1) + ")" + Main.tourLeaders.get(i).getLName());
            } else {
                if (1 == compareDate(Main.tourLeaders.get(i).getCurrentTour().getStartingDate(), finishingDate)
                        || 1 == compareDate(startingDate, Main.tourLeaders.get(i).getCurrentTour().getFinishingDate())) {
                    System.out.println((i + 1) + ")" + Main.tourLeaders.get(i).getLName());
                }
            }
        }
        while (true) {
            tourLeaderChoice = input.nextInt() - 1;
            if (tourLeaderChoice > i) {
                System.out.println("Number isn't valid");
                continue;
            }
            break;
        }
        for (i = 0; i < Main.tourLeaders.size(); i++) {
            if (Main.tourLeaders.get(i).getCurrentTour() == null) {
                if (tourLeaderChoice == i) {
                    return Main.tourLeaders.get(i);
                }
            } else {
                if (1 == compareDate(Main.tourLeaders.get(i).getCurrentTour().getStartingDate(), finishingDate)
                        || 1 == compareDate(startingDate, Main.tourLeaders.get(i).getCurrentTour().getFinishingDate())) {
                    if (tourLeaderChoice == i) {
                        return Main.tourLeaders.get(i);
                    }
                }
            }
        }
        return null;
    }

    public static void addTourTypeBase(TourType tourType) {
        Country iran = Main.countries.getFirst();
        Scanner input = new Scanner(System.in);
        Country country = new Country();
        int travelTypeChoice, time, price, minAttendants, maxAttendants, countryChoice, i;
        String name;
        LinkedList<City> cities = new LinkedList<>();
        System.out.println("Enter tour's name");
        name = input.nextLine();
        tourType.setName(name);
        System.out.println("Choose tour's visiting country");
        for (i = 0; i < Main.countries.size(); i++) {
            System.out.println((i + 1) + ")" + Main.countries.get(i).getName());
        }
        while (true) {
            countryChoice = input.nextInt() - 1;
            if (countryChoice > i) {
                System.out.println("Number isn't valid");
                continue;
            }
            break;
        }
        for (i = 0; i < Main.countries.size(); i++) {
            if (countryChoice == i) {
                country = Main.countries.get(i);
                tourType.setCountry(country);
            }
        }
        if (country.equals(iran)) {
            City city = new City();
            int cityChoice;
            System.out.println("Choose visiting city");
            for (i = 0; i < Main.cities.size(); i++) {
                System.out.println((i + 1) + ")" + Main.cities.get(i).getCityName());
            }
            while (true) {
                cityChoice = input.nextInt() - 1;
                if (cityChoice > i) {
                    System.out.println("Number isn't valid");
                    continue;
                }
                break;
            }
            for (i = 0; i < Main.cities.size(); i++) {
                if (cityChoice == i) {
                    city = Main.cities.get(i);
                }
            }
            cities.add(city);
        } else {
            while (true) {
                int cityChoice;
                System.out.println("Choose visiting cities in order of visit");
                for (i = 0; i < Main.cities.size(); i++) {
                    System.out.println((i + 1) + ")" + Main.cities.get(i).getCityName());
                }
                System.out.println((i + 1) + ")Enter " + (i + 1) + " to finish");
                cityChoice = input.nextInt();
                if (cityChoice == i + 1) {
                    break;
                }
                for (int j = 0; j < Main.cities.size(); j++) {
                    if (cityChoice == j) {
                        cities.add(Main.cities.get(j));
                    }
                }
            }
        }
        tourType.setCities(cities);
        System.out.println("Enter tour's number of days");
        time = input.nextInt();
        tourType.setTime(time);
        System.out.println("Enter tour's price");
        price = input.nextInt();
        tourType.setPrice(price);
        System.out.println("Enter tour's minimum attendants");
        minAttendants = input.nextInt();
        tourType.setMinAttendants(minAttendants);
        System.out.println("Enter tour's maximum attendants");
        maxAttendants = input.nextInt();
        tourType.setMaxAttendants(maxAttendants);
        System.out.println("if tour is an air trip enter 1 and if it's an ground trip enter 2");
        travelTypeChoice = input.nextInt();
        if (travelTypeChoice == 1) {
            tourType.setTravelMethod(TravelMethod.airTrip);
        } else if (travelTypeChoice == 2) {
            tourType.setTravelMethod(TravelMethod.roadTrip);
        }
    }

    public static void addTourType(Person person) {
        ////ClearScreen.cls();
        TourType tourType = new TourType();
        addTourTypeBase(tourType);
        Main.tourTypes.add(tourType);
        System.out.println("Tour type added successfully");
        backToMenu(person);
    }

    public static void editTourType(Person person) {
        ////ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        String name;
        System.out.println("Enter tour's name to edit it");
        name = input.nextLine();
        for (int i = 0; i < Main.tourTypes.size(); i++) {
            if (Main.tourTypes.get(i).getName().equals(name)) {
                addTourTypeBase(Main.tourTypes.get(i));
                flag = true;
                System.out.println("Tour type edited successfully");
                break;
            } else {
                flag = false;
            }
        }

        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void addTourBase(Tour tour) {
        int startingDay, startingMonth, startingYear, finishingDay, finishingMonth, finishingYear;
        String fullName;
        Date startingDate, finishingDate;
        TourType tourType = new TourType();
        TourLeader tourLeader;
        LinkedList<Attraction> attractions = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        int mainChoice, i;
        System.out.println("Choose one of the tour types");
        for (i = 0; i < Main.tourTypes.size(); i++) {
            System.out.println((i + 1) + ")" + Main.tourTypes.get(i).toString());
        }
        while (true) {
            mainChoice = input.nextInt() - 1;
            if (mainChoice > i) {
                System.out.println("Number isn't valid");
                continue;
            }
            break;
        }
        for (i = 0; i < Main.tourTypes.size(); i++) {
            if (mainChoice == i) {
                tourType = Main.tourTypes.get(i);
                break;
            }
        }
        tour.setCountry(tourType.getCountry());
        tour.setMinAttendants(tourType.getMinAttendants());
        tour.setMaxAttendants(tourType.getMaxAttendants());
        tour.setCities(tourType.getCities());
        tour.setPrice(tourType.getPrice());
        tour.setTime(tourType.getTime());
        tour.setTravelMethod(tourType.getTravelMethod());
        while (true) {
            System.out.println("Enter tour's starting day");
            startingDay = input.nextInt();
            System.out.println("Enter tour's starting month");
            startingMonth = input.nextInt();
            System.out.println("Enter tour's starting year");
            startingYear = input.nextInt();
            startingDate = new Date(startingYear, startingMonth, startingDay);
            System.out.println("Enter tour's finishing day");
            finishingDay = input.nextInt();
            System.out.println("Enter tour's finishing month");
            finishingMonth = input.nextInt();
            System.out.println("Enter tour's finishing year");
            finishingYear = input.nextInt();
            finishingDate = new Date(finishingYear, finishingMonth, finishingDay);
            tourLeader = chooseTourLeader(startingDate, finishingDate);
            if (tourLeader == null) {
                System.out.println("Change the time to see the tour leader you want");
                continue;
            }
            break;
        }
        tour.setStartingDate(startingDate);
        tour.setFinishingDate(finishingDate);
        if (tour.getCountry().getName().equals("iran")) {
            for (i = 0; i < tour.getTime(); i++) {
                int attractionChoice, j;
                System.out.println("Choose day " + (i + 1) + " attraction");
                for (j = 0; j < tour.getCities().get(0).getAttractions().size(); j++) {
                    System.out.println((j + 1) + ")" + tour.getCities().get(i).getAttractions().get(j).getName());
                }
                while (true) {
                    attractionChoice = input.nextInt() - 1;
                    if (attractionChoice > j) {
                        System.out.println("Number isn't valid");
                        continue;
                    }
                    break;
                }
                for (j = 0; j < tour.getCities().get(i).getAttractions().size(); j++) {
                    if (attractionChoice == j) {
                        attractions.add(tour.getCities().get(i).getAttractions().get(j));
                    }
                }
            }
            fullName = tour.getCities().getFirst().getCityName() + " " + (Main.tours.size() + 1);
        } else {
            tour.setStartingCity(tour.getCities().getFirst());
            tour.setDestination(tour.getCities().getLast());
            for (i = 0; i < tour.getTime(); i++) {
                int attractionChoice, j;
                System.out.println("Choose day " + (i + 1) + " attraction");
                for (j = 0; j < tour.getCities().get(i).getAttractions().size(); j++) {
                    System.out.println((j + 1) + ")" + tour.getCities().get(i).getAttractions().get(j).getName());
                }
                while (true) {
                    attractionChoice = input.nextInt() - 1;
                    if (attractionChoice > j) {
                        System.out.println("Number isn't valid");
                        continue;
                    }
                    break;
                }
                for (j = 0; j < tour.getCities().get(i).getAttractions().size(); j++) {
                    if (attractionChoice == j) {
                        attractions.add(tour.getCities().get(i).getAttractions().get(j));
                    }
                }
            }
            fullName = tour.getCountry().getName() + " " + (Main.tours.size() + 1);
        }
        tour.setFullName(fullName);
        tour.setAttractions(attractions);
    }

    public static void addTour(Person person) {
        ////ClearScreen.cls();
        Tour tour = new Tour();
        addTourBase(tour);
        Main.tours.add(tour);
        System.out.println("Tour Added Successfully");
        backToMenu(person);
    }

    public static void editTour(Person person) {
        //ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        String fullName;
        boolean flag = false;
        System.out.println("Enter tour's full name to edit it");
        fullName = input.nextLine();
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getFullName().equals(fullName)) {
                addTourBase(Main.tours.get(i));
                System.out.println("Tour edited Successfully");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void deleteTour(Person person) {
        ////ClearScreen.cls();
        Scanner input = new Scanner(System.in);
        String fullName;
        boolean flag = false;
        System.out.println("Enter tour's full name");
        fullName = input.nextLine();
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getFullName().equals(fullName)) {
                Main.tours.remove(i);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Tour has been deleted successfully");
        } else {
            System.out.println("Tour wasn't Found");
        }
        backToMenu(person);
    }

    public static void searchTourType(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to search based on number of days");
        System.out.println("Enter 2 to search based on visiting cities");
        System.out.println("Enter 3 to search based on visiting country");
        System.out.println("Enter 4 to search based on minimum and maximum capacity");
        System.out.println("Enter 5 to search based on price");
        answer = input.nextInt();
        switch (answer) {
            case 1:
                searchInNumberOfDays(person);
                break;
            case 2:
                searchInVisitingCities(person);
                break;
            case 3:
                searchInVisitingCountry(person);
                break;
            case 4:
                searchInMinAndMaxCapacity(person);
                break;
            case 5:
                searchInPrice(person);
                break;
        }
    }

    public static void searchInNumberOfDays(Person person) {
        Scanner input = new Scanner(System.in);
        int number;
        boolean flag = false;
        System.out.println("Enter tour's number of days");
        number = input.nextInt();
        for (int i = 0; i < Main.tourTypes.size(); i++) {
            if (Main.tourTypes.get(i).getTime() == number) {
                System.out.println(Main.tourTypes.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInVisitingCities(Person person) {
        Scanner input = new Scanner(System.in);
        String cityName;
        boolean flag = false;
        System.out.println("Enter a city that you are looking for");
        cityName = input.nextLine();
        for (int i = 0; i < Main.tourTypes.size(); i++) {
            for (int j = 0; j < Main.tourTypes.get(i).getCities().size(); j++) {
                if (Main.tourTypes.get(i).getCities().get(j).getCityName().equals(cityName)) {
                    System.out.println(Main.tourTypes.get(i).toString());
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInVisitingCountry(Person person) {
        Scanner input = new Scanner(System.in);
        String country;
        boolean flag = false;
        System.out.println("Enter tour's visiting country");
        country = input.nextLine();
        for (int i = 0; i < Main.tourTypes.size(); i++) {
            if (Main.tourTypes.get(i).getCountry().getName().equals(country)) {
                System.out.println(Main.tourTypes.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInMinAndMaxCapacity(Person person) {
        Scanner input = new Scanner(System.in);
        int minAttendants, maxAttendants;
        boolean flag = false;
        System.out.println("Enter tour's minimum attendants");
        minAttendants = input.nextInt();
        System.out.println("Enter tour's maximum attendants");
        maxAttendants = input.nextInt();
        for (int i = 0; i < Main.tourTypes.size(); i++) {
            if (Main.tourTypes.get(i).getMinAttendants() >= minAttendants && Main.tourTypes.get(i).getMaxAttendants() <= maxAttendants) {
                System.out.println(Main.tourTypes.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInPrice(Person person) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        int price, choice, secondPrice;
        System.out.println("Enter 1 to search by a specific price");
        System.out.println("Enter 2 to search prices that are bigger than a number");
        System.out.println("Enter 3 to search prices that are smaller than a number");
        System.out.println("Enter 4 to search prices which are between two numbers");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter a price");
                price = input.nextInt();
                for (int i = 0; i < Main.tourTypes.size(); i++) {
                    if (Main.tourTypes.get(i).getPrice() == price) {
                        System.out.println(Main.tourTypes.get(i).toString());
                        flag = true;
                    }
                }
                break;
            case 2:
                System.out.println("Enter minimum price");
                price = input.nextInt();
                for (int i = 0; i < Main.tourTypes.size(); i++) {
                    if (Main.tourTypes.get(i).getPrice() >= price) {
                        System.out.println(Main.tourTypes.get(i).toString());
                        flag = true;
                    }
                }
                break;
            case 3:
                System.out.println("Enter maximum price");
                price = input.nextInt();
                for (int i = 0; i < Main.tourTypes.size(); i++) {
                    if (Main.tourTypes.get(i).getPrice() <= price) {
                        System.out.println(Main.tourTypes.get(i).toString());
                        flag = true;
                    }
                }
                break;
            case 4:
                System.out.println("Enter minimum price");
                price = input.nextInt();
                System.out.println("Enter maximum price");
                secondPrice = input.nextInt();
                for (int i = 0; i < Main.tourTypes.size(); i++) {
                    if (Main.tourTypes.get(i).getPrice() >= price && Main.tourTypes.get(i).getPrice() <= secondPrice) {
                        System.out.println(Main.tourTypes.get(i).toString());
                        flag = true;
                    }
                }
                break;
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInTours(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to search based on tour's tour leader");
        System.out.println("Enter 2 to search based on starting and ending date");
        System.out.println("Enter 3 to search based on number of days");
        System.out.println("Enter 4 to search based on visiting city");
        System.out.println("Enter 5 to search based on visiting country");
        System.out.println("Enter 6 to search based on minimum and maximum capacity");
        answer = input.nextInt();
        switch (answer) {
            case 1:
                searchInTourLeader(person);
                break;
            case 2:
                searchInStartingAndFinishingDate(person);
                break;
            case 3:
                searchInNumberOfDaysTour(person);
                break;
            case 4:
                searchInVisitingCityTour(person);
                break;
            case 5:
                searchInVisitingCountryTour(person);
                break;
            case 6:
                searchInMinAndMaxCapacityTour(person);
                break;
        }
    }

    public static void searchInTourLeader(Person person) {
        Scanner input = new Scanner(System.in);
        String name;
        boolean flag = false;
        System.out.println("Enter tour leader's last name");
        name = input.nextLine();
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getTourLeader().getLName().equals(name)) {
                System.out.println(Main.tours.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInStartingAndFinishingDate(Person person) {
        Scanner input = new Scanner(System.in);
        int choice, startingDay, startingMonth, startingYear, finishingDay, finishingMonth, finishingYear;
        Date startingDate, finishingDate;
        boolean flag = false;
        System.out.println("Enter 1 to see tours after a specific date");
        System.out.println("Enter 2 to see tours before a specific date");
        System.out.println("Enter 3 to see tours between to dates");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the day");
                startingDay = input.nextInt();
                System.out.println("Enter the month");
                startingMonth = input.nextInt();
                System.out.println("Enter the year");
                startingYear = input.nextInt();
                startingDate = new Date(startingYear, startingMonth, startingDay);
                for (int i = 0; i < Main.tours.size(); i++) {
                    if (compareDate(Main.tours.get(i).getStartingDate(), startingDate) >= 0) {
                        System.out.println(Main.tours.get(i).toString());
                        flag = true;
                    }
                }
                break;
            case 2:
                System.out.println("Enter the day");
                finishingDay = input.nextInt();
                System.out.println("Enter the month");
                finishingMonth = input.nextInt();
                System.out.println("Enter the year");
                finishingYear = input.nextInt();
                finishingDate = new Date(finishingYear, finishingMonth, finishingDay);
                for (int i = 0; i < Main.tours.size(); i++) {
                    if (compareDate(Main.tours.get(i).getFinishingDate(), finishingDate) <= 0) {
                        System.out.println(Main.tours.get(i).toString());
                        flag = true;
                    }
                }
                break;
            case 3:
                System.out.println("Enter the day");
                startingDay = input.nextInt();
                System.out.println("Enter the month");
                startingMonth = input.nextInt();
                System.out.println("Enter the year");
                startingYear = input.nextInt();
                startingDate = new Date(startingYear, startingMonth, startingDay);
                System.out.println("Enter the day");
                finishingDay = input.nextInt();
                System.out.println("Enter the month");
                finishingMonth = input.nextInt();
                System.out.println("Enter the year");
                finishingYear = input.nextInt();
                finishingDate = new Date(finishingYear, finishingMonth, finishingDay);
                for (int i = 0; i < Main.tours.size(); i++) {
                    if (compareDate(Main.tours.get(i).getFinishingDate(), finishingDate) <= 0 && compareDate(Main.tours.get(i).getStartingDate(), startingDate) >= 0) {
                        System.out.println(Main.tours.get(i).toString());
                        flag = true;
                    }
                }
                break;
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInNumberOfDaysTour(Person person) {
        Scanner input = new Scanner(System.in);
        int number;
        boolean flag = false;
        System.out.println("Enter tour's number of days");
        number = input.nextInt();
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getTime() == number) {
                System.out.println(Main.tours.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInVisitingCityTour(Person person) {
        Scanner input = new Scanner(System.in);
        String cityName;
        boolean flag = false;
        System.out.println("Enter a city that you are looking for");
        cityName = input.nextLine();
        for (int i = 0; i < Main.tours.size(); i++) {
            for (int j = 0; j < Main.tours.get(i).getCities().size(); j++) {
                if (Main.tours.get(i).getCities().get(j).getCityName().equals(cityName)) {
                    System.out.println(Main.tours.get(i).toString());
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInVisitingCountryTour(Person person) {
        Scanner input = new Scanner(System.in);
        String country;
        boolean flag = false;
        System.out.println("Enter tour's visiting country");
        country = input.nextLine();
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getCountry().getName().equals(country)) {
                System.out.println(Main.tours.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void searchInMinAndMaxCapacityTour(Person person) {
        Scanner input = new Scanner(System.in);
        int minAttendants, maxAttendants;
        boolean flag = false;
        System.out.println("Enter tour's minimum attendants");
        minAttendants = input.nextInt();
        System.out.println("Enter tour's maximum attendants");
        maxAttendants = input.nextInt();
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getMinAttendants() >= minAttendants && Main.tours.get(i).getMaxAttendants() <= maxAttendants) {
                System.out.println(Main.tours.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Tour wasn't found");
        }
        backToMenu(person);
    }

    public static void backToMenu(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to tour menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.tourMenu(person);
        } else if (answer == 2) {
            Menu.mainMenu(person);
        }
    }
}
