package pub.com.mypub.admin;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;

public class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    LocationCustomAdapter mListener;
    CheckBox ch1;
    Button delete;

    public LocationViewHolder(View view, LocationCustomAdapter listener) {
        super(view);
        ch1 = view.findViewById(R.id.ch1);
        mListener= listener;
        delete=view.findViewById(R.id.delete);
        delete.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.delete:

                mListener.deleteRecord((Integer) v.getTag());
                break;


        }

    }
}
