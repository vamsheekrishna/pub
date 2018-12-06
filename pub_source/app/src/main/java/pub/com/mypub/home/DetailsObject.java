package pub.com.mypub.home;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pub.com.mypub.R;
public class DetailsObject extends RecyclerView.ViewHolder implements View.OnClickListener{

    public Button mBook;
    TextView title, category_id,start_date, end_date, start_time, end_time,duration,location_id,language_id,description,note, start_price, contact_id, specialist_id,ticket_id,age_limit ;
    RecycleItemClickListener mListener;
    public DetailsObject(View view, RecycleItemClickListener listener) {
        super(view);
        mListener = listener;

        title = view.findViewById(R.id.event);
        category_id = view.findViewById(R.id.details);
        start_date =view.findViewById(R.id.detee);
        end_date = view.findViewById(R.id.start);
        start_time =view.findViewById(R.id.end);
        end_time = view.findViewById(R.id.event);
        duration = view.findViewById(R.id.detail3);
        location_id =view.findViewById(R.id.description);
        language_id = view.findViewById(R.id.detail2);
        description =view.findViewById(R.id.t1);
        note =view.findViewById(R.id.note);
        start_price = view.findViewById(R.id.price);
        //contact_id = view.findViewById(R.id.detail);
        specialist_id =view.findViewById(R.id.amount);
        ticket_id = view.findViewById(R.id.start);
        age_limit =view.findViewById(R.id.detail4);
    }

    @Override
    public void onClick(View v) {
        mListener.onItemClick(v);
    }
}
