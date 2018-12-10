package com.ja.getdevicelocation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class DailyWeather {

    private double temMin;
    private String city;
    private double temMax;
    private String discript;
    private double humid;
    private double pressure;
    private Calendar cal;


    public DailyWeather(String city,double temMin,double temMax,String discript, double pressure, double humid, Calendar cal) {
        this.temMin=temMin;
        this.city=city;
        this.temMax=temMax;
        this.discript=discript;
        this.pressure=pressure;
        this.humid=humid;
        this.cal=cal;


    }



    public double getTemMin() {
        return temMin;
    }

    public double getTemMax() {
        return temMax;
    }

    public String getCity() {
        return city;
    }

    public String getDiscription() {
        return discript;
    }

    public double getHumid() {
        return humid;
    }

    public double getPressure() {
        return pressure;
    }

    public Calendar getCal(){
        return cal;
    }

    public void setCal(Calendar cal){
        this.cal=cal;
    }
}

