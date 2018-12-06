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

import com.android.volley.Request;
import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;
import pub.com.mypub.admin.MyEvent;
import pub.com.mypub.admin.OnAdminInteractionListener;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Contact;
import pub.com.mypub.admin.models.Event;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Location;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.authentication.NetworkBaseFragment;


public class CreateEventFragment extends NetworkBaseFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button b_date, b_time, b_date1, b_time1, n2,button,tickt,n19,spec,contact,coverPage;
    EditText txtDate, txtTime,txtDate1, txtTime1,in;
    //Spinner spinner;
    private int mYear, mMonth, mDay, mHour, mMinute;
    MyEvent mydata;
    EditText title;
    TextView category,coverpage1,contact1,spec1,tick1,e1f;
    EditText startdate;
    EditText description;
    EditText startprice;
    EditText note;
    TextView txx,in_date1, age;
    Category mCategory;
    Contact mContact;
    Location mLocation;
    ArrayList<Language> mSelectedLanguage;
    ArrayList<Ticket> mSelectedTicket;
    ArrayList<Specialist> mSelectedSpecialist;
    ArrayList<Location> mSelectedLocation;
    ArrayList<Contact> mSelectedContact;
    ArrayList<Category> mSelectedCategory;
    Event event;
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
        b_date1 = view.findViewById(R.id.btn_date1);
        b_time1 = view.findViewById(R.id.btn_time1);
        tickt = view.findViewById(R.id.tickt);
        n19 = view.findViewById(R.id.n19);
        spec=view.findViewById(R.id.spec);
        spec1=view.findViewById(R.id.spec1);
        contact = view.findViewById(R.id.contact);
        contact1 = view.findViewById(R.id.contact1);
        button = view.findViewById(R.id.button);
        in_date1 = view.findViewById(R.id.in_date1);
        category = view.findViewById(R.id.category);
        n2=view.findViewById(R.id.n2);
        coverPage = view.findViewById(R.id.coverPage);
        coverpage1 = view.findViewById(R.id.coverPage1);
        tick1=view.findViewById(R.id.tick1);
        spec =view.findViewById(R.id.spec);
        title=view.findViewById(R.id.e1);
        startdate=view.findViewById(R.id.in_date);
        description=view.findViewById(R.id.e11);
        startprice=view.findViewById(R.id.e1h);
        note=view.findViewById(R.id.e112);
        txx=view.findViewById(R.id.tx);
        e1f=view.findViewById(R.id.e1f);
        age=view.findViewById(R.id.e1k);


        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.n2).setOnClickListener(this);
        b_date.setOnClickListener(this);
        b_time.setOnClickListener(this);
        b_date1.setOnClickListener(this);
        b_time1.setOnClickListener(this);
        button.setOnClickListener(this);
        tickt.setOnClickListener(this);
        n19.setOnClickListener(this);
        spec.setOnClickListener(this);
        contact.setOnClickListener(this);
        coverPage.setOnClickListener(this);
        n2.setOnClickListener(this);

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
        if (null != mSelectedCategory) {
            String temp = "";
            for (Category category:mSelectedCategory ) {
                temp += category.name + "  ";
            }

            if(temp.length()>0) {
                category.setText(temp);
            }
        }
        if (null != mSelectedLanguage) {
            String temp = "";
            for (Language language:mSelectedLanguage ) {
                temp += language.name + "  ";
            }

            if(temp.length()>0) {
                n2.setText(temp);
            }
        }
        if (null != mSelectedContact) {
            String str6 = "";
            for (Contact contact:mSelectedContact ) {
                str6 += contact.name + "  " + contact.phoneNo1+" "+contact.phoneNo2+" "+contact.emailId+" ";
            }
            if(str6.length()>0) {
                contact1.setText(str6);
            }}

        if (null != mSelectedLocation) {
            String str2 = "";
            for (Location location:mSelectedLocation ) {
                str2 += location.city + "  ";
            }
            if(str2.length()>0) {
                e1f.setText(str2);
            }}
