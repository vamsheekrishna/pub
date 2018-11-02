package pub.com.mypub.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pub.com.mypub.R;

public class PersonListAdapter extends RecyclerView.Adapter<PersonOpject> {
    RecycleItemClickListener mListener;
    PersonListAdapter(RecycleItemClickListener listener) {
        mListener = listener;
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

    }




    @Override
    public int getItemCount() {
        return 6;
    }
}

