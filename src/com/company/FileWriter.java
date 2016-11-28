package com.company;

import java.io.*;
import java.util.*;

public class FileWriter {
    private String fileName;
    private PrintStream out;

    public FileWriter(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        out = new PrintStream(new File(this.fileName));
    }

    public void saveToFile(ArrayList<Membership> members){

        out.print("ID\tNAVN\tALDER\tAKTIVT\tELITE\tJUNIOR\tSENIORDISCOUNT\tPRICE");
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

            out.print(id + "\t" + name + "\t" + age + "\t\t" + active + "\t" + elite + "\t" + junior + "\t" + seniorDiscount + "\t\t\t" + price);
            out.println();

        }
    }
}
