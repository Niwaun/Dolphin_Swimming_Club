package com.company;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Niwaun on 29-11-2016.
 */
public class DateCalc {
    private LocalDate joinDate;
    private LocalDate birthDate;
    private LocalDate paymentDate;

    public DateCalc() throws ParseException{
    }

    public DateCalc(String birthday) throws ParseException{
        setBirthDate(birthday);
        setJoinDate();
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate() throws ParseException{
        this.joinDate = today();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthday) throws ParseException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        birthDate = LocalDate.parse(birthday, dtf);
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = today();
    }

    public LocalDate today(){
        LocalDate localDate = LocalDate.now();
        return localDate;
    }

    public String dateToString(LocalDate joinDate){
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dft.format(joinDate);
    }
}
