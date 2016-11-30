package com.company;

import java.text.ParseException;
import java.util.*;


public class Times extends CPR{

    public Times() throws ParseException{
        Scanner input = new Scanner(System.in);

        boolean quit = true;

        while(quit){

            System.out.println("Hvilken disciplin?");
            System.out.println("1. Crawl\n2. Butterfly\n3. Bryst\n4. Fri\nTryk q for at afslutte");
            String ans = input.nextLine().toLowerCase();

            switch(ans){
                case "crawl":
                    this.crawl = true;
                    setCrawlTid();
                    break;

                case "butterfly":
                    this.butterfly = true;
                    setButterflyTid();
                    break;

                case "bryst":
                    this.bryst = true;
                    setBrystTid();
                    break;

                case "fri":
                    this.fri = true;
                    setFriTid();
                    break;

                case "q":
                    quit = false;
                    break;

                default:
                    System.out.println("Der opstod en fejl. Prøv igen.\nIndtast navnet på disciplinen, tak.");

            }
        }
    }

    public Times(String cpr, boolean crawl, int ctid, boolean butterfly, int btid, boolean bryst, int brtid, boolean fri, int ftid) throws ParseException{
        super(cpr);
        this.crawl = crawl;
        this.butterfly = butterfly;
        this.bryst = bryst;
        this.fri = fri;
        this.crawlTid = ctid;
        this.butterflyTid = btid;
        this.brystTid = brtid;
        this.friTid = ftid;
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


    public boolean isButterfly() {
        return butterfly;
    }

    public boolean isBryst() {
        return bryst;
    }

    public boolean isFri() {
        return fri;
    }

    //Her starter getters/setter for tid
    public int getCrawlTid() {
        return crawlTid;
    }

    public void setCrawlTid() {

        Scanner input = new Scanner(System.in);
        System.out.println("Hvad var svømmerens tid? (i sekunder)");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
            System.out.println("Hvad var svømmerens tid? (i sekunder");
        }

        this.crawlTid = input.nextInt();
    }

    public int getButterflyTid() {
        return butterflyTid;
    }

    public void setButterflyTid() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvad var svømmerens tid? (i sekunder)");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
            System.out.println("Hvad var svømmerens tid? (i sekunder");
        }
        this.butterflyTid = input.nextInt();
    }

    public int getBrystTid() {
        return brystTid;
    }

    public void setBrystTid() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvad var svømmerens tid? (i sekunder)");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
            System.out.println("Hvad var svømmerens tid? (i sekunder");
        }
        this.brystTid = input.nextInt();
    }

    public int getFriTid() {
        return friTid;
    }

    public void setFriTid() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvad var svømmerens tid? (i sekunder)");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
            System.out.println("Hvad var svømmerens tid? (i sekunder");
        }
        this.friTid = input.nextInt();
    }
}
