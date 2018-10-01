package pub.com.mypub.authentication;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.Map;

import pub.com.mypub.baseclasses.OnBaseAppListener;


interface OnNetworkInteractionListener extends OnBaseAppListener {

    void showProgressDialog(boolean isShowCancelButton, String string);
    void hideProgressDialog();

    void stringAPIRequest(Map<String, String> params, int method, String URL, String REQUEST_ID);
    void onSuccessResponse(JSONObject response, String REQUEST_ID);
    void onFailureResponse(VolleyError response, String exception, String REQUEST_ID);
    void onFailureResponse(String response, String exception, String REQUEST_ID);
}
