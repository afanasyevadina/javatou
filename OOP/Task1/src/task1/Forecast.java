/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

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
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public Forecast(double temperature, double windSpeed) {
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
    public Forecast(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    /**
     * 
     * @return boolean set to true if water freeze
     */
    public boolean willWaterFreeze()
    {
        return getTemperature() < WATER_FREEZE_TEMPERATURE;
    }
    
    /**
     * 
     * @return boolean set to true if we need an umbrella
     */
    public boolean needUmbrella()
    {
        return getIsRain();
    }
}
