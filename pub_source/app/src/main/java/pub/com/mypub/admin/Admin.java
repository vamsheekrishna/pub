package pub.com.mypub.admin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import pub.com.mypub.R;
import pub.com.mypub.authentication.MyProfile;
import pub.com.mypub.authentication.NetworkBaseActivity;
import pub.com.mypub.home.CreateEventFragment;
import pub.com.mypub.home.EventsDetailsFragment;
import pub.com.mypub.home.EventsFragment;
import pub.com.mypub.home.OnHomeInteractionListener;

public class Admin extends NetworkBaseActivity implements OnAdminInteractionListener, NavigationView.OnNavigationItemSelectedListener,DrawableItemClickListener{

    MyProfile myProfile;
    private OnAdminInteractionListener mListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.admin_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //navigationView.getMenu().setGroupVisible(R.id.erate_event, true);
        navigationView.getMenu().findItem(R.id.erate_event).setVisible(true);

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
    @SuppressWarnings("StatementWithEmptyBody")
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
    public void goToEventsDetailsFragment() {
        addFragment(EventsDetailsFragment.newInstance("", ""), true, true, EventsDetailsFragment.class.getName());
    }

    @Override
    public void goToLanguageFragment() {
        addFragment(LanguageFragment.newInstance("", ""), true, true, LanguageFragment.class.getName());
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.createvent) {

            addFragment(CreateEventFragment.newInstance("", ""), true, true, CreateEventFragment.class.getName());
        }



        else if (id == R.id.event) {
           // addFragment(EventsFragment.newInstance("", ""), true, true, EventsFragment.class.getName());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(View v) {

    }
}
