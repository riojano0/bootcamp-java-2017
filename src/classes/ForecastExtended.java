package classes;

import java.util.Date;

public class ForecastExtended {

    Date date;
    int day;
    int tempMix;
    int tempMax;
    String description;



    public ForecastExtended(Date date, int day, int tempMix, int tempMax, String description) {

        this.date = date;
        this.day = day;
        this.tempMix = tempMix;
        this.tempMax = tempMax;
        this.description = description;
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

    public int getTempMix() {
        return tempMix;
    }

    public void setTempMix(int tempMix) {
        this.tempMix = tempMix;
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
