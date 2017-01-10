package classes;

import utils.DateAdapter;

import java.util.Date;

public class ForecastExtended {

    Date date;
    int day;
    int tempMin;
    int tempMax;
    String description;

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
        String dt = "";
        switch(day){
            case 1: dt ="Sunday"; break;
            case 2: dt ="Monday"; break;
            case 3: dt ="Tuesday"; break;
            case 4: dt ="Wednesday"; break;
            case 5: dt ="Thursday"; break;
            case 6: dt ="Friday"; break;
            case 7: dt ="Saturday"; break;
        }

        return dt;
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
