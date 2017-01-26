package com.montivero.bootcamp2017.Config;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 26/01/2017.
 */
public class DatabaseHelperTest {

    @Test
    public void getCon() throws Exception {

        DatabaseHelper dbHelper = Mockito.mock(DatabaseHelper.class);

        Mockito.when(dbHelper.getCon()).thenReturn(Mockito.mock(Connection.class));

        assertNotNull(dbHelper.getCon());
    }

}