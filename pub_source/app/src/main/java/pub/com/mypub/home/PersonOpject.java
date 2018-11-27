package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pub.com.mypub.R;

public class PersonOpject extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView mDisplay, namee, age, spec;
    RecycleItemClickListener mListener;
    public PersonOpject(View view, RecycleItemClickListener listener) {
        super(view);
        namee = view.findViewById(R.id.name);
        age= view.findViewById(R.id.age);
       spec=view.findViewById(R.id.spec);
        mListener = listener;

    }

    @Override
    public void onClick(View v) {

        mListener.onItemClick(v);
    }
}
