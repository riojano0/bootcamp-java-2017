package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.WindBuilder;

import javax.persistence.*;

/**
 * Created by Daniel on 29/01/2017.
 */
@Entity
@Table(name="winds")
public class Wind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int speed;
    private int direction;

    public Wind(){};

    public Wind(int speed, int direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public Wind(WindBuilder builder) {
        this.speed = builder.speed;
        this.direction = builder.direction;
    }

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString(){
        return String.format("Wind - Speed: %s  Direction: %s", speed,direction);
    }
}
