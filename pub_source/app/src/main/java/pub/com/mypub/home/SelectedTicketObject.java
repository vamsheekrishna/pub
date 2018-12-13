package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Date;
import pub.com.mypub.admin.models.Ticket;

public class SelectedTicketObject extends RecyclerView.ViewHolder implements View.OnClickListener {


    SelectedTicketAdapter mListener;
    TextView event, date_time, name, price, type, total;
    Float total1,type1,price1;
    public SelectedTicketObject(View view, SelectedTicketAdapter listener) {
        super(view);

        event = view.findViewById(R.id.event);
        date_time= view.findViewById(R.id.date_time);
        name=view.findViewById(R.id.name);
        price=view.findViewById(R.id.price);
        type=view.findViewById(R.id.price);
        total=view.findViewById(R.id.total);
        mListener = listener;


//        String temp = price.getText().toString();
//        temp = temp.replace(" ", "");
//        String temp1 = type.getText().toString();
//        temp1 = temp1.replace(" ", "");
//        if(temp.length() > 0) {
//            type1= Float.parseFloat(temp);
//        }
//
//        if(temp1.length() > 0) {
//            price1= Float.parseFloat(temp1);
//        }
//        total1=price1*type1;
//        total.setText(total1+"");

    }

    @Override
    public void onClick(View v) {

//        mListener.onItemClick(v);

    }
}
