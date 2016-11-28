package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <Membership> members = new ArrayList<>();
        ArrayList <User> users = new ArrayList<>();
//        System.out.println("Velkommen til Dolphin Swimming Club");
//        System.out.println("Username: ");
//        System.out.println("Password: ");
        createMember(members);
        saveToFile(members);
//        for (Membership p: members) {
//            System.out.println(p.getId());
//        }

    }

    public static void createMember(ArrayList <Membership> member){
        Scanner input = new Scanner(System.in);
        System.out.println("Hvor mange svømmere skal oprettes?");
        int answer = input.nextInt();
        for (int i = 0; i < answer; i++) {
            member.add(new Membership());
            member.get(i).setId(member);
        }
    }

    public static void saveToFile(ArrayList <Membership> member){
            for (int i = 0; i < member.size(); i++){
                System.out.println("Id: " + member.get(i).getId());
                System.out.println("Name: " + member.get(i).getName());
                System.out.println("Age: " + member.get(i).getAge());
                System.out.println("Active: " + member.get(i).isActive());
                System.out.println("Elite: " + member.get(i).isElite());
                System.out.println("Junior: " + member.get(i).isJunior());
                System.out.println("Discount: " + member.get(i).isSeniorDiscount());
                System.out.println("Price: " + member.get(i).getPrice());
                System.out.println();
            }
    }
}
