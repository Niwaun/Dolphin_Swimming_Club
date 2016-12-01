package com.company;

import java.io.*;
import java.util.*;

public class FileWriter{
    private String fileName;
    private PrintStream out;

    public FileWriter(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    public void saveMemberToFile(ArrayList<Membership> members) throws IOException {

        out = new PrintStream(new File(this.fileName));

//        out.print("ID\tNAVN\t\t\tALDER\tAKTIVT\tELITE\tJUNIOR\tSENIORDISCOUNT\tPRICE");

        String scpr2 = "CPR", snavn = "NAVN", salder = "ALDER", saktivt = "AKTIVT", selite = "ELITE", sjunior = "JUNIOR",
                sseniordisc = "SENIORDISCOUNT", sprice = "PRICE";

        out.printf("%-16s", scpr2);
        out.printf("%-16s", snavn);
        out.printf("%-10s", salder);
        out.printf("%-10s", saktivt);
        out.printf("%-10s", selite);
        out.printf("%-10s", sjunior);
        out.printf("%-17s", sseniordisc);
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

//            out.print(cpr + "\t" + name + "\t\t\t" + age + "\t\t" + active + "\t" + elite + "\t" + junior + "\t" +
//                    seniorDiscount + "\t\t\t" + price);

            out.printf("%-16s", cpr);
            out.printf("%-16s", name);
            out.printf("%-10d", age);
            out.printf("%-10s", convertToString(active));
            out.printf("%-10s", convertToString(elite));
            out.printf("%-10s", convertToString(junior));
            out.printf("%-17s", convertToString(seniorDiscount));
            out.printf("%-10d\n", price);

        }
    }

    public void saveTimeToFile(ArrayList<Times> times) throws IOException{

        this.fileName = fileName;
        out = new PrintStream(new File(fileName));

        String scpr = "CPR", scrawl = "CRAWL", sbutterfly = "BUTTERFLY", sbryst = "BRYST", sfri = "FRI", stid = "TID";

        out.printf("%-16s",scpr);
        out.printf("%-10s",scrawl);
        out.printf("%-10s",stid);
        out.printf("%-14s",sbutterfly);
        out.printf("%-10s",stid);
        out.printf("%-10s",sbryst);
        out.printf("%-10s",stid);
        out.printf("%-10s",sfri);
        out.printf("%-10s\n",stid);

        for (int i = 0; i < times.size(); i++) {
            String cpr = times.get(i).getCpr();
            boolean crawl = times.get(i).isCrawl();
            int crawlTid = times.get(i).getCrawlTid();
            boolean butterfly = times.get(i).isButterfly();
            int butterflyTid = times.get(i).getButterflyTid();
            boolean bryst = times.get(i).isBryst();
            int brystTid = times.get(i).getBrystTid();
            boolean fri = times.get(i).isFri();
            int friTid = times.get(i).getFriTid();

            out.printf("%-16s",cpr);
            out.printf("%-10s",convertToString(crawl));
            out.printf("%-10d",crawlTid);
            out.printf("%-14s",convertToString(butterfly));
            out.printf("%-10d",butterflyTid);
            out.printf("%-10s",convertToString(bryst));
            out.printf("%-10d",brystTid);
            out.printf("%-10s",convertToString(fri));
            out.printf("%-10d\n",friTid);

        }

    }

    public String convertToString(boolean x){

        if(x == true){
            return "true";
        }
        return "false";
    }
}
