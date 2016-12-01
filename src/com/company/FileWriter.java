package com.company;

import java.io.*;
import java.util.*;

public class FileWriter{
    private String fileName;
    private PrintStream out;

    public FileWriter(){
    }

    public FileWriter(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    public void saveMemberToFile(ArrayList<Membership> members) throws IOException {

        out = new PrintStream(new File(this.fileName));

        String tCpr = "CPR", tName = "NAVN", tAge = "ALDER", tActive = "AKTIVT", tElite = "ELITE", tJuinor = "JUNIOR",
                tSenior = "SEN.DISC", tPrice = "PRICE", tCrawl = "CRAWL", tButterfly = "BUTTERFLY",
                tBryst = "BRYST", tFri = "FRI";

        out.printf("%-13s", tCpr);
        out.printf("%-16s", tName);
        out.printf("%-10s", tAge);
        out.printf("%-10s", tActive);
        out.printf("%-10s", tElite);
        out.printf("%-10s", tCrawl);
        out.printf("%-10s", tButterfly);
        out.printf("%-10s", tBryst);
        out.printf("%-10S", tFri);
        out.printf("%-10s", tJuinor);
        out.printf("%-12", tSenior);
        out.printf("%-10s\n", tPrice);


        for (int i = 0; i < members.size(); i++) {
            String cpr = members.get(i).getCpr();
            String name = members.get(i).getName();
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

            out.printf("%-13s", cpr);
            out.printf("%-16s", name);
            out.printf("%-10d", age);
            out.printf("%-10s", convertToString(active));
            out.printf("%-10s", convertToString(elite));
            out.printf("%-10s", convertToString(crawl));
            out.printf("%-10s", convertToString(butterfly));
            out.printf("%-10s", convertToString(bryst));
            out.printf("%-10s", convertToString(fri));
            out.printf("%-10s", convertToString(junior));
            out.printf("%-12s", convertToString(seniorDiscount));
            out.printf("%-10d\n", price);

        }
    }

    public void saveTimeToFile(ArrayList<Times> times) throws IOException{

        this.fileName = fileName;
        out = new PrintStream(new File(fileName));

        String tCpr = "CPR", tName = "NAVN", tDate = "DATO", tTime = "TID";
        out.printf("%-16s", tCpr);
        out.printf("%-16s", tName);
        out.printf("%-16s", tDate);
        out.printf("%-16s\n", tTime);

        for (int i = 0; i < times.size(); i++) {

            String cpr = times.get(i).getCpr();
            String name = times.get(i).getName();
            String date = times.get(i).getDate();
            int time = times.get(i).getTime();

            out.printf("%-16s", cpr);
            out.printf("%-16s", name);
            out.printf("%-16s", date);
            out.printf("%-16d\n", time);
        }

    }
    
    public void saveUserToFile(ArrayList<User> users) throws IOException{
        this.fileName = fileName;
        out = new PrintStream(new File(fileName));
        
        String tName = "NAVN", tUsername = "USERNAME", tPassword = "PASSWORD", tRole = "ROLLE";
        out.printf("%-16s", tName);
        out.printf("%-16s", tUsername);
        out.printf("%-16s", tPassword);
        out.printf("%-16s\n", tRole);

        for (int i = 0; i < users.size(); i++) {
            String name = users.get(i).getName();
            String username = users.get(i).getUsername();
            String password = users.get(i).getPassword();
            String role = users.get(i).getRole();

            out.printf("%-16s", name);
            out.printf("%-16s", username);
            out.printf("%-16s", password);
            out.printf("%-16s\n", role);
        }
    }

    public String convertToString(boolean x){

        if(x == true){
            return "true";
        }
        return "false";
    }
}
