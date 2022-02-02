/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
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
    public DetailedForecast(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    public DetailedForecast(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    @Override
    public double temperatureInFarentgeit()
    {
        return getTemperature() * 9 / 5 + 32;
    }

    @Override
    public String translate(String str) {
        HashMap<String, String> dictionary = new HashMap<>();
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
    
    @Override
    public List<String> getDangers()
    {
        List<String> dangers = super.getDangers();
        if (getTemperature() < VERY_COLD_TEMPERATURE) dangers.add("В школу не надо");
        if (getTemperature() < WATER_FREEZE_TEMPERATURE && getIsRain()) dangers.add("Гололед");
        return dangers;
    }
    
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
