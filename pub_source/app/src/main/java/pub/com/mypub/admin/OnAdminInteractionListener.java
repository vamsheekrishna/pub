package pub.com.mypub.admin;

import pub.com.mypub.admin.models.Category;

public interface OnAdminInteractionListener {

    void goToEventsDetailsFragment();
    void goToLanguageFragment();

    void goToCategoryFragment();

    void goToTickitFragment();

    void goToLocationFragment();

    void goToSpecialistFragment();

    void goToContactFragment();
    void setCategory(Category category);
}
