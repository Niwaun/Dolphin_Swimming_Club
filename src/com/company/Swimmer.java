package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Swimmer {
    private int id;
    private String name;
    private int age;

    public Swimmer() {
        setName();
        setAge();
    }

    public int getId() {
        return id;
    }

    public void setId(ArrayList <Membership> member) {
        id = member.size();
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        Scanner input = new Scanner(System.in);

        System.out.println("Hvor gammel er svømmeren?");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Prøv igen. Skriv et helt tal");
            System.out.println("Hvor gammel er svømmeren?");
        }
        age = input.nextInt();
        while (age < 1){
            System.out.println("Skriv et tal over 0");
            while (!input.hasNextInt()){
                input.next();
                System.out.println("Prøv igen. Skriv et helt tal");
                System.out.println("Hvor gammel er svømmeren?");
            }
            age = input.nextInt();
        }
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvad er svømmerens navn?");
        name = input.next();
    }
}
