package pub.com.mypub.admin;

import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import pub.com.mypub.R;
import pub.com.mypub.admin.DrawableItemClickListener;

public class DrawableObject  implements View.OnClickListener{
    DrawableItemClickListener mListener;
    public DrawableObject(View view, DrawableItemClickListener listener) {
     //   super(view);

        DrawerLayout vieItem = view.findViewById(R.id.drawer_layout);
                     vieItem.findViewById(R.id.nav_view);

        mListener = listener;

    }

    @Override
    public void onClick(View v) {
        mListener.onItemClick(v);
    }


}
