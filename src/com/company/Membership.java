package com.company;

import java.text.ParseException;
import java.util.*;

public class Membership extends Swimmer {
    private boolean active;
    private boolean elite;
    private boolean junior;
    private boolean seniorDiscount;

    private boolean crawl = false;
    private boolean butterfly = false;
    private boolean bryst = false;
    private boolean fri = false;

    private int price;
    private String join;

    public Membership(ArrayList<Membership> members) throws ParseException{
        super(members);
        setActive();
        if (active == true) {
            setElite();
            if(elite == true){
                chooseDisciplin();
            }
        }
        setJunior();
        setSeniorDiscount();
        setPrice();
        setJoin();
    }

    public Membership(String cpr, String name, int age, String date, boolean active, boolean elite, boolean crawl, boolean butterfly,
                      boolean bryst, boolean fri, boolean junior, boolean disc, int price)throws ParseException{

        super(cpr, name, age);
        this.join = date;
        this.active = active;
        this.elite = elite;
        this.crawl = crawl;
        this.butterfly = butterfly;
        this.bryst = bryst;
        this.fri = fri;
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
                case "trænings":
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

    public String getJoin() {
        return join;
    }

    public void setJoin() throws ParseException{
        DateCalc dateCalc = new DateCalc();
        this.join = dateCalc.dateToString(dateCalc.today());
    }

    public void chooseDisciplin(){
        Scanner input = new Scanner(System.in);

        boolean quit = false;
        boolean runChoose = true;
        String ans = "";

        do {

            while(runChoose) {
                System.out.println("Hvilken disciplin er svømmeren aktiv i?");
                System.out.println("1. Crawl\n2. Butterfly\n3. Bryst\n4. Fri");
                ans = input.next().toLowerCase();

                switch (ans) {
                    case "crawl":
                        this.crawl = true;
                        runChoose = false;
                        break;

                    case "butterfly":
                        this.butterfly = true;
                        runChoose = false;
                        break;

                    case "bryst":
                        this.bryst = true;
                        runChoose = false;
                        break;

                    case "fri":
                        this.fri = true;
                        runChoose = false;
                        break;

                    default:
                        System.out.println("Der opstod en fejl. Prøv igen.\nIndtast navnet på disciplinen, tak.");
                        break;
                }
            }
            System.out.println("Vil du tilføje flere discipliner?");
            ans = input.next().toLowerCase();
            switch(ans){
                case "ja":
                    quit = true;
                    runChoose = true;
                    break;
                case "nej":
                    quit = false;
                    break;
                default:
                    System.out.println("Der opstod en fejl. Prøv igen.\nSvar venligst med \"ja\" eller \"nej.\"");
            }
        } while(quit);
    }


    public boolean isCrawl() {
        return crawl;
    }

    public boolean isButterfly() {
        return butterfly;
    }

    public boolean isBryst() {
        return bryst;
    }

    public boolean isFri() {
        return fri;
    }


}
