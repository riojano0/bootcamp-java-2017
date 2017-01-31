# bootcamp-java-2017
Daniel Ezequiel Montivero
###Bootcamp-Globant - Assignment 04

####WeatherApp
    Run the App in a Tomcat 
    or
    mvn tomcat:run (with the plugin dont work index page)
    
####Post Request
    Examples for Post json
    /extra/Json_Post_examples
    
####EndPoints
     INIT
      @GET
     /  :String only show if working
     
     -COUNTRY-
      @GET 
     country/ : Get All Countries
     country/id/{id}  : Get Country by ID
     country/name/{name} : Get Country by Name
     
      ***@GET for Test Json***
     country/test  : Get All Countries for Json Online
     country/test/{shortName3}  : Get Country by ShortName Json Online
     
      @POST
      country/saveCountry  : Save country
      
      -STATE-
       @GET
      state/ : Get All States 
      state/get/id/{id} : Get State by ID
      state/get/all/{country} : Get All States by Country
      
       @POST
      state/saveState : Save State
      
      -WEATHER-
       @GET
      weather/ : Get All weathers
      weather/get/state/{name} : Get weather for State (and optional query Param "date)
      
       @POST
      weather/saveWeather : Save Weather
     
     
      

    


