package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException{
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


        frUser.readUsersFile(users);
        System.out.println("Velkommen til \"The Dolphin\"");
        printUserInfo(users);
        login(users);
    }

    public static void createMember(ArrayList <Membership> member) throws ParseException{
        member.add(new Membership());
    }

    public static void createUser(ArrayList <User> users){
        users.add(new User());
    }

    public static void createTime(ArrayList<Times> times, String a, String b) throws ParseException{

        times.add(new Times(times, a, b));
    }

    public static void printSwimmerInfo(ArrayList <Membership> member){
            for (int i = 0; i < member.size(); i++){
                System.out.println("Cpr:        " + member.get(i).getCpr());
                System.out.println("Name:       " + member.get(i).getName());
                System.out.println("Age:        " + member.get(i).getAge());
                System.out.println("Active:     " + member.get(i).isActive());
                System.out.println("Elite:      " + member.get(i).isElite());
                System.out.println("Crawl:      " + member.get(i).isCrawl());
                System.out.println("Bryst:      " + member.get(i).isBryst());
                System.out.println("Butterfly:  " + member.get(i).isButterfly());
                System.out.println("Fri:        " + member.get(i).isFri());
                System.out.println("Junior:     " + member.get(i).isJunior());
                System.out.println("Discount:   " + member.get(i).isSeniorDiscount());
                System.out.println("Price:      " + member.get(i).getPrice());
                System.out.println("");
            }
    }

    public static void printUserInfo(ArrayList <User> users){
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Name:       " + users.get(i).getName());
            System.out.println("Username:   " + users.get(i).getUsername());
            System.out.println("Password:   " + users.get(i).getPassword());
            System.out.println("Role:       " + users.get(i).getRole());
            System.out.println("");
        }
    }


    public static void printTimesInfo(ArrayList <Times> times, ArrayList<Membership> members){
        for (int i = 0; i < times.size(); i++) {

            System.out.println("CPR:          " + times.get(i).getCpr());
            System.out.println("NAVN:         " + times.get(i).getName());
            System.out.println("DATO:         " + times.get(i).getDate());
            System.out.println("TID:          " + times.get(i).getTime());
        }
    }

    public static void enterDisciplineTime(ArrayList<Membership> members,ArrayList<Times> crawl,
                                        ArrayList<Times> butterfly, ArrayList<Times> bryst, ArrayList<Times> fri)
                                        throws ParseException{

        ArrayList<String> cprArray = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Indtast cpr");
        String cpr = input.next();
        cpr = cpr.substring(0, 6) + '-' + cpr.substring(6, 10);


        String x;

        for (int i = 0; i < members.size(); i++) {

            x = members.get(i).getCpr();
            cprArray.add(x);
        }

        boolean bab = cprArray.contains(cpr);

        if (!bab) {
            System.out.println("Fejl i CPR. Prøv igen.");
            enterDisciplineTime(members, crawl, butterfly, bryst, fri);
        }

        int i = cprArray.indexOf(cpr);
        String name = members.get(i).getName();
        if(members.get(i).isElite()){

            System.out.println(name + " er aktiv i: ");

            if (members.get(i).isCrawl()) {
                System.out.println("Crawl.");
            } if (members.get(i).isButterfly()) {
                System.out.println("Butterfly.");
            } if (members.get(i).isBryst()) {
                System.out.println("Bryst");
            } if (members.get(i).isFri()) {
                System.out.println("Fri");
            }
            System.out.println("Vælg disciplin");
            String disciplin = input.next().toLowerCase();
            switch(disciplin){
                case "crawl":
                    createTime(crawl, name, cpr);
                    break;
                case "butterfly":
                    createTime(butterfly, name, cpr);
                    break;
                case "bryst":
                    createTime(bryst, name, cpr);
                    break;
                case "fri":
                    createTime(fri, name, cpr);
                    break;
                default:
                    System.out.println("Fejl. Kan ikke finde disciplin.\nPrøv igen.");
            }
        } else{
            System.out.println(name + " er ikke elite.");
            enterDisciplineTime(members, crawl, butterfly, bryst, fri);
        }

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
}
