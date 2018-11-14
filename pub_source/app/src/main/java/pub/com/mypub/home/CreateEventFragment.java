package pub.com.mypub.home;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pub.com.mypub.R;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateEventFragment extends NetworkBaseFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button b_date, b_time, b_date1, b_time1, n2,button,tickt,n19,spec,contact;
    EditText txtDate, txtTime,txtDate1, txtTime1,tick1,e1f,spec1,contact1,in;
    //Spinner spinner;
    private int mYear, mMonth, mDay, mHour, mMinute;
    MyEvent mydata;
    String format = "";
    EditText title;
    TextView category;
    EditText startdate;
    EditText enddate;
    EditText starttime;
    EditText endtime;
    EditText description;
    EditText coverpage;
    EditText startprice;
    EditText note;
    TextView txx,in_date1;
    Category mCategory;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAdminInteractionListener mListener;

    public CreateEventFragment() {
        // Required empty public constructor
    }

    public static CreateEventFragment newInstance(String param1, String param2) {
        CreateEventFragment fragment = new CreateEventFragment();
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
        View view = inflater.inflate(R.layout.fragment_create_event, container, false);



        b_date = view.findViewById(R.id.btn_date);
        b_time = view.findViewById(R.id.btn_time);
//        txtDate = view.findViewById(R.id.in_date);
        //txtTime = view.findViewById(R.id.in_time);

        b_date.setOnClickListener(this);
        b_time.setOnClickListener(this);


        b_date1 = view.findViewById(R.id.btn_date1);
        b_time1 = view.findViewById(R.id.btn_time1);
        tickt = view.findViewById(R.id.tickt);
        n19 = view.findViewById(R.id.n19);
        spec=view.findViewById(R.id.spec);
        contact = view.findViewById(R.id.contact);
        button = view.findViewById(R.id.button);
        in_date1 = view.findViewById(R.id.in_date1);
       category = view.findViewById(R.id.category);
       // txtTime1 = view.findViewById(R.id.in_time1);

        b_date1.setOnClickListener(this);
        b_time1.setOnClickListener(this);
       button.setOnClickListener(this);
        tickt.setOnClickListener(this);
        n19.setOnClickListener(this);
        spec.setOnClickListener(this);
        contact.setOnClickListener(this);



//        String [] values =
//                {"Select Language","Comedy","Music","Dance","cinima","Gaming","cultural","Workshop","Food And Drink","Adventure"};
//        spinner= view.findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinner.setAdapter(adapter);



        title=view.findViewById(R.id.e1);
        //category=view.findViewById(R.id.e2);
        startdate=view.findViewById(R.id.in_date);

        //starttime=view.findViewById(R.id.in_time);
       // endtime=view.findViewById(R.id.in_time1);

        description=view.findViewById(R.id.e11);
        coverpage=view.findViewById(R.id.e1f);
        startprice=view.findViewById(R.id.e1h);
        note=view.findViewById(R.id.e112);
        txx=view.findViewById(R.id.tx);

        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.n2).setOnClickListener(this);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAdminInteractionListener) {
            mListener = (OnAdminInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must OnAdminInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(null != mCategory) {
            Toast.makeText(getActivity(), "Category: " + mCategory.name, Toast.LENGTH_LONG).show();
            category.setText(mCategory.name);
        }

    }

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
        super.setTitle("Creat Events");
    }

    @Override
    public void CloseApp() {

    }

    @Override
    public void onClick(View v) {
        if (v == b_date) {


            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            b_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == b_time) {


            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
//
                            b_time.setText(hourOfDay + ":" + minute );
                            setDuration();
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();


        }

        if (v == b_date1) {


            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            b_date1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == b_time1) {


            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
//
                            b_time1.setText(hourOfDay + ":" + minute );
                            setDuration();
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }

        switch (v.getId()) {
            case R.id.submit:
                n2.setText(mydata._language);
                category.setText(mydata._categorySelect);
                tick1.setText(mydata._selectTicket);
                e1f.setText(mydata._selectLocation);
                spec1.setText(mydata._specialist);
                contact1.setText(mydata._contact);

//                String _title = title.getText().toString();
//                String _category =category.getText().toString();
//                String _sdate = startdate.getText().toString();
//                String _edate =enddate.getText().toString();
//                String _stime = starttime.getText().toString();
//                String _etime =endtime.getText().toString();
//              //  String _language =spinner.getSelectedItem().toString();
//                String _des = description.getText().toString();
//                String _coverpage =coverpage.getText().toString();
//                String _sprice = startprice.getText().toString();
//                String _note =note.getText().toString();


//                if(_sdate.equals( _edate)) {
//
//
//                    txx.setText("Title:\t" + _title + "\ncategory:\t" + _category + "\nsart date:\t" + _sdate + "\nend date:\t" + _edate + "\nstart time:\t" + _stime + "\nend time:\t" + _etime + "\nlanguage:\t" + _language + "\ndescrwption:\t" + _des + "\ncoverpage:\t" + _coverpage + "\nstart price:\t" + _sprice + "\nnote:\t" + _note);
//                }
//                else
//                {
//                    Toast.makeText(getActivity(), "Start date and End date must be same", Toast.LENGTH_LONG).show();
//                }

                break;
            case R.id.n2:
                mListener.goToLanguageFragment();
                break;

            case R.id.button:
                mListener.goToCategoryFragment();
                break;

            case R.id.tickt:
                mListener.goToTickitFragment();
                break;


            case R.id.n19:
                mListener.goToLocationFragment();
                break;

            case R.id.spec:
                mListener.goToSpecialistFragment();
                break;

            case R.id.contact:
                mListener.goToContactFragment();
                break;
        }
    }

    private void setDuration() {
        String dateStart = b_time.getText().toString();
        String dateStop =b_time1.getText().toString();
        if(!dateStart.equals(getString(R.string.start_time)) && !dateStop.equals(getString(R.string.end_time))) {

            SimpleDateFormat format = new SimpleDateFormat("HH:mm");

            Date d1 = Calendar.getInstance().getTime();
            Date d2 = Calendar.getInstance().getTime();
            try
            {
                d1 = format.parse(dateStart);
                d2 = format.parse(dateStop);


                long diff = d2.getTime() - d1.getTime();
                long diffHours = diff / (60 * 60 * 1000) % 24;
                Log.e("test",diffHours + " hours, ");
                in_date1.setText("Event's Duration:"+diffHours + " hours, ");
            }
            catch (Exception e)
            {
                Log.e("Exception","Exception "+e.getMessage());
            }
        }

    }


    public void setCategory(Category _category) {
        mCategory = _category;
        //category.setText(mCategory.name);
    }
}
