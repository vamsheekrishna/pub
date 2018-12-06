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
import java.util.List;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.authentication.NetworkBaseFragment;

public class OfflinePromotersFragment extends NetworkBaseFragment implements View.OnClickListener, RecycleItemClickListener, SwipeRefreshLayout.OnRefreshListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<Contact> mOfflineList=new ArrayList<>();
    private OnHomeInteractionListener mListener;
    RecycleItemClickListener recycleItemClickListener;
    SwipeRefreshLayout mSwipeRefreshLayout;
    private String mParam1;
    private String mParam2;
    ArrayList<Contact> mContactList=new ArrayList<>();
    RecyclerView recyclerView;

    public OfflinePromotersFragment() {
        // Required empty public constructor
    }

    public static OfflinePromotersFragment newInstance(String param1, String param2) {
        OfflinePromotersFragment fragment = new OfflinePromotersFragment();
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
        View view = inflater.inflate(R.layout.fragment_offline, container, false);
        //view.findViewById(R.id.book).setOnClickListener(this);

        mSwipeRefreshLayout = view.findViewById(R.id.simpleSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
        recyclerView = view.findViewById(R.id.contact_list);
        setPersonDataList();
        recycleItemClickListener = this;


        return view;
    }

    private void  setPersonDataList() {
        if (null == mListener.getSelectedEvent().mContact) {
            stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL + "contact.php/getAllRecords", "get_all_contact");
        } else {
            setDataAdapter(mListener.getSelectedEvent().mContact);
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeInteractionListener) {
            mListener = (OnHomeInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
      //  Toast.makeText(getContext(),"JSONArray: "+response.toString(), Toast.LENGTH_LONG).show();
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Contact> contact = Arrays.asList(gson.fromJson(response.toString(), Contact[].class));
        mListener.setContactList(new ArrayList<>(contact ));
        setDataAdapter(mListener.getContactList());

    }
    private void setDataAdapter(ArrayList<Contact> contact) {
        OfflineListAdapter mAdapter = new OfflineListAdapter(this, new ArrayList<>(contact ));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {

    }

    @Override
    public void setTagName() {
        super.setTitle("Offline Promoterts");
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
