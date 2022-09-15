package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Launch {

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    
    public static void main(String[] args) {
        // РАБОТА С БАЗОЙ ДАННЫХ MYSQL ЧЕРЕЗ JDBC
        try {
            // Адрес нашей базы данных "tsn_demo" на локальном компьютере (localhost)
            String url = "jdbc:mysql://localhost:3306/weather?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

            // Создание свойств соединения с базой данных
            Properties authorization = new Properties();
            authorization.put("user", "root"); // Зададим имя пользователя БД
            authorization.put("password", "root"); // Зададим пароль доступа в БД

            // Создание соединения с базой данных
            Connection connection = DriverManager.getConnection(url, authorization);

            // Создание оператора доступа к базе данных
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            // Выполнение запроса к базе данных, получение набора данных
            ResultSet table = statement.executeQuery("SELECT "
                    + "weather_log.id, weather_log.date, weather_log.temperature, weather_log.wind_speed, wind_directions.name as wind_direction, weather_types.name as weather_type " 
                    + "FROM weather_log "
                    + "INNER JOIN weather_types on weather_types.id = weather_log.weather_type_id "
                    + "INNER JOIN wind_directions on wind_directions.id = weather_log.wind_direction_id");

            table.first(); // Выведем имена полей
            System.out.print(padRight("ID", 3) + "\t\t");
            System.out.print(padRight("Дата", 10) + "\t\t");
            System.out.print(padRight("Температура", 11) + "\t\t");
            System.out.print(padRight("Скорость ветра", 14) + "\t\t");
            System.out.print(padRight("Направление ветра", 17) + "\t\t");
            System.out.print(padRight("Погода", 15) + "\t\t");
            System.out.println();
            System.out.println("-".repeat(128));
            
            table.beforeFirst(); // Выведем записи таблицы
            while (table.next()) {
                System.out.print(padRight(table.getString("ID"), 3) + "\t\t");
                Date date = (new SimpleDateFormat("yyyy-mm-dd")).parse(table.getString("date"));
                System.out.print(padRight((new SimpleDateFormat("dd.mm.yyyy")).format(date), 10) + "\t\t");
                System.out.print(padRight(table.getString("temperature") + " °C", 11) + "\t\t");
                System.out.print(padRight(table.getString("wind_speed") + " м/с", 14) + "\t\t");
                System.out.print(padRight(table.getString("wind_direction"), 17) + "\t\t");
                System.out.print(padRight(table.getString("weather_type"), 15) + "\t\t");
                System.out.println();
            }

            if (table != null) { table.close(); } // Закрытие набора данных
            if (statement != null) { statement.close(); } // Закрытие базы данных
            if (connection != null) { connection.close(); } // Отключение от базы данных

        } catch (Exception e) {
            System.err.println("Error accessing database!");
            e.printStackTrace();
        }
    }

}
