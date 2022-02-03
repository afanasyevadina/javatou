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
    
    public Forecast(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    public Forecast(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    public boolean willWaterFreeze()
    {
        return getTemperature() < WATER_FREEZE_TEMPERATURE;
    }
    
    public boolean needUmbrella()
    {
        return getIsRain();
    }
}
