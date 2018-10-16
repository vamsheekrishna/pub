package pub.com.mypub.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pub.com.mypub.R;
import pub.com.mypub.authentication.NetworkBaseActivity;
import pub.com.mypub.authentication.NetworkBaseFragment;

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
}
