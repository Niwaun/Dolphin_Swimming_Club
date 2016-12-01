package com.company;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Swimmer extends CPR{
    private String name;
    private int age;
    private String join;
    private String birthday;

    public Swimmer() throws ParseException{
        setBirthday();
        setAge();
        setName();
        setJoin();
    }

    public Swimmer(String cpr, String name, int age)throws ParseException{
        super(cpr);
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge() throws ParseException{
        /*Scanner input = new Scanner(System.in);

        System.out.println("Hvor gammel er svømmeren?");
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Fejl! Skriv et tal");
            System.out.println("Hvor gammel er svømmeren?");
        }
        age = input.nextInt();
        while (age < 1){
            System.out.println("Fejl! Skriv et tal over 0");
            while (!input.hasNextInt()){
                input.next();
                System.out.println("Fejl! Skriv et tal");
                System.out.println("Hvor gammel er svømmeren?");
            }
            age = input.nextInt();
        }*/
        DateCalc dateCalc = new DateCalc(this.birthday);
        try {
            long years = ChronoUnit.YEARS.between(dateCalc.getBirthDate(),dateCalc.getJoinDate());
            this.age = (int) years;
        } catch (Exception e){
            System.out.println("Fejl! Det indtastede er ikke et gyldigt CPR");
            setCpr();
            setAge();
        }
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hvad er svømmerens navn?");
        while (input.hasNextInt()){
            input.next();
            System.out.println("Fejl! Skriv et navn");
            System.out.println("Hvad er svømmerens navn?");
        }
        name = input.next();
    }

    public String getJoin() {
        return join;
    }

    public void setJoin() throws ParseException{
        DateCalc dateCalc = new DateCalc();
        dateCalc.setJoinDate();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday() throws ParseException{
        int year = Integer.parseInt(getCpr().substring(4,6));
        if (year >= 16){
            this.birthday = getCpr().substring(0,2) + '/' + getCpr().substring(2,4) + "/19" + getCpr().substring(4,6);
        }else
            this.birthday = getCpr().substring(0,2) + '/' + getCpr().substring(2,4) + "/20" + getCpr().substring(4,6);
    }
}
