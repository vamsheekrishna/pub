package pub.com.mypub.admin;

import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Location;

public interface OnAdminInteractionListener {

    void goToEventsDetailsFragment();
    void goToLanguageFragment();

    void goToCategoryFragment();

    void goToTickitFragment();

    void goToLocationFragment();

    void goToSpecialistFragment();

    void goToContactFragment();
    void setCategory(Category category);

    void setLocation(Location location);

    void goToCoverPageFragment();

    void setContact(Contact contact);
}
