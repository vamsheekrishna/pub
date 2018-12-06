package pub.com.mypub.admin;

import java.util.ArrayList;

import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;

public interface OnAdminInteractionListener {

    void goToEventsDetailsFragment();
    void goToLanguageFragment();

    void goToCategoryFragment();

    void goToTickitFragment();

    void goToLocationFragment();

    void goToSpecialistFragment();

    void goToContactFragment();




    void goToCoverPageFragment();



    void setSelectedLanguage(ArrayList<Language> language);


    void setSelectedTicket(ArrayList<Ticket> ticket);

    void setSelectedSpecialist(ArrayList<Specialist> specialist);


    void setSelectedLocation(ArrayList<Location> location);

    void setSelectedContact(ArrayList<Contact> contact);

    void setSelectedCategory(ArrayList<Category> category);
}
