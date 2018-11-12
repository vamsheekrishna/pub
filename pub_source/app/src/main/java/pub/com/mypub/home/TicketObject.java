package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.RelativeLayout;

import pub.com.mypub.R;

public class TicketObject extends RecyclerView.ViewHolder implements View.OnClickListener{


    RecycleItemClickListener mListener;
    public TicketObject(View view, RecycleItemClickListener listener) {
        super(view);

        RelativeLayout mViewPlusMin = view.findViewById(R.id.plus_min);
        mViewPlusMin.findViewById(R.id.plus).setOnClickListener(this);
        mViewPlusMin.findViewById(R.id.minus).setOnClickListener(this);
        mListener = listener;

    }

    @Override
    public void onClick(View v) {
        mListener.onItemClick(v);
    }
}
