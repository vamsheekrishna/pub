package pub.com.mypub.admin;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    CheckBox ch1;
    public LocationViewHolder(View view, LocationCustomAdapter listener) {
        super(view);
        ch1 = view.findViewById(R.id.ch1);
    }
    @Override
    public void onClick(View v) {

    }
}
