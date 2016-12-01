package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Anders on 29-Nov-16.
 */
public class FileReader {

    private String fileName;

    public FileReader(){
    }

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

        boolean tempCrawl;
        boolean tempButterfly;
        boolean tempBryst;
        boolean tempFri;

        int tempPrice;


        while(lineScanner.hasNext()){

            tempCPR = lineScanner.next();
            tempName = lineScanner.next();
            tempAge = lineScanner.nextInt();
            tempActive = lineScanner.nextBoolean();
            tempElite = lineScanner.nextBoolean();
            tempCrawl = lineScanner.nextBoolean();
            tempButterfly = lineScanner.nextBoolean();
            tempBryst = lineScanner.nextBoolean();
            tempFri = lineScanner.nextBoolean();
            tempJunior = lineScanner.nextBoolean();
            tempSeniorDisc = lineScanner.nextBoolean();
            tempPrice = lineScanner.nextInt();

            members.add(new Membership(tempCPR, tempName, tempAge, tempActive, tempElite, tempCrawl, tempButterfly,
                    tempBryst, tempFri, tempJunior, tempSeniorDisc, tempPrice));

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
        String tempNavn;
        String tempDate;
        int tempTime;

        while(lineScanner.hasNext()){
            tempCpr = lineScanner.next();
            tempNavn = lineScanner.next();
            tempDate = lineScanner.next();
            tempTime = lineScanner.nextInt();

            times.add(new Times(tempCpr, tempNavn, tempDate, tempTime));
        }
    }
}
