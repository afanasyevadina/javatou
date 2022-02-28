/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Dina-PC
 * Здесь все происходит
 */
public class Launch {

    /**
     * Точка входа
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DetailedForecast forecast = new DetailedForecast("Pavlodar", Date.from(Instant.now()), -20, 5, false, true);
        DetailedForecast.WeatherWarning warning = forecast.new WeatherWarning();
        
        if(warning.isOk()) {
            System.out.println("Все ОК");
        } else {
            warning.getWarnings().forEach(str -> {
                System.out.println(str + "\n");
            });
        }
        
        DetailedForecast.WeatherConverter converter = new DetailedForecast.WeatherConverter();
        System.out.println(converter.celToFarengeit(0));
    }
    
}
