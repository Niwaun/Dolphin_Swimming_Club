package com.company;

import java.util.Scanner;

public class Membership extends Swimmer {
    private boolean active = true;                                                                                      //Aktiv eller passivt
    private boolean elite = true;                                                                                       //Elite eller træning
    private boolean junior = true;                                                                                      //Junior eller senior
    private boolean seniorDiscount = true;                                                                              //Aldersrabet

    public Membership() {
        super();
        setActive();
        setElite();
        setJunior();
        setSeniorDiscount();
    }

    public boolean isElite() {
        return elite;
    }

    public void setElite() {
        Scanner input = new Scanner(System.in);
        System.out.println("Skal det være et elite eller trænings medlemsskab?");
        switch (input.next().toLowerCase()){
            case "elite":
                active = true;
                break;
            case "træning":
                active = false;
                break;
            default:
                System.out.println("Fejl");
        }
    }

    public boolean isJunior() {
        return junior;
    }

    public void setJunior() {
        if (getAge() < 18){
            junior = true;
        } else
            junior = false;
    }

    public boolean isSeniorDiscount() {
        return seniorDiscount;
    }

    public void setSeniorDiscount() {
        if (getAge() > 65){
            seniorDiscount = true;
        } else
            seniorDiscount = false;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive() {
        Scanner input = new Scanner(System.in);
        System.out.println("Skal det være et aktivt eller passivt medlemsskab?");
        switch (input.next().toLowerCase()){
            case "aktivt":
                active = true;
                break;
            case "passivt":
                active = false;
                break;
            default:
                System.out.println("Fejl");
        }
    }
}
