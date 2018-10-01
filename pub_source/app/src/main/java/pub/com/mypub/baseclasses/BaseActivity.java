package pub.com.mypub.baseclasses;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pub.com.mypub.R;

public class BaseActivity extends AppCompatActivity {

    protected String TAG = "BaseActivity";

    public void setTagName(String name) {
        String classpath[] = name.split("\\.");
        TAG = classpath[classpath.length-1];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void addFragment(Fragment fragment, boolean isReplace, boolean isAddToBackStack, String fragment_name) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(isReplace) {
            fragmentTransaction.replace(R.id.root_content, fragment, fragment_name);
        } else {
            fragmentTransaction.add(R.id.root_content, fragment, fragment_name);
        }
        if(isAddToBackStack) {
            fragmentTransaction.addToBackStack(fragment_name);
        }
        fragmentTransaction.commit();
    }

}
