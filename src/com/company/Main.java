package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Membership> members = new ArrayList<>();

        TopFive topFive = new TopFive();

        ArrayList<Times> crawl = new ArrayList<>();
        ArrayList<Times> butterfly = new ArrayList<>();
        ArrayList<Times> bryst = new ArrayList<>();
        ArrayList<Times> fri = new ArrayList<>();

        FileWriter fwCrawl = new FileWriter("crawl.txt");
        FileWriter fwButterfly = new FileWriter("butterfly.txt");
        FileWriter fwBryst = new FileWriter("bryst.txt");
        FileWriter fwFri = new FileWriter("fri.txt");
        FileWriter fwMembers = new FileWriter("members.txt");
        FileWriter fwUser = new FileWriter("users.txt");

        FileReader frCrawl = new FileReader("crawl.txt");
        FileReader frButterfly = new FileReader("butterfly.txt");
        FileReader frBryst = new FileReader("bryst.txt");
        FileReader frFri = new FileReader("fri.txt");
        FileReader frMembers = new FileReader("members.txt");
        FileReader frUser = new FileReader("users.txt");

        frCrawl.readTimesFile(crawl);
        frButterfly.readTimesFile(butterfly);
        frBryst.readTimesFile(bryst);
        frFri.readTimesFile(fri);
        frMembers.readMemberFile(members);
        frUser.readUsersFile(users);

        while (true) {

            System.out.println("Velkommen til \"The Dolphin\"");
            String role = login(users);

            switch (role.toLowerCase()) {
                case "admin":
                    roleAdmin(users, fwUser);
                    break;
                case "treasurer":
                    System.out.println("... Under construction...");
                    break;
                case "chairman":
                    roleChairman(members, fwMembers);
                    break;
                case "coach":
                    roleCoach(members, crawl, butterfly, bryst, fri, fwCrawl, fwButterfly, fwBryst, fwFri, topFive);
                    break;
            }
            System.out.println("Ønsker du at afslutte programmet?");
            if (input.next().equalsIgnoreCase("ja")) {
                System.out.println("Farvel og tak");
                return;
            }
        }
    }

    public static void createMember(ArrayList<Membership> members) throws ParseException {
        members.add(new Membership(members));
    }

    public static void createUser(ArrayList<User> users) {
        users.add(new User());
    }

    public static void createTime(ArrayList<Times> times, String name, String cpr) throws ParseException {

        times.add(new Times(times, name, cpr));
    }

    public static void printSwimmerInfo(ArrayList<Membership> members) {

        Scanner input = new Scanner(System.in);
        boolean error = true;
        boolean runPrint = true;
        do {
            System.out.println("Skriv CPR på det medlem du ønsker at printe");

            String cpr3 = input.next();
            cpr3 = cpr3.substring(0, 6) + "-" + cpr3.substring(6, 10);
            error = true;
            for (int i = 0; i < members.size(); i++) {
                if (cpr3.equals(members.get(i).getCpr())) {

                    String tCpr = "CPR", tName = "NAVN", tAge = "ALDER", tDate = "DATO", tActive = "AKTIVT",
                            tElite = "ELITE", tJuinor = "JUNIOR", tSenior = "SEN.DISC", tPrice = "PRICE",
                            tCrawl = "CRAWL", tButterfly = "BUTTERFLY", tBryst = "BRYST", tFri = "FRI";

                    System.out.printf("%-13s", tCpr);
                    System.out.printf("%-16s", tName);
                    System.out.printf("%-10s", tAge);
                    System.out.printf("%-16s", tDate);
                    System.out.printf("%-10s", tActive);
                    System.out.printf("%-10s", tElite);
                    System.out.printf("%-10s", tCrawl);
                    System.out.printf("%-10s", tButterfly);
                    System.out.printf("%-10s", tBryst);
                    System.out.printf("%-10S", tFri);
                    System.out.printf("%-10s", tJuinor);
                    System.out.printf("%-12s", tSenior);
                    System.out.printf("%-10s\n", tPrice);
                    String cpr4 = members.get(i).getCpr();
                    String name = members.get(i).getName();
                    String date = members.get(i).getJoin();
                    int price = members.get(i).getPrice();
                    int age = members.get(i).getAge();
                    boolean active = members.get(i).isActive();
                    boolean elite = members.get(i).isElite();
                    boolean junior = members.get(i).isJunior();
                    boolean seniorDiscount = members.get(i).isSeniorDiscount();
                    boolean crawl = members.get(i).isCrawl();
                    boolean butterfly = members.get(i).isButterfly();
                    boolean bryst = members.get(i).isBryst();
                    boolean fri = members.get(i).isFri();

                    System.out.printf("%-13s", cpr4);
                    System.out.printf("%-16s", name);
                    System.out.printf("%-10d", age);
                    System.out.printf("%-16s", date);
                    System.out.printf("%-10s", convertToString(active));
                    System.out.printf("%-10s", convertToString(elite));
                    System.out.printf("%-10s", convertToString(crawl));
                    System.out.printf("%-10s", convertToString(butterfly));
                    System.out.printf("%-10s", convertToString(bryst));
                    System.out.printf("%-10s", convertToString(fri));
                    System.out.printf("%-10s", convertToString(junior));
                    System.out.printf("%-12s", convertToString(seniorDiscount));
                    System.out.printf("%-10d\n", price);
                    error = false;
                }
            }
            if (error) {
                System.out.println("Fejl. Kan ikke finde CPR.");
            }

            System.out.println("Ønsker du at printe flere?");
            if (input.next().equalsIgnoreCase("nej")) {
                runPrint = false;
            }
        } while (runPrint);


    }

    public static void printUserInfo(ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Name:       " + users.get(i).getName());
            System.out.println("Username:   " + users.get(i).getUsername());
            System.out.println("Password:   " + users.get(i).getPassword());
            System.out.println("Role:       " + users.get(i).getRole());
            System.out.println("");
        }
    }


    public static void printTimesInfo(ArrayList<Times> times, ArrayList<Membership> members) {

        String tCpr = "CPR", tName = "NAVN", tDate = "DATO", tTime = "TID";
        System.out.printf("%-16s", tCpr);
        System.out.printf("%-16s", tName);
        System.out.printf("%-16s", tDate);
        System.out.printf("%-16s\n", tTime);

        for (int i = 0; i < times.size(); i++) {

            String cpr = times.get(i).getCpr();
            String name = times.get(i).getName();
            String date = times.get(i).getDate();
            int time = times.get(i).getTime();

            System.out.printf("%-16s", cpr);
            System.out.printf("%-16s", name);
            System.out.printf("%-16s", date);
            System.out.printf("%-16d\n", time);
        }

    }

    public static void enterDisciplineTime(ArrayList<Membership> members, ArrayList<Times> crawl,
                                           ArrayList<Times> butterfly, ArrayList<Times> bryst, ArrayList<Times> fri)
            throws ParseException {

        Scanner input = new Scanner(System.in);
        boolean run = true;
        String name = "";
        int i = 0;
        String cpr = "";

        do {
            System.out.println("Skriv CPR på det medlem du ønsker at oprette en tid for");

            cpr = input.next();
            try {
                cpr = cpr.substring(0, 6) + "-" + cpr.substring(6, 10);
            } catch (Exception e) {
                System.out.println("Ugyldigt cpr");
            }

            for (i = 0; i < members.size(); i++) {
                if (cpr.equals(members.get(i).getCpr())) {
                    if (members.get(i).isElite()) {
                        name = members.get(i).getName();
                        System.out.println(name + " er aktiv i: ");

                        if (members.get(i).isCrawl()) {
                            System.out.println("Crawl.");
                        }
                        if (members.get(i).isButterfly()) {
                            System.out.println("Butterfly.");
                        }
                        if (members.get(i).isBryst()) {
                            System.out.println("Bryst");
                        }
                        if (members.get(i).isFri()) {
                            System.out.println("Fri");
                        }
                        System.out.println("Vælg disciplin");
                        String disciplin = input.next().toLowerCase();
                        switch (disciplin) {
                            case "crawl":
                                createTime(crawl, name, cpr);
                                System.out.println("Der er nu oprettet en tid for: " +
                                        members.get(i).getName());
                                break;
                            case "butterfly":
                                createTime(butterfly, name, cpr);
                                System.out.println("Der er nu oprettet en tid for: " +
                                        members.get(i).getName());
                                break;
                            case "bryst":
                                createTime(bryst, name, cpr);
                                System.out.println("Der er nu oprettet en tid for: " +
                                        members.get(i).getName());
                                break;
                            case "fri":
                                createTime(fri, name, cpr);
                                System.out.println("Der er nu oprettet en tid for: " +
                                        members.get(i).getName());
                                break;
                            default:
                                System.out.println("Fejl. Kan ikke finde disciplin.\nPrøv igen.");
                                break;
                        }
                    } else {
                        name = members.get(i).getName();
                        System.out.println(name + " er ikke elite");
                    }
                }
            }

            System.out.println("Fortsæt?");
            if (input.next().equalsIgnoreCase("nej")) {
                run = false;
            }
        } while (run);

    }

    public static String login(ArrayList<User> users) {
        Scanner input = new Scanner(System.in);
        String username = "";
        String password = "";

        do {
            System.out.println("Brugernavn:");
            username = input.next();
            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername())){
                    do {
                        System.out.println("Kodeord:");
                        password = input.next();
                        if (password.equals(users.get(i).getPassword())){
                            System.out.println("Hej " + users.get(i).getName());
                            return users.get(i).getRole();
                        } else {
                            System.out.println("Fejl! Kodeordet er forkert");
                        }
                    }while (true);
                }
            }
            System.out.println("Fejl! Brugernavnet findes ikke");
        }while (true);
    }

    public static void roleAdmin(ArrayList<User> users, FileWriter fwUsers) throws IOException{

        Scanner input = new Scanner(System.in);
        boolean run = true;
        do {
        System.out.println();
        System.out.println("Vil du: \nOprette en bruger?\nSlette en bruger?\nÆndre en bruger?\nPrinte brugerliste\nAfslutte?");
        String ans = "";
        ans = input.next().toLowerCase();
        switch (ans) {
            case "oprette":
                boolean runOpret = true;
                do {

                    createUser(users);
                    System.out.println("Brugeren " + users.get(users.size() - 1).getUsername() + " er oprettet");
                    System.out.println("Ønsker du at oprette flere?");
                    if (input.next().equalsIgnoreCase("nej")) {
                        runOpret = false;
                    }
                } while (runOpret);
                break;

            case "slette":

                boolean runSlet = true;

                do{
                    System.out.println("Skriv brugernavnet på den bruger, du ønsker at slette");
                    String slette = input.next();
                    boolean error = true;
                    for (int i = 0; i < users.size(); i++) {
                        if (slette.equals(users.get(i).getUsername())) {
                            users.remove(i);
                            System.out.println("Brugeren " + slette + " er nu slettet.");
                            error = false;
                        }
                    }
                    if (error) {
                        System.out.println("Fejl. Kan ikke finde brugernavn.");
                    }

                    System.out.println("Ønsker du at slette flere?");
                    if(input.next().equalsIgnoreCase("nej")){
                        runSlet = false;
                    }
                } while(runSlet);

                break;

            case "ændre":
                System.out.println("Skriv brugernavnet på den bruger, du ønsker at ændre");
                String ændre = input.next();
                boolean runÆndre = true;
                boolean error = true;
                for (int i = 0; i < users.size(); i++) {
                    if (ændre.equals(users.get(i).getUsername())) {
                        error = false;
                        do {
                            System.out.println("Hvad ønsker du at ændre?\nNavn?\nBrugernavn?\nKodeord?\nRolle?");
                            switch (input.next().toLowerCase()) {
                                case "brugernavn":
                                    users.get(i).setUsername();
                                    break;
                                case "kodeord":
                                    users.get(i).setPassword();
                                    break;
                                case "rolle":
                                    users.get(i).setRole();
                                    break;
                                case "navn":
                                    users.get(i).setName();
                                    break;
                                default:
                                    System.out.println("Fejl. Svar venligst med \"Navn\", \"Brugernavn\", \"Kodeord\"" +
                                            "\"Rolle\".");
                                    break;
                            }

                            System.out.println("Ønsker du at ændre mere?");
                            if (input.next().equalsIgnoreCase("nej")) {
                                runÆndre = false;
                            }
                        } while (runÆndre);
                    }
                }

                if(error){
                    System.out.println("Fejl. Kunne ikke finde et match.");
                }

                break;
            case "afslutte":
                run = false;
                fwUsers.saveUserToFile(users);
                break;
            case "printe":
                String roller = "ROLLE";
                String brugernavne = "BRUGERNAVN";
                System.out.printf("%-16s%-10s\n", brugernavne, roller);
                for (User brugere :users) {
                    String brugernavn = brugere.getUsername();
                    String rolle = brugere.getRole();
                    System.out.printf("%-16s%-10s\n", brugernavn, rolle);
                }
                break;
            default:
                System.out.println("Fejl. Svar venligst med \"Oprette\", \"Slette\", \"Ændre\", " +
                        "\"Printe\", \"Afslutte\".");
                break;
        }
        }while(run);
    }

    public static void roleChairman(ArrayList<Membership> members, FileWriter fwMembers)
            throws IOException, ParseException{

        Scanner input = new Scanner(System.in);
        boolean run = true;

        do{

            System.out.println("Vil du: \nOprette et medlem?\nSlette et medlem?\nÆndre et medlem?\n" + "" +
                    "Printe info om et medlem?\nAfslutte?");

            String ans = input.next().toLowerCase();
            switch(ans){
                case "oprette":
                    boolean runOpret = true;
                    do {

                        createMember(members);
                        System.out.println(members.get(members.size() - 1).getName() + " er oprettet som medlem.");
                        System.out.println(members.get(members.size()-1).getName() + " skal betale " +
                        members.get(members.size()-1).getPrice() + " kr.");
                        System.out.println("Ønsker du at oprette flere?");
                        if (input.next().equalsIgnoreCase("nej")) {
                            runOpret = false;
                        }
                    } while (runOpret);
                    break;
                case "slette":
                    boolean runSlet = true;
                    boolean error = true;

                    do{
                        System.out.println("Skriv CPR på det medlem du ønsker at slette");

                        String cpr = input.next();
                        cpr = cpr.substring(0,6) + "-" + cpr.substring(6,10);
                        error = true;
                        for (int i = 0; i < members.size(); i++) {
                            if (cpr.equals(members.get(i).getCpr())) {
                                String name = members.get(i).getName();
                                members.remove(i);
                                System.out.println(name + " er nu slettet.");
                                error = false;
                            }
                        }
                        if (error) {
                            System.out.println("Fejl. Kan ikke finde CPR.");
                        }

                        System.out.println("Ønsker du at slette flere?");
                        if(input.next().equalsIgnoreCase("nej")){
                            runSlet = false;
                        }
                    } while(runSlet);
                    break;
                case "ændre":

                    error = true;
                    System.out.println("Skriv CPR nr på det medlem, du ønsker at ændre");
                    String cpr = input.next();
                    try{
                        cpr = cpr.substring(0,6) + "-" + cpr.substring(6,10);
                    }catch (Exception e) {
                        System.out.println("Ikke gyldigt cpr.");
                        error = false;
                    }
                    boolean runÆndre = true;
                    for (int i = 0; i < members.size(); i++) {
                        if (cpr.equals(members.get(i).getCpr())) {
                            error = false;
                            do {
                                System.out.println("Hvad ønsker du at ændre?\nCPR?\nNavn?\nMedlemstype?");
                                switch (input.next().toLowerCase()) {
                                    case "cpr":
                                        members.get(i).setCpr(members);
                                        break;
                                    case "navn":
                                        members.get(i).setName();
                                        break;
                                    case "medlemstype":
                                        members.get(i).setActive();
                                        if(members.get(i).isActive()){
                                            members.get(i).setElite();
                                            if(members.get(i).isElite()){
                                                members.get(i).chooseDisciplin();
                                            }
                                        }
                                        members.get(i).setPrice();
                                        break;
                                    default:
                                        System.out.println("Fejl. Svar venligst med \"cpr\", \"navn\", \"medlemstype\"");
                                        break;
                                }

                                System.out.println("Ønsker du at ændre mere?");
                                if (input.next().equalsIgnoreCase("nej")) {
                                    runÆndre = false;
                                }
                            } while (runÆndre);
                        }
                    }

                    if(error){
                        System.out.println("Fejl. Kunne ikke finde et match.");
                    }

                    break;
                case "printe":
                    String scpr = "CPR";
                    String snavn = "NAVN";
                    System.out.printf("%-16s%-16s\n", scpr, snavn);
                    for (Membership member: members) {
                        String tempCpr = member.getCpr();
                        String tempNavn = member.getName();
                        System.out.printf("%-16s%-16s\n", tempCpr, tempNavn);
                    }
                    System.out.println("");
                    System.out.println("Print yderligere information om et medlem?");
                    String svar = input.next();
                    if(svar.equalsIgnoreCase("nej")){
                        break;
                    }
                    printSwimmerInfo(members);
                    break;
                case "afslutte":
                    run = false;
                    fwMembers.saveMemberToFile(members);
                    break;
                default:
                    System.out.println("Fejl. Prøv igen.\nSvar med \"oprette\", \"slette\", \"ændre\", \"printe\"" +
                            ", \"afslutte\"");
                    break;
            }
        } while(run);

    }

    public static void roleCoach(ArrayList<Membership> members, ArrayList<Times> crawl, ArrayList<Times> butterfly,
                                 ArrayList<Times> bryst, ArrayList<Times>fri, FileWriter fwCrawl,
                                 FileWriter fwButterfly, FileWriter fwbryst, FileWriter fwfri, TopFive topfive)
                                 throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        do {

            System.out.println("Vil du:\nOprette tider?\nSlette tider?\nÆndre tider?\nSe top 5?\nPrinte tider?" +
                    "\nAfslutte");
            String ans = input.next().toLowerCase();
            switch (ans) {
                case "oprette":
                    boolean runOpret = true;
                    do {
                        enterDisciplineTime(members, crawl, butterfly, bryst, fri);
                        System.out.println("Ønsker du at oprette flere tider?");
                        if (input.next().equalsIgnoreCase("nej")) {
                            runOpret = false;
                        }
                    } while (runOpret);
                    break;
                case "slette":
                    boolean runSlet = true;
                    do {
                        System.out.println("For hvilken disciplin vil du slette en tid?\n\"Crawl\", \"Butterfly\"," +
                                " \"Bryst\", \"Fri\"");
                        ans = input.next().toLowerCase();
                        switch (ans) {
                            case "crawl":
                                deleteTime(crawl, members);
                                break;
                            case "butterfly":
                                deleteTime(butterfly, members);
                                break;
                            case "bryst":
                                deleteTime(butterfly, members);
                                break;
                            case "fri":
                                deleteTime(fri, members);
                                break;
                            default:
                                System.out.println("Fejl. Kunne ikke finde disciplin.");
                                break;
                        }
                        System.out.println("Vil du slette flere tider?");
                        if (input.next().equalsIgnoreCase("nej")) {
                            runSlet = false;
                        }
                    } while (runSlet);
                    break;
                case "ændre":
                    boolean runÆndre = true;
                    do {
                        System.out.println("For hvilken disciplin vil du ændre en tid?\n\"Crawl\", \"Butterfly\"," +
                                " \"Bryst\", \"Fri\"");
                        ans = input.next().toLowerCase();
                        switch (ans) {
                            case "crawl":
                                updateTime(crawl, members);
                                break;
                            case "butterfly":
                                updateTime(butterfly, members);
                                break;
                            case "bryst":
                                updateTime(bryst, members);
                                break;
                            case "fri":
                                updateTime(fri, members);
                                break;
                            default:
                                System.out.println("Fejl. Kunne ikke finde disciplin.");
                                break;
                        }
                        System.out.println("Vil du ændre flere tider?");
                        if (input.next().equalsIgnoreCase("nej")) {
                            runÆndre = false;
                        }
                    } while(runÆndre);
                        break;
                case "top":
                    boolean runTop = true;
                    do {
                        System.out.println("For hvilken disciplin vil du se en top 5?\n\"Crawl\", \"Butterfly\"," +
                                " \"Bryst\", \"Fri\"");
                        ans = input.next().toLowerCase();
                        switch (ans) {
                            case "crawl":
                                topfive.sortTimes(crawl);
                                break;
                            case "butterfly":
                                topfive.sortTimes(butterfly);
                                break;
                            case "bryst":
                                topfive.sortTimes(bryst);
                                break;
                            case "fri":
                                topfive.sortTimes(fri);
                                break;
                            default:
                                System.out.println("Fejl. Kunne ikke finde disciplin.");
                                break;
                        }
                        System.out.println("Vil du se flere top 5?");
                        if (input.next().equalsIgnoreCase("nej")) {
                            runTop = false;
                        }
                    } while(runTop);
                    break;

                case "printe":
                    boolean runPrint = true;
                    do{
                        System.out.println("For hvilken disciplin vil du printe information?");
                        String disciplin = input.next().toLowerCase();
                        switch(disciplin){
                            case "crawl":
                                printTimesInfo(crawl, members);
                                break;
                            case "butterfly":
                                printTimesInfo(butterfly, members);
                                break;
                            case "bryst":
                                printTimesInfo(bryst, members);
                                break;
                            case "fri":
                                printTimesInfo(fri, members);
                                break;
                            default:
                                System.out.println("Fejl. Kunne ikke finde disciplin");
                                break;
                        }
                        System.out.println("Vil du printe flere tider?");
                        if (input.next().equalsIgnoreCase("nej")) {
                            runPrint = false;
                        }
                    } while(runPrint);
                    break;
                case "afslutte":
                    fwbryst.saveTimeToFile(bryst);
                    fwButterfly.saveTimeToFile(butterfly);
                    fwCrawl.saveTimeToFile(crawl);
                    fwfri.saveTimeToFile(fri);
                    run = false;
                    break;
                default:
                System.out.println("Fejl. Prøv igen.\nSvar med \"oprette\", \"slette\", \"ændre\", \"top\", \"" +
                                    "printe\", \"afslutte");
                    break;

            }
        } while (run);
    }


    public static String convertToString(boolean x){

        if(x == true){
            return "true";
        }
        return "false";
    }

    public static void deleteTime(ArrayList<Times>times, ArrayList<Membership> members){
        Scanner input = new Scanner(System.in);
        printTimesInfo(times, members);
        String cpr = "";
        boolean run;
        do{
            run = false;
            System.out.println("Indtast CPR for den tid du vil slette.");
            cpr = input.next();
            try {
                cpr = cpr.substring(0, 6) + "-" + cpr.substring(6, 10);
            } catch (Exception e) {
                System.out.println("Ugyldigt cpr");
                run = true;
            }
        } while(run);
        for (int i = 0; i < times.size(); i++) {
            if(cpr.equals(times.get(i).getCpr())){
                String name = times.get(i).getName();
                times.remove(i);
                System.out.println(name + "'s tid er nu slettet");
            }
        }
    }

    public static void updateTime(ArrayList<Times>times, ArrayList<Membership> members){
        Scanner input = new Scanner(System.in);
        printTimesInfo(times, members);
        String cpr = "";
        boolean run;
        do{
            run = false;
            System.out.println("Indtast CPR for den tid du vil ændre.");
            cpr = input.next();
            try {
                cpr = cpr.substring(0, 6) + "-" + cpr.substring(6, 10);
            } catch (Exception e) {
                System.out.println("Ugyldigt cpr");
                run = true;
            }
        } while(run);
        for (int i = 0; i < times.size(); i++) {
            if(cpr.equals(times.get(i).getCpr())){
                int newTime = 0;
                System.out.println("Hvad er den nye tid?");
                while (!input.hasNextInt()) {
                    input.next();
                    System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
                    System.out.println("Hvad var svømmerens tid? (i sekunder");
                }
                newTime = input.nextInt();
                times.get(i).setTime(newTime);
            }
        }
    }
}
