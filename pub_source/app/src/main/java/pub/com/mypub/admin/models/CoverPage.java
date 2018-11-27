package pub.com.mypub.admin.models;

public class CoverPage {
    public int id=0;
    public String image=null;
    boolean isSelected = false;



    public CoverPage (int _id, String _image, boolean selected) {
        super();
        this.id = _id;
        this.image = _image;
    }

        public int getId() { return id; }
        public void setId() { this.id =id; }

        public String getImage() { return image; }
        public void setImage(String _image) { this.image = _image; }

        public boolean isSelected() { return isSelected; }
        public void setSelected(boolean selected) { this.isSelected = selected; }

}
