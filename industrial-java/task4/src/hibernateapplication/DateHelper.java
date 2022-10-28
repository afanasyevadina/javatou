/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dinaafanasyeva
 */
public class DateHelper {
    
    
    protected static String dateFormat = "yyyy-mm-dd";
    
    protected static Date parseDate(String dateString) throws ParseException
    {
        return (new SimpleDateFormat(dateFormat).parse(dateString));
    }
    
    protected static String formatDate(Date date)
    {
        return (new SimpleDateFormat(dateFormat).format(date));
    }
}
