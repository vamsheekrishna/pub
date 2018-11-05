package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import pub.com.mypub.R;

public class EventObject extends RecyclerView.ViewHolder implements View.OnClickListener{

    public Button mBook;
    RecycleItemClickListener mListener;
    public EventObject(View view, RecycleItemClickListener listener) {
        super(view);
        mListener = listener;
        view.findViewById(R.id.book).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*int itemPosition = mRecyclerView.getChildLayoutPosition(view);
        String item = mList.get(itemPosition);
        Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();*/

        mListener.onItemClick(v);
    }
}
