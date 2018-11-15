package pub.com.mypub.admin.models;

public class Specialist {
    public int id;
    public String name;
    public String dob;
    public String specialization;
    public String description;
    public String image;



    public Specialist (int _id, String _name, String _dob, String _specialization, String _description, String _image) {
        id = _id;
        name = _name;
        dob = _dob;
        specialization = _specialization;
        description = _description;
        image = _image;

    }
}
