package pub.com.mypub.admin;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.MyProfile;
import pub.com.mypub.authentication.NetworkBaseActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import java.util.ArrayList;
import pub.com.mypub.home.ContactFragment;
import pub.com.mypub.home.CreateEventFragment;
import pub.com.mypub.home.CreateLocationFragment;
import pub.com.mypub.home.CreateSpecialistFragment;
import pub.com.mypub.home.CreateTicketFragment;
import pub.com.mypub.home.EventsDetailsFragment;
import pub.com.mypub.home.EventsFragment;

public class Admin extends NetworkBaseActivity implements OnAdminInteractionListener, NavigationView.OnNavigationItemSelectedListener,DrawableItemClickListener{

    MyProfile myProfile;
    private OnAdminInteractionListener mListener;
    CreateEventFragment createEventFragment;
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
        createEventFragment = CreateEventFragment.newInstance("", "");

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

        int id = item.getItemId();
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
    public void goToCategoryFragment() {
        addFragment(CategoryFragment.newInstance("", ""), true, true, CategoryFragment.class.getName());
    }

    @Override
    public void goToTickitFragment() {
        addFragment(CreateTicketFragment.newInstance("", ""), true, true, CreateTicketFragment.class.getName());
    }

    @Override
    public void goToLocationFragment() {
        addFragment(CreateLocationFragment.newInstance("", ""), true, true, CreateLocationFragment.class.getName());
    }

    @Override
    public void goToSpecialistFragment() {
        addFragment(CreateSpecialistFragment.newInstance("", ""), true, true, CreateSpecialistFragment.class.getName());
    }

    @Override
    public void goToContactFragment() {
        addFragment(ContactFragment.newInstance("", ""), true, true, ContactFragment.class.getName());
    }

    @Override
    public void setCategory(Category category) {
        createEventFragment.setCategory(category);
    }



    @Override
    public void goToCoverPageFragment() {
        addFragment(CoverPageFragment.newInstance("", ""), true, true, CoverPageFragment.class.getName());
    }

    @Override
    public void setContact(Contact contact) {

        createEventFragment.setContact(contact);
    }



    @Override
    public void setSelectedLanguage(ArrayList<Language> language) {
        createEventFragment.setLanguage(language);
    }

    @Override
    public void setSelectedTicket(ArrayList<Ticket> ticket) {
        createEventFragment.setTicket(ticket);
    }

    @Override
    public void setSelectedSpecialist(ArrayList<Specialist> specialist) {
        createEventFragment.setSpecialist(specialist);
    }

    @Override
    public void setSelectedLocation(ArrayList<Location> location) {
        createEventFragment.setLocation(location);
    }


    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.erate_event) {

            addFragment(createEventFragment, true, true, CreateEventFragment.class.getName());
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
