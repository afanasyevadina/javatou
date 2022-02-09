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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Dina-PC
 */
public class WeatherHistory {
    
    private final LinkedList<DetailedForecast> forecastsList; 
    private final LinkedHashSet<DetailedForecast> forecastsSet;
    private final LinkedHashMap<String,LinkedHashMap<String,DetailedForecast>> forecastsMap;
    
    public WeatherHistory()
    {
        this.forecastsList = new LinkedList<>();
        this.forecastsSet = new LinkedHashSet<>();
        this.forecastsMap = new LinkedHashMap<>();
    } 

    /**
     * 
     * @return LinkedList of forecasts
     */
    public LinkedList<DetailedForecast> getForecastsList() {
        return forecastsList;
    }
    
    /**
     * 
     * @return LinkedHasSet of forecasts
     */
    public LinkedHashSet<DetailedForecast> getForecastsSet() {
        return forecastsSet;
    }
    
    /**
     * 
     * @return LinkedHashMap of forecasts by date, by city
     */
    public LinkedHashMap<String, LinkedHashMap<String, DetailedForecast>> getForecastsMap() {
        return forecastsMap;
    }
    
    /**
     * 
     * @param date Date which we need
     * @return LinkedList of forecasts
     */
    public LinkedList<DetailedForecast> weatherListByDate(Date date)
    {
        LinkedList<DetailedForecast> filtered = this.forecastsList;
        filtered.removeIf(v -> v.getDate().contentEquals((new DetailedForecast()).getDate()));
        return filtered;
    }
    
    /**
     * 
     * @param date Date which we need
     * @return LinkedHasSet of forecasts
     */
    public LinkedHashSet<DetailedForecast> weatherSetByDate(Date date)
    {
        LinkedHashSet<DetailedForecast> filtered = this.forecastsSet;
        filtered.removeIf(v -> v.getDate().contentEquals((new DetailedForecast()).getDate()));
        return filtered;
    }
    
    /**
     * 
     * @param date Date which we need
     * @return LinkedHasMap of forecasts by city
     */
    public LinkedHashMap<String,DetailedForecast> weatherMapByDate(Date date)
    {
        return this.forecastsMap.getOrDefault(date, new LinkedHashMap<>());
    }
    
    /**
     * 
     * @param city String of city
     * @return LinkedHasMap of forecasts by date
     */
    public LinkedHashMap<String,DetailedForecast> weatherMapByCity(String city)
    {
        LinkedHashMap<String,DetailedForecast> result = new LinkedHashMap<>();
        this.forecastsMap.entrySet().stream().filter(entry -> (entry.getValue().containsKey(city))).forEachOrdered(entry -> {
            result.put(entry.getKey(), entry.getValue().get(city));
        });
        return result;
    }
    
    /**
     * 
     * @param forecast DetailedForecast to add
     */
    public void addItem(DetailedForecast forecast) {
        this.forecastsList.add(forecast);
        this.forecastsSet.add(forecast);
        this.forecastsMap.putIfAbsent(forecast.getDate(), new LinkedHashMap<>());
        this.forecastsMap.get(forecast.getDate()).put(forecast.getCity(), forecast);
    }
}
