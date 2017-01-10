package classes;

public class State {

    Country country;
    String name;
    String short_name;
    double area;
    String capital;

    public State(){
    }

    public State(Country country, String name, String short_name, double area, String capital) {
        this.country = country;
        this.name = name;
        this.short_name = short_name;
        this.area = area;
        this.capital = capital;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

}
