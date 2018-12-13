package pub.com.mypub.admin.models;

public class Ticket {
    public int id=0;
    public String ticket_name =null;
    public String price=null;
    public String title=null;
    public String description=null;
    boolean isSelected = false;
    public int mTicketCount =0;
    public int mTicketTotal =0;



    public Ticket () {

    }
    public Ticket (int _id, String _name, String _price, String _title, String _description,  boolean selected) {
        super();
        this.id = _id;
        this.ticket_name = _name;
        this.price = _price;
        this.title = _title;
        this.description = _description;
        this.isSelected = selected;
    }

    public int getId() {
        return id;
    }
    public void setId() {
        this.id =id;
    }

    public String getTicket_name() { return ticket_name; }
    public void setTicket_name(String _name) { this.ticket_name = _name; }

    public String getPrice(){return price;}
    public void setPrice(String _price){this.price=_price;}

    public String getTitle() {return title;}
    public  void setTitle(String _title) {this.title=_title;}

    public  String getDescription(){return  description;}
    public  void setDescription(String _description){this.description=_description;}


    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }


    public Float getTotalAmount() {
        return Float.parseFloat(price) * mTicketCount;
    }

}













