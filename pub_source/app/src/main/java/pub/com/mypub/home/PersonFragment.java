package pub.com.mypub.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
import java.util.HashMap;
import java.util.List;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.authentication.NetworkBaseFragment;

public class PersonFragment extends NetworkBaseFragment implements View.OnClickListener, RecycleItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecycleItemClickListener recycleItemClickListener;
    SwipeRefreshLayout mSwipeRefreshLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Specialist> mSpecialistList=new ArrayList<>();
    private OnHomeInteractionListener mListener;
    RecyclerView recyclerView;

    public PersonFragment() {
        // Required empty public constructor
    }


    public static PersonFragment newInstance(String param1, String param2) {
        PersonFragment fragment = new PersonFragment();
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
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        //view.findViewById(R.id.book).setOnClickListener(this);

        mSwipeRefreshLayout = view.findViewById(R.id.simpleSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
        recyclerView = view.findViewById(R.id.musician_list);
        recycleItemClickListener = this;
        setPersonDataList();


        return view;
    }

    private void setPersonDataList() {
//        ArrayList<Specialist> mSpecialistList=new ArrayList<>();
//        Specialist specialist = new Specialist(1,"Shekspeer","12/8/1770","Music","uhsfu","upload",false);
//        mSpecialistList.add(specialist);
//        Specialist specialist1 = new Specialist(2,"Vender","18/8/1990","Dance","uhsfu","upload",false);
//        mSpecialistList.add(specialist1);
//        Specialist specialist2 = new Specialist(3,"Thomas","20/11/2000","Art","uhsfu","upload",false);
//        mSpecialistList.add(specialist2);

//        String ids = mListener.getSelectedEvent().specialist_id;
//        List<String> myList = new ArrayList<String>(Arrays.asList(ids.split(",")));
//        for (String string : myList) {
//        mSelectedSpecialist.add(string);
//
            if (null == mListener.getSelectedEvent().mSpecialist) {
                HashMap<String, String > parems =new HashMap<>();
                parems.put("id",mListener.getSelectedEvent().specialist_id);
                stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL + "Specialist.php/getSelectedRecords", "get_selected_specialist");

           } else {
              setDataAdapter(mListener.getSelectedEvent().mSpecialist);
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
       // Toast.makeText(getContext(),"JSONObject: "+response.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
       // Toast.makeText(getContext(),"JSONArray: "+response.toString(), Toast.LENGTH_LONG).show();
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Specialist> specialist = Arrays.asList(gson.fromJson(response.toString(), Specialist[].class));
        Event event = mListener.getSelectedEvent();
        mListener.setSpecialistList(new ArrayList<>(specialist ));
        setDataAdapter(mListener.getSpecialistList());


    }

    private void setDataAdapter(ArrayList<Specialist> specialist) {
        PersonListAdapter mAdapter = new PersonListAdapter(this, specialist);
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
        Toast.makeText(getContext(),"onFailureResponse: "+response.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void setTagName() {
        super.setTitle("specialist");
    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(View v) {
        loadRecyclerViewData();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(View v, View v1) {

    }

    private void loadRecyclerViewData() {

    }
}
