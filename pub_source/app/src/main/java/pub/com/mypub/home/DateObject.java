package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Date;

public class DateObject extends RecyclerView.ViewHolder implements View.OnClickListener{

Button start_date;
    RecycleItemClickListener mListener;
    public DateObject(View view, RecycleItemClickListener listener) {
        super(view);
        mListener = listener;
        start_date = view.findViewById(R.id.k);
        start_date.setOnClickListener(this);
        //end_date =view.findViewById(R.id.k2);
    }

    @Override
    public void onClick(View v) {
        Date date = (Date) v.getTag();
        mListener.onItemClick(v);
    }
}

