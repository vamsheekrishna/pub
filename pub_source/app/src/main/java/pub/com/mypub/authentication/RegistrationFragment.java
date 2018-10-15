package pub.com.mypub.authentication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import pub.com.mypub.R;

public class RegistrationFragment extends NetworkBaseFragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    EditText mETPhoneNo;
    EditText mETPassword;
    EditText mETRePassword;
    boolean isValidated=true;
    private OnAuthenticationInteractionListener mListener;
    MyProfile myProfile;
    public RegistrationFragment() {
        // Required empty public constructor
    }

    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
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
        View view = inflater.inflate(R.layout.fragment_registration_1, container,
                false);
        mETPhoneNo =view.findViewById(R.id.phone_no);
        mETPassword=view.findViewById(R.id.password);
        mETRePassword=view.findViewById(R.id.re_password);
        view.findViewById(R.id.but).setOnClickListener(this);
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
        mListener.goToMyProfilePage(myProfile);
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {
        Log.d("REQUEST_ID",REQUEST_ID+": "+response.toString());

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
            case R.id.but:
                if(isValidated == true)
            {

                String _password = mETPassword.getText().toString();
                String _rePassword;
                if(_password.equals( mETRePassword.getText().toString())) {
                    Toast.makeText(getActivity(), "Register successfully ", Toast.LENGTH_LONG).show();
                    myProfile = new MyProfile();
                    myProfile.mPhoneNumber = mETPhoneNo.getText().toString();
                    //myProfile.mName = "Vamshee";
                    //myProfile.mEmail = "vamshee@gmail.com";
                    myProfile.mPassword = _password;

                    //mListener.gotoValidateOTP(myProfile);
                    HashMap<String, String> parems = new HashMap<>();
                    parems.put("password", myProfile.mPassword);
                    parems.put("mobile_number", myProfile.mPhoneNumber);

                    stringAPIRequest(parems, Request.Method.POST, "http://faithindia.org/vAm/my_events/api/login.php/insertUserData", "registration");
                }
                else {
                    Toast.makeText(getActivity(), "password not matching", Toast.LENGTH_LONG).show();
                }
                /*

                */

        }
                break;
    }
}}
