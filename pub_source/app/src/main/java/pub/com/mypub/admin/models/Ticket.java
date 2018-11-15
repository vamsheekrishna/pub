package pub.com.mypub.admin.models;

public class Ticket {
    public int id;
    public String name;
    public String price;
    public String title;
    public String description;



    public Ticket (int _id, String _name, String _price, String _title, String _description) {
        id = _id;
        name = _name;
        price = _price;
        title = _title;
        description = _description;

    }
}
