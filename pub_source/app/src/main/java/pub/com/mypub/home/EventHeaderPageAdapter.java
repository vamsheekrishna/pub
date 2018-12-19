package pub.com.mypub.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pub.com.mypub.R;

class EventHeaderPageAdapter extends PagerAdapter {
    Context context;
    int images[];
    ArrayList<String> mImagePath = new ArrayList<>();
    LayoutInflater layoutInflater;


    public EventHeaderPageAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mImagePath.add("http://faithindia.org/vAm/my_events/images/sunburn/s1.jpeg");
        mImagePath.add("http://faithindia.org/vAm/my_events/images/sunburn/s2.jpeg");
        mImagePath.add("http://faithindia.org/vAm/my_events/images/sunburn/s3.jpeg");
        mImagePath.add("http://faithindia.org/vAm/my_events/images/sunburn/s4.jpeg");
    }

    @Override
    public int getCount() {
        return mImagePath.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.event_header_layout, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        Picasso.with(context).load(mImagePath.get(position)).placeholder(R.drawable.network).into(imageView);
        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
