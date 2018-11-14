package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import pub.com.mypub.R;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateSpecialistFragment extends NetworkBaseFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText name;
    EditText dob;
    EditText spec;
    EditText des;
    EditText image;
    MyEvent mydata;
    TextView txx;
    Button submit;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAdminInteractionListener mListener;

    public CreateSpecialistFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CreateSpecialistFragment newInstance(String param1, String param2) {
        CreateSpecialistFragment fragment = new CreateSpecialistFragment();
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
        View view = inflater.inflate(R.layout.fragment_create_specialist, container,
                false);
        name=view.findViewById(R.id.e1);
        dob=view.findViewById(R.id.e2);
        spec=view.findViewById(R.id.e11);
        des=view.findViewById(R.id.e1f);
        image=view.findViewById(R.id.e1h);

        txx=view.findViewById(R.id.tx);

        view.findViewById(R.id.submit).setOnClickListener(this);

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
        super.setTitle("Creat Specialist");
    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onClick(View v) {


        if (v == submit) {
            mydata= new MyEvent();
            mydata._specialist = name.getText().toString();
            mydata._specialist = dob.getText().toString();
            mydata._specialist = spec.getText().toString();
            mydata._specialist = des.getText().toString();
            mydata._specialist = image.getText().toString();

//
        }
//        switch (v.getId()) {
//            case R.id.submit:
//
//
//                String _name = name.getText().toString();
//                String _dob =dob.getText().toString();
//                String _spes = spec.getText().toString();
//                String _des =des.getText().toString();
//                String _image = image.getText().toString();
//
//
//                txx.setText("Name:\t" + _name + "\nDOB:\t" + _dob + "\nSpecialization:\t" + _spes+ "\ndescreption:\t" + _des+ "\nimage:\t" + _image);
//
//
//                break;
//        }
    }
}
