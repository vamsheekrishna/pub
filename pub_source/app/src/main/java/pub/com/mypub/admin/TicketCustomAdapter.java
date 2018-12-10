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
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.home.RecycleItemClickListener;
import pub.com.mypub.home.TicketObject;

public class TicketCustomAdapter extends RecyclerView.Adapter<TicketViewHolder> {
    RecycleItemClickListener mListener;
    public ArrayList<Ticket> mTicketList ;
    ArrayList<Ticket> tickets;
    public TicketCustomAdapter(ArrayList<Ticket> tickets) {
        mTicketList=tickets;
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
//        ticketViewHolder.ch1.setText(ticket.title);
        ticketViewHolder.ch1.setChecked(ticket.isSelected());
        ticketViewHolder.ch1.setTag(ticket);
    }



    @Override
    public int getItemCount() {
        return mTicketList.size();
    }

//    public TicketCustomAdapter(Context context, int code, ArrayList<Ticket> mTicketList) {
//        super(context, code, mTicketList);
//        this.mTicketList = new ArrayList<Ticket>();
//        this.mTicketList.addAll(mTicketList);
//    }
//
//
//    private class ViewHolder {
//        //TextView id;
//        CheckBox name;
//    }
//
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        pub.com.mypub.admin.TicketCustomAdapter.ViewHolder holder = null;
//        Log.v("ConvertView", String.valueOf(position));
//
//        if (convertView == null) {
//            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = vi.inflate(R.layout.ticket_info, null);
//
//            holder = new pub.com.mypub.admin.TicketCustomAdapter.ViewHolder();
//           // holder.id = (TextView) convertView.findViewById(R.id.code);
//            holder.name = (CheckBox) convertView.findViewById(R.id.ch1);
//            convertView.setTag(holder);
//
//            holder.name.setOnClickListener( new View.OnClickListener() {
//                public void onClick(View v) {
//                    CheckBox ch1 = (CheckBox) v ;
//                    Ticket ticket = (Ticket) ch1.getTag();
//                   ticket.setSelected(ch1.isChecked());
//                }
//            });
//        }
//        else {
//            holder = (pub.com.mypub.admin.TicketCustomAdapter.ViewHolder) convertView.getTag();
//        }
//
//       Ticket ticket = mTicketList.get(position);
//        //holder.id.setText(" (" +  ticket.getId() + ")");
//        holder.name.setText(ticket.getTicket_name());
//        holder.name.setChecked(ticket.isSelected());
//        holder.name.setTag(ticket);
//
//        return convertView;
//
//
//
//
//
//    }
}