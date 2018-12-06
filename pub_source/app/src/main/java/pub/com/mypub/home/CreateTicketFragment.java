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
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.TicketCustomAdapter;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateTicketFragment extends NetworkBaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener, RecycleItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    LinearLayout btAddTicket, createTicket;
    EditText name;
    EditText price;
    EditText title;
    EditText description;
    Button add,submit,New;
    Ticket ticket;
    ArrayList<Ticket> mSelectedTicket = new ArrayList<>();
    ArrayList<Ticket> mTicketList = new ArrayList<>();
    TicketCustomAdapter dataAdapter = null;
    RecyclerView recyclerView;
CheckBox ch1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAdminInteractionListener mListener;
    //private boolean isShowCreateTicket = false;

    public CreateTicketFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CreateTicketFragment newInstance(String param1, String param2) {
        CreateTicketFragment fragment = new CreateTicketFragment();
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

    private ArrayList<Ticket> displayListView() {
//        ArrayList<Ticket> TicketList = new ArrayList<Ticket>();
////        Ticket ticket = new Ticket(0,"Ticket 1","50","single","llll",false);
////        mTicketList.add(ticket);
////    Ticket ticket1 = new Ticket(1,"Ticket 2","80","double","hhhh",false);
////    mTicketList.add(ticket1);
////        Ticket ticket2 = new Ticket(2,"Ticket 3","110","single","bbb",false);
////        mTicketList.add(ticket2);

        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"ticket.php/getAllRecords", "get_all_ticket");
        return mTicketList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_ticket, container,
                false);
        displayListView();
        btAddTicket = view.findViewById(R.id.bt_add_ticket);
        createTicket = view.findViewById(R.id.create_ticket);
        recyclerView= view.findViewById(R.id.listView1);



        name=view.findViewById(R.id.e1);
        price=view.findViewById(R.id.e2);
        title=view.findViewById(R.id.e11);
        description=view.findViewById(R.id.e1f);
        add=view.findViewById(R.id.add);
        submit=view.findViewById(R.id.submit);
        New=view.findViewById(R.id.create);
        ch1=view.findViewById(R.id.ch1);
        view.findViewById(R.id.add).setOnClickListener(this);
        view.findViewById(R.id.create).setOnClickListener(this);
        view.findViewById(R.id.submit).setOnClickListener(this);



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Ticket ticket = (Ticket) parent.getItemAtPosition(position);
//                Toast.makeText(getActivity(),
//                        "Clicked on Row: " + ticket.getTicket_name(),
//                        Toast.LENGTH_LONG).show();
//
//            }});

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
        if(REQUEST_ID.equals("create_ticket")) {
            btAddTicket.setVisibility(View.VISIBLE);
            createTicket.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_ticket")) {
            btAddTicket.setVisibility(View.VISIBLE);
            createTicket.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }

        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Ticket> ticketlist = Arrays.asList(gson.fromJson(response.toString(), Ticket[].class));
        dataAdapter = new TicketCustomAdapter( new ArrayList<>(ticketlist));

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
        super.setTitle("Creat Ticket");
    }

    @Override
    public void CloseApp() {
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.create:
                createTicket.setVisibility(View.VISIBLE);
                btAddTicket.setVisibility(View.GONE);
                break;


            case R.id.add:
                String _name = name.getText().toString();
                String _price = price.getText().toString();
                String _title = title.getText().toString();
                String _description = description.getText().toString();

                ticket=new Ticket();
                ticket.ticket_name =_name;
                ticket.price=_price;
                ticket.title=_title;
                ticket.description=_description;

                   HashMap<String, String> parems = new HashMap<>();
                   parems.put("ticket_name", ticket.ticket_name);
                   parems.put("price", ticket.price);
                   parems.put("title", ticket.title);
                   parems.put("description", ticket.description);

                 stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"ticket.php/createRecord", "create_ticket");
                break;


            case R.id.submit:
                StringBuffer responseText = new StringBuffer();
                ArrayList<Ticket> mTicketList = dataAdapter.mTicketList;
                for (Ticket ticket : mTicketList) {
                    if (ticket.isSelected()) {
                        mSelectedTicket.add(ticket);
                    }
                }
                mListener.setSelectedTicket(mSelectedTicket);
                getActivity().onBackPressed();
                break;


        }}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Ticket ticket = (Ticket) parent.getItemAtPosition(position);
        if(ticket.isSelected()) {
            ticket.setSelected(false);
        } else {
            ticket.setSelected(true);
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
