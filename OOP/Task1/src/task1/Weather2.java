/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

/**
 *
 * @author user
 */
public class Weather2 extends Weather1 {
    public Weather2() {
        super();
    }
    
    public Weather2(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    public Weather2(double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(temperature, windSpeed, isRain, isSunny);
    }
    
    public void forecast(String city)
    {
        System.out.println("Hello. There is a forecast for city " + city);
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
