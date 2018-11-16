package pub.com.mypub.admin.models;

public class Language {
    public int id= Integer.parseInt(null);
    public String name=null;
    boolean selected = false;



    public Language (int _id, String _name, boolean selected) {

        super();
        this.id = id;
        this.name = name;
        this.selected = selected;
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


    public void setName(String name) {

        this.name = name;
    }


    public boolean isSelected() {

        return selected;
    }
    public void setSelected(boolean selected) {

        this.selected = selected;
    }
}
