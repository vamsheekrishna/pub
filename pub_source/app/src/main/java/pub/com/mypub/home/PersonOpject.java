package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pub.com.mypub.R;

public class PersonOpject extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView mDisplay, name, dob, specialization;
    RecycleItemClickListener mListener;
    public PersonOpject(View view, RecycleItemClickListener listener) {
        super(view);
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
