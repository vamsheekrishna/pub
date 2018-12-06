package pub.com.mypub.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

import pub.com.mypub.R;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class GalleryFragment extends NetworkBaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView selectedImage;
    private ImageLoader mImageLoader;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnHomeInteractionListener mListener;

    public GalleryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        setTagName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
//        Gallery gallery = view.findViewById(R.id.gallery);
//        gallery.setSpacing(1);

        selectedImage=view.findViewById(R.id.img1);
        Drawable drw =LoadImageFromWebOperations(" http://faithindia.org/vAm/my_events/images/event1/s1.jpeg");
        selectedImage.setImageDrawable(drw);

//        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this.getActivity());
//        gallery.setAdapter(galleryImageAdapter);
//
//        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                // show the selected Image
//                selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
//            }
//        });


        return view;
    }

    private Drawable LoadImageFromWebOperations(String strPhotoUrl) {
        try {
            InputStream is = (InputStream) new URL(strPhotoUrl).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        }catch (Exception e) {
            System.out.println("Exc="+e);
            return null;
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeInteractionListener) {
            mListener = (OnHomeInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHomeInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
//    public static class LruBitmapCache extends LruCache<String, Bitmap> implements
//            ImageLoader.ImageCache {
//        public static int getDefaultLruCacheSize() {
//            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
//            final int cacheSize = maxMemory / 8;
//
//            return cacheSize;
//        }
//
//        public LruBitmapCache() {
//            this(getDefaultLruCacheSize());
//        }
//
//        public LruBitmapCache(int sizeInKiloBytes) {
//            super(sizeInKiloBytes);
//        }
//
//        @Override
//        protected int sizeOf(String key, Bitmap value) {
//            return value.getRowBytes() * value.getHeight() / 1024;
//        }
//
//        @Override
//        public Bitmap getBitmap(String url) {
//            return get(url);
//        }
//
//        @Override
//        public void putBitmap(String url, Bitmap bitmap) {
//            put(url, bitmap);
//        }
//    }
    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {

    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {

    }

    @Override
    public void setTagName() {
        super.setTitle("Gallery");
    }

    @Override
    public void CloseApp() {

    }


}
