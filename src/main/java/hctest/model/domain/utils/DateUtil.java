package hctest.model.domain.utils;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

  public static final String DEFAULT_DATE_FORMAT = "dd.MM.yyyy";
  public static final String DEFAULT_DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";
  public static final String DEFAULT_DATE_FORMAT_PREC = "dd.MM.yyyy HH:mm:ss.SSSS Z";

  /**
   * Porównanie z dokładnością do pełnej sekundy
   */
  public static boolean equalsToSec(Date d1, Date d2) {
    if (d1 == null || d2 == null) 
      return false;
    
    Date dd1 = truncToSec(d1);
    Date dd2 = truncToSec(d2);
    
    return dd1.equals(dd2);
  }
  
  /**
   * SQL like trunc(), usuwa godzinę
  public static Date trunc(Date date) {

     if (date == null) {
       return null;
     }
   Calendar c = Calendar.getInstance();
   c.setTime(date);    
   c.set(Calendar.HOUR_OF_DAY, 0);
   c.set(Calendar.MINUTE, 0);
   c.set(Calendar.SECOND, 0);
   c.set(Calendar.MILLISECOND, 0);  
   return c.getTime();
  } */
  
  /**
   * Przycina do pełnego dnia
   */
  public static Date truncToDay(Date date) {
    return DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
  }
  
  /**
   * konstruktor dla formatu DEFAULT_DATE_TIME_FORMAT
   */
  public static Date toDatePrec(String date) {
    return toDate_(date, DEFAULT_DATE_TIME_FORMAT);      
  }
  
  /**
   * konstruktor dla formatu dd.MM.yyyy
   */
  public static Date toDate(String date) {
    return toDate_(date, DEFAULT_DATE_FORMAT);    
  }
  
  /**
   * Przycina do pełnej sekundy. Zwraca null dla daty równej null
   */
  public static Date truncToSec(Date date) {
    if(date == null){
      return null;
    }
    return DateUtils.truncate(date, Calendar.SECOND);
  }

  /**
   * Konwertuje do String korzystając formatu - dd.MM.yyyy
   */
  public static String formatTrunc(Date date) {
    return format_(date, DEFAULT_DATE_FORMAT); 
  }

  /**
   * Konwertuje do String korzystając z formatu - dd.MM.yyyy HH:mm:ss
   */
  public static String format(Date date) {
    return format_(date, DEFAULT_DATE_TIME_FORMAT); 
  }
  
  /**
   * Konwertuje do String korzystając z formatu - dd.MM.yyyy HH:mm:ss.SSSS Z
   */
  public static String formatPrec(Date date) {
    return format_(date, DEFAULT_DATE_FORMAT_PREC); 
  }
  
  private static String format_(Date date, String format) {
    DateFormat dateFormatter = new SimpleDateFormat(format);
    dateFormatter.setLenient(false);

    if (date == null) {
      return "null";
    }

    return dateFormatter.format(date); 
  }
  
  private static Date toDate_(String date, String format) {
    DateFormat dateFormatter = new SimpleDateFormat( format );
    dateFormatter.setLenient(false);      
      
    try {
      return dateFormatter.parse(date);
    }
    catch (ParseException pe) {
      throw new RuntimeException("ParseException for value: "+date,pe);
    }      
  }
}
