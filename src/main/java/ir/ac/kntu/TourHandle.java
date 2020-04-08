package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Scanner;

public class TourHandle {

    public static int compareDate(Date date1,Date date2){
        if(date1.getYear()>date2.getYear()){
            return 1;
        }
        else if(date2.getYear()>date1.getYear()){
            return -1;
        }
        else{
            if(date1.getMonth()>date2.getMonth()){
                return 1;
            }
            else if(date2.getMonth()>date1.getMonth()){
                return -1;
            }
            else{
                if(date1.getDay()>date2.getDay()){
                    return 1;
                }
                else if(date2.getDay()>date2.getDay()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    }

    public static void seeAllTourTypes(){
        ////ClearScreen.cls();
        Country iran=Main.countries.getFirst();
        for(int i=0;i<Main.tours.size();i++){
            System.out.println(Main.tours.get(i).getName());
        }
        backToMenu();
    }

    public static void seeAllTours(){
        ////ClearScreen.cls();
        for(int i=0;i<Main.foreignTours.size();i++){
            System.out.println(Main.foreignTours.get(i).customToString());
        }
        for(int i=0;i<Main.localTours.size();i++){
            System.out.println(Main.localTours.get(i).customToString());
        }
        backToMenu();
    }

    public static TourLeader chooseTourLeader(Tour tour,Date startingDate,Date finishingDate){
        TourLeader notFound=new TourLeader();
        Country iran=Main.countries.getFirst();
        TourLeader tourLeader=new TourLeader();
        int tourLeaderChoice,startingChoice;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to choose tour's tour leader from available tour leaders");
        System.out.println("Enter 2 to enter tour leader's name");
        startingChoice=input.nextInt();
        if(startingChoice==1){
            int i;
            System.out.println("Choose on of the tour leaders");
            for(i=0;i<Main.tourLeaders.size();i++){
                if(Main.tourLeaders.get(i).getCurrentTour()==null){
                    System.out.println((i+1)+")"+Main.tourLeaders.get(i).getLName());
                }
                else if(Main.tourLeaders.get(i).getCurrentTour().getCountry().equals(iran)){
                    if(1==compareDate(Main.tourLeaders.get(i).getForeignTour().getStartingDate(),finishingDate)
                            || 1==compareDate(startingDate,Main.tourLeaders.get(i).getForeignTour().getFinishingDate())){
                        System.out.println((i+1)+")"+Main.tourLeaders.get(i).getLName());
                    }
                }
                else{
                    if(1==compareDate(Main.tourLeaders.get(i).getLocalTour().getStartingDate(),finishingDate)
                            || 1==compareDate(startingDate,Main.tourLeaders.get(i).getLocalTour().getFinishingDate())){
                        System.out.println((i+1)+")"+Main.tourLeaders.get(i).getLName());
                    }
                }
            }
            while(true){
                tourLeaderChoice=input.nextInt()-1;
                if(tourLeaderChoice>i){
                    System.out.println("Number isn't valid");
                    continue;
                }
                break;
            }
            for(i=0;i<Main.tourLeaders.size();i++){
                if(Main.tourLeaders.get(i).getCurrentTour()==null){
                    if(tourLeaderChoice==i){
                        return Main.tourLeaders.get(i);
                    }
                }
                else if(Main.tourLeaders.get(i).getCurrentTour().getCountry().equals(iran)){
                    if(1==compareDate(Main.tourLeaders.get(i).getForeignTour().getStartingDate(),finishingDate)
                            || 1==compareDate(startingDate,Main.tourLeaders.get(i).getForeignTour().getFinishingDate())){
                        if(tourLeaderChoice==i){
                            return Main.tourLeaders.get(i);
                        }
                    }
                }
                else{
                    if(1==compareDate(Main.tourLeaders.get(i).getLocalTour().getStartingDate(),finishingDate)
                            || 1==compareDate(startingDate,Main.tourLeaders.get(i).getLocalTour().getFinishingDate())){
                        if(tourLeaderChoice==i){
                            return Main.tourLeaders.get(i);
                        }
                    }
                }
            }
        }
        else if(startingChoice==2){
            boolean flagFound=false,flagAvailable=false;
            String name;
            System.out.println("Enter tour leader's last name");
            name=input.nextLine();
            for(int i=0;i<Main.tourLeaders.size();i++){
                if(Main.tourLeaders.get(i).getLName().equals(name)){
                    flagFound=true;
                    if(Main.tourLeaders.get(i).getCurrentTour()==null
                            ||1==compareDate(Main.tourLeaders.get(i).getLocalTour().getStartingDate(),finishingDate)
                            ||1==compareDate(startingDate,Main.tourLeaders.get(i).getLocalTour().getFinishingDate()) ){
                        tourLeader=Main.tourLeaders.get(i);
                        flagAvailable=true;
                        break;
                    }
                }
            }
            if(!flagFound){
                System.out.println("Tour leader wasn't found");
                return notFound;
            }
            else{
                if(flagAvailable){
                    System.out.println("Tour leader has been selected");
                    return tourLeader;
                }
                else{
                    System.out.println("Tour leader is not available at this time pls change the tour time");
                    return null;
                }
            }
        }
        return notFound;
    }

    public static Tour addTourType(){
        Country iran=Main.countries.getFirst();
        ////ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        Country country=new Country();
        int travelTypeChoice,time,price,minAttendants,maxAttendants,countryChoice,i;
        String name;
        Tour tour=new Tour();
        LinkedList<Location> locations=new LinkedList<>();
        System.out.println("Enter tour's name");
        name=input.nextLine();
        tour.setName(name);
        System.out.println("Choose tour's visiting country");
        for(i=0;i<Main.countries.size();i++){
            System.out.println((i+1)+")"+Main.countries.get(i).getName());
        }
        while(true){
            countryChoice=input.nextInt()-1;
            if(countryChoice>i){
                System.out.println("Number isn't valid");
                continue;
            }
            break;
        }
        for(i=0;i<Main.countries.size();i++){
            if(countryChoice==i){
                country=Main.countries.get(i);
                tour.setCountry(country);
            }
        }
        if(country.equals(iran)){
            Location city=new Location();
            int cityChoice;
            System.out.println("Choose visiting city");
            for(i=0;i<Main.locations.size();i++){
                System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
            }
            while(true){
                cityChoice=input.nextInt()-1;
                if(cityChoice>i){
                    System.out.println("Number isn't valid");
                    continue;
                }
                break;
            }
            for(i=0;i<Main.locations.size();i++){
                    if(cityChoice==i){
                        city=Main.locations.get(i);
                }
            }
            locations.add(city);
            tour.setLocations(locations);
        }
        else{
            while(true){
                int cityChoice;
                System.out.println("Choose visiting cities in order of visit");
                for(i=0;i<Main.locations.size();i++){
                    if(Main.locations.get(i).getCountry() == null || !Main.locations.get(i).getCountry().equals(iran)){
                        System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
                    }
                }
                System.out.println((i+2)+")Enter "+(i+2)+" to finish");
                cityChoice=input.nextInt();
                if(cityChoice==i+2){
                    break;
                }
                for(int j=0;j<Main.locations.size();j++){
                    if(cityChoice==j){
                        locations.add(Main.locations.get(j));
                    }
                }
            }
            tour.setLocations(locations);
        }
        System.out.println("Enter tour's number of days");
        time=input.nextInt();
        tour.setTime(time);
        System.out.println("Enter tour's price");
        price=input.nextInt();
        tour.setPrice(price);
        System.out.println("Enter tour's minimum attendants");
        minAttendants=input.nextInt();
        tour.setMinAttendants(minAttendants);
        System.out.println("Enter tour's maximum attendants");
        maxAttendants=input.nextInt();
        tour.setMaxAttendants(maxAttendants);
        System.out.println("if tour is an air trip enter 1 and if it's an ground trip enter 2");
        travelTypeChoice=input.nextInt();
        if(travelTypeChoice==1){
            tour.setTravelMethod(TravelMethod.airTrip);
        }
        else if(travelTypeChoice==2){
            tour.setTravelMethod(TravelMethod.roadTrip);
        }
        return tour;
    }

    public static void addTourTypeMain(){
        Tour tour=addTourType();
        Main.tours.add(tour);
        System.out.println("Tour type added successfully");
        backToMenu();
    }

    public static void editTourType(){
        Country iran=Main.countries.getFirst();
        ////ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        Country country=new Country();
        int travelTypeChoice,time,price,minAttendants,maxAttendants,countryChoice,i;
        boolean flag=true,find=false;
        String name;
        Tour tour=new Tour();
        LinkedList<Location> locations=new LinkedList<>();
        System.out.println("Enter tour's name to edit it");
        name=input.nextLine();
        for(i=0;i<Main.tours.size();i++){
            if(Main.tours.get(i).getName().equals(name)){
                tour=Main.tours.get(i);
                find=true;
                break;
            }
        }
        if(find){
            System.out.println("Choose tour's visiting country");
            for(i=0;i<Main.countries.size();i++){
                System.out.println((i+1)+Main.countries.get(i).getName());
            }
            while(true){
                countryChoice=input.nextInt()-1;
                if(countryChoice>i){
                    System.out.println("Number isn't valid");
                    continue;
                }
                break;
            }
            for(i=0;i<Main.countries.size();i++){
                if(countryChoice==i){
                    country=Main.countries.get(i);
                    tour.setCountry(country);
                }
            }
            if(country.equals(iran)){
                Location city=new Location();
                int cityChoice;
                System.out.println("Choose visiting city");
                for(i=0;i<Main.locations.size();i++){
                        System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
                }
                while(true){
                    cityChoice=input.nextInt()-1;
                    if(cityChoice>i){
                        System.out.println("Number isn't valid");
                        continue;
                    }
                    break;
                }
                for(i=0;i<Main.locations.size();i++){
                    if(cityChoice==i){
                        city=Main.locations.get(i);
                    }
                }
                locations.add(city);
                tour.setLocations(locations);
            }
            else{
                while(true){
                    int cityChoice;
                    System.out.println("Choose visiting cities in order of visit");
                    for(i=0;i<Main.locations.size();i++){
                        System.out.println((i+1)+")"+Main.locations.get(i).getCityName());
                    }
                    System.out.println((i+2)+"Enter"+(i+2)+"to finish");
                    cityChoice=input.nextInt()-1;
                    if(cityChoice==i+2){
                        break;
                    }
                    for(int j=0;j<Main.locations.size();j++){
                        if(cityChoice==j){
                            locations.add(Main.locations.get(j));
                        }
                    }
                }
                tour.setLocations(locations);
            }
            System.out.println("Enter tour's number of days");
            time=input.nextInt();
            tour.setTime(time);
            System.out.println("Enter tour's price");
            price=input.nextInt();
            tour.setPrice(price);
            System.out.println("Enter tour's minimum attendants");
            minAttendants=input.nextInt();
            tour.setMinAttendants(minAttendants);
            System.out.println("Enter tour's maximum attendants");
            maxAttendants=input.nextInt();
            tour.setMaxAttendants(maxAttendants);
            System.out.println("if tour is an air trip enter 1 and if it's an ground trip enter 2");
            travelTypeChoice=input.nextInt();
            if(travelTypeChoice==1){
                tour.setTravelMethod(TravelMethod.airTrip);
            }
            else if(travelTypeChoice==2){
                tour.setTravelMethod(TravelMethod.roadTrip);
            }
            for(i=0;i<Main.tours.size();i++){
                if(Main.tours.get(i).equals(tour)){
                    System.out.println("Tour already exists");
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("Tour type edited successfully");
            }
        }
        else{
            System.out.println("Tour wasn't found");
        }

    }

    public static void addTourMain(){
        TourLeader notFound=new TourLeader();
        int startingDay,startingMonth,startingYear,finishingDay,finishingMonth,finishingYear;
        Date startingDate,finishingDate;
        Country iran=Main.countries.getFirst();
        ForeignTour foreignTour=new ForeignTour();
        LocalTour localTour=new LocalTour();
        Tour tour=new Tour();
        TourLeader tourLeader;
        ////ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        int mainChoice,i,tourType;
        System.out.println("Choose one of the tour types");
        for(i=0;i<Main.tours.size();i++){
            System.out.println((i+1)+")"+Main.tours.get(i).toString());
        }
        while(true) {
            mainChoice = input.nextInt() - 1;
            if (mainChoice > i) {
                System.out.println("Number isn't valid");
                continue;
            }
            break;
        }
        for(i=0;i<Main.tours.size();i++){
            if(mainChoice==i){
                tour=Main.tours.get(i);
                break;
            }
        }
        if(Main.tours.get(i).getCountry().equals(iran)){
            localTour.setCountry(iran);
            localTour.setMinAttendants(tour.getMinAttendants());
            localTour.setMaxAttendants(tour.getMaxAttendants());
            localTour.setLocations(tour.getLocations());
            localTour.setPrice(tour.getPrice());
            localTour.setTime(tour.getTime());
            localTour.setTravelMethod(tour.getTravelMethod());
            tourType=1;
        }
        else{
            foreignTour.setCountry(tour.getCountry());
            foreignTour.setMinAttendants(tour.getMinAttendants());
            foreignTour.setMaxAttendants(tour.getMaxAttendants());
            foreignTour.setLocations(tour.getLocations());
            foreignTour.setPrice(tour.getPrice());
            foreignTour.setTime(tour.getTime());
            foreignTour.setTravelMethod(tour.getTravelMethod());
            tourType=2;
        }
        while(true){
            System.out.println("Enter tour's starting day");
            startingDay=input.nextInt();
            System.out.println("Enter tour's starting month");
            startingMonth=input.nextInt();
            System.out.println("Enter tour's starting year");
            startingYear=input.nextInt();
            startingDate=new Date(startingYear,startingMonth,startingDay);
            System.out.println("Enter tour's finishing day");
            finishingDay=input.nextInt();
            System.out.println("Enter tour's finishing month");
            finishingMonth=input.nextInt();
            System.out.println("Enter tour's finishing year");
            finishingYear=input.nextInt();
            finishingDate=new Date(finishingYear,finishingMonth,finishingDay);
            tourLeader=chooseTourLeader(tour,startingDate,finishingDate);
            while (tourLeader.equals(notFound)){
                tourLeader=chooseTourLeader(tour,startingDate,finishingDate);
            }
            if(tourLeader==null){
                System.out.println("Change the time to see the tour leader you want");
                continue;
            }
            break;
        }
        LinkedList<Attraction> attractions=new LinkedList<>();
        if(tourType==2){
            System.out.println();
            foreignTour.setStartingCity(tour.getLocations().getFirst());
            foreignTour.setDestination(tour.getLocations().getLast());
            foreignTour.setStartingDate(startingDate);
            foreignTour.setFinishingDate(finishingDate);
            String fullName=foreignTour.getCountry().getName()+" "+(Main.foreignTours.size()+1);
            foreignTour.setFullName(fullName);
            for(i=0;i<foreignTour.getTime();i++){
                ////ClearScreen.cls();
                int attractionChoice,j;
                System.out.println("Choose day "+(i+1)+" attraction");
                for(j=0;j<foreignTour.getLocations().get(i).getAttractions().size();j++){
                    System.out.println((j+1)+")"+foreignTour.getLocations().get(i).getAttractions().get(j).getName());
                }
                while(true) {
                    attractionChoice = input.nextInt() - 1;
                    if (attractionChoice > j) {
                        System.out.println("Number isn't valid");
                        continue;
                    }
                    break;
                }
                for(j=0;j<foreignTour.getLocations().get(i).getAttractions().size();j++){
                    if(attractionChoice==j){
                        attractions.add(foreignTour.getLocations().get(i).getAttractions().get(j));
                    }
                }
            }
            Main.foreignTours.add(foreignTour);
        }
        //khate payin nokte dare
        else{
            localTour.setLocation(tour.getLocations().getFirst());
            localTour.setStartingDate(startingDate);
            localTour.setFinishingDate(finishingDate);
            String fullName=localTour.getLocation().getCityName()+" "+(Main.localTours.size()+1);
            localTour.setFullName(fullName);
            for(i=0;i<localTour.getTime();i++){
                ////ClearScreen.cls();
                int attractionChoice,j;
                System.out.println("Choose day "+(i+1)+" attraction");
                for(j=0;j<localTour.getLocation().getAttractions().size();j++){
                    System.out.println((j+1)+")"+localTour.getLocation().getAttractions().get(j).getName());
                }
                while(true) {
                    attractionChoice = input.nextInt() - 1;
                    if (attractionChoice > j) {
                        System.out.println("Number isn't valid");
                        continue;
                    }
                    break;
                }
                for(j=0;j<localTour.getLocation().getAttractions().size();j++){
                    if(attractionChoice==j){
                        attractions.add(localTour.getLocation().getAttractions().get(j));
                    }
                }
            }
            Main.localTours.add(localTour);
        }
        System.out.println("Tour Added Successfully");
        backToMenu();
    }

    public static void editTour(){
        TourLeader notFound=new TourLeader();
        int startingDay,startingMonth,startingYear,finishingDay,finishingMonth,finishingYear;
        boolean find=false;
        String fullName;
        Date startingDate,finishingDate;
        Country iran=Main.countries.getFirst();
        ForeignTour foreignTour=new ForeignTour();
        LocalTour localTour=new LocalTour();
        Tour tour=new Tour();
        TourLeader tourLeader;
        ////ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        int mainChoice,i,tourType;
        System.out.println("Enter 1 to choose a foreign tour or 2 to choose a local tour");
        tourType=input.nextInt();
        System.out.println("Enter tour's full name to edit it");
        fullName=input.nextLine();
        if(tourType==1){
            for(i=0;i<Main.foreignTours.size();i++){
                if(Main.foreignTours.get(i).getFullName().equals(fullName)){
                    foreignTour=Main.foreignTours.get(i);
                    find=true;
                    break;
                }
            }
        }
        else if(tourType==2){
            for(i=0;i<Main.localTours.size();i++){
                if(Main.localTours.get(i).getFullName().equals(fullName)){
                    localTour=Main.localTours.get(i);
                    find=true;
                    break;
                }
            }
        }
        if(find){
            while(true){
                System.out.println("Enter tour's starting day");
                startingDay=input.nextInt();
                System.out.println("Enter tour's starting month");
                startingMonth=input.nextInt();
                System.out.println("Enter tour's starting year");
                startingYear=input.nextInt();
                startingDate=new Date(startingYear,startingMonth,startingDay);
                System.out.println("Enter tour's finishing day");
                finishingDay=input.nextInt();
                System.out.println("Enter tour's finishing month");
                finishingMonth=input.nextInt();
                System.out.println("Enter tour's finishing year");
                finishingYear=input.nextInt();
                finishingDate=new Date(finishingYear,finishingMonth,finishingDay);
                tourLeader=chooseTourLeader(tour,startingDate,finishingDate);
                while (tourLeader.equals(notFound)){
                    tourLeader=chooseTourLeader(tour,startingDate,finishingDate);
                }
                if(tourLeader==null){
                    System.out.println("Change the time to see the tour leader you want");
                    continue;
                }
                break;
            }
            LinkedList<Attraction> attractions=new LinkedList<>();
            if(tourType==1){
                System.out.println();
                foreignTour.setStartingCity(tour.getLocations().getFirst());
                foreignTour.setDestination(tour.getLocations().getLast());
                foreignTour.setStartingDate(startingDate);
                foreignTour.setFinishingDate(finishingDate);
                for(i=0;i<foreignTour.getTime();i++){
                    ////ClearScreen.cls();
                    int attractionChoice,j;
                    System.out.println("Choose day "+(i+1)+" attraction");
                    for(j=0;j<foreignTour.getLocations().get(i).getAttractions().size();j++){
                        System.out.println((j+1)+")"+foreignTour.getLocations().get(i).getAttractions().get(j).getName());
                    }
                    while(true) {
                        attractionChoice = input.nextInt() - 1;
                        if (attractionChoice > j) {
                            System.out.println("Number isn't valid");
                            continue;
                        }
                        break;
                    }
                    for(j=0;j<foreignTour.getLocations().get(i).getAttractions().size();j++){
                        if(attractionChoice==j){
                            attractions.add(foreignTour.getLocations().get(i).getAttractions().get(j));
                        }
                    }
                }
            }
            else if(tourType==2){
                localTour.setLocation(tour.getLocations().getFirst());
                localTour.setStartingDate(startingDate);
                localTour.setFinishingDate(finishingDate);
                for(i=0;i<localTour.getTime();i++){
                    ////ClearScreen.cls();
                    int attractionChoice,j;
                    System.out.println("Choose day "+(i+1)+" attraction");
                    for(j=0;j<localTour.getLocation().getAttractions().size();j++){
                        System.out.println((j+1)+")"+localTour.getLocation().getAttractions().get(j).getName());
                    }
                    while(true) {
                        attractionChoice = input.nextInt() - 1;
                        if (attractionChoice > j) {
                            System.out.println("Number isn't valid");
                            continue;
                        }
                        break;
                    }
                    for(j=0;j<localTour.getLocation().getAttractions().size();j++){
                        if(attractionChoice==j){
                            attractions.add(localTour.getLocation().getAttractions().get(j));
                        }
                    }
                }
            }
            System.out.println("Tour edited Successfully");
        }
        else{
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void deleteTour(){
        ////ClearScreen.cls();
        Scanner input=new Scanner(System.in);
        String fullName;
        boolean flag=false;
        System.out.println("Enter tour's full name");
        fullName=input.nextLine();
        for(int i=0;i<Main.foreignTours.size();i++){
            if(Main.foreignTours.get(i).getFullName().equals(fullName)){
                Main.foreignTours.remove(i);
                flag=true;
                break;
            }
        }
        if(!flag){
            for(int i=0;i<Main.localTours.size();i++){
                if(Main.localTours.get(i).getFullName().equals(fullName)){
                    Main.localTours.remove(i);
                    flag=true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Tour has been deleted successfully");
        }
        else{
            System.out.println("Tour wasn't Found");
        }
        backToMenu();
    }

    public static void searchTourType(){
        int answer;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to search based on number of days");
        System.out.println("Enter 2 to search based on visiting cities");
        System.out.println("Enter 3 to search based on visiting country");
        System.out.println("Enter 4 to search based on minimum and maximum capacity");
        System.out.println("Enter 5 to search based on price");
        answer=input.nextInt();
        switch (answer){
            case 1:
                searchInNumberOfDays();break;
            case 2:
                searchInVisitingCities();break;
            case 3:
                searchInVisitingCountry();break;
            case 4:
                searchInMinAndMaxCapacity();break;
            case 5:
                searchInPrice();break;
        }
    }

    public static void searchInNumberOfDays(){
        Scanner input=new Scanner(System.in);
        int number;
        boolean flag=false;
        System.out.println("Enter tour's number of days");
        number=input.nextInt();
        for(int i=0;i<Main.tours.size();i++){
            if(Main.tours.get(i).getTime()==number){
                System.out.println(Main.tours.get(i).toString());
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInVisitingCities(){
        Scanner input=new Scanner(System.in);
        String cityName;
        boolean flag=false;
        System.out.println("Enter a city that you are looking for");
        cityName=input.nextLine();
        for(int i=0;i<Main.tours.size();i++){
            for(int j=0;j<Main.tours.get(i).getLocations().size();j++){
                if(Main.tours.get(i).getLocations().get(j).getCityName().equals(cityName)){
                    System.out.println(Main.tours.get(i).toString());
                    flag=true;
                }
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInVisitingCountry(){
        Scanner input=new Scanner(System.in);
        String country;
        boolean flag=false;
        System.out.println("Enter tour's visiting country");
        country=input.nextLine();
        for(int i=0;i<Main.tours.size();i++){
            if(Main.tours.get(i).getCountry().getName().equals(country)){
                System.out.println(Main.tours.get(i).toString());
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInMinAndMaxCapacity(){
        Scanner input=new Scanner(System.in);
        int minAttendants,maxAttendants;
        boolean flag=false;
        System.out.println("Enter tour's minimum attendants");
        minAttendants=input.nextInt();
        System.out.println("Enter tour's maximum attendants");
        maxAttendants=input.nextInt();
        for(int i=0;i<Main.tours.size();i++){
            if(Main.tours.get(i).getMinAttendants()>=minAttendants && Main.tours.get(i).getMaxAttendants()<=maxAttendants){
                System.out.println(Main.tours.get(i).toString());
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInPrice(){
        Scanner input=new Scanner(System.in);
        boolean flag=false;
        int price,choice,secondPrice;
        System.out.println("Enter 1 to search by a specific price");
        System.out.println("Enter 2 to search prices that are bigger than a number");
        System.out.println("Enter 3 to search prices that are smaller than a number");
        System.out.println("Enter 4 to search prices which are between two numbers");
        choice=input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter a price");
                price=input.nextInt();
                for (int i=0;i<Main.tours.size();i++){
                    if(Main.tours.get(i).getPrice()==price){
                        System.out.println(Main.tours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 2:
                System.out.println("Enter minimum price");
                price=input.nextInt();
                for (int i=0;i<Main.tours.size();i++){
                    if(Main.tours.get(i).getPrice()>=price){
                        System.out.println(Main.tours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 3:
                System.out.println("Enter maximum price");
                price=input.nextInt();
                for (int i=0;i<Main.tours.size();i++){
                    if(Main.tours.get(i).getPrice()<=price){
                        System.out.println(Main.tours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 4:
                System.out.println("Enter minimum price");
                price=input.nextInt();
                System.out.println("Enter maximum price");
                secondPrice=input.nextInt();
                for (int i=0;i<Main.tours.size();i++){
                    if(Main.tours.get(i).getPrice()>=price && Main.tours.get(i).getPrice()<=secondPrice){
                        System.out.println(Main.tours.get(i).toString());
                        flag=true;
                    }
                }
                break;
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInTours(){
        int answer;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to search based on tour's tour leader");
        System.out.println("Enter 2 to search based on starting and ending date");
        System.out.println("Enter 3 to search based on number of days");
        System.out.println("Enter 4 to search based on visiting city");
        System.out.println("Enter 5 to search based on visiting country");
        System.out.println("Enter 6 to search based on minimum and maximum capacity");
        System.out.println("Enter 7 to search based on price");
        answer=input.nextInt();
        switch (answer){
            case 1:
                searchInTourLeader();break;
            case 2:
                searchInStartingAndFinishingDate();break;
            case 3:
                searchInNumberOfDaysTour();break;
            case 4:
                searchInVisitingCityTour();break;
            case 5:
                searchInVisitingCountryTour();break;
            case 6:
                searchInMinAndMaxCapacityTour();break;
            case 7:
                searchInPriceTour();break;
        }
    }

    public static void searchInTourLeader(){
        Scanner input=new Scanner(System.in);
        String name;
        boolean flag=false;
        System.out.println("Enter tour leader's name");
        name=input.nextLine();
        for(int i=0;i<Main.foreignTours.size();i++){
            if(Main.foreignTours.get(i).getFullName().equals(name)){
                System.out.println(Main.foreignTours.get(i).toString());
                flag=true;
            }
        }
        for(int i=0;i<Main.localTours.size();i++){
            if(Main.localTours.get(i).getFullName().equals(name)){
                System.out.println(Main.localTours.get(i).toString());
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInStartingAndFinishingDate(){
        Scanner input=new Scanner(System.in);
        int choice,startingDay,startingMonth,startingYear,finishingDay,finishingMonth,finishingYear;
        Date startingDate,finishingDate;
        boolean flag=false;
        System.out.println("Enter 1 to see tours after a specific date");
        System.out.println("Enter 2 to see tours before a specific date");
        System.out.println("Enter 3 to see tours between to dates");
        choice=input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the day");
                startingDay=input.nextInt();
                System.out.println("Enter the month");
                startingMonth=input.nextInt();
                System.out.println("Enter the year");
                startingYear=input.nextInt();
                startingDate=new Date(startingYear,startingMonth,startingDay);
                for(int i=0;i<Main.foreignTours.size();i++){
                    if(compareDate(Main.foreignTours.get(i).getStartingDate(),startingDate)>=0){
                        System.out.println(Main.foreignTours.get(i).toString());
                        flag=true;
                    }
                }
                for(int i=0;i<Main.localTours.size();i++){
                    if(compareDate(Main.localTours.get(i).getStartingDate(),startingDate)>=0){
                        System.out.println(Main.localTours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 2:
                System.out.println("Enter the day");
                finishingDay=input.nextInt();
                System.out.println("Enter the month");
                finishingMonth=input.nextInt();
                System.out.println("Enter the year");
                finishingYear=input.nextInt();
                finishingDate=new Date(finishingYear,finishingMonth,finishingDay);
                for(int i=0;i<Main.foreignTours.size();i++){
                    if(compareDate(Main.foreignTours.get(i).getFinishingDate(),finishingDate)<=0){
                        System.out.println(Main.foreignTours.get(i).toString());
                        flag=true;
                    }
                }
                for(int i=0;i<Main.localTours.size();i++){
                    if(compareDate(Main.localTours.get(i).getFinishingDate(),finishingDate)<=0){
                        System.out.println(Main.localTours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 3:
                System.out.println("Enter the day");
                startingDay=input.nextInt();
                System.out.println("Enter the month");
                startingMonth=input.nextInt();
                System.out.println("Enter the year");
                startingYear=input.nextInt();
                startingDate=new Date(startingYear,startingMonth,startingDay);
                System.out.println("Enter the day");
                finishingDay=input.nextInt();
                System.out.println("Enter the month");
                finishingMonth=input.nextInt();
                System.out.println("Enter the year");
                finishingYear=input.nextInt();
                finishingDate=new Date(finishingYear,finishingMonth,finishingDay);
                for(int i=0;i<Main.foreignTours.size();i++){
                    if(compareDate(Main.foreignTours.get(i).getFinishingDate(),finishingDate)<=0 && compareDate(Main.foreignTours.get(i).getStartingDate(),startingDate)>=0){
                        System.out.println(Main.foreignTours.get(i).toString());
                        flag=true;
                    }
                }
                for(int i=0;i<Main.localTours.size();i++){
                    if(compareDate(Main.localTours.get(i).getFinishingDate(),finishingDate)<=0 && compareDate(Main.localTours.get(i).getStartingDate(),startingDate)>=0){
                        System.out.println(Main.localTours.get(i).toString());
                        flag=true;
                    }
                }
                break;
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInNumberOfDaysTour(){
        Scanner input=new Scanner(System.in);
        int number;
        boolean flag=false;
        System.out.println("Enter tour's number of days");
        number=input.nextInt();
        for(int i=0;i<Main.foreignTours.size();i++){
            if(Main.foreignTours.get(i).getTime()==number){
                System.out.println(Main.foreignTours.get(i).toString());
                flag=true;
            }
        }
        for(int i=0;i<Main.localTours.size();i++){
            if(Main.localTours.get(i).getTime()==number){
                System.out.println(Main.localTours.get(i).toString());
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInVisitingCityTour(){
        Scanner input=new Scanner(System.in);
        String cityName;
        boolean flag=false;
        System.out.println("Enter a city that you are looking for");
        cityName=input.nextLine();
        for(int i=0;i<Main.foreignTours.size();i++){
            for(int j=0;j<Main.foreignTours.get(i).getLocations().size();j++){
                if(Main.foreignTours.get(i).getLocations().get(j).getCityName().equals(cityName)){
                    System.out.println(Main.foreignTours.get(i).toString());
                    flag=true;
                }
            }
        }
        for(int i=0;i<Main.localTours.size();i++){
            if(Main.localTours.get(i).getLocation().getCityName().equals(cityName)){
                System.out.println(Main.localTours.get(i).toString());
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInVisitingCountryTour(){
        Scanner input=new Scanner(System.in);
        String country;
        boolean flag=false;
        System.out.println("Enter tour's visiting country");
        country=input.nextLine();
        if(country.equals("iran") || country.equals("Iran") || country.equals("IRAN")){
            flag=true;
            for (int i=0;i<Main.localTours.size();i++){
                System.out.println(Main.localTours.get(i).toString());
            }
        }
        else{
            for(int i=0;i<Main.foreignTours.size();i++){
                if(Main.foreignTours.get(i).getCountry().getName().equals(country)){
                    System.out.println(Main.foreignTours.get(i).toString());
                    flag=true;
                }
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInMinAndMaxCapacityTour(){
        Scanner input=new Scanner(System.in);
        int minAttendants,maxAttendants;
        boolean flag=false;
        System.out.println("Enter tour's minimum attendants");
        minAttendants=input.nextInt();
        System.out.println("Enter tour's maximum attendants");
        maxAttendants=input.nextInt();
        for(int i=0;i<Main.foreignTours.size();i++){
            if(Main.foreignTours.get(i).getMinAttendants()>=minAttendants && Main.foreignTours.get(i).getMaxAttendants()<=maxAttendants){
                System.out.println(Main.foreignTours.get(i).toString());
                flag=true;
            }
        }
        for(int i=0;i<Main.localTours.size();i++){
            if(Main.localTours.get(i).getMinAttendants()>=minAttendants && Main.localTours.get(i).getMaxAttendants()<=maxAttendants){
                System.out.println(Main.localTours.get(i).toString());
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void searchInPriceTour(){
        Scanner input=new Scanner(System.in);
        boolean flag=false;
        int price,choice,secondPrice;
        System.out.println("Enter 1 to search by a specific price");
        System.out.println("Enter 2 to search prices that are bigger than a number");
        System.out.println("Enter 3 to search prices that are smaller than a number");
        System.out.println("Enter 4 to search prices which are between two numbers");
        choice=input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter a price");
                price=input.nextInt();
                for (int i=0;i<Main.foreignTours.size();i++){
                    if(Main.foreignTours.get(i).getPrice()==price){
                        System.out.println(Main.foreignTours.get(i).toString());
                        flag=true;
                    }
                }
                for (int i=0;i<Main.localTours.size();i++){
                    if(Main.localTours.get(i).getPrice()==price){
                        System.out.println(Main.localTours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 2:
                System.out.println("Enter minimum price");
                price=input.nextInt();
                for (int i=0;i<Main.foreignTours.size();i++){
                    if(Main.foreignTours.get(i).getPrice()>=price){
                        System.out.println(Main.foreignTours.get(i).toString());
                        flag=true;
                    }
                }
                for (int i=0;i<Main.localTours.size();i++){
                    if(Main.localTours.get(i).getPrice()>=price){
                        System.out.println(Main.localTours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 3:
                System.out.println("Enter maximum price");
                price=input.nextInt();
                for (int i=0;i<Main.foreignTours.size();i++){
                    if(Main.foreignTours.get(i).getPrice()<=price){
                        System.out.println(Main.foreignTours.get(i).toString());
                        flag=true;
                    }
                }
                for (int i=0;i<Main.localTours.size();i++){
                    if(Main.localTours.get(i).getPrice()<=price){
                        System.out.println(Main.localTours.get(i).toString());
                        flag=true;
                    }
                }
                break;
            case 4:
                System.out.println("Enter minimum price");
                price=input.nextInt();
                System.out.println("Enter maximum price");
                secondPrice=input.nextInt();
                for (int i=0;i<Main.foreignTours.size();i++){
                    if(Main.foreignTours.get(i).getPrice()>=price && Main.foreignTours.get(i).getPrice()<=secondPrice){
                        System.out.println(Main.foreignTours.get(i).toString());
                        flag=true;
                    }
                }
                for (int i=0;i<Main.localTours.size();i++){
                    if(Main.localTours.get(i).getPrice()>=price && Main.localTours.get(i).getPrice()<=secondPrice){
                        System.out.println(Main.localTours.get(i).toString());
                        flag=true;
                    }
                }
                break;
        }
        if(!flag){
            System.out.println("Tour wasn't found");
        }
        backToMenu();
    }

    public static void backToMenu(){
        int answer;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to go to tour menu");
        System.out.println("Enter 2 to go to main menu");
        answer=input.nextInt();
        if(answer==1){
            Menu.tourMenu();
        }
        else if (answer==2){
            Menu.mainMenu();
        }
    }
}
