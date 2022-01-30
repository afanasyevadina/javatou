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
public class Forecast2 extends Forecast1 {
    public Forecast2() {
        super();
    }
    
    public Forecast2(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    public Forecast2(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    public void forecast(String city)
    {
        System.out.println("Hello. Today is a good day " + getDate() + ". There is a forecast for city " + city);
        System.out.println("Temperature: " + getTemperature());
        System.out.println("Humidity: " + getHumidity());
        System.out.println("Wind speed: " + getWindSpeed());
        if(getIsRain()) {
            System.out.println("Today will be rain");
        }
        if(getIsSunny()) {
            System.out.println("Today will be sunny");
        }
    }
}
