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
        String tempDate;

        int tempAge;
        int tempPrice;

        boolean tempActive;
        boolean tempElite;
        boolean tempJunior;
        boolean tempSeniorDisc;

        boolean tempCrawl;
        boolean tempButterfly;
        boolean tempBryst;
        boolean tempFri;



        while(lineScanner.hasNext()){

            tempCPR = lineScanner.next();
            tempName = lineScanner.next();
            tempAge = lineScanner.nextInt();
            tempDate = lineScanner.next();
            tempActive = lineScanner.nextBoolean();
            tempElite = lineScanner.nextBoolean();
            tempCrawl = lineScanner.nextBoolean();
            tempButterfly = lineScanner.nextBoolean();
            tempBryst = lineScanner.nextBoolean();
            tempFri = lineScanner.nextBoolean();
            tempJunior = lineScanner.nextBoolean();
            tempSeniorDisc = lineScanner.nextBoolean();
            tempPrice = lineScanner.nextInt();

            members.add(new Membership(tempCPR, tempName, tempAge, tempDate, tempActive, tempElite, tempCrawl, tempButterfly,
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
        String tempName;
        String tempDate;
        int tempTime;

        while(lineScanner.hasNext()){
            tempCpr = lineScanner.next();
            tempName = lineScanner.next();
            tempDate = lineScanner.next();
            tempTime = lineScanner.nextInt();

            times.add(new Times(tempCpr, tempName, tempDate, tempTime));
        }
    }

    public void readUsersFile(ArrayList<User> users) throws IOException{
        Scanner input = new Scanner(new File(fileName));
        input.nextLine();
        while (input.hasNextLine()){
            String text = input.nextLine();
            readUserLine(text,users);
        }
    }

    public void readUserLine(String text, ArrayList<User> users) throws IOException{
        Scanner lineScanner = new Scanner(text);

        String tempName;
        String tempUsername;
        String tempPassword;
        String tempRole;

        while(lineScanner.hasNext()){
            tempName = lineScanner.next();
            tempUsername = lineScanner.next();
            tempPassword = lineScanner.next();
            tempRole = lineScanner.next();

            users.add(new User(tempName,tempUsername,tempPassword,tempRole));
        }
    }
}
