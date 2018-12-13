package pub.com.mypub.authentication;

import pub.com.mypub.admin.models.Event;

public interface OnAuthenticationInteractionListener {
    void goToLoginPage();
    void goToRegistrationPage();
    void goToForgotPasswordPage();
    void goToChangePasswordPage();
    void goToForgetTask();
    void goToMyProfilePage(MyProfile myProfile);
    void goToHomePage(MyProfile myProfile);

    void gotoValidateOTP(MyProfile myProfile, boolean isRegistration);

    void goToChangePasswordPage(MyProfile myProfile, boolean isForgot);

    void setSelectedUser(MyProfile selectedUser);
    MyProfile getSelectedUser();


}
