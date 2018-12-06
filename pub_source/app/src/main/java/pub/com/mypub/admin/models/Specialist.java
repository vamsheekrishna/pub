package pub.com.mypub.admin.models;

public class Specialist {
    public int id=0;
    public String name=null;
    public String dob=null;
    public String specialization=null;
    public String description=null;
    public String image=null;
    boolean isSelected = false;

    public Specialist () {

    }

    public Specialist (int _id, String _name, String _dob, String _specialization, String _description, String _image, boolean selected ){
        super();
        this.id = _id;
        this.name = _name;
        this.dob = _dob;
        this.specialization = _specialization;
        this.description = _description;
        this.image = _image;
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

    public String getDob() { return dob; }
    public void setDob(String _dob) { this.dob = _dob; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String _specialization) { this.specialization = _specialization; }

    public String getDescription() { return description; }
    public void setDescription(String _description) { this.description = _description; }

    public String getImage() { return image; }
    public void setImage(String _image) { this.image = _image; }


    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { this.isSelected = selected; }
}
