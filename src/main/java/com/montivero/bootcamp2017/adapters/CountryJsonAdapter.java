package com.montivero.bootcamp2017.adapters;

import com.montivero.bootcamp2017.builders.CountryBuilder;
import com.montivero.bootcamp2017.domains.Country;
import org.apache.cxf.helpers.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 31/01/2017.
 */
public class CountryJsonAdapter {

    private JSONObject response;
    private JSONArray jsonArray;

    public CountryJsonAdapter(String url) {
        try{
        InputStream is = new URL(url).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String message = IOUtils.toString(rd);
        JSONObject json = new JSONObject(message);
        this.response = (JSONObject) json.get("RestResponse");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Country getCountry(){

        Country c=null;
        try {
            response.getJSONObject("result").get("name");

            c = new CountryBuilder()
                    .name(response.getJSONObject("result").getString("name"))
                    .shortName2(response.getJSONObject("result").getString("alpha2_code"))
                    .shortName3(response.getJSONObject("result").getString("alpha3_code"))
                    .build();
            return c;
        }catch (Exception E){
            E.printStackTrace();
            return c;
        }
    }

    public List<Country> getCountries(){
        List<Country> countries = new ArrayList<Country>();
        try {
            this.jsonArray = (JSONArray) response.get("result");
            for(int i =0;this.jsonArray.length()>i;i++ ){
                Country c = new CountryBuilder()
                        .name(jsonArray.getJSONObject(i).getString("name"))
                        .shortName2(jsonArray.getJSONObject(i).getString("alpha2_code"))
                        .shortName3(jsonArray.getJSONObject(i).getString("alpha3_code"))
                        .build();
                countries.add(c);
            }

            return countries;
        }catch (Exception E){
            E.printStackTrace();
            return null;
        }
    }

}
