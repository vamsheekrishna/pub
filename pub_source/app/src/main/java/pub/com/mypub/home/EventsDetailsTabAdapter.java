package pub.com.mypub.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import pub.com.mypub.baseclasses.BaseFragment;

class EventsDetailsTabAdapter extends FragmentStatePagerAdapter {

    ArrayList<BaseFragment> fragments;
    private static final int NUM_ITEMS = 4;
    private ArrayList<String> tabTitles = new ArrayList<>();

    public void setFragmentArray(ArrayList<BaseFragment> _fragments) {
        fragments = _fragments;
        /*for (BaseFragment fragment :fragments) {
            tabTitles.add();
        }*/
    }
    public EventsDetailsTabAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
