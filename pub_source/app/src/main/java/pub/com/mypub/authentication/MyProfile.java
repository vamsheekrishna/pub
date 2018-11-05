package pub.com.mypub.authentication;

import java.io.Serializable;

class MyProfile implements Serializable {

    public String mPhoneNumber;
    public String mName;
    public String mEmail;
    public String mPassword;
    public String mProfileID;
    public boolean isValidated = false;
}
