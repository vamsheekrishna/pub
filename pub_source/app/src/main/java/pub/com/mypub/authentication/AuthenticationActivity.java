package pub.com.mypub.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import pub.com.mypub.R;
import pub.com.mypub.home.Home;

public class AuthenticationActivity extends NetworkBaseActivity implements OnAuthenticationInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        //goToLoginPage();
        addFragment(LoginFragment.newInstance("", ""), false, false, LoginFragment.class.getName());
    }

    @Override
    public void goToLoginPage() {
        addFragment(LoginFragment.newInstance("", ""), true, false, LoginFragment.class.getName());
    }

    @Override
    public void goToRegistrationPage() {
        addFragment(RegistrationFragment.newInstance("", ""), true, true, RegistrationFragment.class.getName());
    }

    @Override
    public void goToForgotPasswordPage() {
        addFragment(ForgetFragment.newInstance("", ""), true, true, ForgetFragment.class.getName());

    }

    @Override
    public void goToChangePasswordPage() {

    }

    @Override
    public void goToForgetTask() {

    }

    {

    }

    @Override
    public void goToMyProfilePage(MyProfile myProfile) {
        Toast.makeText(this, "goToMyProfilePage", Toast.LENGTH_SHORT).show();
        addFragment(ProfileFragment.newInstance("", ""), true, true, ProfileFragment.class.getName());
    }

    @Override
    public void goToHomePage(MyProfile myProfile) {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void gotoValidateOTP(MyProfile myProfile) {
        addFragment(ValidateOTPFragment.newInstance(myProfile, ""), true, true, ValidateOTPFragment.class.getName());
    }


}
