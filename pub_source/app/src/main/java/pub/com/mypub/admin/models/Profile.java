package pub.com.mypub.admin.models;

public class Profile {

    public int id=0;
    public String first_name=null;
    public String last_name =null;
    public String house_no =null;
    public String city =null;
    public String state =null;
    public String country =null;
    public String pin_code =null;
    boolean isSelected = false;


    public Profile () {

    }

    public Profile (int _id, String _first_name, String _last_name, String _house_no, String _city, String _state, String _country, String _pin_code, boolean selected) {
        super();
        this.id = _id;
        this.first_name=_first_name;
        this.last_name =_last_name;
        this.house_no =_house_no;
        this.city =_city;
        this.state =_state;
        this.country =_country;
        this.pin_code =_pin_code;
        this.isSelected= selected;
    }
}
