package classes;

public class Country {

    String name;
    String short_name_2;
    String short_name_3;

    public Country(){

    }

    public Country(String name, String short_name_2, String short_name_3){
        this.name = name;
        this.short_name_2 = short_name_2;
        this.short_name_3 = short_name_3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name_2() {
        return short_name_2;
    }

    public void setShort_name_2(String short_name_2) {
        this.short_name_2 = short_name_2;
    }

    public String getShort_name_3() {
        return short_name_3;
    }

    public void setShort_name_3(String short_name_3) {
        this.short_name_3 = short_name_3;
    }
}
