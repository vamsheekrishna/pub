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
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.home.RecycleItemClickListener;


public class SpesialistCustomAdapter  extends RecyclerView.Adapter<SpecialistViewHolder> {

    RecycleItemClickListener mListener;
    public ArrayList<Specialist> mSpecialistList ;
    ArrayList<Specialist> specialists;
    public SpesialistCustomAdapter(ArrayList<Specialist> specialists) {
        mSpecialistList=specialists;
    }
    @NonNull
    @Override
    public SpecialistViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.specialist_info, viewGroup, false);
        SpecialistViewHolder dateobject = new SpecialistViewHolder(itemView, this);
        dateobject.ch1.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox ch1 = (CheckBox) v ;
                    Specialist specialist=(Specialist) ch1.getTag();
                    specialist.setSelected(ch1.isChecked());

                }
            });
        return dateobject;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialistViewHolder specialistViewHolder, int i) {
        Specialist specialist = mSpecialistList.get(i);
        specialistViewHolder.ch1.setText(specialist.name);
        specialistViewHolder.ch1.setText(specialist.getName());
        specialistViewHolder.ch1.setChecked(specialist.isSelected());
        specialistViewHolder.ch1.setTag(specialist);
    }

    @Override
    public int getItemCount() {
            return mSpecialistList.size();
        }
    }

//    public ArrayList<Specialist> mSpecialistList = new ArrayList<>();
//    public SpesialistCustomAdapter(Context context, int code, ArrayList<Specialist> specialistList) {
//        super(context, code, specialistList);
//        this.mSpecialistList = specialistList;
//    }
//
//
//    private class ViewHolder {
//        //TextView id;
//        CheckBox name;
//    }
//
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        pub.com.mypub.admin.SpesialistCustomAdapter.ViewHolder holder = null;
//        Log.v("ConvertView", String.valueOf(position));
//
//        if (convertView == null) {
//            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = vi.inflate(R.layout.specialist_info, null);
//
//            holder = new pub.com.mypub.admin.SpesialistCustomAdapter.ViewHolder();
//            //holder.id = (TextView) convertView.findViewById(R.id.code);
//            holder.name = (CheckBox) convertView.findViewById(R.id.ch1);
//            convertView.setTag(holder);
//
//            holder.name.setOnClickListener( new View.OnClickListener() {
//                public void onClick(View v) {
//                    CheckBox ch1 = (CheckBox) v ;
//                    Specialist specialist=(Specialist) ch1.getTag();
//                    specialist.setSelected(ch1.isChecked());
//
//                }
//            });
//        }
//        else {
//            holder = (pub.com.mypub.admin.SpesialistCustomAdapter.ViewHolder) convertView.getTag();
//        }
//
//        Specialist specialist = mSpecialistList.get(position);
//      //  holder.id.setText(" (" +  specialist.getId() + ")");
//        holder.name.setText(specialist.getName());
//        holder.name.setChecked(specialist.isSelected());
//        holder.name.setTag(specialist);
//
//        return convertView;
//
//    }
