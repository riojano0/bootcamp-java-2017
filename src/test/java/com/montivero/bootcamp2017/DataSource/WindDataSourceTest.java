package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Domains.Wind;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 18/01/2017.
 */
public class WindDataSourceTest {


    private WindDataSource mockWindData = Mockito.mock(WindDataSource.class);

    @Test
    public void getIdByWind() throws Exception {

        Wind mockWind = Mockito.mock(Wind.class);
        Mockito.when(mockWindData.getIdByWind(mockWind)).thenReturn(20);
        assertEquals(20,mockWindData.getIdByWind(mockWind));

    }

    @Test
    public void getWindByIdObject() throws Exception {

        Wind mockWind = Mockito.mock(Wind.class);
        Mockito.when(mockWindData.getWindByIdObject(1)).thenReturn(mockWind);

        assertEquals(mockWind,mockWindData.getWindByIdObject(1));

    }

    @Test
    public void getWindById() throws Exception {

        ResultSet mockResult = Mockito.mock(ResultSet.class);
        Mockito.when(mockWindData.getWindById(15)).thenReturn(mockResult);

        assertEquals(mockResult,mockWindData.getWindById(15));

    }

    @Test
    public void getAllWinds() throws Exception{
        ResultSet mockResult = Mockito.mock(ResultSet.class);
        Mockito.when(mockWindData.getAllWinds()).thenReturn(mockResult);

        assertEquals(mockResult,mockWindData.getAllWinds());
    }

}