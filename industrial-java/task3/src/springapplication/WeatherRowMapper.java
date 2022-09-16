package springapplication;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс загрузки данных в объект Weather из считанной записи таблицы БД
 *
 */
public class WeatherRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int line) throws SQLException {
        PersonResultSetExtractor extractor = new PersonResultSetExtractor();
        return extractor.extractData(rs);
    }

    /**
     * Класс загрузки данных в объект данных из считанной записи таблицы
     *
     */
    class PersonResultSetExtractor implements ResultSetExtractor {

        @Override
        public Object extractData(ResultSet rs) throws SQLException {
            Weather weatherLog = new Weather();
            weatherLog.setId(rs.getInt("id"));
            try {
                weatherLog.setDate((new SimpleDateFormat("yyyy-mm-dd")).parse(rs.getString("date")));
            } catch (ParseException ex) {
                Logger.getLogger(WeatherRowMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            weatherLog.setTemperature(rs.getDouble("temperature"));
            weatherLog.setWindSpeed(rs.getDouble("wind_speed"));
            weatherLog.setWindDirectionId(rs.getInt("wind_direction_id"));
            weatherLog.setWeatherTypeId(rs.getInt("weather_type_id"));
            weatherLog.setWeatherType(new WeatherType(rs.getString("weather_type_name")));
            weatherLog.setWindDirection(new WindDirection(rs.getString("wind_direction_name")));
            return weatherLog;
        }
    }
}
