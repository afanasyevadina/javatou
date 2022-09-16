package springapplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.TransactionStatus;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Реализация интерфейса работы с таблицей Weather
 *
 */
public class WeatherDAO implements IWeatherDAO {

    private DataSource dataSource;
    
    private String formatDate(Date date)
    {
        return (new SimpleDateFormat("yyyy-mm-dd").format(date));
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Weather weatherLog) { // Реализация вставки новой записи

        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO weather_log (date, temperature, wind_speed, wind_direction_id, weather_type_id) VALUES(?,?,?,?,?)",
                new Object[]{formatDate(weatherLog.getDate()), weatherLog.getTemperature(), weatherLog.getWindSpeed(), weatherLog.getWindDirectionId(), weatherLog.getWeatherTypeId()});
    }

    @Override
    public void append(Date date, double temperature, double windSpeed, int windDirectionId, int weatherTypeId) {  // Реализация добавления новой записи
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO weather_log (date, temperature, wind_speed, wind_direction_id, weather_type_id) VALUES(?,?,?,?,?)", new Object[]{formatDate(date), temperature, windSpeed, windDirectionId, weatherTypeId});
    }

    @Override
    public void deleteByDate(Date date) {  // Реализация удаления записей по дате
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("DELETE FROM weather_log WHERE date = ?", new Object[]{formatDate(date)});
    }

    @Override

    public void deleteAll() {  // Реализация удаления всех запией
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from weather_log");
    }

    @Override
    public Weather findByDate(Date date) { // Реализация поиска записи с заданной датой
        JdbcTemplate select = new JdbcTemplate(dataSource);
        List<Weather> weatherLog = select.query("SELECT "
                + "weather_log.id, weather_log.date, weather_log.temperature, weather_log.wind_speed, weather_type_id, wind_direction_id, wind_directions.name as wind_direction_name, weather_types.name as weather_type_name "
                + "FROM weather_log "
                + "INNER JOIN weather_types on weather_types.id = weather_log.weather_type_id "
                + "INNER JOIN wind_directions on wind_directions.id = weather_log.wind_direction_id "
                + "WHERE date = ?",
                new Object[]{formatDate(date)}, new WeatherRowMapper());
        return weatherLog.size() > 0 ? weatherLog.get(0) : null;
    }

    @Override
    public List<Weather> select(Map<String, String> fields) {  // Реализация получения записей с какими-то полями
        NamedParameterJdbcTemplate select = new NamedParameterJdbcTemplate(dataSource);
        String sql = "SELECT "
                + "weather_log.id, weather_log.date, weather_log.temperature, weather_log.wind_speed, weather_type_id, wind_direction_id, wind_directions.name as wind_direction_name, weather_types.name as weather_type_name "
                + "FROM weather_log "
                + "INNER JOIN weather_types on weather_types.id = weather_log.weather_type_id "
                + "INNER JOIN wind_directions on wind_directions.id = weather_log.wind_direction_id";
        MapSqlParameterSource source = new MapSqlParameterSource();
        if(!fields.keySet().isEmpty()) sql += " where";
        ArrayList<String> conditions = new ArrayList<String>();
        for (String key : fields.keySet()) {
            conditions.add(" " + key + " = :" + key);
            source.addValue(key, fields.get(key));
        }
        sql += String.join(" AND ", conditions);
        return select.query(sql, source, new WeatherRowMapper());
    }

    @Override
    public List<Weather> selectAll() {  // Реализация получения всех записей
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT "
                + "weather_log.id, weather_log.date, weather_log.temperature, weather_log.wind_speed, weather_type_id, wind_direction_id, wind_directions.name as wind_direction_name, weather_types.name as weather_type_name "
                + "FROM weather_log "
                + "INNER JOIN weather_types on weather_types.id = weather_log.weather_type_id "
                + "INNER JOIN wind_directions on wind_directions.id = weather_log.wind_direction_id", new WeatherRowMapper());
    }

    @Override
    public void update(Date date, Map<String, String> fields) {
        NamedParameterJdbcTemplate select = new NamedParameterJdbcTemplate(dataSource);
        String sql = "UPDATE weather_log SET ";
        ArrayList<String> changes = new ArrayList<String>();
        MapSqlParameterSource source = new MapSqlParameterSource();
        for (String key : fields.keySet()) {
            changes.add(key + " = :" + key);
            source.addValue(key, fields.get(key));
        }
        sql += String.join(", ", changes);
        sql += " where date = :date";
        source.addValue("date", fields.get(formatDate(date)));
        select.update(sql, source);
    }

}
