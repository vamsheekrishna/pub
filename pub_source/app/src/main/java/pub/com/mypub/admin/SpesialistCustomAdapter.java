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
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.home.CreateSpecialistFragment;
import pub.com.mypub.home.RecycleItemClickListener;


public class SpesialistCustomAdapter  extends RecyclerView.Adapter<SpecialistViewHolder> {

    RecycleItemClickListener mListener;
    public ArrayList<Specialist> mSpecialistList ;
    ArrayList<Specialist> specialists;
    CreateSpecialistFragment mCreateSpecialistFragment;
    public SpesialistCustomAdapter(ArrayList<Specialist> specialists, CreateSpecialistFragment createSpecialistFragment) {
        mSpecialistList=specialists;
        mCreateSpecialistFragment=createSpecialistFragment;
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
        specialistViewHolder.delete.setTag(i);
        specialistViewHolder.ch1.setChecked(specialist.isSelected());
        specialistViewHolder.ch1.setTag(specialist);
    }

    @Override
    public int getItemCount() {
            return mSpecialistList.size();
        }
    public void deleteRecord(int position) {
        Log.d("position", "position: "+position);
        mCreateSpecialistFragment.deleteSpecialist(position);
    }
    }
