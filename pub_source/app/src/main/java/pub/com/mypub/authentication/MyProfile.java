package pub.com.mypub.authentication;

import java.io.Serializable;

import pub.com.mypub.R;
import pub.com.mypub.utilits.CurrentUser;

public class MyProfile implements Serializable {

    public String mPhoneNumber;
   public String mPassword;
    public String first_name;
    public String last_name;
    public String house_no;
    public String city;
    public String state;
    public String country;
    public String pin_code;
    public String mProfileID;
    public boolean isValidated = false;
    public boolean isAdmin = true;




   private static MyProfile mCurrentUser=null;

   public  static  synchronized  MyProfile getInstance()
   {
       if (mCurrentUser==null)
       {
           mCurrentUser= new MyProfile();
       }
       return  mCurrentUser;
   }



}
