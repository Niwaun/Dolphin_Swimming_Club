package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Niwaun on 29-11-2016.
 */
public class DateCalc {
    private LocalDate joinDate;
    private LocalDate birthDate;

    public DateCalc(String birthday) throws ParseException{
        setJoinDate();
        setBirthDate(birthday);
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate() throws ParseException{
        LocalDate localDate = LocalDate.now();
        joinDate = localDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthday) throws ParseException{
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        birthDate = LocalDate.parse(birthday, dateTimeFormatter);
    }
}
