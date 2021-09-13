package task1;

//Вариант 1

public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // главный класс
        
        //простой конструктор
        Weather1 weather1 = new Weather1();
        System.out.println(weather1);
        
        //конструктор с 2 параметрами        
        Weather1 weather2 = new Weather1(18, 15);
        System.out.println(weather2);
        //сеттеры
        weather2.setHumidity(78);
        weather2.setIsRain(true);
        System.out.println(weather2);
        
        //конструктор с 4 параметрами         
        Weather1 weather3 = new Weather1(12, 2, true, false);
        System.out.println(weather3);
        //геттеры
        System.out.println("try to get temperature via getter: " + weather3.getTemperature());
        System.out.println("try to get wind speed via getter: " + weather3.getWindSpeed());
        
        System.out.println("\n--------------------------\n");
        
        //класс-наследник со своим методом
        Weather2 weather4 = new Weather2(24, 7);
        weather4.forecast("Pavlodar");
        
        System.out.println("\n--------------------------\n");
        
        //унаследован от абстрактного и переопределны методы
        Weather4 weather5 = new Weather4(-5, 30, true, false);
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
