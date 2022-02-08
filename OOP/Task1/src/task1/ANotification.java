/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public abstract class ANotification extends Weather implements IWeatherUSA {
    
    public abstract String attentionText();
    public abstract String forecastText();
    
    public ANotification() {
        super();
    }
    
    /**
     * 
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public ANotification(double temperature, double windSpeed) {
        super(temperature, windSpeed);
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
    public ANotification(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    /**
     * 
     * @return ArrayList of dangers
     */
    public List<String> getDangers()
    {
        List<String> dangers = new ArrayList<>();
        if(getIsRain()) dangers.add("Возьмите зонт, ожидается дождь");
        if (getTemperature() < DANGEROUS_TEMPERATURE) dangers.add("Будет холодно, одевайтесь теплее");
        if (getIsSunny()) dangers.add("Солнце светит прямо в глаз");
        if (getWindSpeed() < DANGEROUS_WIND_SPEED) dangers.add("Ветром унесет");
        return dangers;
    }
}
