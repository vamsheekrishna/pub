package pub.com.mypub.admin.models;

import java.util.ArrayList;

public class Language {
    public int id= 0;
    public String name=null;
    boolean selected = false;
    public ArrayList<String> langList;



    public Language (int _id, String _name, boolean selected) {

        super();
        this.id = _id;
        this.name = _name;
        this.selected = selected;
    }

    public void setLangList(ArrayList<String> langList) {
        this.langList = langList;
    }

    public ArrayList<String> getLangList() {
        return langList;
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

        return selected;
    }
    public void setSelected(boolean selected) {

        this.selected = selected;
    }
}
