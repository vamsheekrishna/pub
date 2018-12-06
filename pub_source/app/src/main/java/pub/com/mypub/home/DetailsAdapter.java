package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Details;
import pub.com.mypub.admin.models.Event;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsObject>{
        RecycleItemClickListener mListener;
    ArrayList<Details> details;
    DetailsAdapter(RecycleItemClickListener listener,  ArrayList<Details> _details) {
        mListener = listener;
        details=_details;
    }
    @NonNull
    @Override
    public DetailsObject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_events_details, viewGroup, false);
        DetailsObject detailsObject = new DetailsObject(itemView, mListener);
        return detailsObject;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsObject detailsObject, int i) {
        detailsObject.title.setText(details.get(i).title);
        detailsObject.category_id.setText(details.get(i).category_id);
        detailsObject.start_date.setText(details.get(i).start_date);
        detailsObject.duration.setText(details.get(i).duration);
        detailsObject.location_id.setText(details.get(i).location_id);
        detailsObject.language_id.setText(details.get(i).language_id);
        detailsObject.description.setText(details.get(i).description);
        detailsObject.note.setText(details.get(i).note);
        detailsObject.start_price.setText(details.get(i).start_price);
        detailsObject.age_limit.setText(details.get(i).age_limit);

    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}
