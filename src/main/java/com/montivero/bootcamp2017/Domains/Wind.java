package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.WindBuilder;

/**
 * Created by Daniel on 09/01/2017.
 */
public class Wind {

    private int speed;
    private int direction;

    public Wind(int s, int d){
        this.speed=s;
        this.direction=d;
    }

    public Wind(WindBuilder builder){
        this.speed=builder.speed;
        this.direction=builder.direction;
    }

    public String windToString(){
        return String.format("Speed: %s \nDirection: %s", speed,direction);
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }


}
