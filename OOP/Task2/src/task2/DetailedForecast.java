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
 * Самый прокачанный класс со всеми реализованными абстрактными методами и методами интерфейса
 * 
 * @author user
 */
public class DetailedForecast extends ANotification {
    /**
     * При этой погоде надо предупредить население
     */
    final double VERY_COLD_TEMPERATURE = -30.0;
    /**
     * Конструктор без параметров
     */
    public DetailedForecast() {
        super();
    }
    
    /**
     * Конструктор с температурой и скоростью ветра
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public DetailedForecast(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    /**
     * Конструктор со всеми данными
     * @param city String which is the city name
     * @param date Date of forecast
     */
    public DetailedForecast(String city, Date date) {
        super(city, date);
    }
    
    /**
     * Конструктор со всеми данными
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
     * Тепрература в Фаренгейтах
     * @return double value of temperature in Farengeit
     */
    @Override
    public double temperatureInFarentgeit()
    {
        return getTemperature() * 9 / 5 + 32;
    }
    
    /**
     * Перевод текста по словарю
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
     * Список опасностей
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
     * Текст предупреждения
     * @return String with attention
     */
    @Override
    public String attentionText()
    {
        if(getDangers().size() < 1) {
            return getDate() + " в " + getCity() + " все хорошо";
        }
        String output = "Внимание жителям города " + getCity() + "! " + getDate() + ":";
        output = getDangers().stream().map(danger -> "\n" + danger).reduce(output, String::concat);
        return output;
    }
    
    /**
     * Текст проноза погоды
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
