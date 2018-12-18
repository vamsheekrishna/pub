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
import android.widget.ListView;
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
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.SpesialistCustomAdapter;
import pub.com.mypub.admin.TicketCustomAdapter;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateSpecialistFragment extends NetworkBaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener, RecycleItemClickListener {
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
    Button add,submit,New;
    ListView listView;
    ArrayList<Specialist> mSelectedSpecialist = new ArrayList<>();
    ArrayList<Specialist> mSpecialistList= new ArrayList<>();
    SpesialistCustomAdapter dataAdapter = null;
    Specialist specialist;
    LinearLayout btAddSpecialist, createSpecialist;
    CheckBox ch1;
    RecyclerView recyclerView;
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

    private  ArrayList<Specialist> displayListView() {
        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"Specialist.php/getAllRecords", "get_all_specialist");
        return mSpecialistList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_specialist, container,
                false);
        displayListView();


        recyclerView= view.findViewById(R.id.listView1);
        name=view.findViewById(R.id.e1);
        dob=view.findViewById(R.id.e2);
        spec=view.findViewById(R.id.e11);
        des=view.findViewById(R.id.e1f);
        image=view.findViewById(R.id.e1h);
        btAddSpecialist = view.findViewById(R.id.bt_add_specialist);
        createSpecialist = view.findViewById(R.id.create_specialist);
        New=view.findViewById(R.id.create);
        txx=view.findViewById(R.id.tx);
        add=view.findViewById(R.id.add);
        ch1=view.findViewById(R.id.ch1);
        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.add).setOnClickListener(this);
        view.findViewById(R.id.create).setOnClickListener(this);

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
        if(REQUEST_ID.equals("create_specialist")) {
            btAddSpecialist.setVisibility(View.VISIBLE);
            createSpecialist.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();
    }
        else if(REQUEST_ID.equals("delete_specialist")) {
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_specialist")) {
            btAddSpecialist.setVisibility(View.VISIBLE);
            createSpecialist.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
    }
        else if(REQUEST_ID.equals("delete_specialist")) {
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Specialist> specialistlist = Arrays.asList(gson.fromJson(response.toString(), Specialist[].class));
        dataAdapter = new SpesialistCustomAdapter( new ArrayList<>(specialistlist),this );

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
        super.setTitle("Creat Specialist");
    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.create:
                createSpecialist.setVisibility(View.VISIBLE);
                btAddSpecialist.setVisibility(View.GONE);
                break;
            case R.id.add:

                String _name = name.getText().toString();
                String _dob = dob.getText().toString();
                String _specialization = spec.getText().toString();
                String _description = des.getText().toString();
                String _image = image.getText().toString();
                if (_name.matches("")|| _dob.matches("")|| _specialization.matches("")|| _description.matches("")|| _image.matches("")) {
                    Toast.makeText(getActivity(), "Plase fill the empty feild", Toast.LENGTH_SHORT).show();
                }
                else {
                    specialist = new Specialist();
                    specialist.name = _name;
                    specialist.dob = _dob;
                    specialist.specialization = _specialization;
                    specialist.description = _description;
                    specialist.image = _image;

                    HashMap<String, String> parems = new HashMap<>();
                    parems.put("name", specialist.name);
                    parems.put("dob", specialist.dob);
                    parems.put("specialization", specialist.specialization);
                    parems.put("description", specialist.description);
                    parems.put("image", specialist.image);

                    stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL + "Specialist.php/createRecord", "create_specialist");
                }
                break;
            case R.id.submit:
                StringBuffer responseText = new StringBuffer();
                ArrayList<Specialist> mSpecialistList = dataAdapter.mSpecialistList;
                for (Specialist specialist : mSpecialistList) {
                    if (specialist.isSelected()) {
                        mSelectedSpecialist.add(specialist);
                    }
                }
                mListener.setSelectedSpecialist(mSelectedSpecialist);
                getActivity().onBackPressed();
                break;


        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Specialist specialist = (Specialist) parent.getItemAtPosition(position);
        if(specialist.isSelected()) {
           specialist.setSelected(false);
        } else {
            specialist.setSelected(true);
        }
    }
    public void deleteSpecialist(int position) {
        Specialist specialist = dataAdapter.mSpecialistList.get(position);
        HashMap<String, String> parm = new HashMap<>();
        parm.put("id", specialist.id+"");
        stringAPIRequest(parm, Request.Method.POST, BuildConfig.BASE_URL + "Specialist.php/deleteRecord", "delete_specialist");
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
