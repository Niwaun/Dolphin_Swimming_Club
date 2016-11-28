package com.company;

import java.io.*;
import java.util.*;

public class FileWriter{
    private String fileName;
    private PrintStream out;

    public FileWriter(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    public void saveToFile(ArrayList<Membership> members) throws IOException {

        out = new PrintStream(new File(this.fileName));

        out.print("ID\tNAVN\t\t\tALDER\tAKTIVT\tELITE\tJUNIOR\tSENIORDISCOUNT\tPRICE");
        out.println();


        for (int i = 0; i < members.size(); i++) {
            int id = members.get(i).getId();
            String name = members.get(i).getName();
            double price = members.get(i).getPrice();
            int age = members.get(i).getAge();
            boolean active = members.get(i).isActive();
            boolean elite = members.get(i).isElite();
            boolean junior = members.get(i).isJunior();
            boolean seniorDiscount = members.get(i).isSeniorDiscount();

            out.print(id + "\t" + name + "\t\t\t" + age + "\t\t" + active + "\t" + elite + "\t" + junior + "\t" + seniorDiscount + "\t\t\t" + price);
            out.println();

        }
    }

    public void readFile(ArrayList<Membership> members) throws IOException{

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
        double tempPrice;


        while(lineScanner.hasNext()){


            tempID = lineScanner.nextInt();
            tempName = lineScanner.next();
            tempAge = lineScanner.nextInt();
            tempActive = lineScanner.nextBoolean();
            tempElite = lineScanner.nextBoolean();
            tempJunior = lineScanner.nextBoolean();
            tempSeniorDisc = lineScanner.nextBoolean();
            tempPrice = lineScanner.nextDouble();

            members.add(new Membership(tempID, tempName, tempAge, tempActive, tempElite, tempJunior, tempSeniorDisc, tempPrice));

        }
    }


}
