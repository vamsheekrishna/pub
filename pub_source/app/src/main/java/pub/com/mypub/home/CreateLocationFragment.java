package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
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
import pub.com.mypub.admin.CategoryCustomAdapter;
import pub.com.mypub.admin.LocationCustomAdapter;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.TicketCustomAdapter;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateLocationFragment extends NetworkBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, RecycleItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText city;
    EditText county;
    EditText state;
    EditText landmark;
    EditText latitude;
    EditText langetude;
    TextView txx;
    Spinner spinner;
    MyEvent mydata;
    Button add,submit,New;
    ArrayList<Location> mSelectedLocation = new ArrayList<>();
    ArrayList<Location> mLocationList = new ArrayList<>();
    LocationCustomAdapter dataAdapter = null;
    CheckBox ch1;
    RecyclerView recyclerView;
    LinearLayout btAddLocation, createLocation;
    Location location;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAdminInteractionListener mListener;

    public CreateLocationFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CreateLocationFragment newInstance(String param1, String param2) {
        CreateLocationFragment fragment = new CreateLocationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setTagName();

    }

    private ArrayList<Location> displayListView() {
//        mLocationList.add(new Location(1,"Banglour","India","hh","rre","eee","jjj", "9934762891",false));
//        mLocationList.add(new Location(2,"Chenai","India","lll","rrne","aaa","mmmm", "9876234600",false));
//        mLocationList.add(new Location(3,"Delhi","India","mnb","www","bgt","jio","7844590322",false));
        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"location.php/getAllRecords", "get_all_location");
        return mLocationList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_location, container,
                false);
        displayListView();
        recyclerView= view.findViewById(R.id.listView1);
        New=view.findViewById(R.id.create);
        btAddLocation = view.findViewById(R.id.bt_add_location);
        createLocation = view.findViewById(R.id.create_location);
        city = view.findViewById(R.id.e1);
        county = view.findViewById(R.id.e2);
        state = view.findViewById(R.id.e11);
        landmark = view.findViewById(R.id.e1f);
        latitude = view.findViewById(R.id.e1h);
        langetude = view.findViewById(R.id.e112);
        txx = view.findViewById(R.id.tx);
        submit=view.findViewById(R.id.submit);
        add=view.findViewById(R.id.add);
        New.setOnClickListener(this);
        view.findViewById(R.id.add).setOnClickListener(this);
        view.findViewById(R.id.submit).setOnClickListener(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setHasFixedSize(false);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAdminInteractionListener) {
            mListener = (OnAdminInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAdminInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_location")) {
            btAddLocation.setVisibility(View.VISIBLE);
            createLocation.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();

            stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"location.php/getAllRecords", "get_all_location");
        }
        else if(REQUEST_ID.equals("delete_location")) {
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        if(REQUEST_ID.equals("delete_location")) {
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Location> location = Arrays.asList(gson.fromJson(response.toString(), Location[].class));

        dataAdapter = new LocationCustomAdapter( new ArrayList<>(location),this);

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
        super.setTitle("Creat Location");
    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.create:
                createLocation.setVisibility(View.VISIBLE);
                btAddLocation.setVisibility(View.GONE);
                break;

            case R.id.add:
                String _city = city.getText().toString();
                String _country = county.getText().toString();
                String _state = state.getText().toString();
                String _landmark = landmark.getText().toString();
                String _latitude = latitude.getText().toString();
                 String _langetude = langetude.getText().toString();

                if (_city.matches("")|| _country.matches("")|| _state.matches("")|| _landmark.matches("")|| _latitude.matches("")|| _langetude.matches("")) {
                    Toast.makeText(getActivity(), "Plase fill the empty feild", Toast.LENGTH_SHORT).show();
                }
                else {

                    location = new Location();
                    location.city = _city;
                    location.country = _country;
                    location.state = _state;
                    location.landmark = _landmark;
                    location.latitude = _latitude;
                    location.langetude = _langetude;


                    HashMap<String, String> parems = new HashMap<>();
                    parems.put("city", location.city);
                    parems.put("country", location.country);
                    parems.put("sate", location.state);
                    parems.put("landmark", location.landmark);
                    parems.put("latitude", location.latitude);
                    parems.put("langtude", location.langetude);


                    stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL + "location.php/createRecord", "create_location");
                    break;
                }
            case R.id.submit:
                StringBuffer responseText = new StringBuffer();
                ArrayList<Location> mLocationList = dataAdapter.mLocationList;
                for (Location location : mLocationList) {
                    if (location.isSelected()) {
                        mSelectedLocation.add(location);
                    }
                }
                mListener.setSelectedLocation(mSelectedLocation);
                getActivity().onBackPressed();
                break;


        }

    }

    public void deleteLocation(int position) {
        Location location = dataAdapter.mLocationList.get(position);
        HashMap<String, String> parm = new HashMap<>();
        parm.put("id", location.id+"");
        stringAPIRequest(parm, Request.Method.POST, BuildConfig.BASE_URL + "location.php/deleteRecord", "delete_location");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Location location = (Location) parent.getItemAtPosition(position);
        if(location.isSelected()) {
            location.setSelected(false);
        } else {
            location.setSelected(true);
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