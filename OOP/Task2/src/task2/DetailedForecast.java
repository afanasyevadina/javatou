/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.Date;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class DetailedForecast extends ANotification {
    
    final double VERY_COLD_TEMPERATURE = -30.0;
    
    public DetailedForecast() {
        super();
    }
    
    /**
     * 
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public DetailedForecast(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    /**
     * 
     * @param city String which is the city name
     * @param date Date of forecast
     */
    public DetailedForecast(String city, Date date) {
        super(city, date);
    }
    
    /**
     * 
     * @param city String which is the city name
     * @param date Date of forecast
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     * @param isRain boolean set to true if rain
     * @param isSunny boolean set to true if sunny
     */
    public DetailedForecast(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    /**
     * 
     * @return double value of temperature in Farengeit
     */
    @Override
    public double temperatureInFarentgeit()
    {
        return getTemperature() * 9 / 5 + 32;
    }
    
    /**
     * 
     * @param str String to translate
     * @return String translated
     */
    @Override
    public String translate(String str) {
        LinkedHashMap<String, String> dictionary = new LinkedHashMap<>();
        dictionary.put("Всем привет", "Hello everyone");
        dictionary.put("В этот чудесный день", "In this awesome day");
        dictionary.put("в замечательном городе", "in very cool city");
        dictionary.put("Температура", "Temperature");
        dictionary.put("Влажность", "Humidity");
        dictionary.put("Скорость ветра", "Wind speed");
        dictionary.put("Ожидается дождь", "Will be rain");
        dictionary.put("Солнечно", "Sunny");
        dictionary.put("Внимание жителям города", "Attention to the residents of the city");
        dictionary.put("все хорошо", "everything is OK");
        dictionary.put("В школу не надо", "Don't need to go to school");
        dictionary.put("Гололед", "Ice");
        dictionary.put("Возьмите зонт, ожидается дождь", "Take an umbrella, it's going to rain");
        dictionary.put("Будет холодно, одевайтесь теплее", "It will be cold, dress warmly");
        dictionary.put("Солнце светит прямо в глаз", "The sun shines right into your eyes");
        dictionary.put("Ветром унесет", "The wind will blow");
        dictionary.put(" в ", " in ");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            str = str.replaceAll(entry.getKey(), entry.getValue());
        }
        return str;
    }
    
    /**
     * 
     * @return ArrayList of dangers
     */
    @Override
    public List<String> getDangers()
    {
        List<String> dangers = super.getDangers();
        if (getTemperature() < VERY_COLD_TEMPERATURE) dangers.add("В школу не надо");
        if (getTemperature() < WATER_FREEZE_TEMPERATURE && getIsRain()) dangers.add("Гололед");
        return dangers;
    }
    
    /**
     * 
     * @return String with attention
     */
    @Override
    public String attentionText()
    {
        if(getDangers().size() < 1) {
            return getDate() + " в " + getCity() + " все хорошо";
        }
        String output = "Внимание жителям города " + getCity() + "! " + getDate() + ":";
        for(String danger : getDangers()) {
            output += "\n" + danger;
        }
        return output;
    }
    
    /**
     * 
     * @return String with forecast
     */
    @Override
    public String forecastText()
    {
        String output = "Всем привет. В этот чудесный день " + getDate() + " в замечательном городе " + getCity();
        output += "\nТемпература: " + getTemperature();
        output += "\nВлажность: " + getHumidity();
        output += "\nСкорость ветра: " + getWindSpeed();
        if(getIsRain()) {
            output += "\nОжидается дождь";
        }
        if(getIsSunny()) {
            output += "\nСолнечно";
        }
        return output;
    }
}
