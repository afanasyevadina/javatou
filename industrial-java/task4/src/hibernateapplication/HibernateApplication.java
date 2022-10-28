package hibernateapplication;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class HibernateApplication {

    public static void main(String[] args) throws ParseException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        WeatherType weatherType1 = new WeatherType();
        weatherType1.setName("Наводнение");
        session.save(weatherType1);

        WeatherType weatherType2 = new WeatherType();
        weatherType2.setName("Апокалипсис");
        session.save(weatherType2);

        org.hibernate.Transaction tr = session.beginTransaction();
        session.delete(weatherType1);
        tr.commit();

        List<WeatherType> list = (List<WeatherType>) session.createCriteria(WeatherType.class).list();
//	    List<UserRole> list=(List<UserRole>)session.createSQLQuery("select * from WeatherType").addEntity(WeatherType.class).list();
//        List<UserRole> list = (List<UserRole>) session.createQuery("from WeatherType where id in (7,10,48)").list();
        for (WeatherType role : list) {
            System.out.println(role);
        }

        WeatherLog log = new WeatherLog();
        log.setDate(Date.from(Instant.now()));
        log.setWeatherType(weatherType2);
        log.setWindSpeed(0.0);
        log.setTemperature(6.0);
        log.setWindDirection(session.get(WindDirection.class, 3));
        session.save(log);
        
        log = (WeatherLog) session.get(WeatherLog.class, log.getId());
        log.setTemperature(9.0);
        session.save(log);
        
        formattedHeader();
        
        List<WeatherLog> list2 = (List<WeatherLog>) session
                .createCriteria(WeatherLog.class)
                //  .addOrder(Order.asc("login"))
                // .createCriteria("userRole")
                //.add(Expression.like("name", "%"))
                //.addOrder(Order.asc("name"))
                .list();
        list2.forEach((item) -> {
            formattedRow(item);
            //System.out.println(item);
        });
        
        session.close();

        System.exit(0);
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
    
    protected static void formattedRow(WeatherLog weatherLog)
    {
        System.out.print(padRight(Integer.toString(weatherLog.getId()), 3) + "\t\t");
        System.out.print(padRight(DateHelper.formatDate(weatherLog.getDate()), 10) + "\t\t");
        System.out.print(padRight(weatherLog.getTemperature().toString(), 11) + "\t\t");
        System.out.print(padRight(weatherLog.getWindSpeed().toString(), 14) + "\t\t");
        System.out.print(padRight(weatherLog.getWindDirection().getName(), 17) + "\t\t");
        System.out.print(padRight(weatherLog.getWeatherType().getName(), 15) + "\t\t");
        System.out.println();
    }
}
