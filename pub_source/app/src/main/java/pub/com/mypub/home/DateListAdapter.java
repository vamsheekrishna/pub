package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pub.com.mypub.R;

public class DateListAdapter extends RecyclerView.Adapter<DateObject> {
    RecycleItemClickListener mListener;
    DateListAdapter(RecycleItemClickListener listener) {
        mListener = listener;
    }
    @NonNull
    @Override
    public DateObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_add_date, viewGroup, false);
        DateObject Dateobject = new DateObject(itemView, mListener);
        return Dateobject;
    }

    @Override
    public void onBindViewHolder(@NonNull DateObject dateObject, int i) {

    }





    @Override
    public int getItemCount() {
        return 8;
    }
}


