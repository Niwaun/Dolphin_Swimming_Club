package com.company;

import java.io.*;
import java.util.*;

/**
 * Created by Anders on 29-Nov-16.
 */
public class FileReader {

    private String fileName;

    public FileReader(String fileName) throws IOException{
        this.fileName = fileName;
    }

    public void readFile(ArrayList<Membership> members) throws IOException {

        Scanner input = new Scanner(new File(fileName));
        input.nextLine();
        while(input.hasNextLine()){
            String text = input.nextLine();
            readLine(text, members);
        }
    }

    public void readLine(String text, ArrayList<Membership> members)throws IOException{

        Scanner lineScanner = new Scanner(text);
        int tempID;
        String tempName;
        int tempAge;
        boolean tempActive;
        boolean tempElite;
        boolean tempJunior;
        boolean tempSeniorDisc;
        int tempPrice;


        while(lineScanner.hasNext()){

            tempID = lineScanner.nextInt();
            tempName = lineScanner.next();
            tempAge = lineScanner.nextInt();
            tempActive = lineScanner.nextBoolean();
            tempElite = lineScanner.nextBoolean();
            tempJunior = lineScanner.nextBoolean();
            tempSeniorDisc = lineScanner.nextBoolean();
            tempPrice = lineScanner.nextInt();

            members.add(new Membership(tempID, tempName, tempAge, tempActive, tempElite, tempJunior, tempSeniorDisc, tempPrice));

        }
    }
}
