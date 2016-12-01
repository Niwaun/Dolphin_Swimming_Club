package com.company;

import java.util.Scanner;

public class User {
    private String name;
    private String username;
    private String password;
    private String role;

    public User() {
        setName();
        setUsername();
        setPassword();
        setRole();
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast navnet på brugeren:");
        while (input.hasNextInt()){
            input.next();
            System.out.println("Fejl! Skriv et navn");
        }
        name = input.next();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast brugernavnet:");
        username = input.next();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast kodeordet:");
        password = input.next();
    }

    public String getRole() {
        return role;
    }

    public void setRole() {
        Scanner input = new Scanner(System.in);
        System.out.println("Vælg rolle:");
        System.out.println("Admin\nTræner\nBestyrrer\nKasserer");
        do {
            switch (input.next().toLowerCase()) {
                case "admin":
                    role = "Admin";
                    return;
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
