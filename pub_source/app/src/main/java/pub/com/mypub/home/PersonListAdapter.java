package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Specialist;

public class PersonListAdapter extends RecyclerView.Adapter<PersonOpject> {
    RecycleItemClickListener mListener;
    ArrayList<Specialist> specialists;
    PersonListAdapter(RecycleItemClickListener listener, ArrayList<Specialist> _specialists) {
        mListener = listener;
        specialists=_specialists;
    }
    @NonNull
    @Override
    public PersonOpject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_musician, viewGroup, false);
        PersonOpject personopject = new PersonOpject(itemView, mListener);
        return personopject;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonOpject personOpject, int i) {
        personOpject.name.setText(specialists.get(i).name);
        personOpject.dob.setText(specialists.get(i).dob      );
        personOpject.specialization.setText(specialists.get(i).specialization);
    }




    @Override
    public int getItemCount() {
        return specialists.size();
    }
}

