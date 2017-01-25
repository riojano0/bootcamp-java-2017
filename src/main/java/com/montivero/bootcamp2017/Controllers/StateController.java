package com.montivero.bootcamp2017.Controllers;

import com.montivero.bootcamp2017.DataSource.StateDataSource;
import com.montivero.bootcamp2017.Domains.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Daniel on 24/01/2017.
 */
@RestController
public class StateController {

    @Autowired
    StateDataSource stateData;

    @RequestMapping(value = "state/get/all" ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<State>> stateGetAll(){
        ArrayList<State> states = new ArrayList<State>();

        try{
            states  = stateData.getAllStatesObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ArrayList<State>>(states, HttpStatus.OK);
    }

    @RequestMapping(value="/state/get/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<State> stateGetById(@PathVariable(value="id") int id){
        State state=null;
        try {
            state = stateData.getStateByIdObject(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<State>(state, HttpStatus.OK);
    }

    @RequestMapping(value="/state/get/name/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<State> stateGetByName(@PathVariable(value="name") String name){
        State state=null;
        try {
            state = stateData.getStateByNameObject(name);
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<State>(state, HttpStatus.OK);
    }

    @RequestMapping(value="/state/get/country/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<State>> stateGetAllByCountry(@PathVariable(value="name") String name){
        ArrayList<State> states = new ArrayList<State>();
        try {
            for(State state:stateData.getAllStatesObjects()){
                if (state.getCountry().getName().equals(name)){
                    states.add(state);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ArrayList<State>>(states, HttpStatus.OK);
    }

    @RequestMapping(value="/state/new", method= RequestMethod.POST)
    public ResponseEntity<String> stateAdd(@RequestBody State state){
        try {

            stateData.insertState(state);

        }catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Fail to add "+state.toString(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Is added "+state.toString(),HttpStatus.CREATED);
    }

}
