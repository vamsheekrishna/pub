package pub.com.mypub.authentication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;

public class LoginFragment extends NetworkBaseFragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    MyProfile myProfile;
    EditText mETPhoneNo;
    EditText mETPassword;
    private OnAuthenticationInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        getActivity().setTitle("Login");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login_1, container, false);
        view.findViewById(R.id.register).setOnClickListener(this);
        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.forgot).setOnClickListener(this);

        mETPhoneNo =view.findViewById(R.id.phone_no);
        mETPassword=view.findViewById(R.id.password);
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
        Log.d("response: ","response: "+response);
        Toast.makeText(getActivity(), "login successful", Toast.LENGTH_LONG).show();
        try {
            myProfile.mProfileID = response.getString("id");
            mListener.goToHomePage(myProfile);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //mListener.goToMyProfilePage(myProfile);
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {
        showDaialog (exception);
        Toast.makeText(getActivity(), "login Fail " + exception, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {
        showDaialog (exception);
        Toast.makeText(getActivity(), "login Fail "+ exception, Toast.LENGTH_LONG).show();

    }
    public void showDaialog(String exception)
    {
        new AlertDialog.Builder(getContext())
                .setTitle("Error Alert")
                .setMessage(exception)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    @Override
    public void setTagName() {

    }

    @Override
    public void CloseApp() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                mListener.goToRegistrationPage();
                break;

            case R.id.forgot:
                mListener.goToForgotPasswordPage();
                break;

            case R.id.submit:
                myProfile= new MyProfile();
                myProfile.mPhoneNumber = mETPhoneNo.getText().toString();
                myProfile.mPassword= mETPassword.getText().toString();
                //
                HashMap<String, String> parems = new HashMap<>();
                parems.put("password", myProfile.mPassword);
                parems.put("mobile_number", myProfile.mPhoneNumber);
                stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"login.php/getLoginDetails", "login");
                break;
        }}
    }
