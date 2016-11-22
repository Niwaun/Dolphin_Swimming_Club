package com.company;
import java.util.Scanner;

public class Swimmer {
    private String name;
    private int id;
    private int age;
    //private String birthday;      Smidt på pause
    private String email;
    private int phoneNumber;
    private String address;



    public int getAge() {
        return age;
    }

    public void setAge() {
        Scanner input = new Scanner(System.in);

        System.out.println("Hvor gammel er du dit svin");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Prøv igen. Skriv et helt tal");
            System.out.println("Hvor gammel er du");
        }
        age = input.nextInt();
        while (age < 1){
            System.out.println("Skriv et tal over 0");
            while (!input.hasNextInt()){
                input.next();
                System.out.println("Prøv igen. Skriv et helt tal");
                System.out.println("Hvor gammel er du");
            }
            age = input.nextInt();
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast telefonnummer");
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Det indtastede er ikke et gyldigt telefonnummer");
            System.out.println("Prøv igen");
        }
        phoneNumber = input.nextInt();
        while (phoneNumber < 9999999 || phoneNumber > 100000000){
            System.out.println("Det indtastede er ikke et gyldigt telefonnummer");
            System.out.println("Prøv igen");
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Det indtastede er ikke et gyldigt telefonnummer");
                System.out.println("Prøv igen");
            }
            phoneNumber = input.nextInt();
        }
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
