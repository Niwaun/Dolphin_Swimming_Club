package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(System.in);
        ArrayList <Membership> members = new ArrayList<>();
        FileWriter fw = new FileWriter("virkerdet.txt");
        FileReader fr = new FileReader("virkerdet.txt");
        fr.readFile(members);
        createMember(members);
        fw.saveMemberToFile(members);



//        ArrayList <User> users = new ArrayList<>();
//        System.out.println("Velkommen til Dolphin Swimming Club");
//        System.out.println("Username: ");
//        System.out.println("Password: ");
//        while (true) {
//            createMember(members, members.size());
//            createUser(users);
            printSwimmerInfo(members);
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

    public static void createMember(ArrayList <Membership> member){
        member.add(new Membership());
    }

    public static void createUser(ArrayList <User> users){
        users.add(new User());
    }

    public static void printSwimmerInfo(ArrayList <Membership> member){
            for (int i = 0; i < member.size(); i++){
                System.out.println("Id:         " + member.get(i).getCpr());
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

    public static void printUserInfo(ArrayList <User> users){
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username:   " + users.get(i).getUsername());
            System.out.println("Password:   " + users.get(i).getPassword());
            System.out.println("Role:       " + users.get(i).getRole());
            System.out.println("");
        }
    }
}
