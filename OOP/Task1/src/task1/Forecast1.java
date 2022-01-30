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
public class Forecast1 { //это главный
    private double temperature; 
    private double humidity; 
    private double windSpeed; 
    private boolean isRain;
    private boolean isSunny;
    private String city;
    private Date date;

    // Это конструктор по-умолчанию (без параметров)
    public Forecast1() {
        temperature = 0;
        humidity = 70;
        windSpeed = 0;
        isRain = false;
        isSunny = true;
        date = Date.from(Instant.now());
        city = "Everywhere";
    }
    
    public Forecast1(double temperature, double windSpeed) {
        this.temperature = temperature;
        this.humidity = 70;
        this.windSpeed = windSpeed;
        this.isRain = false;
        this.isSunny = true;
        date = Date.from(Instant.now());
        city = "Everywhere";
    }
    
    public Forecast1(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        this.temperature = temperature;
        this.humidity = 70;
        this.windSpeed = windSpeed;
        this.isRain = isRain;
        this.isSunny = isSunny;
        this.city = city;
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCity() {
        return city;
    }

    public void setSity(String city) {
        this.city = city;
    }

    public String getDate() {
        return new SimpleDateFormat("dd MMMMM yyyy", new Locale("en", "EN")).format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getIsRain() {
        return isRain;
    }

    public void setIsRain(boolean isRain) {
        this.isRain = isRain;
    }

    public boolean getIsSunny() {
        return isSunny;
    }

    public void setIsSunny(boolean isSunny) {
        this.isSunny = isSunny;
    }
    
    @Override
    // Переопределение метода "toString" для печати объектов класса
    public String toString() {
        return "{ city=" + city + " date=" + getDate() + " temperature=" + temperature + ", humidity=" + humidity + ", windSpeed=" + windSpeed + ", isRain=" + isRain+ ", isSunny=" + isSunny + '}';
    }
}
