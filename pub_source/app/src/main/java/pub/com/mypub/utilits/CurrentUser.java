package pub.com.mypub.utilits;

public class CurrentUser {

    private static CurrentUser mInstance= null;

    public int UserId;
    public String mName;
    public String mPhoneNumber;

    private CurrentUser(){

    }

    public static synchronized CurrentUser getInstance() {
        if(null == mInstance){
            mInstance = new CurrentUser();
        }
        return mInstance;
    }
}
