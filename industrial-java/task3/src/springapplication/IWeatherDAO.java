package springapplication;

import java.util.Date;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Интерфейс работы с таблицой Weather
 *
 */
public interface IWeatherDAO {
    void setDataSource(DataSource ds); // Установка связи с данныими
    void insert(Weather weatherLog); // Вставка новой записи
    void append(Date date, double temperature, double windSpeed, int windDirection, int weatherType); // Добавление новой записи
    void deleteByDate(Date date); // Удаление записи по фамилии
    void deleteAll(); // Удаление всех запией
    void update(Date date, Map<String, String> fields); // Изменение записей в таблице
    Weather findByDate(Date date); // Получение записи с заданным возрастом
    List<Weather> select(Map<String, String> fields); // Получение записей с заданным именем и фамилией
    List<Weather> selectAll(); // Получение всех записей
}
