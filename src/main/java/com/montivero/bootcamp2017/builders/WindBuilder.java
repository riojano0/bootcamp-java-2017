package com.montivero.bootcamp2017.builders;

import com.montivero.bootcamp2017.domains.Wind;

public class WindBuilder {

    public int speed = 20;
    public int direction = 15;

    public WindBuilder speed(int speed){
        this.speed=speed;
        return this;
    }

    public WindBuilder direction(int direction){
        this.direction=direction;
        return this;
    }

    public Wind build(){
        return new Wind(this);
    }


}
