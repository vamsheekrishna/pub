package pub.com.mypub.authentication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.Map;

import pub.com.mypub.R;
import pub.com.mypub.baseclasses.BaseActivity;

public class NetworkBaseActivity extends BaseActivity implements OnNetworkChangeListener{
    boolean isWifiConnected = false;
    boolean isMobileDataConnected = false;
    CustomDialogFragment customFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //setTagName();
        //customFragment = CustomDialogFragment.newInstance("", "");
        //globalDialogBox = new GlobalDialogBox("Network Alert", "Network Disconnected", this);
    }
    void showNetworkNotAvailableDialog() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        customFragment = CustomDialogFragment.newInstance(true,"");
        customFragment.show(ft, "dialog");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //checkNetworkConnection();
        registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }

    @Override
    protected void onStop() {
        super.onStop();
        isWifiConnected = false;
        isMobileDataConnected = false;
        unregisterReceiver(networkChangeReceiver);
    }

    BroadcastReceiver networkChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkNetworkConnection();
        }
    };

    @Override
    public void onNetworkChanging() {
        Log.d(TAG, "Network Changing");
        Toast.makeText(this, "Network Changing........", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNetworkConnected() {
        //globalDialogBox.alertDialog.dismiss();
        if(null != customFragment && customFragment.isVisible()) {
            customFragment.dismiss();
        }
    }

    @Override
    public void onNetworkDisConnected() {
        //alertDialog();
        //globalDialogBox.alertDialog.show();
        //getSupportFragmentManager().beginTransaction().add(customFragment, "customFragment").commit();
        //customFragment.getDialog().show();
        /**/
        showNetworkNotAvailableDialog();
    }

    @Override
    public void checkNetworkConnection() {
        isWifiConnected = false;
        isMobileDataConnected = false;
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivity != null;
        NetworkInfo[] netInfo = connectivity.getAllNetworkInfo();
        if (null != netInfo) {
            for (NetworkInfo ni : netInfo) {
                if (ni.getState() == NetworkInfo.State.CONNECTED) {
                    if (ni.getTypeName().equalsIgnoreCase("WIFI")  && ni.isConnected())
                        isWifiConnected = true;
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE") && ni.isConnected())
                        isMobileDataConnected = true;
                    //onNetworkConnected();
                }
            }
        }

        if(isWifiConnected || isMobileDataConnected) {
            onNetworkConnected();
        } else {
            onNetworkDisConnected();
        }
    }

    @Override
    public boolean isNetworkAvailable() {
        return isWifiConnected || isMobileDataConnected;
    }
}
