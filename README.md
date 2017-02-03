# bootcamp-java-2017
Daniel Ezequiel Montivero
###Bootcamp-Globant - Assignment 04

####WeatherApp
    Run the App in a Tomcat 
    or
    mvn tomcat:run (with the plugin dont work index page)
    
####Post Body
    Examples for Post json
    /extra/Json_Post_examples
    
####EndPoints
     INIT
      @GET
     /  :String only show if working
     
     -COUNTRY-
      @GET 
     country/get/all : Get All Countries
     country/id/{id}  : Get Country by ID
     country/name/{name} : Get Country by ShortName3
          
      @POST
      country/saveCountry  : Save country
      
      -STATE-
       @GET
      state/get/all/{countryShortName} : Get All States by Country ShortName3 
      state/get/{country}/{state} : Get State by countryShortName3 and State ShortName
       
       @POST
      state/saveState : Save State
      
      -WEATHER-
       @GET
      weather/get/{country}/{state} : Get weather for Country(FullName) and state(FullName)
      
       @POST
      weather/saveWeather : Save Weather
     
     
      

    


