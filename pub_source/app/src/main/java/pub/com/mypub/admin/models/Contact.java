package pub.com.mypub.admin.models;

public class Contact {
    public int id=0;
    public String name=null;
    public String phoneNo1 =null;
    public String phoneNo2 =null;
    public String emailId =null;
    boolean isSelected = false;


    public Contact () {

    }

    public Contact (int _id, String _name, String _phone1, String _phone2, String _emailid, boolean selected) {
        super();
        this.id = _id;
       this.name=_name;
        this.phoneNo1 =_phone1;
        this.phoneNo2 =_phone2;
        this.emailId =_emailid;
        this.isSelected= selected;
    }
    public int getId() {
        return id;
    }
    public void setId() {
        this.id = id;
    }


    public String getName() { return name; }
    public void setName(String _name) { this.name = _name; }

    public String getPhoneNo1() { return phoneNo1; }
    public void setPhoneNo1(String _phone1) { this.phoneNo1 = _phone1; }

    public String getPhoneNo2() { return phoneNo2; }
    public void setPhoneNo2(String _phone2) { this.phoneNo1 = _phone2; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String _emailid) { this.emailId = _emailid; }

    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }
}
