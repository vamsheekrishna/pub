package pub.com.mypub.home;

import android.view.View;

import pub.com.mypub.admin.models.Event;

public interface RecycleItemClickListener {
    void onItemClick(View v);
    void onItemClick(View v, View v1);


//    void setSelectedEvent(Event selectedEvent);
//    Event getSelectedEvent();
}
