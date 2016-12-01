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

        String scpr2 = "CPR", snavn = "NAVN", salder = "ALDER", saktivt = "AKTIVT", selite = "ELITE", sjunior = "JUNIOR",
                sseniordisc = "SEN.DISC", sprice = "PRICE", scrawl = "CRAWL", sbutterfly = "BUTTERFLY",
                sbryst = "BRYST", sfri = "FRI";

        out.printf("%-13s", scpr2);
        out.printf("%-16s", snavn);
        out.printf("%-10s", salder);
        out.printf("%-10s", saktivt);
        out.printf("%-10s", selite);
        out.printf("%-10s", scrawl);
        out.printf("%-10s", sbutterfly);
        out.printf("%-10s", sbryst);
        out.printf("%-10S", sfri);
        out.printf("%-10s", sjunior);
        out.printf("%-12", sseniordisc);
        out.printf("%-10s\n", sprice);


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

    public void saveTimeToFile(ArrayList<Times> times, ArrayList<Membership> members) throws IOException{

        this.fileName = fileName;
        out = new PrintStream(new File(fileName));

        String ccpr = "CPR", cname = "NAVN", cdate = "DATO", ctime = "TID";
        out.printf("%-16s", ccpr);
        out.printf("%-16s", cname);
        out.printf("%-16s", cdate);
        out.printf("%-16s\n", ctime);

        for (int i = 0; i < times.size(); i++) {

            String tcpr = times.get(i).getCpr();
            String tname = times.get(i).getName();
            String tdate = times.get(i).getDate();
            int ttime = times.get(i).getTime();

            out.printf("%-16s", tcpr);
            out.printf("%-16s", tname);
            out.printf("%-16s", tdate);
            out.printf("%-16d\n", ttime);

        }

    }

    public String convertToString(boolean x){

        if(x == true){
            return "true";
        }
        return "false";
    }
}
