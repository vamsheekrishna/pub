package pub.com.mypub.admin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Ticket;

public class TicketCustomAdapter extends ArrayAdapter<Ticket> {




    public ArrayList<Ticket> mTicketList = new ArrayList<>();
    public TicketCustomAdapter(Context context, int code, ArrayList<Ticket> mTicketList) {
        super(context, code, mTicketList);
        this.mTicketList = new ArrayList<Ticket>();
        this.mTicketList.addAll(mTicketList);
    }


    private class ViewHolder {
        TextView id;
        CheckBox name;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        pub.com.mypub.admin.TicketCustomAdapter.ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.ticket_info, null);

            holder = new pub.com.mypub.admin.TicketCustomAdapter.ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.code);
            holder.name = (CheckBox) convertView.findViewById(R.id.ch1);
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox ch1 = (CheckBox) v ;
                    Ticket ticket = (Ticket) ch1.getTag();
                   ticket.setSelected(ch1.isChecked());
                }
            });
        }
        else {
            holder = (pub.com.mypub.admin.TicketCustomAdapter.ViewHolder) convertView.getTag();
        }

       Ticket ticket = mTicketList.get(position);
        holder.id.setText(" (" +  ticket.getId() + ")");
        holder.name.setText(ticket.getName());
        holder.name.setChecked(ticket.isSelected());
        holder.name.setTag(ticket);

        return convertView;





    }}