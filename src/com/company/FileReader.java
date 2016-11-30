package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Anders on 29-Nov-16.
 */
public class FileReader {

    private String fileName;

    public FileReader(String fileName) throws IOException{
        this.fileName = fileName;
    }

    public void readMemberFile(ArrayList<Membership> members) throws IOException, ParseException {

        Scanner input = new Scanner(new File(fileName));
        input.nextLine();
        while(input.hasNextLine()){
            String text = input.nextLine();
            readMemberLine(text, members);
        }
    }

    public void readMemberLine(String text, ArrayList<Membership> members)throws IOException, ParseException{

        Scanner lineScanner = new Scanner(text);
        String tempCPR;
        String tempName;
        int tempAge;
        boolean tempActive;
        boolean tempElite;
        boolean tempJunior;
        boolean tempSeniorDisc;
        int tempPrice;


        while(lineScanner.hasNext()){

            tempCPR = lineScanner.next();
            tempName = lineScanner.next();
            tempAge = lineScanner.nextInt();
            tempActive = lineScanner.nextBoolean();
            tempElite = lineScanner.nextBoolean();
            tempJunior = lineScanner.nextBoolean();
            tempSeniorDisc = lineScanner.nextBoolean();
            tempPrice = lineScanner.nextInt();

            members.add(new Membership(tempCPR, tempName, tempAge, tempActive, tempElite, tempJunior, tempSeniorDisc, tempPrice));

        }
    }

    public void readTimesFile(ArrayList<Times> times) throws IOException, ParseException {

        Scanner input = new Scanner(new File(fileName));
        input.nextLine();
        while(input.hasNextLine()){
            String text = input.nextLine();
            readTimesLine(text, times);
        }

    }

    public void readTimesLine(String text, ArrayList<Times> times) throws ParseException {

        Scanner lineScanner = new Scanner(text);

        String tempCpr;
//        String tempName;
        boolean tempCrawl;
        boolean tempBryst;
        boolean tempButterfly;
        boolean tempFri;
        int tempCrawlTid;
        int tempBrystTid;
        int tempButterflyTid;
        int tempFriTid;

        while(lineScanner.hasNext()){
            tempCpr = lineScanner.next();
//            tempName = lineScanner.next();
            tempCrawl = lineScanner.nextBoolean();
            tempCrawlTid = lineScanner.nextInt();
            tempButterfly = lineScanner.nextBoolean();
            tempButterflyTid = lineScanner.nextInt();
            tempBryst = lineScanner.nextBoolean();
            tempBrystTid = lineScanner.nextInt();
            tempFri = lineScanner.nextBoolean();
            tempFriTid = lineScanner.nextInt();

            times.add(new Times(tempCpr,/* tempName,*/ tempCrawl, tempCrawlTid, tempButterfly, tempButterflyTid, tempBryst, tempBrystTid, tempFri, tempFriTid));
        }
    }
}
