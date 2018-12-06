package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Event;

public class DateListAdapter extends RecyclerView.Adapter<DateObject> {
    RecycleItemClickListener mListener;
    ArrayList<Event> event;
    public ArrayList<Event> mEventList ;
    String start_date, end_date,dayDifference,ds;
    Date date1,date2;
    long different;

    SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
    List<Date> dates;
    DateListAdapter(RecycleItemClickListener listener, ArrayList<Date> _dates) {
        dates=_dates;
        mListener = listener;
    }



    @NonNull
    @Override
    public DateObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_add_date, viewGroup, false);
        DateObject dateobject = new DateObject(itemView, mListener);
        return dateobject;
    }

    @Override
    public void onBindViewHolder(@NonNull DateObject dateObject, int i) {

        Date lDate = dates.get(i);
        ds = format.format(lDate);
        dateObject.start_date.setText(ds);
        dateObject.start_date.setTag(lDate);
        /*start_date = event.get(i).start_date;
        end_date = event.get(i).end_date;


        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");

        try {
            date1 = format.parse(start_date);
            date2 = format.parse(end_date);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/
/*        long interval = 24*1000 * 60 * 60;
        long endTime =date2.getTime() ;
        long curTime = date1.getTime();
        while (curTime <= endTime) {
            dates.add(new Date(curTime));
            curTime += interval;
        }
        for(i = 0; i<dates.size(); i++){
            Date lDate =(Date)dates.get(i);
           ds = format.format(lDate);
            System.out.println(" Date is ..." + ds);
        }
        different = Math.abs(date1.getTime() - date2.getTime());

        dayDifference = Long.toString(different);

        Log.e("HERE", "HERE: " + dayDifference);

        dateObject.start_date.setText(ds);
       dateObject.end_date.setText(ds);*/
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date1);
//
//        while (calendar.getTime().before(date2)) {
//            Date result = calendar.getTime();
//            event.add(result);
//            calendar.add(Calendar.DATE, 1);
//        }


    }

    @Override
    public int getItemCount() {
            return dates.size();
    }
}


