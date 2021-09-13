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
public abstract class Weather3 extends Weather1 implements IWeather {
    public abstract boolean willWaterFreeze();
    public abstract boolean needUmbrella();
    
    public void attention()
    {
        if (getTemperature() < 0) {
            System.out.println("Very cold, take a warm clothes");
        }
        if (getIsRain()) {
            System.out.println("It looks like there will be rain, stay home or take an umbrella");
        }
        if (getIsSunny()) {
            System.out.println("It looks like there will be sunny, take a glass");
        }
        if (getWindSpeed() < 5) {
            System.out.println("Wind is hard");
        }
    }
    
    public Weather3() {
        super();
    }
    
    public Weather3(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    public Weather3(double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(temperature, windSpeed, isRain, isSunny);
    }
}
