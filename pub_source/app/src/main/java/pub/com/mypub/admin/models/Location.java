package pub.com.mypub.admin.models;

public class Location {
    public int id;
    public String city;
    public String country;
    public String state;
    public String landmark;
    public String latitude;
    public String langetude;


    public Location (int _id, String _city, String _country, String _state, String _landmark, String _latitude, String _langetude) {
        id = _id;
        city = _city;
        country = _country;
        state = _state;
        landmark = _landmark;
        latitude = _latitude;
        langetude = _langetude;
    }
}
