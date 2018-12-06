package pub.com.mypub.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import pub.com.mypub.R;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class VedioFragment extends NetworkBaseFragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    MediaController m;
    VideoView vid;
    private OnHomeInteractionListener mListener;

    public VedioFragment() {
        // Required empty public constructor
    }

    public static VedioFragment newInstance(String param1, String param2) {
        VedioFragment fragment = new VedioFragment();
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

        setTagName();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vedio, container, false);
        vid = view.findViewById(R.id.videoView);

        view.findViewById(R.id.btnPlay).setOnClickListener(this);
        return view;

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
        switch (v.getId()) {
            case R.id.btnPlay:

                m = new MediaController(getActivity());
                vid.setMediaController(m);

                String path = "/Users/admin/Documents/work/events/pub_source/app/src/main/res/raw/sf.mp4";

                Uri u = Uri.parse(path);

                vid.setVideoURI(u);

                vid.start();




                break;
        }
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
        super.setTitle("Gallery ");
    }

    @Override
    public void CloseApp() {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and ticket_name
        void onFragmentInteraction(Uri uri);
    }
}
