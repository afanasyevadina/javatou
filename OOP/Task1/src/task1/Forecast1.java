/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

/**
 *
 * @author user
 */
public class Forecast1 { //это главный
    private double temperature; 
    private double humidity; 
    private double windSpeed; 
    private boolean isRain;
    private boolean isSunny;

    // Это конструктор по-умолчанию (без параметров)
    public Forecast1() {
        temperature = 0;
        humidity = 70;
        windSpeed = 0;
        isRain = false;
        isSunny = true;
    }
    
    public Forecast1(double temperature, double windSpeed) {
        this.temperature = temperature;
        this.humidity = 70;
        this.windSpeed = windSpeed;
        this.isRain = false;
        this.isSunny = true;
    }
    
    public Forecast1(double temperature, double windSpeed, boolean isRain, boolean isSunny) {
        this.temperature = temperature;
        this.humidity = 70;
        this.windSpeed = windSpeed;
        this.isRain = isRain;
        this.isSunny = isSunny;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public boolean getIsRain() {
        return isRain;
    }

    public void setIsRain(boolean isRain) {
        this.isRain = isRain;
    }

    public boolean getIsSunny() {
        return isSunny;
    }

    public void setIsSunny(boolean isSunny) {
        this.isSunny = isSunny;
    }
    
    @Override
    // Переопределение метода "toString" для печати объектов класса
    public String toString() {
        return "{ temperature=" + temperature + ", humidity=" + humidity + ", windSpeed=" + windSpeed + ", isRain=" + isRain+ ", isSunny=" + isSunny + '}';
    }
}
