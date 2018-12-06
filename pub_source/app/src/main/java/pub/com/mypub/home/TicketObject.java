package pub.com.mypub.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pub.com.mypub.R;

public class TicketObject extends RecyclerView.ViewHolder implements View.OnClickListener{


    TicketListAdapter mListener;
    TextView mDisplay, mTVTitle, mTVPrice, mTVDescription, totalamount;
    int mTicketCount = 0;
    ImageView mPlus, mMinus;

    int total,type,price;
    public TicketObject(View view, TicketListAdapter listener) {
        super(view);

        RelativeLayout mViewPlusMin = view.findViewById(R.id.plus_min);
        mPlus = mViewPlusMin.findViewById(R.id.plus);
        mPlus.setOnClickListener(this);
        mMinus = mViewPlusMin.findViewById(R.id.minus);
        mMinus.setOnClickListener(this);
        mTVTitle = view.findViewById(R.id.ticket_name);
        mTVPrice= view.findViewById(R.id.price);
        mTVDescription=view.findViewById(R.id.description);
        totalamount=view.findViewById(R.id.total);

        mDisplay = mViewPlusMin.findViewById(R.id.t1);
        mListener = listener;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus:
                /*mTicketCount += 1;*/
                updateAmount(v, 1);
                break;
            case R.id.minus:
                updateAmount(v, -1);
                ;
                /*if(mTicketCount>0) {
                    *//*mTicketCount -= 1;*/
                    //display(mListener.getTicketObject(-1, (Integer) v.getTag()));
                break;
        }
    }

    private void updateAmount(View v, int value) {
        display (mListener.getTicketObject(value, (Integer) v.getTag()));
        price=Integer.parseInt(mTVPrice.getText().toString());
        String temp = mDisplay.getText().toString();
        temp = temp.replace(" ", "");
        if(temp.length() > 0) {
            type= Integer.parseInt(temp);
        }
        total=price*type;
        totalamount.setText(total+"");
    }

    private void display(int number) {
        mDisplay.setText(" "+number);

    }
}
