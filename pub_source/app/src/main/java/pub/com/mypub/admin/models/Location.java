package pub.com.mypub.admin.models;

public class Location {
    public int id=0;
    public String city=null;
    public String country=null;
    public String state=null;
    public String landmark=null;
    public String latitude=null;
    public String langetude=null;
    boolean isSelected = false;

    public Location (int _id, String _city, String _country, String _state, String _landmark, String _latitude, String _langetude,  boolean selected) {
        this.id = _id;
        this.city = _city;
        this.country = _country;
        this.state = _state;
        this.landmark = _landmark;
        this.latitude = _latitude;
        this.langetude = _langetude;
    }


    public int getId() {
        return id;
    }
    public void setId() {
        this.id =id;
    }

    public String getCity() { return city; }
    public void setCity(String _city) { this.city = _city; }

    public String getcountry(){return country;}
    public void setCountry(String _country){this.country=_country;}

    public String getState() {return state;}
    public  void setState(String _state) {this.state=_state;}

    public  String getLandmark(){return  landmark;}
    public  void setLandmark(String _landmark){this.landmark=_landmark;}

    public String getLatitude() {return latitude;}
    public  void setLatitude(String _latitude) {this.latitude=_latitude;}

    public  String getLangetude(){return  langetude;}
    public  void setLangetude(String _langetude){this.langetude=_langetude;}



    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }

}