package classes;

/**
 * Created by Daniel on 09/01/2017.
 */
public class Atmosphere {

    int humidity;
    double pressure;
    double visibility;
    int rising;

    public Atmosphere() {
    }

    public Atmosphere(int humidity, double pressure, double visibility, int rising) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.rising = rising;
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
}
