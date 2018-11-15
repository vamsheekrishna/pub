package pub.com.mypub.admin;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;

import static android.support.v4.content.ContextCompat.getSystemService;

public class MyCustomAdapter extends ArrayAdapter<Language> {

        private ArrayList<Language> mLanguageList;

        public MyCustomAdapter(Context context, int textViewResourceId,
        ArrayList<Language> mLanguageList) {
            super(context, textViewResourceId, mLanguageList);
            this.mLanguageList = new ArrayList<Language>();
            this.mLanguageList.addAll(mLanguageList);
        }

        private class ViewHolder {
            TextView code;
            CheckBox ch1;
            CheckBox  ch2;
        }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.language_info, container,
//    }
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            ViewHolder holder = null;
//            Log.v("ConvertView", String.valueOf(position));
//
//            if (convertView == null) {
//                LayoutInflater vi = (LayoutInflater)getSystemService(
//                        Context.LAYOUT_INFLATER_SERVICE);
//                convertView = vi.inflate(R.layout.language_info, null);
//
//                holder = new ViewHolder();
//                holder.code = (TextView) convertView.findViewById(R.id.code);
//                holder.ch1 = (CheckBox) convertView.findViewById(R.id.ch1);
//                holder.ch2 = (CheckBox) convertView.findViewById(R.id.ch2);
//                convertView.setTag(holder);
//
//                holder.ch1.setOnClickListener( new View.OnClickListener() {
//                    public void onClick(View v) {
//                        CheckBox cb = (CheckBox) v ;
//                        Language language = (Language) cb.getTag();
//                        Toast.makeText(getApplicationContext(),
//                                "Clicked on Checkbox: " + cb.getText() +
//                                        " is " + cb.isChecked(),
//                                Toast.LENGTH_LONG).show();
//                        Language.setSelected(cb.isChecked());
//                    }
//                });
//            }
//            else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//
//            Language country = mLanguageList.get(position);
//            holder.id.setText(" (" +  Language.getid() + ")");
//            holder.name.setText(Language.getname());
//            holder.ch1.setChecked(Language.isSelected());
//            holder.ch1.setTag(language);
//
//            return convertView;
//
//        }
//
//    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }



    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
