package pub.com.mypub.authentication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Objects;

import pub.com.mypub.R;
import pub.com.mypub.baseclasses.BaseFragment;

public abstract class NetworkBaseFragment extends BaseFragment implements OnNetworkInteractionListener {

    private CustomDialogFragment customFragment;

    @Override
    public void showProgressDialog(boolean isShowCancelButton, String string) {
        FragmentTransaction ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        Fragment prev = getActivity().getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        customFragment = CustomDialogFragment.newInstance(isShowCancelButton, string);
        customFragment.show(ft, "dialog");
    }

    @Override
    public void hideProgressDialog() {
        if(null != customFragment && customFragment.isVisible()) {
            customFragment.dismiss();
        }
    }
    @Override
    public void stringAPIRequest(final Map<String, String> params, int method, String URL, final String REQUEST_ID) {
        showProgressDialog(false, getString(R.string.validating_data));
        //Creating a string request
        StringRequest stringRequest = new StringRequest(method, URL,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        hideProgressDialog();
                        try {
                            Log.i("resp1", "resp1: " + response);
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            //{ status:'fail',data:'user not existed.'}
                            if(!jsonObject.getString("status").equals("fail")) {
                                if(jsonObject.getString("type").equals("object")) {
                                    onSuccessResponse(new JSONObject(jsonObject.getString("data")), REQUEST_ID);
                                } else {
                                    onSuccessResponse(new JSONArray(jsonObject.getString("data")), REQUEST_ID);
                                }
                            } else {
                                onFailureResponse(response,jsonObject.getString("data"), REQUEST_ID);
                            }
                        } catch (Exception e) {
                            onFailureResponse(response, e.getMessage(), REQUEST_ID);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        hideProgressDialog();
                        try {
                            onFailureResponse( error, "", REQUEST_ID);
                        } catch (Exception e){
                            onFailureResponse(error, error.getMessage(), REQUEST_ID);
                        }
                        //You can handle error here if you want
                    }
                }){
            @Override
            protected Map<String, String> getParams() {

                return params;
            }
        };

        //Adding the string request to the queue
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        Log.i("req", "req" + requestQueue);
    }
}
