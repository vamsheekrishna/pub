package pub.com.mypub.home;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pub.com.mypub.R;

public class OfflineOpject extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView  name, phone1, phone2, emailid;
    RecycleItemClickListener mListener;
    public OfflineOpject(View view, RecycleItemClickListener listener) {
        super(view);
        name = view.findViewById(R.id.name);
        phone1= view.findViewById(R.id.phone1);
        phone2=view.findViewById(R.id.phone2);
        emailid=view.findViewById(R.id.emailid);
        mListener = listener;

    }
    @Override
    public void onClick(View v) {

        mListener.onItemClick(v);
    }
}
