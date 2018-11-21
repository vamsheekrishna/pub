package pub.com.mypub.admin.models;

public class Ticket {
    public int id=0;
    public String name=null;
    public double price=0;
    public String title=null;
    public String description=null;
    boolean isSelected = false;



    public Ticket (int _id, String _name, double _price, String _title, String _description,  boolean selected) {
        super();
        this.id = _id;
        this.name = _name;
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

    public String getName() { return name; }
    public void setName(String _name) { this.name = _name; }

    public double getPrice(){return price;}
    public void setPrice(double _price){this.price=_price;}

    public String getTitle() {return title;}
    public  void setTitle(String _title) {this.title=_title;}

    public  String getDescription(){return  description;}
    public  void setDescription(String _description){this.description=_description;}


    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }

}













