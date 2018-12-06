package pub.com.mypub.admin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pub.com.mypub.R;
import pub.com.mypub.home.TicketListAdapter;

class TicketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TicketCustomAdapter mListener;

    CheckBox ch1;
    public TicketViewHolder(View view, TicketCustomAdapter listener) {
        super(view);
        ch1=view.findViewById(R.id.ch1);

    }



    @Override
    public void onClick(View v) {

    }
}
