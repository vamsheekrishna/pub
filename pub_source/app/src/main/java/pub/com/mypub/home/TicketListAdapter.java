package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Ticket;

public class TicketListAdapter extends RecyclerView.Adapter<TicketObject> {
    RecycleItemClickListener mListener;
    ArrayList<Ticket> tickets;
    TicketListAdapter(RecycleItemClickListener listener, ArrayList<Ticket> _tickets) {
        mListener = listener;
        tickets= _tickets;
    }
    @NonNull
    @Override
    public TicketObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_add_event, viewGroup, false);
        TicketObject Ticketobject  = new TicketObject(itemView, this);
        return Ticketobject ;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketObject ticketObject, int i) {
        ticketObject.mTVTitle.setText(tickets.get(i).title);
        ticketObject.mTVPrice.setText(String.valueOf(tickets.get(i).price));
        ticketObject.mTVDescription.setText(tickets.get(i).description);
        ticketObject.mPlus.setTag(i);
        ticketObject.mMinus.setTag(i);
    }
    public int getTicketObject(int value, int position) {
        if(!(value<0 && tickets.get(position).mTicketCount<=0)) {
            tickets.get(position).mTicketCount += value;
        }
        return tickets.get(position).mTicketCount;
    }
    @Override
    public int getItemCount() {
        return tickets.size();
    }
}

