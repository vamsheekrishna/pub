package pub.com.mypub.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Profile;
import pub.com.mypub.authentication.MyProfile;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class GetProfileFragment extends NetworkBaseFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button save;
    TextView first_name, last_name,house_no, city, state, country, pin_code;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnHomeInteractionListener mListener;

    public GetProfileFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GetProfileFragment newInstance(String param1, String param2) {
        GetProfileFragment fragment = new GetProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_get_profile, container, false);


        first_name=view.findViewById(R.id.e2);
        last_name=view.findViewById(R.id.e3);
        house_no =view.findViewById(R.id.e4);
        city =view.findViewById(R.id.ee);
        state=view.findViewById(R.id.et);
        country =view.findViewById(R.id.e5);
        pin_code =view.findViewById(R.id.e6);



        first_name.setText(MyProfile.getInstance().first_name);
        last_name.setText(MyProfile.getInstance().last_name);
        house_no.setText(MyProfile.getInstance().house_no);
        city.setText(MyProfile.getInstance().city);
        state.setText(MyProfile.getInstance().state);
        country.setText(MyProfile.getInstance().country);
        pin_code.setText(MyProfile.getInstance().pin_code);

        setPersonDataList();
        return view;
    }

    private void setPersonDataList() {

            HashMap<String, String > parems =new HashMap<>();
            parems.put("id",MyProfile.getInstance().mProfileID+"");
            stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL + "profile.php/getAllRecords", "get_selected_specialist");


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeInteractionListener) {
            mListener = (OnHomeInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHomeInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

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

    }

    @Override
    public void CloseApp() {

    }


}
