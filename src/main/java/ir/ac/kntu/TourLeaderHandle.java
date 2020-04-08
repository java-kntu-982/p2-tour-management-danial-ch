package ir.ac.kntu;

import org.checkerframework.checker.units.qual.C;

import java.util.LinkedList;
import java.util.Scanner;

public class TourLeaderHandle {

    public static void seeAllLeaders(){
        //ClearScreen.cls();
        for(int i=0;i<Main.tourLeaders.size();i++){
            System.out.println((i+1)+")"+Main.tourLeaders.get(i).toString());
        }
        backToMenu();
    }

    public static void addLeader(){
        //ClearScreen.cls();
        String fName,lName,nationalCode,idNumber,temp;
        int birthYear,birthMonth,birthDay,registerYear,registerMonth,registerDay;
        boolean married=false;
        Date birthDate,registerDate;
        LinkedList<Location> knownLocations=new LinkedList<>();
        LinkedList<Country> knownCountries=new LinkedList<>();
        Scanner input=new Scanner(System.in);
        TourLeader tourLeader=new TourLeader();
        System.out.println("Enter first name");
        fName=input.nextLine();
        System.out.println("Enter last name");
        lName=input.nextLine();
        System.out.println("Enter national code name");
        nationalCode=input.nextLine();
        System.out.println("Enter ID number name");
        idNumber=input.nextLine();
        System.out.println("Is he/she married?(y/n)");
        temp=input.nextLine();
        if(temp.equals("y")){
            married=true;
        }
        else if(temp.equals("n")){
            married=false;
        }
        System.out.println("Enter birth year");
        birthYear=input.nextInt();
        System.out.println("Enter birth month");
        birthMonth=input.nextInt();
        System.out.println("Enter birth day");
        birthDay=input.nextInt();
        birthDate=new Date(birthYear,birthMonth,birthDay);
        System.out.println("Enter register year");
        registerYear=input.nextInt();
        System.out.println("Enter register month");
        registerMonth=input.nextInt();
        System.out.println("Enter register day");
        registerDay=input.nextInt();
        registerDate=new Date(registerYear,registerMonth,registerDay);
        System.out.println("Enter a city's number to add it to tour leader's known locations");
        while(true){
            int tempLocation,i;
            for(i=0;i<Main.locations.size();i++){
                System.out.println((i+1)+") "+Main.locations.get(i).getCityName());
            }
            System.out.println((i+2)+")Enter "+(i+2)+" to finish");
            tempLocation=input.nextInt();
            if(tempLocation==i+2){
                break;
            }
            for(int j=0;j<Main.locations.size();j++){
                if(i-1==j){
                    knownLocations.add(Main.locations.get(j));
                }
            }
        }
        System.out.println("Enter a country's number to add it to tour leader's known countries");
        while(true){
            int tempLocation,i;
            for(i=0;i<Main.countries.size();i++){
                System.out.println((i+1)+")"+Main.countries.get(i).getName());
            }
            System.out.println((i+2)+")Enter "+(i+2)+" to finish");
            tempLocation=input.nextInt();
            if(tempLocation==i+2){
                break;
            }
            for(int j=0;j<Main.countries.size();j++){
                if(i-1==j){
                    knownCountries.add(Main.countries.get(j));
                }
            }
        }
        tourLeader.setAge(2020-birthYear);
        tourLeader.setFName(fName);
        tourLeader.setLName(lName);
        tourLeader.setIdNumber(idNumber);
        tourLeader.setNationalCode(nationalCode);
        tourLeader.setMarried(married);
        tourLeader.setCurrentTour(null);
        tourLeader.setBirthDate(birthDate);
        tourLeader.setRegisterDate(registerDate);
        tourLeader.setKnownLocations(knownLocations);
        tourLeader.setKnownCountries(knownCountries);
        Main.tourLeaders.add(tourLeader);
        System.out.println("Tour leader added successfully");
        backToMenu();
    }

