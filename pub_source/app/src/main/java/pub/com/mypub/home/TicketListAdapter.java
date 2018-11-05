package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pub.com.mypub.R;

public class TicketListAdapter extends RecyclerView.Adapter<TicketObject> {
    RecycleItemClickListener mListener;
    TicketListAdapter(RecycleItemClickListener listener) {
        mListener = listener;
    }
    @NonNull
    @Override
    public TicketObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_add_event, viewGroup, false);
        TicketObject Ticketobject  = new TicketObject(itemView, mListener);
        return Ticketobject ;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketObject TicketObject, int i) {

    }




    @Override
    public int getItemCount() {
        return 5;
    }
}

