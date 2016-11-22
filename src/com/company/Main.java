package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <Membership> member = new ArrayList<>();
        member.add(new Membership());
        member.add(new Membership());
        for (Membership liste : member) {
            System.out.println(liste);
        }
    }
}
