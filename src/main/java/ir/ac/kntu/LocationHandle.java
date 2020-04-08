package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Scanner;

public class LocationHandle {

    public static void seeAllLocations(){
        ////ClearScreen.cls();
        int temp;
        for(int i=0;i<Main.locations.size();i++){
            System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
        }
        temp=Main.locations.size();
        for(int i=0;i<Main.countries.size();i++){
            System.out.println((temp+i+1)+")"+Main.countries.get(i).getName());
        }
        backToMenu();
    }

    public static void addCountry(){
        ////ClearScreen.cls();
        String name;
        LinkedList<Location> locations=new LinkedList<>();
        Scanner input=new Scanner(System.in);
        Country country=new Country();
        System.out.println("Enter country's name");
        name=input.nextLine();
        System.out.println("choose country's locations");
        while(true){
            int tempLocation,i;
            ////ClearScreen.cls();
            for(i=0;i<Main.locations.size();i++){
                if(Main.locations.get(i).isShow()){
                    System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
                }
            }
            System.out.println((i+2)+")Enter "+(i+2)+" to finish");
            tempLocation=input.nextInt();
            if(tempLocation==i+2){
                break;
            }
            for(int j=0;j<Main.locations.size();j++){
                if(i==j){
                    locations.add(Main.locations.get(j));
                    Main.locations.get(j).setCountry(country);
                    Main.locations.get(j).setShow(false);
                }
            }
        }
        for(int i=0;i<Main.locations.size();i++){
            Main.locations.get(i).setShow(true);
        }
        country.setName(name);
        country.setLocations(locations);
        Main.countries.add(country);
        System.out.println("Country added successfully");
        backToMenu();
    }

    public static void addCity(){
        ////ClearScreen.cls();
        String name;
        Scanner input=new Scanner(System.in);
        Location location=new Location();
        System.out.println("Enter city's name");
        name=input.nextLine();
        location.setCityName(name);
        Main.locations.add(location);
        backToMenu();
    }

    public static void deleteCountry(){
        ////ClearScreen.cls();
        String name;
        boolean flag=false;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter country's name");
        name=input.nextLine();
        for(int i=0;i<Main.countries.size();i++){
            if(Main.countries.get(i).getName().equals(name)){
                Main.countries.remove(i);
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("Country deleted successfully");
        }
        else{
            System.out.println("Country wasn't found");
        }
        backToMenu();
    }

    public static void deleteCity(){
        ////ClearScreen.cls();
        String name;
        boolean flag=false;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter city's name");
        name=input.nextLine();
        for(int i=0;i<Main.locations.size();i++){
            if(Main.locations.get(i).getCityName().equals(name)){
                Main.locations.remove(i);
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("City deleted successfully");
        }
        else{
            System.out.println("City wasn't found");
        }
        backToMenu();
    }

    public static void editCountry(){
        Scanner input=new Scanner(System.in);
        int position;
        String name;
        boolean flag=false;
        LinkedList<Location> locations=new LinkedList<>();
        Country country=new Country();
        System.out.println("Enter country's name to edit it");
        name=input.nextLine();
        for(int i=0;i<Main.countries.size();i++){
            if(Main.countries.get(i).getName().equals(name)){
                position=i;
                flag=true;
                System.out.println("Enter country's name");
                name=input.nextLine();
                System.out.println("choose country's locations");
                while(true){
                    int tempLocation;
                    for(i=0;i<Main.locations.size();i++){
                            System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
                    }
                    System.out.println((i+2)+")Enter "+(i+2)+" to finish");
                    tempLocation=input.nextInt();
                    if(tempLocation==i+2){
                        break;
                    }
                    for(int j=0;j<Main.locations.size();j++){
                        if(i==j){
                            locations.add(Main.locations.get(j));
                            Main.locations.get(j).setCountry(country);
                        }
                    }
                }
                country.setName(name);
                country.setLocations(locations);
                Main.countries.remove(position);
                Main.countries.add(position,country);
                System.out.println("Country edited successfully");
            }
        }
        if(!flag){
            System.out.println("Country wasn't found");
        }
        backToMenu();
    }

    public static void backToMenu(){
        int answer;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to go to locations menu");
        System.out.println("Enter 2 to go to main menu");
        answer=input.nextInt();
        if(answer==1){
            Menu.locationsMenu();
        }
        else if (answer==2){
            Menu.mainMenu();
        }
    }
}
