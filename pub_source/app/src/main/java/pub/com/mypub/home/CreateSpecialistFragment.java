package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.SpesialistCustomAdapter;
import pub.com.mypub.admin.TicketCustomAdapter;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateSpecialistFragment extends NetworkBaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
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
    Button add,submit;
    ListView listView;
    ArrayList<Specialist> mSelectedSpecialist = new ArrayList<>();
    ArrayList<Specialist> mSpecialistList= new ArrayList<>();
    SpesialistCustomAdapter dataAdapter = null;
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
        displayListView();
        setTagName();
    }

    private void displayListView() {
        ArrayList<Specialist> SpecialistList = new ArrayList<Specialist>();
        Specialist specialist = new Specialist(1,"Shekspeer","12/8/1770","Music","uhsfu","upload",false);
        mSpecialistList.add(specialist);
        Specialist specialist1 = new Specialist(2,"Vender","18/8/1990","Dance","uhsfu","upload",false);
        mSpecialistList.add(specialist1);
        Specialist specialist2 = new Specialist(3,"Thomas","20/11/2000","Art","uhsfu","upload",false);
        mSpecialistList.add(specialist2);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_specialist, container,
                false);

        dataAdapter = new SpesialistCustomAdapter(this.getActivity(), R.layout.specialist_info, mSpecialistList);
        listView= view.findViewById(R.id.listView1);

        listView.setAdapter(dataAdapter);


        name=view.findViewById(R.id.e1);
        dob=view.findViewById(R.id.e2);
        spec=view.findViewById(R.id.e11);
        des=view.findViewById(R.id.e1f);
        image=view.findViewById(R.id.e1h);

        txx=view.findViewById(R.id.tx);

        view.findViewById(R.id.submit).setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Specialist specialist = (Specialist) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(),
                        "Clicked on Row: " + specialist.getName(),
                        Toast.LENGTH_LONG).show();

            }});
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
        switch(v.getId()) {
            case R.id.add:
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
