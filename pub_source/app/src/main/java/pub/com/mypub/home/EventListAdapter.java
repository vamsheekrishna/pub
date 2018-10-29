package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pub.com.mypub.R;

public class EventListAdapter extends RecyclerView.Adapter<EventObject> {
    RecycleItemClickListener mListener;
    EventListAdapter(RecycleItemClickListener listener) {
        mListener = listener;
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

    }


    @Override
    public int getItemCount() {
        return 6;
    }
}
