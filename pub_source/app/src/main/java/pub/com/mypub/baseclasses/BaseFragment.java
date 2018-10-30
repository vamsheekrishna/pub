package pub.com.mypub.baseclasses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements OnBaseAppListener{

    public String fragmentName = "Default";
    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public String getTitle() {
        return fragmentName;
    }
    public void setTitle(String name) {
        fragmentName = name;
    }
}
