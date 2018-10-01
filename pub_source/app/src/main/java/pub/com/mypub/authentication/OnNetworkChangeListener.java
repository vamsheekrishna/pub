package pub.com.mypub.authentication;

interface OnNetworkChangeListener {
    boolean isShowCancelButton = false;

    void onNetworkConnected();
    void onNetworkChanging();
    void onNetworkDisConnected();
    void checkNetworkConnection();
    boolean isNetworkAvailable();
}
