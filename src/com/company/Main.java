package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <Membership> member = new ArrayList<>();

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
