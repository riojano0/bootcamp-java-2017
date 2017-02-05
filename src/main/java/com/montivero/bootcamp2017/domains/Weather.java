package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.WeatherBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    private State state;
    private String description;

    @ManyToOne(fetch=FetchType.EAGER)
    private Wind wind;

    @ManyToOne(fetch=FetchType.EAGER)
    private Atmosphere atmosphere;

    @ManyToOne(fetch=FetchType.EAGER)
    private ForecastToday today;

    @OneToMany(fetch=FetchType.EAGER)
    private List<ForecastExtended> week;

    public Weather (){};

    public Weather(State state, String description, Wind wind, Atmosphere atmosphere, ForecastToday today, List<ForecastExtended> week) {
        this.state = state;
        this.description = description;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.today = today;
        this.week = week;
    }

    public Weather(WeatherBuilder builder) {
        this.state = builder.state;
        this.description = builder.description;
        this.wind = builder.wind;
        this.atmosphere = builder.atmosphere;
        this.today = builder.today;
        this.week = builder.week;
    }

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public ForecastToday getToday() {
        return today;
    }

    public void setToday(ForecastToday today) {
        this.today = today;
    }

    public List<ForecastExtended> getWeek() {
        return week;
    }

    public void setWeek(List<ForecastExtended> week) {
        this.week = week;
    }

    @Override
    public String toString(){
        String forecastExtendedOut = "";
        if(week !=null) {
            for (ForecastExtended aWeek : week) {
                if (aWeek!=null)
                    forecastExtendedOut += aWeek.toString() + "\n";
            }
        }
        return String.format("Weather State:\n%s \n\n%s \n\n%s \n\n%s"+
                        "\n\nDescription: %s \n\n%s ",
                state.getName(),
                today.toString(),
                atmosphere.toString(),
                wind.toString(),
                description,
                forecastExtendedOut
        );
    }

}
