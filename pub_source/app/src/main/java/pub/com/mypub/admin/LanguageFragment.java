package pub.com.mypub.admin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.authentication.NetworkBaseFragment;
import pub.com.mypub.home.RecycleItemClickListener;


public class LanguageFragment extends NetworkBaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener, RecycleItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
EditText language1;
Button create1,select,New;
CheckBox one;
Language language;
ArrayList<Language> mSelectedLanguage = new ArrayList<>();
ArrayList<Language> mLanguageList = new ArrayList<>();
CheckBox ch1;
RecyclerView recyclerView;
LinearLayout btAddLanguage, createLanguage;
LanguageCustomAdapter dataAdapter = null;
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
    private ArrayList<Language> displayListView() {

        //Array list of countries
//        ArrayList<Language> countryList = new ArrayList<Language>();
//        Language language = new Language(1,"Arabic",false);
//        mLanguageList.add(language);
//        Language language1 = new Language(2,"English",false);
//        mLanguageList.add(language1);
//        Language language3 = new Language(3,"Franch",false);
//        mLanguageList.add(language3);
        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"language.php/getAllRecords", "get_all_language");
        return mLanguageList;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_language, container, false);

        displayListView();
        recyclerView= view.findViewById(R.id.listView1);
        New=view.findViewById(R.id.create);
        btAddLanguage = view.findViewById(R.id.bt_add_language);
        createLanguage = view.findViewById(R.id.create_language);
       language1= view.findViewById(R.id.n1);
       one = view.findViewById(R.id.ch1);
        create1=view.findViewById(R.id.e1);
        select=view.findViewById(R.id.submit);

       create1.setOnClickListener(this);
        select.setOnClickListener(this);
        New.setOnClickListener(this);




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
        if(REQUEST_ID.equals("create_language")) {
            btAddLanguage.setVisibility(View.VISIBLE);
            createLanguage.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();
    }}

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_specialist")) {
            btAddLanguage.setVisibility(View.VISIBLE);
            createLanguage.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Language> languages = Arrays.asList(gson.fromJson(response.toString(), Language[].class));
        dataAdapter = new LanguageCustomAdapter( new ArrayList<>(languages));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(dataAdapter);
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
            case R.id.create:
                createLanguage.setVisibility(View.VISIBLE);
                btAddLanguage.setVisibility(View.GONE);
                break;
            case R.id.e1:
                String _name = language1.getText().toString();


                language = new Language();
                language.name=_name;


                HashMap<String, String> parems = new HashMap<>();
                parems.put("name", language.name);


                stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"language.php/createRecord", "create_language");
                break;
            case R.id.submit:
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

    @Override
    public void onItemClick(View v) {

    }

    @Override
    public void onItemClick(View v, View v1) {

    }
}
