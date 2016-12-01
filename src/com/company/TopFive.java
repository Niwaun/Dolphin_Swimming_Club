package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Anders on 30-Nov-16.
 */
public class TopFive {

    public static void sortTimes(ArrayList<Times> times) {

        ArrayList<Integer> timeArray = new ArrayList<>();

        for (int i = 0; i < times.size(); i++) {
            timeArray.add(times.get(i).getTime());
        }

        String snr = "NR", sname = "NAME", stime = "TIME(s)";
        System.out.printf("De 5 hurtigste tider er:\n%-3s%-16s%-8s\n", snr, sname, stime);

        Collections.sort(timeArray);
        timeArray.subList(5, (timeArray.size())).clear();
        for (int i = 0; i < timeArray.size(); i++) {
            int time = timeArray.get(i);
            for (int j = 0; j < times.size(); j++) {
                if (time == times.get(j).getTime()) {
                    String name = times.get(j).getName();

                    System.out.printf("%-3d%-16s%-8d\n", i+1, name, time);

                }
            }
        }
    }
}
