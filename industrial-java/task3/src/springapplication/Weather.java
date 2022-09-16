package springapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс, соответсвующий записи в таблице Weather
 *
 */
public class Weather {

    int id;            // Код записи
    Date date; 
    Double temperature;
    Double windSpeed;
    Integer windDirectionId;
    Integer weatherTypeId;
    WeatherType weatherType;
    WindDirection windDirection;

    public Weather() {
        this.id = 0;
        this.date = null;
        this.temperature = null;
        this.windSpeed = null;
        this.windDirectionId = null;
        this.weatherTypeId = null;
        this.weatherType = null;
        this.windDirection = null;
    }

    public Weather(Date date) {
        this.id = 0;
        this.date = date;
        this.temperature = null;
        this.windSpeed = null;
        this.windDirectionId = null;
        this.weatherTypeId = null;
        this.weatherType = null;
        this.windDirection = null;
    }

    public Weather(Date date, double temperature, double windSpeed, int windDirectionId, int weatherTypeId) {
        this.id = 0;
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirectionId = windDirectionId;
        this.weatherTypeId = weatherTypeId;
        this.weatherType = null;
        this.windDirection = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDirectionId() {
        return windDirectionId;
    }

    public void setWindDirectionId(Integer windDirectionId) {
        this.windDirectionId = windDirectionId;
    }

    public Integer getWeatherTypeId() {
        return weatherTypeId;
    }

    public void setWeatherTypeId(Integer weatherTypeId) {
        this.weatherTypeId = weatherTypeId;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public String toString() {
        return String.format("Дата=%s, Температура=%.2f, Скорость ветра=%.2f, Направление ветра=%d, Погода=%d", (new SimpleDateFormat("dd.mm.yyyy")).format(date), temperature, windSpeed, windDirectionId, weatherTypeId);
    }

}
