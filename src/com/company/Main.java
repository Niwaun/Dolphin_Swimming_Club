package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <Membership> members = new ArrayList<>();
        ArrayList <User> users = new ArrayList<>();
        System.out.println("Velkommen til Dolphin Swimming Club");
        System.out.println("Username: ");
        System.out.println("Password: ");
    }

    public static void createMember(ArrayList member){
        Scanner input = new Scanner(System.in);
        System.out.println("Hvor mange svømmere skal oprettes?");
        int answer = input.nextInt();
        for (int i = 0; i < answer; i++) {
            member.add(new Membership());
        }
    }
}
