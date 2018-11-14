package pub.com.mypub.admin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pub.com.mypub.R;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CategoryFragment extends NetworkBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Spinner spinner;
    MyEvent mydata;
    EditText category;
    Button create,select;
    Category mSelectedCategory = null;
    ArrayList<Category> mCategoryList = new ArrayList<>();
    private String mParam1;
    private String mParam2;

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

    private void getCategoryData() {
        //"Select Language","Comedy","Music","Dance","cinima","Gaming","cultural","Workshop","Food And Drink","Adventure"
        mCategoryList.add(new Category(-1, "Select Language"));
        mCategoryList.add(new Category(-1, "Comedy"));
        mCategoryList.add(new Category(-1, "Music"));
        mCategoryList.add(new Category(-1, "Dance"));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getCategoryData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        category = view.findViewById(R.id.n1);
        create=view.findViewById(R.id.add);
        select=view.findViewById(R.id.submit);

        create.setOnClickListener(this);
        select.setOnClickListener(this);


        String [] values = {"Select Language","Comedy","Music","Dance","cinima","Gaming","cultural","Workshop","Food And Drink","Adventure"};
        ArrayList<String> categoryNames = new ArrayList<>();
        for (Category category:mCategoryList) {
            categoryNames.add(category.name);
        }
        spinner= view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, categoryNames);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
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
        if(v.getId() == R.id.submit) {
            onSubmit();
        } else if(v.getId() == R.id.add) {

        }
        /*if (v == create) {
            mydata= new MyEvent();
            mydata._category = category.getText().toString();

//
        }
        else if (v== select){
            mydata= new MyEvent();
            mydata._category = spinner.getSelectedItem().toString();

        }*/

    }

    private void onSubmit() {
        mListener.setCategory(mSelectedCategory);
        getActivity().onBackPressed();
    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {
        //getCategoryData();
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

    }

    @Override
    public void CloseApp() {

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position != 0) {
            mSelectedCategory = mCategoryList.get(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
