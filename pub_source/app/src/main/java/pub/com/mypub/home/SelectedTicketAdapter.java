package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;


public class SelectedTicketAdapter extends RecyclerView.Adapter<SelectedTicketObject>{
    RecycleItemClickListener mListener;
    ArrayList<Ticket> tickets;
    SelectedTicketAdapter(RecycleItemClickListener listener, ArrayList<Ticket> _tickets) {
        mListener = listener;
        tickets = _tickets;
    }
    @Override
    public SelectedTicketObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.amount, viewGroup, false);
        SelectedTicketObject SelectedTicketobject  = new SelectedTicketObject(itemView, this);
        return SelectedTicketobject ;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedTicketObject selectedTicketObject, int i) {
//        selectedTicketObject.event.setText(tickets.get(i).title);
//        selectedTicketObject.date_time.setText(String.valueOf(tickets.get(i).price));
       selectedTicketObject.name.setText(tickets.get(i).ticket_name);
        selectedTicketObject.type.setText(tickets.get(i).mTicketCount+"");
        selectedTicketObject.price.setText(tickets.get(i).price);
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }
}
