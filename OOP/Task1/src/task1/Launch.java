package task1;

//Вариант 1

public class Launch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // главный класс
        
        //простой конструктор
        Forecast1 weather1 = new Forecast1();
        System.out.println(weather1);
        
        //конструктор с 2 параметрами        
        Forecast1 weather2 = new Forecast1(18, 15);
        System.out.println(weather2);
        //сеттеры
        weather2.setHumidity(78);
        weather2.setIsRain(true);
        System.out.println(weather2);
        
        //конструктор с 4 параметрами         
        Forecast1 weather3 = new Forecast1(12, 2, true, false);
        System.out.println(weather3);
        //геттеры
        System.out.println("try to get temperature via getter: " + weather3.getTemperature());
        System.out.println("try to get wind speed via getter: " + weather3.getWindSpeed());
        
        System.out.println("\n--------------------------\n");
        
        //класс-наследник со своим методом
        Forecast2 weather4 = new Forecast2(24, 7);
        weather4.forecast("Pavlodar");
        
        System.out.println("\n--------------------------\n");
        
        //унаследован от абстрактного и переопределны методы
        Forecast4 weather5 = new Forecast4(-5, 30, true, false);
        weather5.attention();
        
        //это абстрактные
        System.out.println("needUmbrella: " + weather5.needUmbrella());
        System.out.println("willWaterFreeze: " + weather5.willWaterFreeze());
        
        weather5.setTemperature(25);
        
        //это из интерфейса
        System.out.println("temperatureInFarentgeit: " + weather5.temperatureInFarentgeit());
        weather5.setWindSpeed(30);
        System.out.println("windSpeedInKmPerHour:" + weather5.windSpeedInKmPerHour());
    }
    
}
