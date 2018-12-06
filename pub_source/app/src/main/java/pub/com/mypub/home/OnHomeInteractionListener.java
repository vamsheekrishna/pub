package pub.com.mypub.home;

import android.view.MenuItem;

import java.util.ArrayList;

import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;

public interface OnHomeInteractionListener {
    void goToMyProfile();
    void goToEvent();
    void goToChangePassword();
    void goToEventsDetailsFragment();
    void goTovedioFragment();
    boolean onNavigationItemSelected(MenuItem menuItem);
    void onDrawerSlide();
    void setSelectedEvent(Event selectedEvent);
    Event getSelectedEvent();

    void setSpecialistList(ArrayList<Specialist> selectedEvent);
    ArrayList<Specialist> getSpecialistList();

    void setEventList(ArrayList<Event> selectedEvent);
    ArrayList<Event> getEventList();

    void setContactList(ArrayList<Contact> selectedEvent);
    ArrayList<Contact> getContactList();

    void setSelectedEventt(ArrayList<Event> evenrt);

    void setSelectedTickett(ArrayList<Ticket> tickets);
}
