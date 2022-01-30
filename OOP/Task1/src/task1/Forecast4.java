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
public class Forecast4 extends Forecast3 {
    public Forecast4() {
        super();
    }
    
    public Forecast4(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    public Forecast4(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    @Override
    public boolean willWaterFreeze()
    {
        return getTemperature() < 0;
    }
    
    @Override
    public boolean needUmbrella()
    {
        return getIsRain();
    }
    
    @Override
    public double temperatureInFarentgeit()
    {
        return getTemperature() * 9 / 5 + 32;
    }
    
    @Override
    public double windSpeedInKmPerHour()
    {
        return getWindSpeed() * 3.6;
    }
    
    @Override
    public void attention()
    {
        System.out.println("Please, read this carefully!");
        super.attention();
    }
}
