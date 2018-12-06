package pub.com.mypub.home;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Contact;

public class OfflineListAdapter extends RecyclerView.Adapter<OfflineOpject>{
    RecycleItemClickListener mListener;
    ArrayList<Contact> contact;
    OfflineListAdapter(RecycleItemClickListener listener, ArrayList<Contact> _contact) {
        mListener = listener;
        contact=_contact;
    }
    @NonNull
    @Override
    public OfflineOpject onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_offline_promoters, viewGroup, false);
        OfflineOpject Offlineopject = new OfflineOpject(itemView, mListener);
        return Offlineopject;
    }

    @Override
    public void onBindViewHolder(@NonNull OfflineOpject offlineOpject, int i) {
        offlineOpject.name.setText(contact.get(i).name);
        offlineOpject.phone1.setText(contact.get(i).phoneNo1);
        offlineOpject.phone2.setText(contact.get(i).phoneNo2);
        offlineOpject.emailid.setText(contact.get(i).emailId);
    }

    @Override
    public int getItemCount() {
        return contact.size();
    }
}
