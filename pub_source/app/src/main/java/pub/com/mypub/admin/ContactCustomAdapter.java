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
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.home.RecycleItemClickListener;


public class ContactCustomAdapter extends RecyclerView.Adapter<ContactViewHolder>{
    RecycleItemClickListener mListener;
    public ArrayList<Contact> mContactList ;
    ArrayList<Contact> contact;
    public ContactCustomAdapter(ArrayList<Contact> contact) {
        mContactList = contact;
    }



    @NonNull
    @Override

    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_info, viewGroup, false);
        ContactViewHolder dateobject = new ContactViewHolder(itemView, this);
        dateobject.ch1.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox ch1 = (CheckBox) v ;
               Contact contact=(Contact) ch1.getTag();
                contact.setSelected(ch1.isChecked());
            }
        });
        return dateobject;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        Contact contact = mContactList.get(i);
        contactViewHolder.ch1.setText(contact.name);
        contactViewHolder.ch1.setText(contact.getName());
        contactViewHolder.ch1.setChecked(contact.isSelected());
        contactViewHolder.ch1.setTag(contact);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }
}
