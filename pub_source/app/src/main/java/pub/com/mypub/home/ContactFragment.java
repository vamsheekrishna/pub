package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;

import pub.com.mypub.admin.ContactCustomAdapter;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class ContactFragment extends NetworkBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, RecycleItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<Contact> mSelectedContact = new ArrayList<>();
    EditText phoneNo1, phoneNo2,name, emailId;
    TextView txx;
    MyEvent mydata;
    Button submit,add,New;
    Spinner spinner;
    Contact contact;
    LinearLayout btAddContact, createContact;
    ArrayList<Contact> mContactList = new ArrayList<>();
    RecyclerView recyclerView;
  CheckBox ch1;
    ContactCustomAdapter dataAdapter = null;
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
    private ArrayList<Contact> getContactData() {
//        mContactList.add(new Contact(0,"HayderAbad","9987263541"));
//        mContactList.add(new Contact(1,"Chenai","8765290987"));
//        mContactList.add(new Contact(2,"Delhi","5678920918"));
//        mContactList.add(new Contact(3,"Noida","9812670000"));

        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"contact.php/getAllRecords", "get_all_contact");
        return mContactList;

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
        View view = inflater.inflate(R.layout.fragment_contact, container,
                false);

        getContactData();
        recyclerView= view.findViewById(R.id.listView1);
        name=view.findViewById(R.id.name);
        ch1=view.findViewById(R.id.ch1);
        phoneNo1 =view.findViewById(R.id.phone1);
        phoneNo2 =view.findViewById(R.id.phone2);
       emailId =view.findViewById(R.id.email);
        txx=view.findViewById(R.id.tx);
        submit=view.findViewById(R.id.submit);
        add=view.findViewById(R.id.add);
        btAddContact = view.findViewById(R.id.bt_add_contact);
        createContact = view.findViewById(R.id.create_contact);
        New=view.findViewById(R.id.create);
        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.add).setOnClickListener(this);
        view.findViewById(R.id.create).setOnClickListener(this);

//        String[] values = {"HyderAbad  9987263541", "Chenai  8765290987", "Noida  9812670000", "Delhi  5678920918"};
//        spinner = view.findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(this);

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
        if(REQUEST_ID.equals("create_contact")) {
            btAddContact.setVisibility(View.VISIBLE);
            createContact.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();
    }}

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_contact")) {
            btAddContact.setVisibility(View.VISIBLE);
            createContact.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();
        }
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Contact> contact = Arrays.asList(gson.fromJson(response.toString(), Contact[].class));
        dataAdapter = new ContactCustomAdapter( new ArrayList<>(contact));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(dataAdapter);
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

        switch (v.getId()) {
            case R.id.create:
                createContact.setVisibility(View.VISIBLE);
                btAddContact.setVisibility(View.GONE);
                break;

            case R.id.submit:
                StringBuffer responseText = new StringBuffer();
                ArrayList<Contact> mContactList = dataAdapter.mContactList;
                for (Contact contact : mContactList) {
                    if (contact.isSelected()) {
                        mSelectedContact.add(contact);
                    }
                }
                mListener.setSelectedContact(mSelectedContact);
                getActivity().onBackPressed();
                break;


            case R.id.add:

                String _name = name.getText().toString();
                String _phone1 = phoneNo1.getText().toString();
                String _phone2 = phoneNo2.getText().toString();
                String _emailid = emailId.getText().toString();


                contact = new Contact();
                contact.name = _name;
                contact.phoneNo1 = _phone1;
                contact.phoneNo2 = _phone2;
                contact.emailId = _emailid;


                HashMap<String, String> parems = new HashMap<>();
                parems.put("name", contact.name);
                parems.put("phoneNo1", contact.phoneNo1);
                parems.put("phoneNo2", contact.phoneNo2);
                parems.put("emailId", contact.emailId);


                stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL + "contact.php/createRecord", "create_contact");

                break;

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



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = (Contact) parent.getItemAtPosition(position);
        if(contact.isSelected()) {
            contact.setSelected(false);
        } else {
            contact.setSelected(true);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(View v) {

    }

    @Override
    public void onItemClick(View v, View v1) {

    }
}
