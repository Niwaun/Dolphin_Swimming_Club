package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
//        Scanner input = new Scanner(System.in);
//        ArrayList <Membership> members = new ArrayList<>();
//        FileWriter fwMember = new FileWriter("virkerdet.txt");
//        FileReader fr = new FileReader("virkerdet.txt");
//        fr.readMemberFile(members);
//        createMember(members);
//        fw.saveMemberToFile(members);

        FileWriter fwTimes = new FileWriter("times.txt");
        FileReader frTimes = new FileReader("times.txt");
        ArrayList<Times> times = new ArrayList<>();
//        frTimes.readTimesFile(times);

        createTime(times);

//        fwTimes.saveTimeToFile(times);
//        printTimesInfo(times);


//        ArrayList <User> users = new ArrayList<>();
//        System.out.println("Velkommen til Dolphin Swimming Club");
//        System.out.println("Username: ");
//        System.out.println("Password: ");
//        while (true) {
//            createMember(members, members.size());
//            createUser(users);
//            printSwimmerInfo(members);
//            saveUserToFile(users);
//            System.out.println("quit?");
//            switch (input.nextLine().toLowerCase()){
//                case "yes":
//                    return;
//                default:
//                    break;
//            }
//        }
    }

    public static void createMember(ArrayList <Membership> member) throws ParseException{
        member.add(new Membership());
    }

    public static void createUser(ArrayList <User> users){
        users.add(new User());
    }

    public static void createTime(ArrayList <Times> times)throws ParseException{
        times.add(new Times());
    }

    public static void printSwimmerInfo(ArrayList <Membership> member){
            for (int i = 0; i < member.size(); i++){
                System.out.println("Id:         " + member.get(i).getCpr());
                System.out.println("Name:       " + member.get(i).getName());
                System.out.println("Age:        " + member.get(i).getAge());
                System.out.println("Active:     " + member.get(i).isActive());
                System.out.println("Elite:      " + member.get(i).isElite());
                System.out.println("Junior:     " + member.get(i).isJunior());
                System.out.println("Discount:   " + member.get(i).isSeniorDiscount());
                System.out.println("Price:      " + member.get(i).getPrice());
                System.out.println("");
            }
    }

    public static void printUserInfo(ArrayList <User> users){
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username:   " + users.get(i).getUsername());
            System.out.println("Password:   " + users.get(i).getPassword());
            System.out.println("Role:       " + users.get(i).getRole());
            System.out.println("");
        }
    }

    public static void printTimesInfo(ArrayList <Times> times){
        for (int i = 0; i < times.size(); i++) {
            System.out.println("Crawl:       " + times.get(i).isCrawl());
            System.out.println("Tid:         " + times.get(i).getCrawlTid());
            System.out.println("Bryst:       " + times.get(i).isBryst());
            System.out.println("Tid:         " + times.get(i).getBrystTid());
            System.out.println("Butterfly:   " + times.get(i).isButterfly());
            System.out.println("Tid:         " + times.get(i).getButterflyTid());
            System.out.println("Fri:         " + times.get(i).isFri());
            System.out.println("Tid          " + times.get(i).getFriTid());
        }
    }
}
