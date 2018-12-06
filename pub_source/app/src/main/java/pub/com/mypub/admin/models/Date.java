package pub.com.mypub.admin.models;
import java.io.Serializable;
import java.util.ArrayList;

public class Date implements Serializable {
    public String start_date = null;
    public String end_date = null;
    public ArrayList<Date> mDate = null;

    public Date() {
    }

    public Date ( String _start_date, String _end_date)
    {

    }
}