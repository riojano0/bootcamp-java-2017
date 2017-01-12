package classes;

import utils.DateAdapter;

import java.util.Date;
import java.util.HashMap;

public class ForecastExtended {

    Date date;
    int day;
    int tempMin;
    int tempMax;
    String description;

    private static final HashMap<Integer,String> days;
    static {
        days = new HashMap<Integer,String>();
        days.put(1,"Sunday");
        days.put(2,"Monday");
        days.put(3,"Tuesday");
        days.put(4,"Wednesday");
        days.put(5,"Thursday");
        days.put(6,"Friday");
        days.put(7,"Saturday");
    }

    public ForecastExtended() {
    }

    public ForecastExtended(Date date, int day, int tempMin, int tempMax, String description) {

        this.date = date;
        this.day = day;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.description = description;
    }

    public String forecastExtendedToString(){
        return String.format("Date: %s Day: %s Temp Min: %s °C Temp Max: %s °C Description: %s",
                DateAdapter.dateDeformat(date),
                dayToString(),
                tempMin,
                tempMax,
                description
                );
    }

    public String dayToString(){
        return days.get(day);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
