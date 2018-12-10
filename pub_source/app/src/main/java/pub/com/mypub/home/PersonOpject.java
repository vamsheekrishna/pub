package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Event;

public class PersonOpject extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView mDisplay, name, dob, specialization;
    RecycleItemClickListener mListener;
    public PersonOpject(View view, RecycleItemClickListener listener) {
        super(view);
//        Event event = mListener.getSelectedEvent();
        name = view.findViewById(R.id.name);
        dob = view.findViewById(R.id.age);
       specialization =view.findViewById(R.id.spec);
        mListener = listener;

    }

    @Override
    public void onClick(View v) {

        mListener.onItemClick(v);
    }
}
