package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PersonOpject extends RecyclerView.ViewHolder implements View.OnClickListener{


    RecycleItemClickListener mListener;
    public PersonOpject(View view, RecycleItemClickListener listener) {
        super(view);
        mListener = listener;

    }

    @Override
    public void onClick(View v) {

        mListener.onItemClick(v);
    }
}
