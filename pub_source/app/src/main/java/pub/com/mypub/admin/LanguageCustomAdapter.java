package pub.com.mypub.admin;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.home.RecycleItemClickListener;


public class LanguageCustomAdapter extends RecyclerView.Adapter<LanguageViewHolder> {
    RecycleItemClickListener mListener;
    public ArrayList<Language> mLanguageList ;
    LanguageFragment mLanguageFragment;
    ArrayList<Language> language;
    public LanguageCustomAdapter(ArrayList<Language> languages, LanguageFragment languageFragment) {
        mLanguageList = languages;
        mLanguageFragment = languageFragment;
    }
    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_info, viewGroup, false);
        LanguageViewHolder dateobject = new LanguageViewHolder(itemView, this);
        dateobject.ch1.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox ch1 = (CheckBox) v ;
               Language language=(Language) ch1.getTag();
                language.setSelected(ch1.isChecked());
            }
        });

        return dateobject;
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder languageViewHolder, int i) {
        Language language = mLanguageList.get(i);
        languageViewHolder.ch1.setText(language.name);
        languageViewHolder.delete.setTag(i);
        languageViewHolder.ch1.setChecked(language.isSelected());
        languageViewHolder.ch1.setTag(language);
    }

    @Override
    public int getItemCount() {
        return mLanguageList.size();
    }

    public void deleteRecord(int position) {
        Log.d("position", "position: "+position);
        mLanguageFragment.deleteLanguage(position);
    }
}
