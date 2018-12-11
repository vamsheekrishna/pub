package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class BookingFragment extends NetworkBaseFragment implements RecycleItemClickListener,View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView displayInteger;
    int minteger = 0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //ArrayList<Ticket> mTicketList=new ArrayList<>();
    ArrayList<Event> mEventList=new ArrayList<>();
    private OnHomeInteractionListener mListener;
    RecyclerView recyclerView,recyclerView1;
    ArrayList<Event> mSelectedEvent;
    TextView display;
    Button time, proceed;
    RecycleItemClickListener recycleItemClickListener;
    TicketListAdapter mTicketListAdapterAdapter;
    ArrayList<Location> mSelectedLocation = new ArrayList<>();
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
        //RecycleItemClickListener recycleItemClickListener = this;
        recyclerView = view.findViewById(R.id.ticket_list);
        recyclerView1 = view.findViewById(R.id.date_list);
        recycleItemClickListener = this;
        setTicketDataList();
        setDateList();
        setTicketAmount();
        display = view.findViewById(R.id.display);
        time = view.findViewById(R.id.time);
        proceed = view.findViewById(R.id.proceed);
        time.setOnClickListener(this);
        proceed.setOnClickListener(this);
        /*TimeListAdapter tAdapter = new TimeListAdapter(this);
        RecyclerView recyclerView2 = view.findViewById(R.id.time_list);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(tAdapter);*/
        return view;
    }

    private void setTicketAmount() {
        ArrayList<Ticket>tickets = new ArrayList<>();
    }

    private void setDateList() {
        ArrayList<Date> dateList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");

        try {
            Date date1 = format.parse(mListener.getSelectedEvent().start_date);
            Date date2 = format.parse(mListener.getSelectedEvent().end_date);
            long difference = date2.getTime() - date1.getTime();
            float daysBetween = (difference / (1000*60*60*24));
            System.out.println("Number of Days between dates: "+daysBetween);
            for (int i =0; i<=daysBetween; i++) {
                System.out.println("Number of Days between dates: "+daysBetween);
                dateList.add(new Date(date1.getTime()+ (i*(1000*60*60*24))));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mListener.getSelectedEvent().mDateList = dateList;
        DateListAdapter mmAdapter = new DateListAdapter(this, mListener.getSelectedEvent().mDateList);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(mmAdapter);

        /*stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"events.php/getAllRecords", "get_all_event");
        return mEventList;*/
    }

    private void setTicketDataList() {

        if(null == mListener.getSelectedEvent().mTickets) {
            HashMap<String, String > parems =new HashMap<>();
            parems.put("id",mListener.getSelectedEvent().ticket_id);
            stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"ticket.php/getSelectedRecords", "get_selected_ticket");
        } else {
            setDataAdapter(mListener.getSelectedEvent().mTickets);
        }

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
        Toast.makeText(getContext(),"JSONObject: "+response.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
       // Toast.makeText(getContext(),"JSONArray: "+response.toString(), Toast.LENGTH_LONG).show();
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Ticket> ticketlist = Arrays.asList(gson.fromJson(response.toString(), Ticket[].class));
       // List<Event> eventlist = Arrays.asList(gson.fromJson(response.toString(), Event[].class));
        mListener.setTicktList(new ArrayList<>(ticketlist ));
        setDataAdapter(mListener.getTicketList());

        }

    private void setDataAdapter(ArrayList<Ticket> ticketList) {
        mTicketListAdapterAdapter = new TicketListAdapter(this, ticketList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(mTicketListAdapterAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    if (null != mSelectedEvent) {
        String temp = "";
        for (Event event : mSelectedEvent) {
            temp += event.start_date + "  "+ event.end_date+" ";
        }

        if (temp.length() > 0) {
            display.setText(temp);
        }
    }}
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
            case R.id.k:
                    Date date = (Date) v.getTag();
                    Toast.makeText(getActivity(), "date: "+date.toString(), Toast.LENGTH_LONG).show();
                    display.setText(date.toString());
                break;
            case R.id.time:
                String timee = time.getText().toString();
                display.setText(timee);
                break;
        }
    }

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
    public void setEvent(ArrayList<Event> _event) {
        mSelectedEvent = _event;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.proceed:
                ArrayList<Ticket> tickets = mTicketListAdapterAdapter.tickets;
                for (Ticket ticket: tickets) {
                         if(ticket.mTicketCount>0)
                         {
                             mListener.getSelectedEvent().setmSelectedTickets( ticket);
                         }
                }
                mListener.goToTicketAmountFragment();
                break;
        }
    }
}


