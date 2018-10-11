package pub.com.mypub.home;

import android.os.Bundle;

import pub.com.mypub.R;
import pub.com.mypub.authentication.NetworkBaseActivity;

public class AllEvents extends NetworkBaseActivity implements OnAllEventsInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
