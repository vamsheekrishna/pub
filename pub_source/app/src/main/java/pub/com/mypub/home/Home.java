package pub.com.mypub.home;

import android.os.Bundle;

import pub.com.mypub.R;
import pub.com.mypub.authentication.NetworkBaseActivity;

public class Home extends NetworkBaseActivity implements OnHomeInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addFragment(EventsFragment.newInstance("",""),false,true,EventsFragment.class.getName());
    }

    @Override
    public void goToMyProfile() {
    }

    @Override
    public void goToEvent() {
        addFragment(EventsFragment.newInstance("",""),true,true,EventsFragment.class.getName());
    }

    @Override
    public void goToChangePassword() {

    }

    @Override
    public void goToEventsDetailsFragment() {
        addFragment(EventsDetailsFragment.newInstance("",""),true,true,EventsDetailsFragment.class.getName());
    }

    @Override
    public void goTovedioFragment() {
        addFragment(VedioFragment.newInstance("",""),true,true,VedioFragment.class.getName());

    }
}
