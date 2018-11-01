package pub.com.mypub.home;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import pub.com.mypub.R;
import pub.com.mypub.authentication.NetworkBaseFragment;
import pub.com.mypub.baseclasses.BaseFragment;
import pub.com.mypub.customview.WrapContentHeightViewPager;


public class EventsDetailsFragment extends NetworkBaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private TabLayout tabLayout;
    private EventsDetailsTabAdapter mAdapter;
    private OnHomeInteractionListener mListener;
    private EventsDetailsTabAdapter eventsDetailsTabAdapter;
    public EventsDetailsFragment() {
        // Required empty public constructor
    }

    public static EventsDetailsFragment newInstance(String param1, String param2) {
        EventsDetailsFragment fragment = new EventsDetailsFragment();
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

        setTagName();
        View view = inflater.inflate(R.layout.sample_collapse, container, false);
        ViewPager viewPager = view.findViewById(R.id.pager_container);
//        Typeface typeface = getResources().getFont(R.font.kaushanscriptregular);
        EventHeaderPageAdapter eventHeaderPageAdapter = new EventHeaderPageAdapter(getContext(),new int[]{R.drawable.s1, R.drawable.s2,R.drawable.s3,R.drawable.s4, R.drawable.s5,R.drawable.s6,R.drawable.s8, R.drawable.s88});
        viewPager.setAdapter(eventHeaderPageAdapter);
        /*NestedScrollView scrollView = view.findViewById (R.id.scroll_view);
        scrollView.setFillViewport (true);*/
        ViewPager eventBodyPageAdapter = view.findViewById(R.id.detail_fragment_list);
        eventsDetailsTabAdapter = new EventsDetailsTabAdapter(getActivity().getSupportFragmentManager());
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(EventDetailTabFragment.newInstance("",""));

        fragments.add(VedioFragment.newInstance("",""));
        fragments.add(TAndCFragment.newInstance("",""));
        fragments.add(BookingFragment.newInstance("",""));
        eventsDetailsTabAdapter.setFragmentArray(fragments);
        eventBodyPageAdapter.setAdapter(eventsDetailsTabAdapter);

        /*tabLayout = view.findViewById (R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(eventBodyPageAdapter);*/

        /*TabLayout tabLayout = view.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(eventBodyPageAdapter);*/

        return view;
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

    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {

    }

    @Override
    public void setTagName() {
        super.setTitle("Event Details");
    }

    @Override
    public void CloseApp() {

    }
}
