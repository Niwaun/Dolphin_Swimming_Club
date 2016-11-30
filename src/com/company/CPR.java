package com.company;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Niwaun on 30-11-2016.
 */
public class CPR {
    private String cpr;

    public CPR() throws ParseException{
        setCpr();
    }

    public CPR(String cpr) {
        this.cpr = cpr;
    }

    public String getCpr() {

        return cpr;
    }

    public void setCpr() {
        Scanner input = new Scanner(System.in);

        System.out.println("Hvad er svømmerens CPR nr?");
        while (input.hasNext()){
            cpr = input.nextLine();
            if(Pattern.matches("[a-zA-Z]+", cpr) && cpr.length() != 10){
                System.out.println("Fejl! Det indtastede er ikke et gyldigt CPR");
                System.out.println("Hvad er svømmerens CPR nr?");
            } else
                break;
        }
        this.cpr = cpr.substring(0,6) + '-' + cpr.substring(6,10);
    }
}
