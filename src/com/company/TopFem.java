package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Anders on 30-Nov-16.
 */
public class TopFem {

    public static void crawlTidSorter(ArrayList<Times> times){

        ArrayList<Integer> crawlTidArray = new ArrayList<>();

        for (int i = 0; i < times.size(); i++) {
            if(times.get(i).isCrawl() == true){
                crawlTidArray.add(times.get(i).getCrawlTid());
            }
        }
        Collections.sort(crawlTidArray);
        System.out.println("Tid\tNavn");
        System.out.println("De 5 hurtigste tider i crawl er: ");
        for (int i = 0; i < crawlTidArray.size(); i++) {
            int x = crawlTidArray.get(i);
            for (int j = 0; j < times.size(); j++) {
                if(x == times.get(j).getCrawlTid()){
                    System.out.println(x + "\t" + times.get(j).getName());
                }
            }
        }
    }

    public static void butterflyTidSorter(ArrayList<Times> times){

        ArrayList<Integer> butterflyTidArray = new ArrayList<>();

        for (int i = 0; i < times.size(); i++) {
            if(times.get(i).isButterfly() == true){
                butterflyTidArray.add(times.get(i).getButterflyTid());
            }
        }
        Collections.sort(butterflyTidArray);
        System.out.println("Tid\tNavn");
        System.out.println("De 5 hurtigste tider i butterfly er: ");
        for (int i = 0; i < butterflyTidArray.size(); i++) {
            int x = butterflyTidArray.get(i);
            for (int j = 0; j < times.size(); j++) {
                if(x == times.get(j).getButterflyTid()){
                    System.out.println(x + "\t" + times.get(j).getName());
                }
            }
        }
    }

    public static void brystTidSorter(ArrayList<Times> times){

        ArrayList<Integer> brystTidArray = new ArrayList<>();

        for (int i = 0; i < times.size(); i++) {
            if(times.get(i).isBryst() == true){
                brystTidArray.add(times.get(i).getBrystTid());
            }
        }
        Collections.sort(brystTidArray);
        System.out.println("Tid\tNavn");
        System.out.println("De 5 hurtigste tider i bryst er: ");
        for (int i = 0; i < brystTidArray.size(); i++) {
            int x = brystTidArray.get(i);
            for (int j = 0; j < times.size(); j++) {
                if(x == times.get(j).getBrystTid()){
                    System.out.println(x + "\t" + times.get(j).getName());
                }
            }
        }
    }

    public static void friTidSorter(ArrayList<Times> times){

        ArrayList<Integer> friTidArray = new ArrayList<>();

        for (int i = 0; i < times.size(); i++) {
            if(times.get(i).isFri() == true){
                friTidArray.add(times.get(i).getFriTid());
            }
        }
        Collections.sort(friTidArray);
        System.out.println("De 5 hurtigste tider i fri er: ");
        System.out.println("Tid\tNavn");
        for (int i = 0; i < friTidArray.size(); i++) {
            int x = friTidArray.get(i);
            for (int j = 0; j < times.size(); j++) {
                if(x == times.get(j).getFriTid()){
                    System.out.println(x + "\t" + times.get(j).getName());
                }
            }
        }
    }

}
