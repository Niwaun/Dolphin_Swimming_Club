package com.company;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String role;

    public User() {
        setUsername();
        setPassword();
        setRole();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvad er brugernavnet?");
        username = input.next();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvad er kodeordet?");
        password = input.next();
    }

    public String getRole() {
        return role;
    }

    public void setRole() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvilken rolle skal brugeren have?");
        System.out.println("1. Træner/n2. Bestyrrer/n3. Kasserer");
        do {
            switch (input.nextLine().toLowerCase()) {
                case "træner":
                    role = "Coach";
                    return;
                case "bestyrrer":
                    role = "Chairmain";
                    return;
                case "kasserer":
                    role = "Treasurer";
                    return;
                default:
                    System.out.println("Fejl i indtastning");
                    System.out.println("Prøv igen");
            }
        }while (true);
    }
}
