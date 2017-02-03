package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.domains.State;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 02/02/2017.
 */
public class StateControllerTest {
    @Test
    public void getAllStatesByCountry() throws Exception {

        StateController stateController = Mockito.mock(StateController.class);
        List<State> states = new ArrayList<State>();
        State state = Mockito.mock(State.class);
        states.add(state);

        Mockito.when(stateController.getAllStatesByCountry("IND")).thenReturn(states);
        assertEquals(states,stateController.getAllStatesByCountry("IND"));
    }

    @Test
    public void getStateByCountryAndShortName() throws Exception {
        StateController stateController = Mockito.mock(StateController.class);
        State state = Mockito.mock(State.class);
        Mockito.when(stateController.getStateByCountryAndShortName("IND","AL")).thenReturn(state);
        assertEquals(state,stateController.getStateByCountryAndShortName("IND","AL"));

    }

}