    public static void deleteLeader(){
        Scanner input=new Scanner(System.in);
        boolean flag=false;
        //ClearScreen.cls();
        System.out.println("Enter tour leader's ID number to delete him/her from system");
        String idNumber=input.nextLine();
        for(int i=0;i<Main.tourLeaders.size();i++){
            if(Main.tourLeaders.get(i).getIdNumber().equals(idNumber)){
                Main.tourLeaders.remove(i);
                System.out.println("Tour leader deleted successfully");
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Tour leader wasn't found");
        }
        backToMenu();
    }

    public static void editLeader(){
        //ClearScreen.cls();
        String fName,lName,nationalCode,idNumber,temp;
        int birthYear,birthMonth,birthDay,registerYear,registerMonth,registerDay;
        boolean married=false,flag=false;
        Date birthDate,registerDate;
        LinkedList<Location> knownLocations=new LinkedList<>();
        LinkedList<Country> knownCountries=new LinkedList<>();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter tour leader's ID number to edit him/her");
        String idNumberTemp=input.nextLine();
        for(int k=0;k<Main.tourLeaders.size();k++){
            if(Main.tourLeaders.get(k).getIdNumber().equals(idNumberTemp)){
                TourLeader tourLeader=Main.tourLeaders.get(k);
                System.out.println("Enter new first name");
                fName=input.nextLine();
                System.out.println("Enter new last name");
                lName=input.nextLine();
                System.out.println("Enter new national code name");
                nationalCode=input.nextLine();
                System.out.println("Enter new ID number name");
                idNumber=input.nextLine();
                System.out.println("Is he/she married?(y/n)");
                temp=input.nextLine();
                if(temp.equals("y")){
                    married=true;
                }
                else if(temp.equals("n")){
                    married=false;
                }
                System.out.println("Enter new birth year");
                birthYear=input.nextInt();
                System.out.println("Enter new birth month");
                birthMonth=input.nextInt();
                System.out.println("Enter new birth day");
                birthDay=input.nextInt();
                birthDate=new Date(birthYear,birthMonth,birthDay);
                System.out.println("Enter new register year");
                registerYear=input.nextInt();
                System.out.println("Enter new register month");
                registerMonth=input.nextInt();
                System.out.println("Enter new register day");
                registerDay=input.nextInt();
                registerDate=new Date(registerYear,registerMonth,registerDay);
                System.out.println("Tour leader's known locations hast been deleted\nEnter a city's number to add it to tour leader's known locations");
                while(true){
                    int tempLocation,i;
                    for(i=0;i<Main.locations.size();i++){
                        System.out.println((i+1)+") "+Main.locations.get(i).getCityName());
                    }
                    System.out.println((i+2)+")Enter "+(i+2)+" to finish");
                    tempLocation=input.nextInt();
                    if(tempLocation==i+2){
                        break;
                    }
                    for(int j=0;j<Main.locations.size();j++){
                        if(i-1==j){
                            knownLocations.add(Main.locations.get(j));
                        }
                    }
                }
                System.out.println("Enter a country's number to add it to tour leader's known countries");
                while(true){
                    int tempLocation,i;
                    for(i=0;i<Main.countries.size();i++){
                        System.out.println((i+1)+")"+Main.countries.get(i).getName());
                    }
                    System.out.println((i+2)+")Enter "+(i+2)+" to finish");
                    tempLocation=input.nextInt();
                    if(tempLocation==i+2){
                        break;
                    }
                    for(int j=0;j<Main.countries.size();j++){
                        if(i-1==j){
                            knownCountries.add(Main.countries.get(j));
                        }
                    }
                }
                tourLeader.setAge(2020-birthYear);
                tourLeader.setFName(fName);
                tourLeader.setLName(lName);
                tourLeader.setIdNumber(idNumber);
                tourLeader.setNationalCode(nationalCode);
                tourLeader.setMarried(married);
                tourLeader.setCurrentTour(null);
                tourLeader.setBirthDate(birthDate);
                tourLeader.setRegisterDate(registerDate);
                tourLeader.setKnownLocations(knownLocations);
                System.out.println("Tour leader edited successfully");
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Tour leader wasn't found");
        }
        backToMenu();
    }

    public static void searchInTourLeaders(){
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 Search By first name");
        System.out.println("Enter 2 Search By last name");
        System.out.println("Enter 3 Search By known locations");
        System.out.println("Enter 4 Search By age");
        int answer=input.nextInt();
        switch (answer){
            case 1:
                searchByFName();break;
            case 2:
                searchByLName();break;
            case 3:
                searchByKnownLocations();break;
            case 4:
                searchByAge();break;
        }
        backToMenu();
    }

    public static void searchByFName(){
        //ClearScreen.cls();
        String fName;
        boolean flag=false;
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter first name");
        fName=input.nextLine();
        for(int i=0;i<Main.tourLeaders.size();i++){
            if(Main.tourLeaders.get(i).getFName().equals(fName)){
                System.out.println(Main.tourLeaders.get(i).toString());
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Tour leader wasn't found");
        }
        backToMenu();
    }

    public static void searchByLName(){
        //ClearScreen.cls();
        String lName;
        boolean flag=false;
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter last name");
        lName=input.nextLine();
        for(int i=0;i<Main.tourLeaders.size();i++){
            if(Main.tourLeaders.get(i).getLName().equals(lName)){
                System.out.println(Main.tourLeaders.get(i).toString());
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Tour leader wasn't found");
        }
        backToMenu();
    }

    public static void searchByKnownLocations(){
        //ClearScreen.cls();
        Location location=new Location();
        Country country=new Country();
        boolean flag=false;
        int i,answer,j,choice;
        //ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to Search in countries");
        System.out.println("Enter 2 to Search in cities");
        choice=input.nextInt();
        System.out.println("Choose one of the locations below");
        if(choice==1){
            for(i=0;i<Main.countries.size();i++){
                System.out.println((i+1)+")"+Main.countries.get(i).getName());
            }
            answer=input.nextInt();
            for(i=0;i<Main.countries.size();i++){
                if(i==answer){
                    country=Main.countries.get(i);
                    break;
                }
            }
            for(i=0;i<Main.tourLeaders.size();i++){
                for(j=0;j<Main.tourLeaders.get(i).getKnownCountries().size();j++){
                    if(Main.tourLeaders.get(i).getKnownCountries().get(j).equals(country)){
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag=true;
                        break;
                    }
                }
            }
        }
        else if(choice==2){
            for(i=0;i<Main.locations.size();i++){
                System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
            }
            answer=input.nextInt();
            for(i=0;i<Main.locations.size();i++){
                if(i==answer){
                    location=Main.locations.get(i);
                    break;
                }
            }
            for(i=0;i<Main.tourLeaders.size();i++){
                for(j=0;j<Main.tourLeaders.get(i).getKnownLocations().size();j++){
                    if(Main.tourLeaders.get(i).getKnownLocations().get(j).equals(location)){
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag=true;
                        break;
                    }
                }
            }
        }
        if(!flag){
            System.out.println("Tour leader wasn't found");
        }
        backToMenu();
    }

    public static void searchByAge(){
        //ClearScreen.cls();
        int answer,smallerThanNumber,biggerThanNumber;
        boolean flag=false;
        Scanner input=new Scanner(System.in);
        System.out.println("1)A certain number");
        System.out.println("2)Bigger than a number");
        System.out.println("3)Smaller than a number");
        System.out.println("4)Between two numbers");
        answer=input.nextInt();
        switch (answer){
            case 1:
                int exactNumber;
                System.out.println("Enter number");
                exactNumber=input.nextInt();
                for(int i=0;i<Main.tourLeaders.size();i++){
                    if(Main.tourLeaders.get(i).getAge()==exactNumber){
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag=true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Enter a number smaller than the age");
                biggerThanNumber=input.nextInt();
                for(int i=0;i<Main.tourLeaders.size();i++){
                    if(Main.tourLeaders.get(i).getAge()>biggerThanNumber){
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag=true;
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Enter a number bigger than the age");
                smallerThanNumber=input.nextInt();
                for(int i=0;i<Main.tourLeaders.size();i++){
                    if(Main.tourLeaders.get(i).getAge()<smallerThanNumber){
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag=true;
                        break;
                    }
                }
                break;
            case 4:
                System.out.println("Enter a number bigger than the age");
                smallerThanNumber=input.nextInt();
                System.out.println("Enter a number smaller than the age");
                biggerThanNumber=input.nextInt();
                for(int i=0;i<Main.tourLeaders.size();i++){
                    if(Main.tourLeaders.get(i).getAge()<smallerThanNumber && Main.tourLeaders.get(i).getAge()>biggerThanNumber){
                        System.out.println(Main.tourLeaders.get(i).toString());
                        flag=true;
                        break;
                    }
                }
                break;
        }
        if(!flag){
            System.out.println("Tour leader wasn't found");
        }
        backToMenu();
    }

    public static void backToMenu(){
        int answer;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to go to tour leader menu");
        System.out.println("Enter 2 to go to main menu");
        answer=input.nextInt();
        if(answer==1){
            Menu.tourLeaderMenu();
        }
        else if (answer==2){
            Menu.mainMenu();
        }
    }
}
