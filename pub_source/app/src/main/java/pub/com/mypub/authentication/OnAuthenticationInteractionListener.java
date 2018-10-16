package pub.com.mypub.authentication;

public interface OnAuthenticationInteractionListener {
    void goToLoginPage();
    void goToRegistrationPage();
    void goToForgotPasswordPage();
    void goToChangePasswordPage();
    void goToForgetTask();
    void goToMyProfilePage(MyProfile myProfile);
    void goToHomePage(MyProfile myProfile);

    void gotoValidateOTP(MyProfile myProfile);
}
