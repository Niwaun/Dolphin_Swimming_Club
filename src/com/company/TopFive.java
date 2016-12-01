package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Anders on 30-Nov-16.
 */
public class TopFive {

    public static void sortTimes(ArrayList<Membership> members, ArrayList<Times> times) {

        ArrayList<Integer> timeArray = new ArrayList<>();

        for (int i = 0; i < times.size(); i++) {
            timeArray.add(times.get(i).getTime());
        }

        String snr = "NR", sname = "NAME", stime = "TIME";
        System.out.printf("%-3s%-16s%-8s\n", snr, sname, stime);

        Collections.sort(timeArray);
        for (int i = 0; i < 5; i++) {


            int place = i+1;
            String name = members.get(i).getName();
            int time = timeArray.get(i);

            System.out.printf("%-3d%-16s%-8d\n", place, name, time);
        }
    }
}







//        Collections.sort(crawlTidArray);
//        crawlTidArray.subList(5,(crawlTidArray.size())).clear();
//        System.out.println("De 5 hurtigste tider i crawl er: ");
//        System.out.println("Tid\tNavn");
//        for (int i = 0; i < crawlTidArray.size(); i++) {
//            int x = crawlTidArray.get(i);
//            for (int j = 0; j < members.size(); j++) {
//                if(x == members.get(j).getCrawlTid()){
//                    String cpr = members.get(j).getCpr();
//                    for (int k = 0; k < members.size(); k++) {
//                        if (cpr.equals(members.get(k).getCpr())){
//                            System.out.println(x + "\t" + members.get(k).getName());
//                        }
//                    }
//                }
//            }
//        }
//    }

//    public static void butterflyTidSorter(ArrayList<Times> times, ArrayList<Membership> members){
//
//        ArrayList<Integer> butterflyTidArray = new ArrayList<>();
//
//        for (int i = 0; i < times.size(); i++) {
//            if(times.get(i).isButterfly() == true){
//                butterflyTidArray.add(times.get(i).getButterflyTid());
//            }
//        }
//        Collections.sort(butterflyTidArray);
//        butterflyTidArray.subList(5,(butterflyTidArray.size())).clear();
//        System.out.println("De 5 hurtigste tider i butterfly er: ");
//        System.out.println("Tid\tNavn");
//        for (int i = 0; i < butterflyTidArray.size(); i++) {
//            int x = butterflyTidArray.get(i);
//            for (int j = 0; j < times.size(); j++) {
//                if(x == times.get(j).getButterflyTid()){
//                    String cpr = times.get(j).getCpr();
//                    for (int k = 0; k < members.size(); k++) {
//                        if (cpr.equals(members.get(k).getCpr())){
//                            System.out.println(x + "\t" + members.get(k).getName());
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public static void brystTidSorter(ArrayList<Times> times, ArrayList<Membership> members){
//
//        ArrayList<Integer> brystTidArray = new ArrayList<>();
//
//        for (int i = 0; i < times.size(); i++) {
//            if(times.get(i).isBryst() == true){
//                brystTidArray.add(times.get(i).getBrystTid());
//            }
//        }
//        Collections.sort(brystTidArray);
//        brystTidArray.subList(5,(brystTidArray.size())).clear();
//        System.out.println("De 5 hurtigste tider i bryst er: ");
//        System.out.println("Tid\tNavn");
//        for (int i = 0; i < brystTidArray.size(); i++) {
//            int x = brystTidArray.get(i);
//            for (int j = 0; j < times.size(); j++) {
//                if(x == times.get(j).getBrystTid()){
//                    String cpr = times.get(j).getCpr();
//                    for (int k = 0; k < members.size(); k++) {
//                        if (cpr.equals(members.get(k).getCpr())){
//                            System.out.println(x + "\t" + members.get(k).getName());
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public static void friTidSorter(ArrayList<Times> times, ArrayList<Membership> members){
//
//        ArrayList<Integer> friTidArray = new ArrayList<>();
//
//        for (int i = 0; i < times.size(); i++) {
//            if(times.get(i).isFri() == true){
//                friTidArray.add(times.get(i).getFriTid());
//            }
//        }
//        Collections.sort(friTidArray);
//        friTidArray.subList(5,(friTidArray.size())).clear();
//        System.out.println("De 5 hurtigste tider i fri er: ");
//        System.out.println("Tid\tNavn");
//        for (int i = 0; i < friTidArray.size(); i++) {
//            int x = friTidArray.get(i);
//            for (int j = 0; j < times.size(); j++) {
//                if(x == times.get(j).getFriTid()){
//                    String cpr = times.get(j).getCpr();
//                    for (int k = 0; k < members.size(); k++) {
//                        if (cpr.equals(members.get(k).getCpr())){
//                            System.out.println(x + "\t" + members.get(k).getName());
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
