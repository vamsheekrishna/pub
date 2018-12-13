package pub.com.mypub.authentication;

import java.io.Serializable;

import pub.com.mypub.utilits.CurrentUser;

public class MyProfile implements Serializable {

    public String mPhoneNumber;
    public String mName;
    public String mEmail;
    public String mPassword;
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
