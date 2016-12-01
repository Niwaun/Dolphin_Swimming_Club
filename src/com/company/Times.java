package com.company;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;


public class Times extends CPR{

    private String name;
    private String date;
    private int time;

    public Times(ArrayList<Times> times, String name, String cpr) throws ParseException {
        addTimeToDiscipline(times);
        setName(name);
        setCpr(cpr);
        setDate();
    }

    public Times() throws ParseException{

    }

    public Times(String cpr, String name, String date, int time) throws ParseException{

        super(cpr);

        this.name = name;
        this.date = date;
        this.time = time;

    }

    Scanner input = new Scanner(System.in);

    public int getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void addTimeToDiscipline(ArrayList<Times> times) throws ParseException {

        System.out.println("Hvad var svømmerens tid? (i sekunder)");
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
            System.out.println("Hvad var svømmerens tid? (i sekunder");
        }
        time = input.nextInt();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate() throws ParseException {
        DateCalc dateCalc = new DateCalc();
        this.date = dateCalc.dateToString(dateCalc.today());
    }

    //        do {
//            System.out.println("Inden for hvilken disciplin har svømmeren fået en tid?");
//            String ans = input.nextLine().toLowerCase();
//
//            switch (ans) {
//                case "crawl":
//                    System.out.println("Hvad var svømmerens tid? (i sekunder)");
//                    while (!input.hasNextInt()) {
//                        input.next();
//                        System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
//                        System.out.println("Hvad var svømmerens tid? (i sekunder");
//                    }
//                    time = input.nextInt();
//                    crawl.add(new Times(time));
//
//                    break;
//
//                case "butterfly":
//                    System.out.println("Hvad var svømmerens tid? (i sekunder)");
//                    while (!input.hasNextInt()) {
//                        input.next();
//                        System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
//                        System.out.println("Hvad var svømmerens tid? (i sekunder");
//                    }
//                    time = input.nextInt();
//                    butterfly.add(new Times(time));
//
//                    break;
//
//                case "bryst":
//                    System.out.println("Hvad var svømmerens tid? (i sekunder)");
//                    while (!input.hasNextInt()) {
//                        input.next();
//                        System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
//                        System.out.println("Hvad var svømmerens tid? (i sekunder");
//                    }
//                    time = input.nextInt();
//                    bryst.add(new Times(time));
//
//                    break;
//
//                case "fri":
//                    System.out.println("Hvad var svømmerens tid? (i sekunder)");
//                    while (!input.hasNextInt()) {
//                        input.next();
//                        System.out.println("Der opstod en fejl.\nPrøv igen. Husk at skrive hele tal i sekunder");
//                        System.out.println("Hvad var svømmerens tid? (i sekunder");
//                    }
//                    time = input.nextInt();
//                    fri.add(new Times(time));
//
//                    break;
//
//                default:
//                    System.out.println("Fejl. Prøv igen");
//                    break;
//            }
//
//            System.out.println("Vil du tilføje flere discipliner?");
//            ans = input.nextLine().toLowerCase();
//            switch(ans){
//                case "ja":
//                    break;
//                case "nej":
//                    return;
//                default:
//                    System.out.println("Der opstod en fejl. Prøv igen.\nSvar venligst med \"ja\" eller \"nej.\"");
//            }
//        } while (true);

}
