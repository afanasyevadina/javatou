/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task7;

/**
 * Интерфейс для локализации
 * 
 * @author user
 */
public interface IWeatherUSA {
    /**
     * Температура в Фаренгейтах
     * @return double value of temperature in Farengeit
     */
    double temperatureInFarentgeit();
    /**
     * Перевод строки
     * @param str String to translate
     * @return String translated
     */
    String translate(String str);
}
