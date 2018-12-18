package pub.com.mypub.admin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.authentication.NetworkBaseFragment;
import pub.com.mypub.home.RecycleItemClickListener;


public class CategoryFragment extends NetworkBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, RecycleItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Spinner spinner;
    MyEvent mydata;
    EditText category1;
    Button create,select,New;
    ArrayList<Category> mCategoryList = new ArrayList<>();
    CheckBox ch1;
    RecyclerView recyclerView;
    LinearLayout btAddCategory, createCategory;
    CategoryCustomAdapter dataAdapter = null;
    Category category;
    private String mParam1;
    private String mParam2;
    ArrayList<Category> mSelectedCategory = new ArrayList<>();

    private OnAdminInteractionListener mListener;

    public CategoryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private  ArrayList<Category> getCategoryData() {

        stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"category.php/getAllRecords", "get_all_category");
        return mCategoryList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        getCategoryData();
        recyclerView= view.findViewById(R.id.listView1);
        New=view.findViewById(R.id.create);
        btAddCategory = view.findViewById(R.id.bt_add_category);
        createCategory = view.findViewById(R.id.create_category);
        category1 = view.findViewById(R.id.n1);
        create=view.findViewById(R.id.add);
        select=view.findViewById(R.id.submit);
        New.setOnClickListener(this);
        create.setOnClickListener(this);
        select.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setHasFixedSize(false);

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAdminInteractionListener) {
            mListener = (OnAdminInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAdminInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.create:
                createCategory.setVisibility(View.VISIBLE);
                btAddCategory.setVisibility(View.GONE);
                break;
            case R.id.add:
                String _name = category1.getText().toString();

                if (_name.matches("")) {
                    Toast.makeText(getActivity(), "Plase enter category name", Toast.LENGTH_SHORT).show();
                }
                else {
                    category = new Category();
                    category.name = _name;


                    HashMap<String, String> parems = new HashMap<>();
                    parems.put("name", category.name);


                    stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL + "category.php/createRecord", "create_category");
                }
                break;
            case R.id.submit:
                StringBuffer responseText = new StringBuffer();
                ArrayList<Category> mCategoryList = dataAdapter.mCategoryList;
                for ( Category category:mCategoryList ) {
                    if( category.isSelected() ){
                        mSelectedCategory.add(category);
                    }
                }

                mListener.setSelectedCategory(mSelectedCategory);
                getActivity().onBackPressed();
                break;
        }

    }



    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_category")) {
            btAddCategory.setVisibility(View.VISIBLE);
            createCategory.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();

            stringAPIRequest(null, Request.Method.POST, BuildConfig.BASE_URL+"category.php/getAllRecords", "get_all_category");
        }
        else if(REQUEST_ID.equals("delete_category")) {
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        if(REQUEST_ID.equals("delete_category")) {
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        List<Category> category = Arrays.asList(gson.fromJson(response.toString(), Category[].class));

        dataAdapter = new CategoryCustomAdapter( new ArrayList<>(category),this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(dataAdapter);
    }

    public void deleteCategory(int position) {
        Category category = dataAdapter.mCategoryList.get(position);
        HashMap<String, String> parm = new HashMap<>();
        parm.put("id", category.id+"");
        stringAPIRequest(parm, Request.Method.POST, BuildConfig.BASE_URL + "category.php/deleteRecord", "delete_category");
    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {

    }

    @Override
    public void setTagName() {

    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Category category = (Category) parent.getItemAtPosition(position);
        if(category.isSelected()) {
            category.setSelected(false);
        } else {
            category.setSelected(true);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(View v) {

    }

    @Override
    public void onItemClick(View v, View v1) {

    }
}
