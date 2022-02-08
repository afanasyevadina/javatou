/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Dina-PC
 */
public class WeatherHistory {
    
    private final List<DetailedForecast> forecastsList; 
    private final Set<DetailedForecast> forecastsSet;
    private final Map<String,Map<String,DetailedForecast>> forecastsMap;
    
    public WeatherHistory()
    {
        this.forecastsList = new ArrayList<>();
        this.forecastsSet = new LinkedHashSet<>();
        this.forecastsMap = new LinkedHashMap<>();
    } 

    /**
     * 
     * @return List
     */
    public List<DetailedForecast> getForecastsList() {
        return forecastsList;
    }
    
    /**
     * 
     * @param date
     * @return List
     */
    public List<DetailedForecast> weatherByDate(Date date)
    {
        List<DetailedForecast> filtered = this.forecastsList;
        filtered.removeIf(v -> v.getDate().contentEquals((new DetailedForecast()).getDate()));
        return filtered;
    }
}
