package pub.com.mypub.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
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
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class TicketAmountFragment extends NetworkBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, RecycleItemClickListener  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnHomeInteractionListener mListener;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecycleItemClickListener recycleItemClickListener;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView recyclerView;
    SelectedTicketAdapter mTicketListAdapterAdapter;
    public TicketAmountFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TicketAmountFragment newInstance(String param1, String param2) {
        TicketAmountFragment fragment = new TicketAmountFragment();
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
        View view = inflater.inflate(R.layout.fragment_ticket_amount, container, false);
        recyclerView = view.findViewById(R.id.ticket_list);
        recycleItemClickListener = this;
        setTicketDataList();
        return view;
    }

    private void setTicketDataList() {
        setDataAdapter(mListener.getSelectedEvent().mSelectedTickets);
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
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Ticket> ticketlist = Arrays.asList(gson.fromJson(response.toString(), Ticket[].class));
        mListener.setTicktList(new ArrayList<>(ticketlist ));
        setDataAdapter(mListener.getTicketList());
    }

    private void setDataAdapter(ArrayList<Ticket> ticketList) {
        mTicketListAdapterAdapter = new SelectedTicketAdapter(this, new ArrayList<>(ticketList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(mTicketListAdapterAdapter);
    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {
        Toast.makeText(getContext(),"onFailureResponse: "+response.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {
        Toast.makeText(getContext(),"onFailureResponse: "+response.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void setTagName() {

    }

    @Override
    public void CloseApp() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

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
