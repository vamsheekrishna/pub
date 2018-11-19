package pub.com.mypub.admin;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.authentication.NetworkBaseFragment;
import static android.support.v4.content.ContextCompat.getSystemService;


public class LanguageFragment extends NetworkBaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
EditText language;
Button create,select;
CheckBox one;
CheckBox two;
MyEvent mydata;
ListView listView;
String mSelectedLanguage = null;
ArrayList<Language> mLanguageList = new ArrayList<>();
ArrayList<String> lang;
MyCustomAdapter dataAdapter = null;
Language mLanguage;

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
      // two=view.findViewById(R.id.ch2);
        create=view.findViewById(R.id.e1);
        select=view.findViewById(R.id.e11);

       create.setOnClickListener(this);
        select.setOnClickListener(this);
       // one.setOnClickListener(this);
       //two.setOnClickListener(this);
//        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);


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
        if (v == create) {
//           mydata= new MyEvent();
//            mydata._language = language.getText().toString();

//
        }
        else if (v== select){

            StringBuffer responseText = new StringBuffer();
//            responseText.append("The following were selected...\n");

            ArrayList<Language> mLanguageList = dataAdapter.mLanguageList;
            for(int i=0;i<mLanguageList.size();i++){

                if(dataAdapter.mLanguageList.get(i).isSelected()) {
                    mSelectedLanguage= String.valueOf(responseText.append( dataAdapter.mLanguageList.get(i).getName()));
                   // mSelectedLanguage= mSelectedLanguage.add(language);
//                    mSelectedLanguage.name= responseText.toString();

                }

//               mSelectedLanguage = mLanguageList.get(i);
//                if(mSelectedLanguage.isSelected()){
//                    responseText.append("\n" + mSelectedLanguage.getName());
//                }
            }

            Toast.makeText(getActivity(),
                    responseText, Toast.LENGTH_LONG).show();
            mListener.setLanguage(mLanguage);
            getActivity().onBackPressed();

//            if(one.isChecked()) {
//                mydata= new MyEvent();
//                mydata._ch1 = one.getText().toString();
//            }
//
//            if(two.isChecked()) {
//                mydata= new MyEvent();
//                mydata._ch2 = two.getText().toString();
//            }

        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Language language = (Language) parent.getItemAtPosition(position);
        if (position != 0) {
//            mSelectedLanguage = mLanguageList.get(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
