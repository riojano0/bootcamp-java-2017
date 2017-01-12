package classes;

/**
 * Created by Daniel on 09/01/2017.
 */
public class Weather {

    State state;
    ForecastToday today;
    ForecastExtended[] week = new ForecastExtended[10];
    Wind wind;
    Atmosphere atmosphere;
    String description;

    public Weather() {
    }

    public Weather(State state, ForecastToday today, ForecastExtended[] week, Wind wind, Atmosphere atmosphere, String description) {
        this.state = state;
        this.today = today;
        this.week = week;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ForecastToday getToday() {
        return today;
    }

    public void setToday(ForecastToday today) {
        this.today = today;
    }

    public ForecastExtended[] getWeek() {
        return week;
    }

    public void setWeek(ForecastExtended[] week) {
        this.week = week;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
