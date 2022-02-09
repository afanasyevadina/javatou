package task1;

//Вариант 1

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Здесь проверим, как все работает
 * @author Dina-PC
 */
public class Launch {

    /**
     * Точка входа
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //простой конструктор
        Weather weather1 = new Weather();
        System.out.println(weather1);
        
        //конструктор с 2 параметрами        
        Weather weather2 = new Weather(18, 15);
        System.out.println(weather2);
        //сеттеры
        weather2.setHumidity(78);
        weather2.setIsRain(true);
        System.out.println(weather2);
        
        //конструктор с 4 параметрами         
        Weather weather3 = new Weather("Павлодар", Date.from(Instant.now()), 12, 2, true, false);
        System.out.println(weather3);
        //геттеры
        System.out.println("try to get temperature via getter: " + weather3.getTemperature());
        System.out.println("try to get wind speed via getter: " + weather3.getWindSpeed());
        
        System.out.println("\n--------------------------\n");
        
        //класс-наследник со своим методом
        Forecast forecast1 = new Forecast(-24, 7);
        System.out.println("Зонт брать? " + (forecast1.needUmbrella() ? "Да" : "Нет"));
        System.out.println("А лужи замерзнут? " + (forecast1.willWaterFreeze() ? "Да" : "Нет"));
        
        System.out.println("\n--------------------------\n");
        
        //унаследован от абстрактного и переопределены методы
        Date customDate;
        try {
            customDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-24");
        } catch(ParseException ex) {
            customDate = Date.from(Instant.now());
        }
        DetailedForecast detailedForecast = new DetailedForecast("Стокгольм", customDate ,-35, 30, false, true);
        System.out.println(detailedForecast.attentionText());
        
        System.out.println("\n--------------------------\n");
        
        detailedForecast.setTemperature(25);
        
        //это из интерфейса
        System.out.println("Information for foreigners.\nTemperature in Farentgeit: " + detailedForecast.temperatureInFarentgeit());
        System.out.println("\n");        
        System.out.println(detailedForecast.translate(detailedForecast.forecastText()));
        System.out.println("\n");
        System.out.println(detailedForecast.translate(detailedForecast.attentionText()));
        
    }
    
}
