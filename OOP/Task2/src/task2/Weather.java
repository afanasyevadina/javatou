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
     * @param temperature
     * @param windSpeed 
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
     * @param city
     * @param date
     * @param temperature
     * @param windSpeed
     * @param isRain
     * @param isSunny 
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
     * @return 
     */
    public double getTemperature() {
        return temperature == null ? 0.0 : temperature;
    }
    
    /**
     * 
     * @param temperature 
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    /**
     * 
     * @return double
     */
    public double getHumidity() {
        return humidity == null ? 0.0 : humidity;
    }
    
    /**
     * 
     * @param humidity 
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return double
     */
    public double getWindSpeed() {
        return windSpeed == null ? 0.0 : windSpeed;
    }

    /**
     * 
     * @param windSpeed 
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * 
     * @return String
     */
    public String getCity() {
        return city == null ? "" : city;
    }

    /**
     * 
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return String
     */
    public String getDate() {
        return date == null ? "" : new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    /**
     * 
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 
     * @return boolean
     */
    public boolean getIsRain() {
        return isRain == null ? false : isRain;
    }

    /**
     * 
     * @param isRain 
     */
    public void setIsRain(boolean isRain) {
        this.isRain = isRain;
    }

    /**
     * 
     * @return boolean
     */
    public boolean getIsSunny() {
        return isSunny == null ? false : isSunny;
    }

    /**
     * 
     * @param isSunny 
     */
    public void setIsSunny(boolean isSunny) {
        this.isSunny = isSunny;
    }
    
    /**
     * 
     * @return String
     */
    @Override
    // Переопределение метода "toString" для печати объектов класса
    public String toString() {
        return "{ city=" + city + " date=" + date + " temperature=" + temperature + ", humidity=" + humidity + ", windSpeed=" + windSpeed + ", isRain=" + isRain+ ", isSunny=" + isSunny + '}';
    }
}
