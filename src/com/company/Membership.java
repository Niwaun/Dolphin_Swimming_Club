package com.company;

import java.util.Scanner;

public class Membership extends Swimmer {
    private boolean active;
    private boolean elite;
    private boolean junior;
    private boolean seniorDiscount;
    private double dPrice;
    private int price;

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

    public Membership(int id, String name, int age, boolean active, boolean elite, boolean junior, boolean disc, int price){

        super(id, name, age);
        this.active = active;
        this.elite = elite;
        this.junior = junior;
        this.seniorDiscount = disc;
        this.price = price;


    }

    public int getPrice() {
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
            price = (int) (price - (price * 0.25));
        }
    }

    public boolean isElite() {

        return elite;
    }

    public void setElite() {
        Scanner input = new Scanner(System.in);
        System.out.println("Skal det være et Elite eller Trænings medlemsskab?");
        do {
            switch (input.nextLine().toLowerCase()) {
                case "elite":
                    elite = true;
                    return;
                case "træning":
                    elite = false;
                    return;
                default:
                    System.out.println("Fejl! Vælg enten træning eller elite.");
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
        System.out.println("Skal det være et Aktivt eller Passivt medlemsskab?");
        do {
            switch (input.nextLine().toLowerCase()) {
                case "aktivt":
                    active = true;
                    return;
                case "passivt":
                    active = false;
                    return;
                default:
                    System.out.println("Fejl! Vælg enten Aktivt eller Passivt.");
            }
        }while (true);
    }

    public void setFromFile(){


    }
}
