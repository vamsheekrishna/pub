package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONObject;
import pub.com.mypub.R;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateLocationFragment extends NetworkBaseFragment implements View.OnClickListener {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_location, container,
                false);
        city=view.findViewById(R.id.e1);
        county=view.findViewById(R.id.e2);
        state=view.findViewById(R.id.e11);
        landmark=view.findViewById(R.id.e1f);
        latitude=view.findViewById(R.id.e1h);
        langetude=view.findViewById(R.id.e112);
        txx=view.findViewById(R.id.tx);

        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.ep).setOnClickListener(this);


        String [] values =
                {"Ticket1","Ticket2","Ticket3","Ticket4","Ticket5","Ticket6"};
        spinner= view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

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

        if (v == add) {
            mydata= new MyEvent();
            mydata._createLocation = city.getText().toString();
            mydata._createLocation = county.getText().toString();
            mydata._createLocation = state.getText().toString();
            mydata._createLocation = landmark.getText().toString();
            mydata._createLocation = latitude.getText().toString();
            mydata._createLocation = langetude.getText().toString();

//
        }
        else if (v== submit){
            mydata= new MyEvent();
            mydata._selectLocation = spinner.getSelectedItem().toString();

        }
//        switch (v.getId()) {
//            case R.id.submit:
//
//
//                String _city = city.getText().toString();
//                String _country =county.getText().toString();
//                String _state = state.getText().toString();
//                String _landmark =landmark.getText().toString();
//                String _latitude = latitude.getText().toString();
//                String _langetude =langetude.getText().toString();
//
//                txx.setText("city:\t" + _city + "\ncounry:\t" + _country + "\nstate:\t" + _state+ "\nlandMark:\t" + _landmark+ "\nlatitude:\t" + _latitude+ "\nlangude:\t" + _langetude);
//
//
//                break;
//        }
    }
}
