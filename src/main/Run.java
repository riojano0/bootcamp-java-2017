package main;

import classes.Country;
import database.WindDataSource;
import utils.InputAdapter;

import java.sql.SQLException;

/**
 * Created by Daniel on 10/01/2017.
 */
public class Run {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Country c = new Country();
        String name = InputAdapter.InputScanner("Ingrese el nombre del Pais: ", "Nombre no valido",1,80);
        String name_short2 = InputAdapter.InputScanner("Ingrese el nombre corto compuesto de 2 caracteres:", "Caracteres no valido",2,2);
        String name_short3 = InputAdapter.InputScanner("Ingrese el nombre corto compuesto de 3 caracteres:", "Caracteres no valido",3,3);

        c.setName(name);
        c.setShort_name_2(name_short2);
        c.setShort_name_3(name_short3);
        System.out.println(c.getName());
        System.out.println(c.getShort_name_2());
        System.out.println(c.getShort_name_3());

        WindDataSource wData = new WindDataSource();
        wData.insertWind(10,35);


    }
}
