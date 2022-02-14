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
 * Класс информации о погоде
 * @author user
 */
public class Weather { //это главный
    /**
     * Температура
     */
    private Double temperature; 
    /**
     * Влажность
     */
    private Double humidity; 
    /**
     * Скорость ветра
     */
    private Double windSpeed; 
    /**
     * Дождливо, если true
     */
    private Boolean isRain;
    /**
     * Солнечно, если true
     */
    private Boolean isSunny;
    /**
     * Город
     */
    private String city;
    /**
     * Дата
     */
    private Date date;
    
    /**
     * Опасная скорость ветра
     */
    final double DANGEROUS_WIND_SPEED = 5.0;
    /**
     * Опасная температура
     */
    final double DANGEROUS_TEMPERATURE = -5.0;
    /**
     * Температура замерзания воды
     */
    final double WATER_FREEZE_TEMPERATURE = 0.0;
    

    /**
     * Это конструктор по-умолчанию без параметров
     */
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
     * Конструктор с температурой и скоростью ветра
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public Weather(double temperature, double windSpeed) {
        this.temperature = temperature;
        this.humidity = null;
        this.windSpeed = windSpeed;
        this.isRain = false;
        this.isSunny = true;
        date = null;
        city = null;
    }
    
    /**
     * Конструктор со всеми данными
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
     * Получить температуру в Цельсиях
     * @return double value of temperature in Cel
     */
    public double getTemperature() {
        return temperature == null ? 0.0 : temperature;
    }
    
    /**
     * Установить температуру в Цельсиях
     * @param temperature double value of temperature in Cel
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    /**
     * Получить влажность в процентах
     * @return double value of humidity
     */
    public double getHumidity() {
        return humidity == null ? 0.0 : humidity;
    }
    
    /**
     * Установить влажность в процентах
     * @param humidity double value of humidity 
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Получить скорость ветра в м/с
     * @return double value of wind speed
     */
    public double getWindSpeed() {
        return windSpeed == null ? 0.0 : windSpeed;
    }

    /**
     * Установить скорость ветра в м/с
     * @param windSpeed double value of wind speed
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * Получить название города
     * @return String which is the city name
     */
    public String getCity() {
        return city == null ? "" : city;
    }

    /**
     * Установить название города
     * @param city String which is the city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Получить форматированную дату
     * @return String with formatted date
     */
    public String getDate() {
        return date == null ? "" : new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    /**
     * Установить дату
     * @param date Date of forecast
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Узнать, будет ли дождь
     * @return boolean set to true if rain
     */
    public boolean getIsRain() {
        return isRain == null ? false : isRain;
    }

    /**
     * Установить, будет ли дождь
     * @param isRain boolean set to true if rain
     */
    public void setIsRain(boolean isRain) {
        this.isRain = isRain;
    }

    /**
     * Узнать, будет ли солнечно
     * @return boolean set to true if sunny
     */
    public boolean getIsSunny() {
        return isSunny == null ? false : isSunny;
    }

    /**
     * Установить, будет ли солнечно
     * @param isSunny boolean set to true if sunny
     */
    public void setIsSunny(boolean isSunny) {
        this.isSunny = isSunny;
    }
    
    /**
     * Переопределение метода "toString" для печати объектов класса
     * @return String of serialized object
     */
    @Override
    public String toString() {
        return "{ city=" + city + " date=" + date + " temperature=" + temperature + ", humidity=" + humidity + ", windSpeed=" + windSpeed + ", isRain=" + isRain+ ", isSunny=" + isSunny + '}';
    }
}
