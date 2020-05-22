import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.*;
import java.text.*;
public class Main
{
  public static Integer differenceInDates (String d2, String d1)
  {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date1 = LocalDate.parse(d1, dtf);
    LocalDate date2 = LocalDate.parse(d2, dtf);
    Integer daysBetween = (int) (long) ChronoUnit.DAYS.between(date1, date2);
    return daysBetween;
  }
  public static String getPrevDate(String curDate) {
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  LocalDate date = LocalDate.parse(curDate, dtf);
  date = date.plusDays(-1);
  return date.toString();
}
  public static Dictionary func (Dictionary<String,Integer> dict)
  {
      Dictionary<String,Integer> res = new Hashtable<String,Integer>();
      Enumeration dictKeys = dict.keys();
      Enumeration dictElements = dict.elements();
      String d1 = dictKeys.nextElement().toString();
      String d2;
      Integer v1 = Integer.parseInt(dictElements.nextElement().toString());
      Integer v2;
    for ( ;dictElements.hasMoreElements();)
        {
            d2=dictKeys.nextElement().toString();
            v2 = Integer.parseInt(dictElements.nextElement().toString());
            res.put(d1,v1);
            Integer diffDates = differenceInDates(d1,d2);
            Integer diff = (v2-v1)/diffDates;
            for(int i=0; i<diffDates-1; i++) {
                d1 = getPrevDate(d1);
                v1=v1+diff;
                res.put(d1,v1);
            }
            d1=d2;
            v1=v2;
        }
        res.put(d1,v1);
    return res;
  }
  public static void printDictionary (Dictionary<String,Integer> dict)
  {
    Enumeration dictKeys = dict.keys();
    Enumeration dictElements = dict.elements();
    for (; dictElements.hasMoreElements();)
        {
            System.out.println (dictKeys.nextElement() + " : " +
			    dictElements.nextElement());
        }
  }
  public static void main (String[]args)
  {
    Dictionary<String,Integer> dict = new Hashtable<String,Integer> ();
    System.out.println("Input-");
    dict.put ("2020-03-11", 20);
    dict.put ("2020-03-10", 10);
    dict.put("2020-03-13",10);
    printDictionary(dict);
    Dictionary output = func (dict);
    System.out.println("Output-");
    printDictionary(output);
  }
}