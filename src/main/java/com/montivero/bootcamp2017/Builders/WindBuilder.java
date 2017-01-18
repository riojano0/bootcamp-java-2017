package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.Wind;

/**
 * Created by Daniel on 14/01/2017.
 */
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
        return new Wind(this
        );
    }


}
