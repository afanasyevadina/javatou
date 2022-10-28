package hibernateapplication;

import java.util.Date;

public class WeatherLog {

    private Integer id;
    private WeatherType weatherType;
    private WindDirection windDirection;
    private Double temperature;
    private Double windSpeed;
    private Date date;

    public WeatherLog() {
    }

    public WeatherLog(Integer id) {
        this.id = id;
    }

    public WeatherLog(Integer id, WeatherType weatherType, WindDirection windDirection, Double temperature, Double windSpeed, Date date) {
        this.id = id;
        this.weatherType = weatherType;
        this.windDirection = windDirection;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    

    public String toString() {
        return String.format("%s, %s, температура-%.2f, ветер- %s, %.2f м/с", DateHelper.formatDate(getDate()), weatherType.getName(), getTemperature(), windDirection.getName(), getWindSpeed());
    }

}
