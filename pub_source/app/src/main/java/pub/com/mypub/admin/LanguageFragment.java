package pub.com.mypub.admin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class LanguageFragment extends NetworkBaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
EditText language;
Button create,select;
CheckBox one;
ListView listView;
ArrayList<Language> mSelectedLanguage = new ArrayList<>();
ArrayList<Language> mLanguageList = new ArrayList<>();
MyCustomAdapter dataAdapter = null;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAdminInteractionListener mListener;

    public LanguageFragment() {
        // Required empty public constructor
    }

    public static LanguageFragment newInstance(String param1, String param2) {
        LanguageFragment fragment = new LanguageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private void displayListView() {

        //Array list of countries
        ArrayList<Language> countryList = new ArrayList<Language>();
        Language language = new Language(1,"Arabic",false);
        mLanguageList.add(language);
        Language language1 = new Language(2,"English",false);
        mLanguageList.add(language1);
        Language language3 = new Language(3,"Franch",false);
        mLanguageList.add(language3);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        displayListView();
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_language, container, false);


         dataAdapter = new MyCustomAdapter(this.getActivity(),
                R.layout.language_info, mLanguageList);
        listView= view.findViewById(R.id.listView1);

        listView.setAdapter(dataAdapter);





       language = view.findViewById(R.id.n1);
       one = view.findViewById(R.id.ch1);
        create=view.findViewById(R.id.e1);
        select=view.findViewById(R.id.e11);

       create.setOnClickListener(this);
        select.setOnClickListener(this);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Language language = (Language) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(),
                        "Clicked on Row: " + language.getName(),
                        Toast.LENGTH_LONG).show();

            }});

        return view;
    }







    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAdminInteractionListener ) {
            mListener = (OnAdminInteractionListener ) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAdminInteractionListener ");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {

    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {

    }

    @Override
    public void setTagName() {

    }

    @Override
    public void CloseApp() {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.e1:
                break;
            case R.id.e11:
                StringBuffer responseText = new StringBuffer();
                ArrayList<Language> mLanguageList = dataAdapter.mLanguageList;
                for ( Language language:mLanguageList ) {
                    if( language.isSelected() ){
                        mSelectedLanguage.add(language);
                    }
                }

                mListener.setSelectedLanguage(mSelectedLanguage);
                getActivity().onBackPressed();
                break;
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Language language = (Language) parent.getItemAtPosition(position);
        if(language.isSelected()) {
            language.setSelected(false);
        } else {
            language.setSelected(true);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
