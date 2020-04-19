package ir.ac.kntu;

import java.util.Scanner;

public class PeopleHandle {

    public static void editPersonBase(Person person) {
        Scanner input = new Scanner(System.in);
        String username, oldPass, newPass, email, phoneNumber;
        System.out.println("Enter new username");
        username = input.nextLine();
        person.userName = username;
        System.out.println("Enter old password");
        while (true) {
            oldPass = input.nextLine();
            if (person.passWord.equals(oldPass)) {
                System.out.println("Enter new password");
                newPass = input.nextLine();
                person.passWord = newPass;
                break;
            } else {
                System.out.println("Your password is incorrect try again");
            }
        }
        System.out.println("Enter new email");
        email = input.nextLine();
        person.email = email;
        System.out.println("Enter new phone number");
        phoneNumber = input.nextLine();
        person.phoneNumber = phoneNumber;
    }

    public static void editEmployeeBase(Person person) {
        Scanner input = new Scanner(System.in);
        if (person.getAccessLevel() == 3) {
            Employee employee = (Employee) person;
            int baseSalary, registerDay, registerMonth, registerYear;
            Date registerDate;
            System.out.println("Enter new base salary");
            baseSalary = input.nextInt();
            employee.setBaseSalary(baseSalary);
            System.out.println("Enter new register day");
            registerDay = input.nextInt();
            System.out.println("Enter new register month");
            registerMonth = input.nextInt();
            System.out.println("Enter new register year");
            registerYear = input.nextInt();
            registerDate = new Date(registerYear, registerMonth, registerDay);
            employee.setRegisterDate(registerDate);
        }
    }

    public static void editProfile(Person person) {
        editPersonBase(person);
        editEmployeeBase(person);
        backToMenu(person);
    }

    public static void customerActions(Person person) {
        System.out.println("Enter 1 to add a customer");
        if (person.getAccessLevel() == 2 || person.getAccessLevel() == 4) {
            System.out.println("Enter 2 to edit a customer");
            System.out.println("Enter 3 to delete a customer");
        }
    }

    public static void employeeActions() {
        System.out.println("Enter 1 to add an employee");
        System.out.println("Enter 2 to edit an employee");
        System.out.println("Enter 3 to delete an employee");
    }

    public static void tourLeaderActions() {
        System.out.println("Enter 1 to add a tour leader");
        System.out.println("Enter 2 to edit a tour leader");
        System.out.println("Enter 3 to delete a tour leader");
    }

    public static void adminActions() {
        System.out.println("Enter 1 to add an admin");
        System.out.println("Enter 2 to edit an admin");
        System.out.println("Enter 3 to delete an admin");
    }

    public static void peopleActions(Person person, int personChoice) {
        Scanner input = new Scanner(System.in);
        switch (personChoice) {
            case 2:
                customerActions(person);
                break;
            case 3:
                employeeActions();
                break;
            case 4:
                tourLeaderActions();
                break;
            case 5:
                adminActions();
                break;
        }
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                addPerson(person, personChoice);
                break;
            case 2:
                editPerson(person);
                break;
            case 3:
                deletePerson(person);
                break;
        }
    }

    public static void addPerson(Person person, int personChoice) {
        Scanner input = new Scanner(System.in);
        if (personChoice == 2 || person.getAccessLevel() == 4) {
            Person prs;
            String username, password, email, phoneNumber;
            System.out.println("Enter username");
            username = input.nextLine();
            System.out.println("Enter password");
            password = input.nextLine();
            System.out.println("Enter email");
            email = input.nextLine();
            System.out.println("Enter phone number");
            phoneNumber = input.nextLine();
            if (personChoice == 3) {
                int baseSalary, registerDay, registerMonth, registerYear;
                Date registerDate;
                System.out.println("Enter base salary");
                baseSalary = input.nextInt();
                System.out.println("Enter register day");
                registerDay = input.nextInt();
                System.out.println("Enter register day");
                registerMonth = input.nextInt();
                System.out.println("Enter register day");
                registerYear = input.nextInt();
                registerDate = new Date(registerYear, registerMonth, registerDay);
                Employee employee = new Employee(username, password, email, phoneNumber, baseSalary, registerDate);
                Main.people.add(employee);
            } else {
                prs = new Person(username, password, email, phoneNumber, personChoice - 1);
                Main.people.add(prs);
            }
        } else {
            System.out.println("You don't have permission to add this type of user");
        }
        backToMenu(person);
    }

    public static void editPerson(Person person) {
        Scanner input = new Scanner(System.in);
        boolean allowed = false, found = false;
        System.out.println("Enter username");
        String username = input.nextLine();
        for (int i = 0; i < Main.people.size(); i++) {
            if (Main.people.get(i).userName.equals(username)) {
                found = true;
                if (person.getAccessLevel() == 4) {
                    allowed = true;
                    editPersonBase(Main.people.get(i));
                    editEmployeeBase(Main.people.get(i));
                    break;
                } else if (person.getAccessLevel() == 2 && Main.people.get(i).getAccessLevel() == 1) {
                    allowed = true;
                    editPersonBase(Main.people.get(i));
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Username wasn't found");
        } else {
            if (!allowed) {
                System.out.println("You don't have permission to edit this user");
            } else {
                System.out.println("User edited successfully");
            }
        }
        backToMenu(person);
    }

    public static void deletePerson(Person person) {
        Scanner input = new Scanner(System.in);
        boolean allowed = false, found = false;
        System.out.println("Enter username");
        String username = input.nextLine();
        for (int i = 0; i < Main.people.size(); i++) {
            if (Main.people.get(i).userName.equals(username)) {
                found = true;
                if (person.getAccessLevel() == 4) {
                    allowed = true;
                    Main.people.remove(i);
                    break;
                } else if (person.getAccessLevel() == 2 && Main.people.get(i).getAccessLevel() == 1) {
                    allowed = true;
                    Main.people.remove(i);
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Username wasn't found");
        } else {
            if (!allowed) {
                System.out.println("You don't have permission to delete this user");
            } else {
                System.out.println("User deleted successfully");
            }
        }
        backToMenu(person);
    }

    public static void backToMenu(Person person) {
        int answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to go to people menu");
        System.out.println("Enter 2 to go to main menu");
        answer = input.nextInt();
        if (answer == 1) {
            Menu.peopleMenu(person);
        } else if (answer == 2) {
            Menu.mainMenu(person);
        }
    }
}
