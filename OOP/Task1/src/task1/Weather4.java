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
public class Weather4 extends Weather3 {
    public Weather4() {
        super();
    }
    
    public Weather4(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    public Weather4(double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(temperature, windSpeed, isRain, isSunny);
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
