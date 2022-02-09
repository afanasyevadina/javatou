/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;


    

/**
 *
 * @author user
 */
public class Weather { //это главный
    
    private Double temperature; 
    private Double humidity; 
    private Double windSpeed; 
    private Boolean isRain;
    private Boolean isSunny;
    private String city;
    private Date date;
    
    final double DANGEROUS_WIND_SPEED = 5.0;
    final double DANGEROUS_TEMPERATURE = -5.0;
    final double WATER_FREEZE_TEMPERATURE = 0.0;
    

    // Это конструктор по-умолчанию (без параметров)
    public Weather() {
        temperature = null;
        humidity = null;
        windSpeed = null;
        isRain = null;
        isSunny = null;
        date = null;
        city = null;
    }
    
    /**
     * 
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public Weather(double temperature, double windSpeed) {
        this.temperature = temperature;
        this.humidity = null;
        this.windSpeed = windSpeed;
        this.isRain = false;
        this.isSunny = true;
        date = Date.from(Instant.now());
        city = null;
    }
    
    /**
     * 
     * @param city String which is the city name
     * @param date Date of forecast
     */
    public Weather(String city, Date date) {
        this.city = city;
        this.date = date;
    }
    
    /**
     * 
     * @param city String which is the city name
     * @param date Date of forecast
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     * @param isRain boolean set to true if rain
     * @param isSunny boolean set to true if sunny
     */
    public Weather(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        this.temperature = temperature;
        this.humidity = null;
        this.windSpeed = windSpeed;
        this.isRain = isRain;
        this.isSunny = isSunny;
        this.city = city;
        this.date = date;
    }

    /**
     * 
     * @return double value of temperature in Cel
     */
    public double getTemperature() {
        return temperature == null ? 0.0 : temperature;
    }
    
    /**
     * 
     * @param temperature double value of temperature in Cel
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    /**
     * 
     * @return double value of humidity
     */
    public double getHumidity() {
        return humidity == null ? 0.0 : humidity;
    }
    
    /**
     * 
     * @param humidity double value of humidity 
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return double value of wind speed
     */
    public double getWindSpeed() {
        return windSpeed == null ? 0.0 : windSpeed;
    }

    /**
     * 
     * @param windSpeed double value of wind speed
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * 
     * @return String which is the city name
     */
    public String getCity() {
        return city == null ? "" : city;
    }

    /**
     * 
     * @param city String which is the city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return String with formatted date
     */
    public String getDate() {
        return date == null ? "" : new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    /**
     * 
     * @param date Date of forecast
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 
     * @return boolean set to true if rain
     */
    public boolean getIsRain() {
        return isRain == null ? false : isRain;
    }

    /**
     * 
     * @param isRain boolean set to true if rain
     */
    public void setIsRain(boolean isRain) {
        this.isRain = isRain;
    }

    /**
     * 
     * @return boolean set to true if sunny
     */
    public boolean getIsSunny() {
        return isSunny == null ? false : isSunny;
    }

    /**
     * 
     * @param isSunny boolean set to true if sunny
     */
    public void setIsSunny(boolean isSunny) {
        this.isSunny = isSunny;
    }
    
    /**
     * 
     * @return String of serialized object
     */
    @Override
    // Переопределение метода "toString" для печати объектов класса
    public String toString() {
        return "\n{ \ncity=" + city + " \ndate=" + date + " \ntemperature=" + temperature + ", \nhumidity=" + humidity + ", \nwindSpeed=" + windSpeed + ", \nisRain=" + isRain+ ", \nisSunny=" + isSunny + "\n}\n";
    }
}
