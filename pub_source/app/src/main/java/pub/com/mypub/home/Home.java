package pub.com.mypub.home;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import pub.com.mypub.R;
import pub.com.mypub.authentication.AuthenticationActivity;
import pub.com.mypub.authentication.ChangePasswordFragment;
import pub.com.mypub.authentication.ForgetFragment;
import pub.com.mypub.authentication.LoginFragment;
import pub.com.mypub.authentication.MyProfile;
import pub.com.mypub.authentication.NetworkBaseActivity;
import pub.com.mypub.authentication.ProfileFragment;
import pub.com.mypub.authentication.RegistrationFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import org.json.JSONException;

public class Home extends NetworkBaseActivity implements OnHomeInteractionListener, NavigationView.OnNavigationItemSelectedListener{
    MyProfile myProfile;
    private OnHomeInteractionListener mListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void goToMyProfile() {

    }

    @Override
    public void goToEvent() {


    }

    @Override
    public void goToChangePassword() {

    }

    @Override
    public void goToEventsDetailsFragment() {
        addFragment(EventsDetailsFragment.newInstance("", ""), true, true, EventsDetailsFragment.class.getName());
    }

    @Override
    public void goTovedioFragment() {

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {


                addFragment(ProfileFragment.newInstance("", ""), true, true, ProfileFragment.class.getName());
        }
        else if (id == R.id.event) {
            addFragment(EventsFragment.newInstance("", ""), true, true, EventsFragment.class.getName());

        }
        else if (id == R.id.changepassword) {
            addFragment(ChangePasswordFragment.newInstance("", ""), true, true, ChangePasswordFragment.class.getName());
        }
        else if (id == R.id.nav_share) {

        }
        else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDrawerSlide() {

    }
}

//        MenuItem menuItem = null;
//        selectDrawerItem(menuItem);
//        return true;
//    }
//    public void selectDrawerItem(MenuItem menuItem) {
//        // Create a new fragment and specify the fragment to show based on nav item clicked
//        Fragment fragment = null;
//        Class fragmentClass = null;
//        switch(menuItem.getItemId()) {
//            case R.id.profile:
//                fragmentClass = ProfileFragment.class;
//                break;
//            case R.id.event:
//                fragmentClass = EventsFragment.class;
//                break;
//        }
//
//        try {
//            fragment = (Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Insert the fragment by replacing any existing fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
//
//        // Highlight the selected item has been done by NavigationView
//        menuItem.setChecked(true);
//        // Set action bar title
//        setTitle(menuItem.getTitle());
//        // Close the navigation drawer
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawers();
//    }

