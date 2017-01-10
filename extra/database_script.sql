CREATE DATABASE Weather_db;

USE Weather_db;

CREATE TABLE Countries (
   id int NOT NULL AUTO_INCREMENT,
   Country varchar(80) NOT NULL,
   Country_code_2 varchar(2) NOT NULL,
   Country_code_3 varchar(3) NOT NULL,
   CONSTRAINT Countries_pk PRIMARY KEY (id)
);

CREATE TABLE States (
   id int NOT NULL AUTO_INCREMENT,
   Countries_id int NOT NULL,
   State varchar(80) NOT NULL,
   State_short varchar(10) NOT NULL,
   State_area int NOT NULL,
   Capital varchar(80) NOT NULL,
   CONSTRAINT States_pk PRIMARY KEY (id),
   CONSTRAINT Country_fk FOREIGN KEY (Countries_id)
   		REFERENCES Countries(id)
);

CREATE TABLE Winds (
   id int NOT NULL AUTO_INCREMENT,
   speed int NOT NULL,
   direction int NOT NULL,
   CONSTRAINT Winds_pk PRIMARY KEY (id)
);

CREATE TABLE Atmospheres (
   id int NOT NULL AUTO_INCREMENT,
   Humidity int NOT NULL,
   Pressure float NOT NULL,
   Visibility float NOT NULL,
   rising int NOT NULL,
   CONSTRAINT Atmospheres_pk PRIMARY KEY (id)
);

CREATE TABLE Days (
   id int NOT NULL AUTO_INCREMENT,
   Day varchar(30) NOT NULL UNIQUE,
   CONSTRAINT Days_pk PRIMARY KEY (id)
);

CREATE TABLE forecast_today (
   id int NOT NULL AUTO_INCREMENT,
   Date_day datetime NOT NULL,
   Temp int NOT NULL,
   CONSTRAINT forecast_today_pk PRIMARY KEY (id)
);

CREATE TABLE forecast_extended (
   id int NOT NULL,
   date_day datetime NOT NULL,
   Days_id int NOT NULL,
   Temp_min int NOT NULL,
   Temp_max int NOT NULL,
   Description varchar(80) NOT NULL,
   CONSTRAINT forecast_extended_pk PRIMARY KEY (id,date_day),
   CONSTRAINT day_fk FOREIGN KEY (Days_id)
   		REFERENCES Days(id)
);

CREATE TABLE Weather (
   id int NOT NULL AUTO_INCREMENT,
   States_id int NOT NULL,
   forecast_today_id int NOT NULL,
   forecast_extended_id int NOT NULL,
   Winds_id int NOT NULL,
   Atmospheres_id int NOT NULL,
   Description varchar(80) NOT NULL,
   CONSTRAINT Weather_pk PRIMARY KEY (id),
   CONSTRAINT State_fk FOREIGN KEY (States_id)
		REFERENCES States(id),
   CONSTRAINT forecast_today_fk FOREIGN KEY (forecast_today_id)
   		REFERENCES forecast_today(id),
   CONSTRAINT forecast_extended_fk FOREIGN KEY (forecast_extended_id)
   		REFERENCES forecast_extended(id)
);

/* Values for the Secondary Table Days */
Insert into Days(day) values('Sunday')
Insert into Days(day) values('Monday');
Insert into Days(day) values('Tuesday');
Insert into Days(day) values('Wednesday');
Insert into Days(day) values('Thursday');
Insert into Days(day) values('Friday');
Insert into Days(day) values('Saturday');