package pub.com.mypub.admin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.home.CreateLocationFragment;
import pub.com.mypub.home.CreateSpecialistFragment;
import pub.com.mypub.home.RecycleItemClickListener;


public class LocationCustomAdapter extends  RecyclerView.Adapter<LocationViewHolder> {

    RecycleItemClickListener mListener;
    public ArrayList<Location> mLocationList;
    CreateLocationFragment mCreateLocationFragment;

    ArrayList<Location> location;
    public LocationCustomAdapter(ArrayList<Location> location, CreateLocationFragment createLocationFragment) {
        mLocationList = location;
        mCreateLocationFragment=createLocationFragment;
    }


    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_info, viewGroup, false);
        LocationViewHolder dateobject = new LocationViewHolder(itemView, this);
        dateobject.ch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox ch1 = (CheckBox) v;
                Location location = (Location) ch1.getTag();
                location.setSelected(ch1.isChecked());

            }
        });
        return dateobject;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder locationViewHolder, int i) {
        Location location = mLocationList.get(i);
        locationViewHolder.ch1.setText(location.city);
        locationViewHolder.delete.setTag(i);
        locationViewHolder.ch1.setChecked(location.isSelected());
        locationViewHolder.ch1.setTag(location);

    }

    @Override
    public int getItemCount() {
        return mLocationList.size();
    }
    public void deleteRecord(int position) {
        Log.d("position", "position: "+position);
        mCreateLocationFragment.deleteLocation(position);
    }
}
