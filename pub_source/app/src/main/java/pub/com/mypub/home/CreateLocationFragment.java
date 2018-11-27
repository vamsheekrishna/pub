package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.LocationCustomAdapter;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.TicketCustomAdapter;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateLocationFragment extends NetworkBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
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
    Button add,submit;
    ListView listView;
    ArrayList<Location> mSelectedLocation = new ArrayList<>();
    ArrayList<Location> mLocationList = new ArrayList<>();
    LocationCustomAdapter dataAdapter = null;

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
        displayListView();
    }

    private void displayListView() {
        mLocationList.add(new Location(1,"Banglour","India","hh","rre","eee","jjj",false));
        mLocationList.add(new Location(2,"Chenai","India","lll","rrne","aaa","mmmm",false));
        mLocationList.add(new Location(3,"Delhi","India","mnb","www","bgt","jio",false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_location, container,
                false);

        dataAdapter = new LocationCustomAdapter(this.getActivity(),
                R.layout.location_info, mLocationList);
        listView= view.findViewById(R.id.listView1);

        listView.setAdapter(dataAdapter);
        city = view.findViewById(R.id.e1);
        county = view.findViewById(R.id.e2);
        state = view.findViewById(R.id.e11);
        landmark = view.findViewById(R.id.e1f);
        latitude = view.findViewById(R.id.e1h);
        langetude = view.findViewById(R.id.e112);
        txx = view.findViewById(R.id.tx);
        submit=view.findViewById(R.id.submit);
        add=view.findViewById(R.id.add);
        view.findViewById(R.id.add).setOnClickListener(this);
        view.findViewById(R.id.submit).setOnClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Location location = (Location) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(),
                        "Clicked on Row: " + location.getCity(),
                        Toast.LENGTH_LONG).show();

            }});

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
        super.setTitle("Creat Location");
    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.add:
                break;
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
}