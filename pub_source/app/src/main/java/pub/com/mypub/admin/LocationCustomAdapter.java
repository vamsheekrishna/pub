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
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.home.RecycleItemClickListener;


public class LocationCustomAdapter extends  RecyclerView.Adapter<LocationViewHolder> {

    RecycleItemClickListener mListener;
    public ArrayList<Location> mLocationList;

    public LocationCustomAdapter(ArrayList<Location> location) {
        mLocationList = location;
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
        locationViewHolder.ch1.setChecked(location.isSelected());
        locationViewHolder.ch1.setTag(location);

    }

    @Override
    public int getItemCount() {
        return mLocationList.size();
    }
}

//    private class ViewHolder {
//        TextView id;
//        CheckBox name;
//    }
//
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        pub.com.mypub.admin.LocationCustomAdapter .ViewHolder holder = null;
//        Log.v("ConvertView", String.valueOf(position));
//
//        if (convertView == null) {
//            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = vi.inflate(R.layout.ticket_info, null);
//
//            holder = new pub.com.mypub.admin.LocationCustomAdapter .ViewHolder();
//            holder.id = (TextView) convertView.findViewById(R.id.code);
//            holder.name = (CheckBox) convertView.findViewById(R.id.ch1);
//            convertView.setTag(holder);
//
//            holder.name.setOnClickListener( new View.OnClickListener() {
//                public void onClick(View v) {
//                    CheckBox ch1 = (CheckBox) v ;
//                    Location location = (Location) ch1.getTag();
//                    location.setSelected(ch1.isChecked());
//                }
//            });
//        }
//        else {
//            holder = (pub.com.mypub.admin.LocationCustomAdapter .ViewHolder) convertView.getTag();
//        }
//
//       Location location = mLocationList.get(position);
//        holder.id.setText(" (" +  location.getId() + ")");
//        holder.name.setText(location.getCity());
//        holder.name.setChecked(location.isSelected());
//        holder.name.setTag(location);
//
//        return convertView;
//
//
//
//
//
//    }}