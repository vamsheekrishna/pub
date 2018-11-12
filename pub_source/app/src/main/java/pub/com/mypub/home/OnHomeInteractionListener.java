package pub.com.mypub.home;

import android.view.MenuItem;

public interface OnHomeInteractionListener {
    void goToMyProfile();
    void goToEvent();
    void goToChangePassword();
    void goToEventsDetailsFragment();
    void goTovedioFragment();
    boolean onNavigationItemSelected(MenuItem menuItem);
    void onDrawerSlide();

}
