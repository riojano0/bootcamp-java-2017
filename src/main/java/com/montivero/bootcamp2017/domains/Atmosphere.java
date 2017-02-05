package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.AtmosphereBuilder;

import javax.persistence.*;

@Entity
@Table(name="atmospheres")
public class Atmosphere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int humidity;
    private double pressure;
    private double visibility;
    private int rising;

    public Atmosphere() {};

    public Atmosphere(int humidity, double pressure, double visibility, int rising) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.rising = rising;
    }

    public Atmosphere(AtmosphereBuilder builder){
        this.humidity = builder.humidity;
        this.pressure = builder.pressure;
        this.visibility = builder.visibility;
        this.rising = builder.rising;
    }

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

    @Override
    public String toString(){
        return String.format("Atmosphere: \nHumidity: %s \nPressure: %s \nVisibility: %s \nRising: %s",
                humidity,
                pressure,
                visibility,
                rising);
    }
}
