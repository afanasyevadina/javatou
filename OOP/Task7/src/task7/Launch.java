/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task7;

import java.util.ArrayList;
import java.util.Date;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Точка входа в программу
 *
 * @author Dina-PC
 */
public class Launch {

    /**
     * Здесь все происходит
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            WeatherHistory history = new WeatherHistory();
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-03-27"), 10, 2, false, false));
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-03-28"), 8, 5, false, true));
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-03-29"), 7, 12, true, false));
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-03-30"), 11, 0, false, true));
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-03-31"), 14, 3, false, true));
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-04-01"), 5, 1, false, true));
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-04-02"), 15, 8, false, false));
            history.addItem(new DetailedForecast("Pavlodar", stringToDate("2022-04-03"), 12, 4, false, true));
            LinkedList<DetailedForecast> forecastsList = history.getForecastsList();
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("weather.dat"))) {
                out.writeObject(forecastsList);
            }
            
            try (
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("weather.dat"))) {
                LinkedList<DetailedForecast> newForecastsList = (LinkedList<DetailedForecast>) in.readObject();
                newForecastsList.stream().forEach(item -> {
                    System.out.println(item);
                });
            }
        } catch (IOException | ClassNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    public static Date stringToDate(String str) throws ParseException
    {
        return Date.from(new SimpleDateFormat("yyyy-MM-dd").parse(str).toInstant());
    }

}
