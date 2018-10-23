package pub.com.mypub.authentication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fforgot_1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fforgot_1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fforgot_1Fragment extends NetworkBaseFragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText mETPassword;
    EditText mETRePassword;
    MyProfile myProfile;
    private OnAuthenticationInteractionListener mListener;

    public Fforgot_1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fforgot_1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fforgot_1Fragment newInstance(String param1, String param2) {
        Fforgot_1Fragment fragment = new Fforgot_1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_fforgot_1, container,
                false);;

        mETPassword=view.findViewById(R.id.password);
        mETRePassword=view.findViewById(R.id.re_password);
        view.findViewById(R.id.but).setOnClickListener(this);

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
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
                        Toast.makeText(getActivity(), "save successfully ", Toast.LENGTH_LONG).show();
                        myProfile = new MyProfile();
                        myProfile.mPassword = _password;
                        HashMap<String, String> parems = new HashMap<>();
                        parems.put("password", myProfile.mPassword);

                        stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"login.php/insertUserData", "registration");
                    }
                    else {
                        Toast.makeText(getActivity(), "password not matching", Toast.LENGTH_LONG).show();
                    }



                break;
        }

    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {
        mListener.goToHomePage(myProfile);

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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
