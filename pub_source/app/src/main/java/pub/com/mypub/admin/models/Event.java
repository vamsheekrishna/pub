package pub.com.mypub.admin.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Event implements Serializable {

    public int id=0;
    public String title =null;
    public String category_id=null;
    public String start_date=null;
    public String end_date=null;
    public String start_time =null;
    public String end_time=null;
    public String duration=null;
    public String location_id=null;
    public String language_id=null;
    public String description =null;
    public String note=null;
    public String tandc=null;
    public String start_price=null;
    public String contact_id=null;
    public String specialist_id=null;
    public String ticket_id=null;
    public String age_limit=null;
    boolean isSelected = false;
    public ArrayList<Specialist> mSpecialist = null;
    //public ArrayList<Ticket> mTicketlist = null;
    public ArrayList<Date> mDateList = null;
    public ArrayList<Event> mEvent = null;
    public ArrayList<Contact> mContact = null;
    public ArrayList<Ticket> mTickets;
    public ArrayList<Ticket> mSelectedTickets = new ArrayList<>();


    public Event () { }

    public Event (int _id, String _title, String _category_id, String _start_date, String _end_date, String _start_time,  String _end_time, String _duration, String _location_id,
                  String _language_id, String _description, String _note, String _tandc, String _start_price, String _contact_id, String _specialist_id,
                  String _ticket_id, String _age_limit,  boolean selected) {
        super();
        this.id = _id;
        this.title = _title;
        this.category_id = _category_id;
        this.start_date = _start_date;
        this.end_date = _end_date;
        this.start_time = _start_time;
        this.end_time = _end_time;
        this.duration = _duration;
        this.location_id = _location_id;
        this.language_id = _language_id;
        this.description = _description;
        this.note = _note;
        this.tandc = _tandc;
        this.start_price = _start_price;
        this.contact_id = _contact_id;
        this.specialist_id = _specialist_id;
        this.ticket_id = _ticket_id;
        this.age_limit = _age_limit;
        this.isSelected = selected;
    }

    public int getId() {
        return id;
    }
    public void setId() {
        this.id =id;
    }

    public String getTitle() {return title;}
    public  void setTitle(String _title) {this.title=_title;}

    public String getCategory_id() {return category_id;}
    public  void setCategory_id(String _category_id) {this.category_id=_category_id;}

    public String getStart_date() { return start_date; }
    public void setStart_date(String _start_date) { this.start_date = _start_date; }

    public String getEnd_date(){return end_date;}
    public void setEnd_date(String _end_date){this.end_date=_end_date;}

    public  String getStart_time(){return  start_time;}
    public  void setStart_time(String _start_time){this.start_time=_start_time;}

    public  String getEnd_time(){return  end_time;}
    public  void setEnd_time(String _end_time){this.end_time=_end_time;}

    public  String getDuration(){return  duration;}
    public  void setDuration(String _duration){this.duration=_duration;}

    public  String getLocation_id(){return  location_id;}
    public  void setLocation_id(String _location_id){this.location_id=_location_id;}

    public  String getLanguage_id(){return  language_id;}
    public  void setLanguage_id(String _language_id){this.language_id=_language_id;}

    public  String getDescription(){return  description;}
    public  void setDescription(String _description){this.description=_description;}

    public  String getNote(){return  note;}
    public  void setNote(String _note){this.note=_note;}

    public  String getTandc(){return  tandc;}
    public  void setTandc(String _tandc){this.tandc=_tandc;}

    public  String getStart_price(){return  start_price;}
    public  void setStart_price(String _start_price){this.start_price=_start_price;}

    public  String getContact_id(){return  contact_id;}
    public  void setContact_id(String _contact_id){this.contact_id=_contact_id;}

    public  String getSpecialist_id(){return  specialist_id;}
    public  void setSpecialist_id(String _specialist_id){this.specialist_id=_specialist_id;}

    public  String getTicket_id(){return  ticket_id;}
    public  void setTicket_id(String _ticket_id){this.ticket_id=_ticket_id;}

    public  String getAge_limit(){return  age_limit;}
    public  void setAge_limit(String _age_limit){this.age_limit=_age_limit;}



    public  ArrayList<Ticket> getmSelectedTickets(){
        return  mSelectedTickets;
    }
    public  void setmSelectedTickets(Ticket s){
        mSelectedTickets.add(s);
    }


    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }

}













