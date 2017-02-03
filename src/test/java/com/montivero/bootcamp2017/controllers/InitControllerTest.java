package com.montivero.bootcamp2017.controllers;

import com.sun.org.apache.xml.internal.security.Init;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 01/02/2017.
 */
public class InitControllerTest {

    @Test
    public void hello() throws Exception {

        InitController initController = Mockito.mock(InitController.class);

        String expect = "Init Controller Run";
        Mockito.when(initController.hello()).thenReturn("Init Controller Run");

        assertEquals(expect,initController.hello());

    }

}