package classes;

/**
 * Created by Daniel on 09/01/2017.
 */
public class Wind {

    int speed;
    int direction;

    public Wind(){

    }

    public Wind(int speed, int direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public String windToString(){
        return String.format("Speed: %s \nDirection: %s", speed,direction);
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
}
