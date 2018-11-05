package pub.com.mypub.authentication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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



public class ForgetFragment extends NetworkBaseFragment  implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
   EditText mPhoneNumber;
   Button send;
    MyProfile myProfile;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAuthenticationInteractionListener mListener;

    public ForgetFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ForgetFragment newInstance(String param1, String param2) {
        ForgetFragment fragment = new ForgetFragment();
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

            getActivity().setTitle("Forgot Password");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forget, container,
                false);
        mPhoneNumber= view.findViewById(R.id.phone_edtext);
       view.findViewById(R.id.send).setOnClickListener(this);
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
        Log.d("response: ", "response: " + response);

        Toast.makeText(getActivity(), "save successful", Toast.LENGTH_LONG).show();
        /*try {
            myProfile.mProfileID = response.getString("id");
            mListener.goToChangePasswordPage(myProfile);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        gotoValidate();
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        Toast.makeText(getActivity(), "save successful", Toast.LENGTH_LONG).show();
        gotoValidate();

    }
    void gotoValidate() {
        mListener.gotoValidateOTP(myProfile, false);
        //mListener.goToChangePasswordPage(myProfile, true);
    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {
        showDaialog (exception);
        Toast.makeText(getActivity(), "Re Try",
                Toast.LENGTH_SHORT).show();
    }

    private void showDaialog(String exception) {
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
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {
        showDaialog (exception);
        Toast.makeText(getActivity(), "Re Try",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.send:
                String getphoneId = mPhoneNumber.getText().toString();
                myProfile= new MyProfile();
                myProfile.mPhoneNumber = getphoneId;

                //
                HashMap<String, String> parems = new HashMap<>();
                parems.put("mobile_number", myProfile.mPhoneNumber);
                stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"login.php/getUserDetails", "login");
                break;

        }


    }

    @Override
    public void setTagName() {

    }

    @Override
    public void CloseApp() {

    }
}
 /* if (getEmailId.equals("") && getEmailId.length() > 0 && getEmailId.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
                {
                Toast.makeText(getActivity(), "send successful", Toast.LENGTH_LONG).show();
            }

                else
                    Toast.makeText(getActivity(), "Re Try",
                            Toast.LENGTH_SHORT).show();*/