package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(System.in);
        ArrayList <Membership> members = new ArrayList<>();
        FileWriter fw = new FileWriter("virkerdet.txt");
        fw.readFile(members);
        createMember(members, members.size());
        fw.saveToFile(members);


//        ArrayList <User> users = new ArrayList<>();
//        System.out.println("Velkommen til Dolphin Swimming Club");
//        System.out.println("Username: ");
//        System.out.println("Password: ");
//        while (true) {
//            createMember(members, members.size());
//            createUser(users);
            saveSwimmerToFile(members);
//            saveUserToFile(users);
//            System.out.println("quit?");
//            switch (input.nextLine().toLowerCase()){
//                case "yes":
//                    return;
//                default:
//                    break;
//            }
//        }
    }

    public static void createMember(ArrayList <Membership> member, int i){
        member.add(new Membership());
        member.get(i).setId(member);
    }

    public static void createUser(ArrayList <User> users){
        users.add(new User());
    }

    public static void saveSwimmerToFile(ArrayList <Membership> member){
            for (int i = 0; i < member.size(); i++){
                System.out.println("Id:         " + member.get(i).getId());
                System.out.println("Name:       " + member.get(i).getName());
                System.out.println("Age:        " + member.get(i).getAge());
                System.out.println("Active:     " + member.get(i).isActive());
                System.out.println("Elite:      " + member.get(i).isElite());
                System.out.println("Junior:     " + member.get(i).isJunior());
                System.out.println("Discount:   " + member.get(i).isSeniorDiscount());
                System.out.println("Price:      " + member.get(i).getPrice());
                System.out.println("");
            }
    }

    public static void saveUserToFile(ArrayList <User> users){
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username:   " + users.get(i).getUsername());
            System.out.println("Password:   " + users.get(i).getPassword());
            System.out.println("Role:       " + users.get(i).getRole());
            System.out.println("");
        }
    }
}
