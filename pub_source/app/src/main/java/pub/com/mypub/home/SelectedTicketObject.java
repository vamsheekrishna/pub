package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pub.com.mypub.R;

public class SelectedTicketObject extends RecyclerView.ViewHolder implements View.OnClickListener {


    SelectedTicketAdapter mListener;
    TextView event, date_time, name, price, type;

    public SelectedTicketObject(View view, SelectedTicketAdapter listener) {
        super(view);

        event = view.findViewById(R.id.event);
        date_time= view.findViewById(R.id.date_time);
        name=view.findViewById(R.id.total);
        price=view.findViewById(R.id.price);
        type=view.findViewById(R.id.type);
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
//        mListener.onItemClick(v);

    }
}
