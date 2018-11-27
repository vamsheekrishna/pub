package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pub.com.mypub.R;

public class TicketObject extends RecyclerView.ViewHolder implements View.OnClickListener{


    TicketListAdapter mListener;
    TextView mDisplay, mTVTitle, mTVPrice, mTVDescription;
    int mTicketCount = 0;
    ImageView mPlus, mMinus;
    public TicketObject(View view, TicketListAdapter listener) {
        super(view);

        RelativeLayout mViewPlusMin = view.findViewById(R.id.plus_min);
        mPlus = mViewPlusMin.findViewById(R.id.plus);
        mPlus.setOnClickListener(this);
        mMinus = mViewPlusMin.findViewById(R.id.minus);
        mMinus.setOnClickListener(this);
        mTVTitle = view.findViewById(R.id.title);
        mTVPrice= view.findViewById(R.id.price);
        mTVDescription=view.findViewById(R.id.detail1);

        mDisplay = mViewPlusMin.findViewById(R.id.t1);
        mListener = listener;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus:
                /*mTicketCount += 1;*/
                display (mListener.getTicketObject(1, (Integer) v.getTag()));
                ;
                break;
            case R.id.minus:
                ;
                /*if(mTicketCount>0) {
                    *//*mTicketCount -= 1;*/
                    display(mListener.getTicketObject(-1, (Integer) v.getTag()));
                break;
        }
    }

    private void display(int number) {
        mDisplay.setText(" "+number);
    }
}
