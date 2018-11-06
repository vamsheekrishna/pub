package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pub.com.mypub.R;

public class TimeObject extends RecyclerView.ViewHolder implements View.OnClickListener{


    RecycleItemClickListener mListener;
    public TimeObject(View view, RecycleItemClickListener listener) {
        super(view);
        mListener = listener;

    }

    @Override
    public void onClick(View v) {

        mListener.onItemClick(v);
    }
}


