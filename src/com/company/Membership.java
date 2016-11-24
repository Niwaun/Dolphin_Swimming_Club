package com.company;

import java.util.Scanner;

public class Membership extends Swimmer {
    private boolean active;
    private boolean elite;
    private boolean junior;
    private boolean seniorDiscount;
    private double price;

    public Membership() {
        super();
        setActive();
        if (active == true) {
            setElite();
        }
        setJunior();
        setSeniorDiscount();
        setPrice();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        if (active == true){
            if (junior == true){
                price = 1000;
            }else if (junior == false){
                price = 1600;
            }
        }else
            price = 500;

        if (seniorDiscount == true){
            price = price - (price * 0.25);
        }
    }

    public boolean isElite() {
        return elite;
    }

    public void setElite() {
        Scanner input = new Scanner(System.in);
        System.out.println("Skal det være et elite eller trænings medlemsskab?");
        do {
            switch (input.nextLine().toLowerCase()) {
                case "elite":
                    active = true;
                    return;
                case "træning":
                    active = false;
                    return;
                default:
                    System.out.println("Fejl i indtastning");
                    System.out.println("Prøv igen");
            }
        }while (true);
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
        if (getAge() > 60){
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
        do {
            switch (input.nextLine().toLowerCase()) {
                case "aktivt":
                    active = true;
                    return;
                case "passivt":
                    active = false;
                    return;
                default:
                    System.out.println("Fejl i indtastning");
                    System.out.println("Prøv igen");
            }
        }while (true);
    }
}