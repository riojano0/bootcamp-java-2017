package classes;

import java.util.Date;

public class ForecastToday {
    Date date;
    int temp;

    public ForecastToday() {
    }

    public ForecastToday(Date date, int temp) {
        this.date = date;
        this.temp = temp;
    }

    public String forecastTodayToString(){
        return String.format("Date: %s \nTemp: %s", date,temp);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
