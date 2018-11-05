package pub.com.mypub.authentication;

import android.content.Context;
import android.os.Bundle;
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

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;

public class ChangePassword extends NetworkBaseFragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText mETPassword;
    EditText mETRePassword;
    EditText mETMobileNumber;
    boolean isForgotPassword = false;
    MyProfile myProfile;
    private OnAuthenticationInteractionListener mListener;

    public ChangePassword() {
        // Required empty public constructor
    }

    public static ChangePassword newInstance(MyProfile profile, boolean isForgotPassword) {
        ChangePassword fragment = new ChangePassword();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, profile);
        args.putBoolean(ARG_PARAM2, isForgotPassword);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myProfile = (MyProfile)getArguments().getSerializable(ARG_PARAM1);
            isForgotPassword = getArguments().getBoolean(ARG_PARAM2);

            getActivity().setTitle("Change Password");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_password, container,
                false);

        EditText mPhoneNumber = view.findViewById(R.id.phone_no);
        mETPassword=view.findViewById(R.id.password);
        mETRePassword=view.findViewById(R.id.re_password);
        if(isForgotPassword) {
            mPhoneNumber.setVisibility(View.GONE);
        }
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:


                    String _password = mETPassword.getText().toString();
                    String _rePassword;
                    if(_password.equals( mETRePassword.getText().toString())) {
                        //myProfile.mPassword = _password;
                        HashMap<String, String> parems = new HashMap<>();
                        parems.put("password",_password);
                        parems.put("mobile_number", myProfile.mPhoneNumber);
                        stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"login.php/updatePassword", "change_password");
                    }
                    else {
                        Toast.makeText(getActivity(), "password not matching", Toast.LENGTH_LONG).show();
                    }



                break;
        }

    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {
        Toast.makeText(getActivity(), "save successfully ", Toast.LENGTH_LONG).show();
        mListener.goToLoginPage();

    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        Toast.makeText(getActivity(), "save successfully ", Toast.LENGTH_LONG).show();
        mListener.goToLoginPage();

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
}
