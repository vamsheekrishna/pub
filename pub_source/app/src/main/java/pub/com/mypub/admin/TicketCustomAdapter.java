package pub.com.mypub.admin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.home.CreateTicketFragment;
import pub.com.mypub.home.RecycleItemClickListener;
import pub.com.mypub.home.TicketObject;

public class TicketCustomAdapter extends RecyclerView.Adapter<TicketViewHolder> {
    RecycleItemClickListener mListener;
    public ArrayList<Ticket> mTicketList ;
    ArrayList<Ticket> tickets;
    CreateTicketFragment mCreateTicketFragment;
    public TicketCustomAdapter(ArrayList<Ticket> tickets, CreateTicketFragment createTicketFragment) {
        mTicketList=tickets;
        mCreateTicketFragment=createTicketFragment;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ticket_info, viewGroup, false);
        TicketViewHolder dateobject = new TicketViewHolder(itemView, this);
        dateobject.ch1.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox ch1 = (CheckBox) v ;
                    Ticket ticket = (Ticket) ch1.getTag();
                   ticket.setSelected(ch1.isChecked());
                }
            });
        return dateobject;
    }


    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {
        Ticket ticket = mTicketList.get(i);
        ticketViewHolder.ch1.setText(ticket.ticket_name);
        ticketViewHolder.delete.setTag(i);
        ticketViewHolder.ch1.setChecked(ticket.isSelected());
        ticketViewHolder.ch1.setTag(ticket);
    }



    @Override
    public int getItemCount() {
        return mTicketList.size();
    }

    public void deleteRecord(int position) {
        Log.d("position", "position: "+position);
        mCreateTicketFragment.deleteTicket(position);
    }
}