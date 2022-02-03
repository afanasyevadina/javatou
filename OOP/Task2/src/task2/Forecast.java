/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.Date;

/**
 *
 * @author user
 */
public class Forecast extends Weather {
    public Forecast() {
        super();
    }
    
    /**
     * 
     * @param temperature
     * @param windSpeed 
     */
    public Forecast(double temperature, double windSpeed) {
        super(temperature, windSpeed);
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
    public Forecast(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    /**
     * 
     * @return boolean
     */
    public boolean willWaterFreeze()
    {
        return getTemperature() < WATER_FREEZE_TEMPERATURE;
    }
    
    /**
     * 
     * @return boolean
     */
    public boolean needUmbrella()
    {
        return getIsRain();
    }
}
