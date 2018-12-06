package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import pub.com.mypub.admin.models.Details;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.authentication.NetworkBaseFragment;

public class EventDetailTabFragment extends NetworkBaseFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    TextView title, category_id,start_date,duration,location_id,language_id,description,note, start_price,age_limit ;
    private OnHomeInteractionListener mListener;
    public static EventDetailTabFragment newInstance(String param1, String param2) {
        EventDetailTabFragment fragment = new EventDetailTabFragment();
        fragment.setTagName();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setTagName();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events_details, container, false);
        //view.findViewById(R.id.book).setOnClickListener(this);

        title = view.findViewById(R.id.event);
        category_id = view.findViewById(R.id.details);
        start_date =view.findViewById(R.id.detee);
        duration = view.findViewById(R.id.detail3);
        location_id =view.findViewById(R.id.description);
        language_id = view.findViewById(R.id.detail2);
        description =view.findViewById(R.id.t1);
        note =view.findViewById(R.id.note);
        start_price = view.findViewById(R.id.price);
        age_limit =view.findViewById(R.id.detail4);

        getActivity().setTitle("Events");
        Event event = mListener.getSelectedEvent();
        title.setText(event.title);
        category_id.setText(event.category_id);
        start_date.setText(event.start_date);
        duration.setText(event.duration);
        location_id.setText(event.location_id);
        language_id.setText(event.language_id);
        description.setText(event.description);
        note.setText(event.note);
        start_price.setText(event.start_price);
        age_limit.setText(event.age_limit);
        /*mSwipeRefreshLayout = view.findViewById(R.id.simpleSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);*/


        //setEventDataList();
        //recyclerView = view.findViewById(R.id.event_list);
        //recycleItemClickListener = this;


        return view;
    }

    /*private ArrayList<Details> setEventDataList() {
        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"events.php/getAllRecords", "get_all_event");
        return mDetailsList;
    }*/


    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {

    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        /*Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Details> details = Arrays.asList(gson.fromJson(response.toString(), Details[].class));

        DetailsAdapter mAdapter = new DetailsAdapter(this, new ArrayList<>(details));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);*/
    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {

    }

    @Override
    public void setTagName() {
        super.setTitle("Event details");
    }

    @Override
    public void CloseApp() {

    }
}
