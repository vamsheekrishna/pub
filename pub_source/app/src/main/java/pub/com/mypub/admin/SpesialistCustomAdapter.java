package pub.com.mypub.admin;

import android.content.Context;
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


public class SpesialistCustomAdapter  extends ArrayAdapter<Specialist> {

    public ArrayList<Specialist> mSpecialistList = new ArrayList<>();
    public SpesialistCustomAdapter(Context context, int code, ArrayList<Specialist> specialistList) {
        super(context, code, specialistList);
        this.mSpecialistList = specialistList;
    }


    private class ViewHolder {
        TextView id;
        CheckBox name;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        pub.com.mypub.admin.SpesialistCustomAdapter.ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.ticket_info, null);

            holder = new pub.com.mypub.admin.SpesialistCustomAdapter.ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.code);
            holder.name = (CheckBox) convertView.findViewById(R.id.ch1);
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox ch1 = (CheckBox) v ;
                    Specialist specialist=(Specialist) ch1.getTag();
                    specialist.setSelected(ch1.isChecked());

                }
            });
        }
        else {
            holder = (pub.com.mypub.admin.SpesialistCustomAdapter.ViewHolder) convertView.getTag();
        }

        Specialist specialist = mSpecialistList.get(position);
        holder.id.setText(" (" +  specialist.getId() + ")");
        holder.name.setText(specialist.getName());
        holder.name.setChecked(specialist.isSelected());
        holder.name.setTag(specialist);

        return convertView;

    }
}