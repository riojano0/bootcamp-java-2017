package com.montivero.bootcamp2017.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Daniel on 10/01/2017.
 */
@SpringBootApplication
public class Run {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
            SpringApplication.run(Run.class, args);

    }
}
