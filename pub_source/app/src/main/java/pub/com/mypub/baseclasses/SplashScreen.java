package pub.com.mypub.baseclasses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;

import pub.com.mypub.PubMainActivity;
import pub.com.mypub.R;
import pub.com.mypub.authentication.AuthenticationActivity;
import pub.com.mypub.authentication.NetworkBaseActivity;

public class SplashScreen extends NetworkBaseActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    private boolean isGoToNextScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTagName();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        //checkNetworkConnection();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                isGoToNextScreen = true;
                goToNextScreen();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void goToNextScreen() {

        if(isNetworkAvailable() && isGoToNextScreen) {
            SharedPreferences sharedPreferences = getSharedPreferences(Constant.SHARED_PREF_NAME, Context.MODE_PRIVATE);
            boolean loggedIn = sharedPreferences.getBoolean(Constant.IS_LOGGED, false);
            //If we will get true
            if(loggedIn){
                //We will start the Profile Activity
                Intent intent = new Intent(SplashScreen.this, PubMainActivity.class);
                startActivity(intent);
            } else {
                Intent mainIntent = new Intent(SplashScreen.this, AuthenticationActivity.class);
                startActivity(mainIntent);
            }
            finish();
        }
    }

    /*@Override
    public void setTagName() {
        setTagName(getLocalClassName());
    }*/

    @Override
    public void onNetworkConnected() {
        super.onNetworkConnected();
        goToNextScreen();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/

    }
}
