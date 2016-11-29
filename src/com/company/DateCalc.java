package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Niwaun on 29-11-2016.
 */
public class DateCalc {
    private Date joinDate;
    private Date birthDate;

    public DateCalc(String join, String birthday) throws ParseException{
        setJoinDate(join);
        setBirthDate(birthday);
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String join) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
        joinDate = format.parse(join);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthday) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
        birthDate = format.parse(birthday);
    }
}
