package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static LinkedList<TourLeader> tourLeaders = new LinkedList<>();
    public static LinkedList<TourType> tourTypes = new LinkedList<>();
    public static LinkedList<Tour> tours = new LinkedList<>();
    public static LinkedList<Attraction> attractions = new LinkedList<>();
    public static LinkedList<City> cities = new LinkedList<>();
    public static LinkedList<Country> countries = new LinkedList<>();
    public static LinkedList<Person> people = new LinkedList<>();

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin("admin", "admin", "admin", "111111111");
        people.add(admin);
        Country iran = new Country();
        iran.setName("iran");
        countries.add(iran);
        while (true) {
            System.out.println("Enter 1 to Login to system");
            System.out.println("Enter 2 to exit");
            int answer = input.nextInt();
            if (answer == 1) {
                boolean wrongUserName = true, wrongPassword = true;
                System.out.println("Enter Username");
                String username = input.next();
                System.out.println("Enter password");
                String password = input.next();
                for (Person person : people) {
                    if (person.userName.equals(username)) {
                        wrongUserName = false;
                        if (person.passWord.equals(password)) {
                            wrongPassword = false;
                            System.out.print("You have logged in as ");
                            switch (person.getAccessLevel()) {
                                case 1:
                                    System.out.print("customer\n");
                                    break;
                                case 2:
                                    System.out.println("tour leader\n");
                                    break;
                                case 3:
                                    System.out.print("employee\n");
                                    break;
                                case 4:
                                    System.out.println("admin\n");
                                    break;
                            }
                            Menu.mainMenu(person);
                            break;
                        }
                    }
                }
                if (wrongPassword) {
                    System.out.println("Password is incorrect");
                    continue;
                }
                if (wrongUserName) {
                    System.out.println("Username was not found");
                }
            } else {
                break;
            }
        }
    }
}
