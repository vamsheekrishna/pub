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
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pub.com.mypub.R;

import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class ContactFragment extends NetworkBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText location;
    EditText phoneno;
    TextView txx;
    MyEvent mydata;
    Button submit,add;
    Spinner spinner;

    Contact mSelectedContact = null;
    ArrayList<Contact> mContactList = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAdminInteractionListener mListener;

    public ContactFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private void getContactData() {
        mContactList.add(new Contact(0,"HayderAbad","9987263541"));
        mContactList.add(new Contact(1,"Chenai","8765290987"));
        mContactList.add(new Contact(2,"Delhi","5678920918"));
        mContactList.add(new Contact(3,"Noida","9812670000"));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        getContactData();
        setTagName();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container,
                false);
        location=view.findViewById(R.id.e1);
        phoneno=view.findViewById(R.id.e2);
        txx=view.findViewById(R.id.tx);
        submit=view.findViewById(R.id.submit);
        add=view.findViewById(R.id.add);

        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.add).setOnClickListener(this);

        String[] values =
                {"HyderAbad  9987263541", "Chenai  8765290987", "Noida  9812670000", "Delhi  5678920918"};
        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

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
        super.setTitle("contact");
    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onClick(View v) {
        if (v == add) {
        }


        if (v == submit) {
            onSubmit();


//
        }


//        switch (v.getId()) {
//            case R.id.submit:
//
//
//                    String _location = location.getText().toString();
//                    String _phoneno =phoneno.getText().toString();
//
//                txx.setText("Location:\t" + _location + "\nPhone Number:\t" + _phoneno );
//
//
//                break;
//        }

    }

    private void onSubmit() {
        mListener.setContact(mSelectedContact);
        getActivity().onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position != 0) {
            mSelectedContact = mContactList.get(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
