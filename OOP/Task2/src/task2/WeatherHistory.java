/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dina-PC
 */
public class WeatherHistory {
    
    private List<DetailedForecast> forecasts;  
    
    public WeatherHistory()
    {
        this.forecasts = new ArrayList<>();
    } 

    /**
     * 
     * @return List
     */
    public List<DetailedForecast> getForecasts() {
        return forecasts;
    }

    /**
     * 
     * @param forecasts 
     */
    public void setForecasts(List<DetailedForecast> forecasts) {
        this.forecasts = forecasts;
    }
    
    /**
     * 
     * @param forecasts 
     */
    public WeatherHistory(ArrayList<DetailedForecast> forecasts)
    {
        this.forecasts = forecasts;
    }
    
    /**
     * 
     * @param date
     * @return List
     */
    public List<DetailedForecast> weatherByDate(Date date)
    {
        List<DetailedForecast> filtered = this.forecasts;
        filtered.removeIf(v -> v.getDate().contentEquals((new DetailedForecast()).getDate()));
        return filtered;
    }
}
