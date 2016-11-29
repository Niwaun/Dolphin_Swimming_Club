package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Swimmer {
    private String cpr;
    private String name;
    private int age;

    public Swimmer() {
        setName();
        setAge();
    }

    public Swimmer(String cpr, String name, int age){

        this.cpr = cpr;
        this.name = name;
        this.age = age;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr() {
        Scanner input = new Scanner(System.in);

        System.out.println("Hvad er svømmerens CPR nr?");
        while (input.hasNext()){
            if(Pattern.matches("[a-zA-Z]+", input.nextLine()) == false && input.nextLine().length() == 10){

            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        Scanner input = new Scanner(System.in);

        System.out.println("Hvor gammel er svømmeren?");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Fejl! Skriv et tal");
            System.out.println("Hvor gammel er svømmeren?");
        }
        age = input.nextInt();
        while (age < 1){
            System.out.println("Fejl! Skriv et tal over 0");
            while (!input.hasNextInt()){
                input.next();
                System.out.println("Fejl! Skriv et tal");
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
        while (input.hasNextInt()){
            input.next();
            System.out.println("Fejl! Skriv et navn");
            System.out.println("Hvad er svømmerens navn?");
        }
        name = input.next();
    }
}
