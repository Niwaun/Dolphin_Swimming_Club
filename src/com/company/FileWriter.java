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

        out.print("ID\tNAVN\t\t\tALDER\tAKTIVT\tELITE\tJUNIOR\tSENIORDISCOUNT\tPRICE");
        out.println();


        for (int i = 0; i < members.size(); i++) {
            String cpr = members.get(i).getCpr();
            String name = members.get(i).getName();
            int price = members.get(i).getPrice();
            int age = members.get(i).getAge();
            boolean active = members.get(i).isActive();
            boolean elite = members.get(i).isElite();
            boolean junior = members.get(i).isJunior();
            boolean seniorDiscount = members.get(i).isSeniorDiscount();

            out.print(cpr + "\t" + name + "\t\t\t" + age + "\t\t" + active + "\t" + elite + "\t" + junior + "\t" + seniorDiscount + "\t\t\t" + price);
            out.println();

        }
    }

    public void saveTimeToFile(ArrayList<Times> times) throws IOException{

        this.fileName = fileName;
        out = new PrintStream(new File(fileName));

        out.print("CPR\tNAVN\tCRAWL\tTID\tBUTTERFLY\tTID\tBRYST\tTID\tFRI\tTID");
        out.println();

        for (int i = 0; i < times.size(); i++) {
            String cpr = times.get(i).getCpr();
            String name = times.get(i).getName();
            boolean crawl = times.get(i).isCrawl();
            int crawlTid = times.get(i).getCrawlTid();
            boolean butterfly = times.get(i).isButterfly();
            int butterflyTid = times.get(i).getButterflyTid();
            boolean bryst = times.get(i).isBryst();
            int brystTid = times.get(i).getBrystTid();
            boolean fri = times.get(i).isFri();
            int friTid = times.get(i).getFriTid();

            out.print(cpr +"\t"+ name +"\t"+ crawl +"\t"+ crawlTid +"\t"+ butterfly +"\t"+ butterflyTid +"\t"+ bryst +"\t"+ brystTid +"\t"+ fri +"\t"+ friTid);
            out.println();

        }

    }
}
