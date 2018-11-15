package pub.com.mypub.admin.models;

public class Language {
    public int id;
    public String name;
    boolean selected = false;



    public Language (int _id, String _name, boolean selected) {

        super();
        this.id = id;
        this.name = name;
        this.selected = selected;
    }

    public int getid() {
        return id;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }


    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}