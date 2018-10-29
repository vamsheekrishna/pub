package pub.com.mypub.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class EventsDetailsTabAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_ITEMS = 4;
    private String tabTitles[] = new String[] { "Tab 1", "Tab 2", "Tab 3", "Tab 4" };

    public EventsDetailsTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
    @Override
    public Fragment getItem(int i) {
        return EventDetailTabFragment.newInstance("","");
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
