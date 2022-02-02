/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

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
    
    public Weather(double temperature, double windSpeed) {
        this.temperature = temperature;
        this.humidity = null;
        this.windSpeed = windSpeed;
        this.isRain = false;
        this.isSunny = true;
        date = Date.from(Instant.now());
        city = null;
    }
    
    public Weather(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        this.temperature = temperature;
        this.humidity = null;
        this.windSpeed = windSpeed;
        this.isRain = isRain;
        this.isSunny = isSunny;
        this.city = city;
        this.date = date;
    }

    public double getTemperature() {
        return temperature == null ? 0.0 : temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity == null ? 0.0 : humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed == null ? 0.0 : windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCity() {
        return city == null ? "" : city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date == null ? "" : new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getIsRain() {
        return isRain == null ? false : isRain;
    }

    public void setIsRain(boolean isRain) {
        this.isRain = isRain;
    }

    public boolean getIsSunny() {
        return isSunny == null ? false : isSunny;
    }

    public void setIsSunny(boolean isSunny) {
        this.isSunny = isSunny;
    }
    
    @Override
    // Переопределение метода "toString" для печати объектов класса
    public String toString() {
        return "{ city=" + city + " date=" + date + " temperature=" + temperature + ", humidity=" + humidity + ", windSpeed=" + windSpeed + ", isRain=" + isRain+ ", isSunny=" + isSunny + '}';
    }
}
