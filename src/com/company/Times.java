package com.company;

import java.util.*;


public class Times extends Swimmer{

    public Times(){
        setBryst();
        setButterfly();
        setCrawl();
        setFri();
    }

    Scanner input = new Scanner(System.in);

    private boolean crawl = false;
    private boolean butterfly = false;
    private boolean bryst = false;
    private boolean fri = false;

    private int crawlTid = 0;       //Alle tider er i sekunder til en start
    private int butterflyTid = 0;   //Alle tider er i sekunder til en start
    private int brystTid = 0;       //Alle tider er i sekunder til en start
    private int friTid = 0;         //Alle tider er i sekunder til en start


    public boolean isCrawl() {
        return crawl;
    }

    public void setCrawl() {
        Scanner input = new Scanner(System.in);
        System.out.println("Har svømmeren svømmet crawl? ja/nej");
        String answer = input.next().toLowerCase();
        switch(answer){
            case "ja":
                this.crawl = true;
                break;
            case "nej":
                this.crawl = false;
                break;
            default:
                System.out.println("Der skete en fejl\nPrøv igen.");
                setCrawl();
        }
    }

    public boolean isButterfly() {
        return butterfly;
    }

    public void setButterfly() {
        Scanner input = new Scanner(System.in);
        System.out.println("Har svømmeren svømmet butterfly? ja/nej");
        String answer = input.next().toLowerCase();
        switch(answer){
            case "ja":
                this.butterfly = true;
                break;
            case "nej":
                this.butterfly = false;
                break;
            default:
                System.out.println("Der skete en fejl\nPrøv igen.");
                setButterfly();
        }
    }

    public boolean isBryst() {
        return bryst;
    }

    public void setBryst() {
        Scanner input = new Scanner(System.in);
        System.out.println("Har svømmeren svømmet bryst? ja/nej");
        String answer = input.next().toLowerCase();
        switch(answer){
            case "ja":
                this.bryst = true;
                break;
            case "nej":
                this.bryst = false;
                break;
            default:
                System.out.println("Der skete en fejl\nPrøv igen.");
                setBryst();
        }
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri() {
        Scanner input = new Scanner(System.in);
        System.out.println("Har svømmeren svømmet fri? ja/nej");
        String answer = input.next().toLowerCase();
        switch(answer){
            case "ja":
                this.fri = true;
                break;
            case "nej":
                this.fri = false;
                break;
            default:
                System.out.println("Der skete en fejl\nPrøv igen.");
                setFri();
        }
    }

    //Her starter getters/setter for tid
    public int getCrawlTid() {
        return crawlTid;
    }

    public void setCrawlTid(int crawlTid) {
        this.crawlTid = input.nextInt();
    }

    public int getButterflyTid() {
        return butterflyTid;
    }

    public void setButterflyTid(int butterflyTid) {
        this.butterflyTid = input.nextInt();
    }

    public int getBrystTid() {
        return brystTid;
    }

    public void setBrystTid(int brystTid) {
        this.brystTid = input.nextInt();
    }

    public int getFriTid() {
        return friTid;
    }

    public void setFriTid(int friTid) {
        this.friTid = input.nextInt();
    }
}
