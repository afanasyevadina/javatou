/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task7;

import java.util.Date;

/**
 * Класс прогноза погоды
 * 
 * @author user
 */
public class Forecast extends Weather {
    /**
     * Конструктор без параметров
     */
    public Forecast() {
        super();
    }
    
    /**
     * Конструктор с температурой и скоростью ветра
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public Forecast(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    /**
     * Конструктор со городом и датой
     * @param city String which is the city name
     * @param date Date of forecast
     */
    public Forecast(String city, Date date) {
        super(city, date);
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
    public Forecast(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    /**
     * Будет ли замерзать вода?
     * @return boolean set to true if water freeze
     */
    public boolean willWaterFreeze()
    {
        return getTemperature() < WATER_FREEZE_TEMPERATURE;
    }
    
    /**
     * Нужен ли зонт?
     * @return boolean set to true if we need an umbrella
     */
    public boolean needUmbrella()
    {
        return getIsRain();
    }
}
