package pub.com.mypub.admin.models;

public class Language {
    public int id= 0;
    public String name=null;
    boolean isSelected = false;



    public Language (int _id, String _name, boolean selected) {

        super();
        this.id = _id;
        this.name = _name;
        this.isSelected = selected;
    }



    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }


    public String getName() {

        return name;
    }


    public void setName(String _name) {

        this.name = _name;
    }


    public boolean isSelected() {

        return isSelected;
    }
    public void setSelected(boolean selected) {

        this.isSelected = selected;
    }
}
