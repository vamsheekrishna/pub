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
import pub.com.mypub.admin.models.Language;




public class MyCustomAdapter extends ArrayAdapter<Language> {



    ArrayList<Language> mLanguageList = new ArrayList<>();
    public MyCustomAdapter(Context context, int code,  ArrayList<Language> mLanguageList) {
        super(context, code, mLanguageList);
        this.mLanguageList = new ArrayList<Language>();
        this.mLanguageList.addAll(mLanguageList);
    }


    private class ViewHolder {
        TextView id;
        CheckBox name;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        pub.com.mypub.admin.MyCustomAdapter.ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.language_info, null);

            holder = new pub.com.mypub.admin.MyCustomAdapter.ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.code);
            holder.name = (CheckBox) convertView.findViewById(R.id.ch1);
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox ch1 = (CheckBox) v ;
                    Language language = (Language) ch1.getTag();
                    language.setSelected(ch1.isChecked());
                }
            });
        }
        else {
            holder = (pub.com.mypub.admin.MyCustomAdapter.ViewHolder) convertView.getTag();
        }

        Language language = mLanguageList.get(position);
        holder.id.setText(" (" +  language.getId() + ")");
        holder.name.setText(language.getName());
        holder.name.setChecked(language.isSelected());
        holder.name.setTag(language);

        return convertView;





}}