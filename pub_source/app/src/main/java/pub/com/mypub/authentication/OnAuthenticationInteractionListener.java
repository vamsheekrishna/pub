package pub.com.mypub.authentication;

public interface OnAuthenticationInteractionListener {
    void goToLoginPage();
    void goToRegistrationPage();
    void goToForgotPasswordPage();
    void goToChangePasswordPage();
    void goToMyProfilePage(MyProfile myProfile);

    void gotoValidateOTP(MyProfile myProfile);
}
