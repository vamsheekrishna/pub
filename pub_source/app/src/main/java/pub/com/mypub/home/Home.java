package pub.com.mypub.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.ChangePasswordFragment;
import pub.com.mypub.authentication.MyProfile;
import pub.com.mypub.authentication.NetworkBaseActivity;
import pub.com.mypub.authentication.ProfileFragment;

import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;

import java.util.ArrayList;

public class Home extends NetworkBaseActivity implements OnHomeInteractionListener, NavigationView.OnNavigationItemSelectedListener{
    MyProfile myProfile;
    Event mCurrentEvent;
    Specialist mCurrentSpecialist;
    BookingFragment BookingFragment;
    private OnHomeInteractionListener mListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        BookingFragment = BookingFragment.newInstance("", "");
        navigationView.getMenu().setGroupVisible(R.id.erate_event, false);
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

        addFragment(EventsDetailsFragment.newInstance(getSelectedEvent(), ""), true, true, EventsDetailsFragment.class.getName());
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDrawerSlide() {

    }

    @Override
    public void setSelectedEvent(Event selectedEvent) {
        mCurrentEvent = selectedEvent;
    }

    @Override
    public Event getSelectedEvent() {
        return mCurrentEvent;
    }

    @Override
    public void setSelectedSpecialist(Specialist SelectedSpecialist) {
        mCurrentSpecialist = SelectedSpecialist;
    }

    @Override
    public Specialist getSelectedSpecialist() {
        return mCurrentSpecialist;
    }

    @Override
    public void setSpecialistList(ArrayList<Specialist> specialist) {
        mCurrentEvent.mSpecialist = specialist;
    }

    @Override
    public ArrayList<Specialist> getSpecialistList() {
        return mCurrentEvent.mSpecialist;
    }

    @Override
    public void setTicktList(ArrayList<Ticket> ticketlist) {
        mCurrentEvent.mTickets = ticketlist;
    }



    @Override
    public ArrayList<Ticket> getTicketList() {
        return mCurrentEvent.mTickets;
    }

    @Override
    public void setEventList(ArrayList<Event> event) {
        mCurrentEvent.mEvent = event;
    }

    @Override
    public ArrayList<Event> getEventList() {
        return mCurrentEvent.mEvent;
    }

    @Override
    public void setContactList(ArrayList<Contact> contact) {
        mCurrentEvent.mContact = contact;
    }

    @Override
    public ArrayList<Contact> getContactList() {
        return mCurrentEvent.mContact;
    }

    @Override
    public void setSelectedEventt(ArrayList<Event> evenrt) {
        BookingFragment.setEvent(evenrt);
    }

    @Override
    public void setSelectedTickett(ArrayList<Ticket> tickets) {
        mCurrentEvent.mTicketlist = tickets;
    }
}

