/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Абстрактный класс, описывающий уведомления о погоде
 * 
 * @author user
 */
public abstract class ANotification extends Weather implements IWeatherUSA {
    /**
     * Предупреждение об опасностях
     * @return String attention about gangers
     */
    public abstract String attentionText();
    /**
     * Прогноз погоды - сводка
     * @return String forecast info
     */
    public abstract String forecastText();
    
    /**
     * Конструктор без параметров
     */
    public ANotification() {
        super();
    }
    
    /**
     * Конструктор с температурой и скоростью ветра
     * @param temperature double value of temperature in Cel
     * @param windSpeed double value of wind speed
     */
    public ANotification(double temperature, double windSpeed) {
        super(temperature, windSpeed);
    }
    
    /**
     * Конструктор с городом и датой
     * @param city String which is the city name
     * @param date Date of forecast
     */
    public ANotification(String city, Date date) {
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
    public ANotification(String city, Date date, double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        super(city, date, temperature, windSpeed, isRain, isSunny);
    }
    
    /**
     * Список опасностей
     * @return ArrayList of dangers
     */
    public List<String> getDangers()
    {
        List<String> dangers = new ArrayList<>();
        if(getIsRain()) dangers.add("Возьмите зонт, ожидается дождь");
        if (getTemperature() < DANGEROUS_TEMPERATURE) dangers.add("Будет холодно, одевайтесь теплее");
        if (getIsSunny()) dangers.add("Солнце светит прямо в глаз");
        if (getWindSpeed() < DANGEROUS_WIND_SPEED) dangers.add("Ветром унесет");
        return dangers;
    }
}
