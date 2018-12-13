package pub.com.mypub.admin.models;
import java.io.Serializable;
import java.util.ArrayList;


public class Booking  implements Serializable {

    public int id=0;
    public String user_id=null;
    public String event_id =null;
    public String book_date=null;
    public String ticket_total_amount=null;
    boolean isSelected = false;
    public Booking () {

    }

    public Booking (int _id, String _user_id, String _event_id, String _book_date, String _ticket_total_amount, boolean selected){
        super();
        this.id = _id;
        this.user_id = _user_id;
        this.event_id = _event_id;
        this.book_date = _book_date;
        this.ticket_total_amount = _ticket_total_amount;
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



    public  String getEvent_id(){return  event_id;}
    public  void setEvent_id(String _event_id){this.event_id=_event_id;}


    public String getBooking_date() {return book_date;}
    public  void setBooking_date(String _book_date) {this.book_date=_book_date;}


    public String getTotal_amount(){return ticket_total_amount;}
    public void setTotal_amount(String _ticket_total_amount){this.ticket_total_amount=_ticket_total_amount;}




    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }



}
