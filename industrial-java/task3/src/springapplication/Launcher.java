package springapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.util.List;

class Launcher {
    
    protected static String dateFormat = "yyyy-mm-dd";
    
    protected static Date parseDate(String dateString) throws ParseException
    {
        return (new SimpleDateFormat(dateFormat).parse(dateString));
    }
    
    protected static String formatDate(Date date)
    {
        return (new SimpleDateFormat(dateFormat).format(date));
    }
    
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    
    protected static void formattedHeader()
    {
        System.out.print(padRight("ID", 3) + "\t\t");
        System.out.print(padRight("Дата", 10) + "\t\t");
        System.out.print(padRight("Температура", 11) + "\t\t");
        System.out.print(padRight("Скорость ветра", 14) + "\t\t");
        System.out.print(padRight("Направление ветра", 17) + "\t\t");
        System.out.print(padRight("Погода", 15) + "\t\t");
        System.out.println();
        System.out.println("-".repeat(136));
    }
    
    protected static void formattedRow(Weather weatherLog)
    {
        System.out.print(padRight(Integer.toString(weatherLog.getId()), 3) + "\t\t");
        System.out.print(padRight(formatDate(weatherLog.getDate()), 10) + "\t\t");
        System.out.print(padRight(weatherLog.getTemperature().toString(), 11) + "\t\t");
        System.out.print(padRight(weatherLog.getWindSpeed().toString(), 14) + "\t\t");
        System.out.print(padRight(weatherLog.getWindDirection().getName(), 17) + "\t\t");
        System.out.print(padRight(weatherLog.getWeatherType().getName(), 15) + "\t\t");
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // Загрузка файла с биновами

            WeatherDAO weatherDAO = (WeatherDAO) context.getBean("customerDAO"); // Загрузка бина доступа к таблице 

            weatherDAO.deleteAll(); // Удаление всех записей
            
            Weather weatherLog = new Weather(parseDate("2022-09-01"), 17, 5, 5, 2); // Создание нового объекта таблицы 
            weatherDAO.insert(weatherLog); // Вставить новый объект (запись) в таблицу

            weatherDAO.insert(new Weather(parseDate("2022-09-02"), 12, 4, 3, 1)); // Вставить новый объект (запись) в таблицу

            Weather weatherLog1 = weatherDAO.findByDate(parseDate("2022-09-01")); // Поиск записи по возрасту клиента
            System.out.println(weatherLog1 != null ? weatherLog1 : "Нет данных"); // Вывод на экран найденной записи

            weatherDAO.deleteByDate(parseDate("2022-09-02")); // Удаление записей по фрагменту фамилии

            weatherDAO.append(parseDate("2022-09-03"), 12, 4, 3, 1); // Добавлние записей
            weatherDAO.append(parseDate("2022-09-04"), 30, 0, 2, 4); // Добавлние записей
            weatherDAO.append(parseDate("2022-09-05"), 12, 4, 1, 3); // Добавлние записей
            weatherDAO.append(parseDate("2022-09-06"), 43, 3, 4, 1); // Добавлние записей
            weatherDAO.append(parseDate("2022-09-07"), 18, 1, 2, 2); // Добавлние записей
            

            weatherDAO.update(parseDate("2022-09-01"), new HashMap<String, String>() {{
                put("temperature", "15");
                put("wind_speed", "3");
            }}); // Изменение записей в таблице

            System.out.println("Данные в таблице БД:");
            
            formattedHeader();

            List<Weather> list = weatherDAO.selectAll();
            for (Weather weatherLogItem : list) {
                formattedRow(weatherLogItem);
            }
            
            System.out.println();

            System.out.println("Данные в таблице БД с температурой 12 и скоростью ветра 4:");
            
            formattedHeader();

            List<Weather> listFiltered = weatherDAO.select(new HashMap<String, String>() {{
                put("temperature", "12");
                put("wind_speed", "4");
            }});
            for (Weather weatherLogItem : listFiltered) {
                formattedRow(weatherLogItem);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }
}
