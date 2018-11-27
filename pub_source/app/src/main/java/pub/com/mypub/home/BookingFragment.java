package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class BookingFragment extends NetworkBaseFragment implements RecycleItemClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView displayInteger;
    int minteger = 0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Ticket> mTicketList=new ArrayList<>();
    private OnHomeInteractionListener mListener;

    public BookingFragment() {
        // Required empty public constructor
    }


    public static BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
        fragment.setTagName();

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
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        RecycleItemClickListener recycleItemClickListener = this;
        TicketListAdapter mAdapter = new TicketListAdapter(recycleItemClickListener, setTicketDataList() );
        RecyclerView recyclerView = view.findViewById(R.id.ticket_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));

//        recyclerView.getLayoutManager().setAutoMeasureEnabled(true);
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(mAdapter);

        DateListAdapter mmAdapter = new DateListAdapter(recycleItemClickListener);
        RecyclerView recyclerView1 = view.findViewById(R.id.date_list);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(mmAdapter);

        TimeListAdapter tAdapter = new TimeListAdapter(recycleItemClickListener);
        RecyclerView recyclerView2 = view.findViewById(R.id.time_list);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(tAdapter);
        return view;
    }

    private ArrayList<Ticket> setTicketDataList() {
        ArrayList<Ticket> mTicketList=new ArrayList<>();
        Ticket ticket = new Ticket(0,"Ticket 1",50,"single","GA tickets give access to the GA zone/main dance floor at sensation Rise. Dress code:All white mandatory",false);
        mTicketList.add(ticket);
        Ticket ticket1 = new Ticket(1,"Ticket 2",80,"double","GA tickets give access to the GA zone/main dance floor at sensation Rise. Dress code:All white mandatory",false);
        mTicketList.add(ticket1);
        Ticket ticket2 = new Ticket(2,"Ticket 3",110,"single","GA tickets give access to the GA zone/main dance floor at sensation Rise. Dress code:All white mandatory",false);
        mTicketList.add(ticket2);
        return mTicketList;
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
        super.setTitle("Booking Event");
    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onItemClick(View v) {
        switch (v.getId()) {
            case R.id.plus:

                break;
            case R.id.minus:

                break;
        }}

        public void onItemClick(View v, View v1) {
            /*switch (v.getId()) {
                case R.id.plus:
                    minteger = minteger + 1;

                    ((TextView)v1).setText(minteger);
                    break;
                case R.id.minus:
                    minteger = minteger - 1;

                    ((TextView)v1).setText(minteger);
                    break;
            }*/


            Toast.makeText(getContext(),"event clicked:", Toast.LENGTH_LONG).show();
        }


}


