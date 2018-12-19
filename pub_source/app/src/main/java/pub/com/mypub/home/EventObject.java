package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pub.com.mypub.R;

public class EventObject extends RecyclerView.ViewHolder implements View.OnClickListener{

    public Button mBook;
    ImageView selectedImage;
    TextView title, location_id, start_price, start_date, end_date;
    RecycleItemClickListener mListener;
    public EventObject(View view, RecycleItemClickListener listener) {
        super(view);
        mListener = listener;
        mBook = view.findViewById(R.id.book);
        mBook.setOnClickListener(this);
        selectedImage=view.findViewById(R.id.top_view);
        title = view.findViewById(R.id.event);
        location_id = view.findViewById(R.id.note);
        start_price =view.findViewById(R.id.amount);
        start_date = view.findViewById(R.id.start);
        end_date =view.findViewById(R.id.end);
    }

    @Override
    public void onClick(View v) {
        /*int itemPosition = mRecyclerView.getChildLayoutPosition(view);
        String item = mList.get(itemPosition);
        Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();*/

        mListener.onItemClick(v);
    }
}
