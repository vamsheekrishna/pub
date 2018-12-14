package pub.com.mypub.authentication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Profile;
import pub.com.mypub.home.OnHomeInteractionListener;

public class ProfileFragment extends NetworkBaseFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
     Button save;
    EditText first_name, last_name,house_no, city, state, country, pin_code;
    //Profile profile;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    MyProfile myProfile;
    private OnAuthenticationInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        save= view.findViewById(R.id.save);
        save.setOnClickListener(this);

        first_name=view.findViewById(R.id.e2);
        last_name=view.findViewById(R.id.e3);
        house_no =view.findViewById(R.id.e4);
        city =view.findViewById(R.id.ee);
        state=view.findViewById(R.id.et);
        country =view.findViewById(R.id.e5);
        pin_code =view.findViewById(R.id.e6);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAuthenticationInteractionListener) {
            mListener = (OnAuthenticationInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAuthenticationInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {

        Log.d("REQUEST_ID",REQUEST_ID+": "+response.toString());
        Toast.makeText(getContext(),"User already existed.", Toast.LENGTH_LONG).show();
        mListener.goToLoginPage();
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

        switch (v.getId()) {

            case R.id.save:

                String _first_name = first_name.getText().toString();
                String _last_name = last_name.getText().toString();
                String _house_no = house_no.getText().toString();
                String _city = city.getText().toString();
                String _state = state.getText().toString();
                String _country = country.getText().toString();
                String _pin_code = pin_code.getText().toString();


                MyProfile profile = MyProfile.getInstance();
                profile.first_name=_first_name;
                profile.last_name =_last_name;
                profile.house_no =_house_no;
                profile.city =_city;
                profile.state =_state;
                profile.country =_country;
                profile.pin_code =_pin_code;


                HashMap<String, String> parems = new HashMap<>();
                parems.put("first_name", profile.first_name);
                parems.put("last_name", profile.last_name);
                parems.put("house_no", profile.house_no);
                parems.put("city", profile.city);
                parems.put("state", profile.state);
                parems.put("country", profile.country);
                parems.put("pin_code", profile.pin_code);
                parems.put("id", profile.mProfileID);
                stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL + "profile.php/createRecord", "create_profile");

                break;
        }
    }
}
