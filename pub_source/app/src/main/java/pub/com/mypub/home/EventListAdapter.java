package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Event;

public class EventListAdapter extends RecyclerView.Adapter<EventObject> {
    RecycleItemClickListener mListener;
    ArrayList<Event> event;
    EventListAdapter(RecycleItemClickListener listener,  ArrayList<Event> _event) {
        mListener = listener;
        event=_event;
    }


    @NonNull
    @Override
    public EventObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_list_row, viewGroup, false);
        EventObject eventObject = new EventObject(itemView, mListener);
        return eventObject;
    }

    @Override
    public void onBindViewHolder(@NonNull EventObject eventObject, int i) {
        eventObject.title.setText(event.get(i).title);
        eventObject.location_id.setText(event.get(i).location_id);
        eventObject.start_price.setText(event.get(i).start_price);
        eventObject.start_date.setText(event.get(i).start_date);
        eventObject.end_date.setText(event.get(i).end_date);
        eventObject.mBook.setTag(i);
    }


    @Override
    public int getItemCount() {
        return event.size();
    }
}
