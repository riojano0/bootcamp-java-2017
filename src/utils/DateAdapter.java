package utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel on 09/01/2017.
 */
public class DateAdapter {
    /* class create only for no use Calendar */

    private DateAdapter(){}

    public static Date dateFormat(String dateString) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date date = fmt.parse(dateString);
        return date;
    }

    public static String dateDeformat(Date date){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = fmt.format(date);
        return dateString;
    }
}
