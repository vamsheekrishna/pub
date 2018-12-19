package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class EventsFragment extends NetworkBaseFragment implements View.OnClickListener, RecycleItemClickListener, SwipeRefreshLayout.OnRefreshListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecycleItemClickListener recycleItemClickListener;
    SwipeRefreshLayout mSwipeRefreshLayout;
    private String mParam1;
    private String mParam2;
    ArrayList<Event> mEventList=new ArrayList<>();
    private OnHomeInteractionListener mListener;
    RecyclerView recyclerView;
    EventListAdapter mAdapter;
    public EventsFragment() {
        // Required empty public constructor
    }
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
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
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        //view.findViewById(R.id.book).setOnClickListener(this);
        getActivity().setTitle("Events");

        mSwipeRefreshLayout = view.findViewById(R.id.simpleSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);


        setEventDataList();
        recyclerView = view.findViewById(R.id.event_list);
        recycleItemClickListener = this;


        return view;
    }

    private void setEventDataList() {
        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"events.php/getAllRecords", "get_all_event");
    }

    private ActionBar getActionBar() {
        return null;
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
        switch (v.getId()){
            case R.id.book:
                mListener.setSelectedEvent(mEventList.get((Integer) v.getTag()));
                mListener.goToEventsDetailsFragment();
                break;


        }
    }

    @Override
    public void onItemClick(View v) {
        mListener.setSelectedEvent(mEventList.get((Integer) v.getTag()));
        mListener.goToEventsDetailsFragment();
    }

    @Override
    public void onItemClick(View v, View v1) {

    }

    @Override
    public void onRefresh() {
        loadRecyclerViewData();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void loadRecyclerViewData() {

    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {
        //Toast.makeText(getContext(),"JSONObject: "+response.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
      // Toast.makeText(getContext(),"JSONArray: "+response.toString(), Toast.LENGTH_LONG).show();
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Event> event = Arrays.asList(gson.fromJson(response.toString(), Event[].class));
        mEventList = new ArrayList<>(event );
        mAdapter = new EventListAdapter(this, mEventList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {
        Toast.makeText(getContext(),"onFailureResponse: "+response.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {
        Toast.makeText(getContext(),"onFailureResponse: "+response, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setTagName() {

    }

    @Override
    public void CloseApp() {

    }
}
