/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
            Scanner scan = new Scanner(System.in);
            System.out.println("За сколько дней записать погоду?");
            List<String> cities = new ArrayList<>(List.of("Pavlodar", "Nur-Sultan", "Almaty"));
            int count;
            while (true) {
                if (scan.hasNextInt()) {
                    count = scan.nextInt();
                    break;
                } else {
                    System.out.println("Надо было число: ");
                    scan.next();
                }
            }
            for (int i = 0; i < count; i++) {
                for (String city : cities) {
                    Date date = Date.from(Instant.now());
                    date.setTime(date.getTime() - 3600 * 24 * 1000 * (count - i));
                    DetailedForecast forecast = new DetailedForecast(city, date);
                    System.out.println("Погода в городе " + forecast.getCity() + " " + forecast.getDate() + ": ");
                    System.out.println("Температура: ");
                    while (true) {
                        if (scan.hasNextDouble()) {
                            forecast.setTemperature(scan.nextDouble());
                            break;
                        } else {
                            System.out.println("Надо было число: ");
                            scan.next();
                        }
                    }
                    System.out.println("Скорость ветра: ");
                    while (true) {
                        if (scan.hasNextDouble()) {
                            forecast.setWindSpeed(scan.nextDouble());
                            break;
                        } else {
                            System.out.println("Надо было число: ");
                            scan.next();
                        }
                    }
                    System.out.println("Влажность: ");
                    while (true) {
                        if (scan.hasNextDouble()) {
                            forecast.setHumidity(scan.nextDouble());
                            break;
                        } else {
                            System.out.println("Надо было число: ");
                            scan.next();
                        }
                    }
                    System.out.println("Дождь (1/0): ");
                    forecast.setIsRain("1".equals(scan.next()));
                    System.out.println("Солнечно (1/0): ");
                    forecast.setIsSunny("1".equals(scan.next()));
                    history.addItem(forecast);
                }
            }
            LinkedList<DetailedForecast> forecastsList = history.getForecastsList();
            LinkedHashSet<DetailedForecast> forecastsSet = history.getForecastsSet();
            LinkedHashMap<String, DetailedForecast> forecastsMap = history.weatherMapByCity("Pavlodar");
            System.out.println("--- List before changing ---");
            System.out.println(forecastsList);
            System.out.println("--- Set before changing ---");
            System.out.println(forecastsSet);
            System.out.println("--- Map of Pavlodar weather before changing ---");
            System.out.println(forecastsMap);

            forecastsList.remove(0);
            forecastsSet.remove(forecastsSet.stream().findFirst().get());
            forecastsMap.remove(forecastsMap.keySet().stream().findFirst().get());

            forecastsList.getLast().setIsSunny(true);
            forecastsList.getLast().setTemperature(24);

            forecastsSet.stream().skip(forecastsSet.size() - 1).findFirst().get().setIsSunny(true);
            forecastsSet.stream().skip(forecastsSet.size() - 1).findFirst().get().setTemperature(24);

            forecastsMap.get(forecastsMap.keySet().stream().skip(forecastsMap.keySet().size() - 1).findFirst().get()).setIsSunny(true);
            forecastsMap.get(forecastsMap.keySet().stream().skip(forecastsMap.keySet().size() - 1).findFirst().get()).setTemperature(24);

            System.out.println("\n--- Changing... ---\n");

            System.out.println("--- List after changing ---");
            System.out.println(forecastsList);
            System.out.println("--- Set after changing ---");
            System.out.println(forecastsSet);
            System.out.println("--- Map of Pavlodar weather after changing ---");
            System.out.println(forecastsMap);
        } catch (Exception e) {
            System.out.println("Что-то не то ввели...");
        }
    }

}
