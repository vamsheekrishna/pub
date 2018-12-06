package pub.com.mypub.admin.models;
import java.io.Serializable;
import java.util.ArrayList;


public class Booking  implements Serializable {

    public int id=0;
    public String user_id=null;
    public String booking_date =null;
    public String event_ticket_ids=null;
    public String total_amount=null;
    public String paid_amount =null;
    public String type=null;
    public String events_id=null;
    public String event_date=null;
    boolean isSelected = false;
    public Booking () {

    }

    public Booking (int _id, String _user_id, String _booking_date, String _event_ticket_ids, String _total_amount, String _paid_amount,  String _type, String _events_id, String _event_date, boolean selected){
        super();
        this.id = _id;
        this.user_id = _user_id;
        this.booking_date = _booking_date;
        this.event_ticket_ids = _event_ticket_ids;
        this.total_amount = _total_amount;
        this.paid_amount = _paid_amount;
        this.type = _type;
        this.events_id = _events_id;
        this.event_date = _event_date;
        this.isSelected = selected;
    }


    public int getId() {
        return id;
    }
    public void setId() {
        this.id =id;
    }

    public String getUser_id() {return user_id;}
    public  void setUser_id(String _user_id) {this.user_id=_user_id;}

    public String getBooking_date() {return booking_date;}
    public  void setBooking_date(String _booking_date) {this.booking_date=_booking_date;}

    public String getEvent_ticket_ids() { return event_ticket_ids; }
    public void setEvent_ticket_ids(String _event_ticket_ids) { this.event_ticket_ids = _event_ticket_ids; }

    public String getTotal_amount(){return total_amount;}
    public void setTotal_amount(String _total_amount){this.total_amount=_total_amount;}

    public  String getPaid_amount(){return  paid_amount;}
    public  void setPaid_amount(String _paid_amount){this.paid_amount=_paid_amount;}

    public  String getType(){return  type;}
    public  void setType(String _type){this.type=_type;}

    public  String getEvents_id(){return  events_id;}
    public  void setEvents_id(String _events_id){this.events_id=_events_id;}

    public  String getEvent_date(){return  event_date;}
    public  void setEvent_date(String _event_date){this.event_date=_event_date;}

    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }



}