//            //Toast.makeText(getActivity(), "location: " + mLocation.city+mLocation.country+mLocation.state+mLocation.landmark+mLocation.latitude+mLocation.langetude, Toast.LENGTH_LONG).show();
//            location.setText(mLocation.city+" "+mLocation.country+" "+mLocation.state+" "+mLocation.landmark+" "+mLocation.latitude+" "+mLocation.langetude);

        if (null != mSelectedTicket) {
            String str = "";
            for (Ticket ticket:mSelectedTicket ) {
                str += ticket.ticket_name + " ,   "+ticket.title+" ";
            }

            if(str.length()>0) {
                tick1.setText(str);
            }
        }
        if (null != mSelectedSpecialist) {
            String str1 = "";
            for (Specialist specialist:mSelectedSpecialist ) {
                str1 += specialist.name + "  ";
            }

            if(str1.length()>0) {
                spec1.setText(str1);
            }
        }
    }

    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_event")) {
            Toast.makeText(getActivity(), "JSONObject Sucsesfully", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {
        if(REQUEST_ID.equals("create_event")) {
            Toast.makeText(getActivity(), "JSONArray Sucsesfully", Toast.LENGTH_LONG).show();
        }
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

                            b_time1.setText(hourOfDay + ":" + minute );
                            setDuration();
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        switch (v.getId()) {
            case R.id.submit:

                String _title = title.getText().toString();
                String _category_id = category.getText().toString();
                String _start_date = b_date.getText().toString();
                String _end_date = b_date1.getText().toString();
                String _start_time = b_time.getText().toString();
                String _end_time = b_time1.getText().toString();
                String _duration = in_date1.getText().toString();
                String _location_id = e1f.getText().toString();
                String _language_id = n2.getText().toString();
                String _description = description.getText().toString();
                String _note = note.getText().toString();
                String _start_price = startprice.getText().toString();
                String _contact_id = contact1.getText().toString();
                String _specialist_id = spec1.getText().toString();
                String _ticket_id = tick1.getText().toString();
                String _age_limit = age.getText().toString();


                event = new Event();
                event.title =_title;
                event.category_id=_category_id;
                event.start_date=_start_date;
                event.end_date=_end_date;
                event.start_time=_start_time;
                event.end_time =_end_time;
                event.duration =_duration;
                event.location_id=_location_id;
                event.language_id=_language_id;
                event.description=_description;
                event.note=_note;
                event.start_price=_start_price;
                event.contact_id =_contact_id;
                event.specialist_id=_specialist_id;
                event.ticket_id=_ticket_id;
                event.age_limit=_age_limit;


                HashMap<String, String> parems = new HashMap<>();
                parems.put("title", event.title);
                parems.put("category_id", event.category_id);
                parems.put("start_date",event.start_date);
                parems.put("end_date", event.end_date);
                parems.put("start_time", event.start_time);
                parems.put("end_time", event.end_time);
                parems.put("duration", event.duration);
                parems.put("location_id", event.location_id);
                parems.put("language_id",event.language_id);
                parems.put("description", event.description);
                parems.put("note", event.note);
                parems.put("start_price",event.start_price);
                parems.put("contact_id", event.contact_id);
                parems.put("specialist_id", event.specialist_id);
                parems.put("ticket_id", event.ticket_id);
                parems.put("age_limit", event.age_limit);

                stringAPIRequest(parems, Request.Method.POST, BuildConfig.BASE_URL+"events.php/createRecord", "create_event");
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
            case R.id.coverPage:
                mListener.goToCoverPageFragment();
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
                in_date1.setText(diffHours + " hours, ");
            }
            catch (Exception e)
            {
                Log.e("Exception","Exception "+e.getMessage());
            }
        }

    }


    public void setCategory(ArrayList<Category> _category) {
        mSelectedCategory = _category;
    }
    public void setContact(ArrayList<Contact> _contact) {
        mSelectedContact = _contact;

    }
    public void setLocation(ArrayList<Location> _location) {
        mSelectedLocation = _location;

    }
    public void setSpecialist(ArrayList<Specialist> _specialist) {
        mSelectedSpecialist = _specialist;

    }
    public void setLanguage(ArrayList<Language> _language) {
        mSelectedLanguage = _language;

    }
    public void setTicket(ArrayList<Ticket> _ticket) {
        mSelectedTicket = _ticket;

    }
}
