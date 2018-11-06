package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pub.com.mypub.R;

public class TimeListAdapter extends RecyclerView.Adapter<TimeObject> {
    RecycleItemClickListener mListener;
    TimeListAdapter(RecycleItemClickListener listener) {
        mListener = listener;
    }
    @NonNull
    @Override
    public TimeObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_add_time, viewGroup, false);
        TimeObject Timeobject = new TimeObject(itemView, mListener);
        return Timeobject;
    }

    @Override
    public void onBindViewHolder(@NonNull TimeObject timeObject, int i) {

    }






    @Override
    public int getItemCount() {
        return 8;
    }
}


