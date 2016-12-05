package com.company;

import java.io.IOException;
import java.lang.reflect.Member;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Niwaun on 30-11-2016.
 */
public class CPR {
    private String cpr;

    public CPR() throws ParseException{
//        setCpr();
    }

    public CPR(String cpr) {
        this.cpr = cpr;
    }

    public String getCpr() {

        return cpr;
    }

    public void setCpr(ArrayList<Membership> members) {
        Scanner input = new Scanner(System.in);

        boolean runCpr = true;
        boolean runCpr2 = true;
        String tempCpr = "";
        do {
            while(runCpr2){
                System.out.println("Hvad er medlemmets CPR nr?");

                cpr = input.next();

                if(cpr.length() != 10){
                    if (Pattern.matches("[a-zA-Z]+", cpr) ) {
                        System.out.println("Fejl! Det indtastede er ikke et gyldigt CPR");
                    } else {
                        System.out.println("Fejl! Det indtastede er ikke et gyldigt CPR");
                    }
                } else if(Pattern.matches("[a-zA-Z]+", cpr)) {
                    System.out.println("Fejl! Det indtastede er ikke et gyldigt CPR");
                } else {
                    int day = Integer.parseInt(cpr.substring(0,2));
                    int mounth = Integer.parseInt(cpr.substring(2,4));
                    if (day > 31){
                        System.out.println("Fejl! Det indtastede er ikke et gyldigt CPR");
                    } else if (mounth > 12){
                        System.out.println("Fejl! Det indtastede er ikke et gyldigt CPR");
                    } else {
                        tempCpr = cpr.substring(0,6) + '-' + cpr.substring(6,10);
                        runCpr2 = false;
                    }
                }
            }

            boolean error = true;
            for (int i = 0; i < members.size(); i++) {
                if(tempCpr.equals(members.get(i).getCpr())){
                    System.out.println("Fejl. CPR nr findes allerede");
                    error = false;
                    runCpr2 = true;
                }
            }
            if(error){
                this.cpr = tempCpr;
                runCpr = false;
            }
        } while(runCpr);
    }

    public void setCpr(String cpr){
        this.cpr = cpr;
    }

}
