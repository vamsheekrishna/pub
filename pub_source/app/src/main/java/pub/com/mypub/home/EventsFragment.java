package pub.com.mypub.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pub.com.mypub.R;


public class EventsFragment extends Fragment implements View.OnClickListener, RecycleItemClickListener, SwipeRefreshLayout.OnRefreshListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecycleItemClickListener recycleItemClickListener;
    SwipeRefreshLayout mSwipeRefreshLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnHomeInteractionListener mListener;

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

        recycleItemClickListener = this;
        EventListAdapter mAdapter = new EventListAdapter(recycleItemClickListener);
        RecyclerView recyclerView = view.findViewById(R.id.event_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

       // TextView mTitle = view.findViewById(R.id.toolbar_title);
        //mTitle.setTypeface(Typeface.createFromFile("font/kaushanscriptregular.otf"));

      //  Typeface fontTypeFace = Typeface.createFromAsset(getActivity().getAssets(),"fonts/thehistoriademo.ttf");

        return view;
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
                mListener.goToEventsDetailsFragment();
                break;


        }
    }

    @Override
    public void onItemClick(View v) {
        mListener.goToEventsDetailsFragment();
    }

    @Override
    public void onRefresh() {
        loadRecyclerViewData();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void loadRecyclerViewData() {

    }
}
