package pub.com.mypub.authentication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import pub.com.mypub.BuildConfig;
import pub.com.mypub.R;

public class ValidateOTPFragment extends NetworkBaseFragment implements View.OnClickListener{


    private static final String TAG = "ValidateOTPFragment";
    private static final String MY_PROFILE = "phone_number";
    private static final String ARG_PARAM2 = "param2";

    private static final String KEY_VERIFY_IN_PROGRESS = "key_verify_in_progress";

    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_CODE_SENT = 2;
    private static final int STATE_VERIFY_FAILED = 3;
    private static final int STATE_VERIFY_SUCCESS = 4;
    private static final int STATE_SIGNIN_FAILED = 5;
    private static final int STATE_SIGNIN_SUCCESS = 6;

    //private String mPhoneNumber = "";
    private String mParam2;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    private boolean mVerificationInProgress = false;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    //private ViewGroup mPhoneNumberViews;
    //private ViewGroup mSignedInViews;

    //private TextView mStatusText;
    private TextView mDetailText;

    //private EditText mPhoneNumberField;
    private EditText mVerificationField;

    //private Button mStartButton;
    private Button mVerifyButton;
    private Button mResendButton;
    //private Button mSignOutButton;

    ProgressBar progressBar;

    private OnAuthenticationInteractionListener mListener;
    private MyProfile myProfile = new MyProfile();
    private boolean isRegistration = true;


    public ValidateOTPFragment() {
        // Required empty public constructor
    }

    public static ValidateOTPFragment newInstance(MyProfile param1, boolean param2) {
        ValidateOTPFragment fragment = new ValidateOTPFragment();
        Bundle args = new Bundle();
        args.putSerializable(MY_PROFILE, param1);
        args.putBoolean(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myProfile = (MyProfile) getArguments().getSerializable(MY_PROFILE);
            //mPhoneNumber = getArguments().getString(MY_PROFILE);
            isRegistration = getArguments().getBoolean(ARG_PARAM2);
        }
    }
    @Override
    public void onSuccessResponse(JSONObject response, String REQUEST_ID) {

    }

    @Override
    public void onSuccessResponse(JSONArray response, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(VolleyError response, String exception, String REQUEST_ID) {

    }

    @Override
    public void onFailureResponse(String response, String exception, String REQUEST_ID) {

    }

    @Override
    public void setTagName() {

    }

    @Override
    public void CloseApp() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_verify_phone:
                if (BuildConfig.IS_DEBUG) {
                    mListener.goToMyProfilePage(myProfile);
                } else {
                    String code = mVerificationField.getText().toString();
                    if (TextUtils.isEmpty(code)) {
                        mVerificationField.setError("Cannot be empty.");
                        return;
                    }

                    verifyPhoneNumberWithCode(mVerificationId, code);
                }
                break;
            case R.id.button_resend:
                resendVerificationCode(myProfile.mPhoneNumber, mResendToken);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_validate_otp, null);

        setView(view);
        return view;
    }


    private void setView(final View body) {
        progressBar = body.findViewById(R.id.progressBar);

        // Assign views
        //mPhoneNumberViews = (ViewGroup) body.findViewById(R.id.phone_auth_fields);
        //mSignedInViews = (ViewGroup) body.findViewById(R.id.signed_in_buttons);

        //mStatusText = body.findViewById(R.id.status);
        mDetailText = body.findViewById(R.id.detail);

        //mPhoneNumberField = (EditText) body.findViewById(R.id.field_phone_number);
        mVerificationField = body.findViewById(R.id.field_verification_code);

        //mStartButton = (Button) body.findViewById(R.id.button_start_verification);
        mVerifyButton = body.findViewById(R.id.button_verify_phone);
        mResendButton = body.findViewById(R.id.button_resend);
        //mSignOutButton = (Button) body.findViewById(R.id.sign_out_button);

        // Assign click listeners
        mVerifyButton.setOnClickListener(this);
        mResendButton.setOnClickListener(this);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        // Initialize phone auth callbacks
        // [START phone_auth_callbacks]
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verificaiton without
                //     user action.
                Log.d(TAG, "onVerificationCompleted:" + credential);
                // [START_EXCLUDE silent]
                mVerificationInProgress = false;
                // [END_EXCLUDE]

                // [START_EXCLUDE silent]
                // Update the UI and attempt sign in with the phone credential
                updateUI(STATE_VERIFY_SUCCESS, credential);
                // [END_EXCLUDE]
                signInWithPhoneAuthCredential(credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e);
                // [START_EXCLUDE silent]
                mVerificationInProgress = false;
                // [END_EXCLUDE]

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // [START_EXCLUDE]
                    mVerificationField.setError("Invalid phone number.");
                    // [END_EXCLUDE]
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    // [START_EXCLUDE]
                    Toast.makeText(getActivity(),"Quota exceeded.", Toast.LENGTH_SHORT).show();
                    /*Snackbar.make(body.findViewById(android.R.id.content), "Quota exceeded.",
                            Snackbar.LENGTH_SHORT).show();*/
                    // [END_EXCLUDE]
                }

                // Show a message and update the UI
                // [START_EXCLUDE]
                updateUI(STATE_VERIFY_FAILED);
                // [END_EXCLUDE]
            }

            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:" + verificationId);

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;

                // [START_EXCLUDE]
                // Update UI
                updateUI(STATE_CODE_SENT);
                // [END_EXCLUDE]
            }
        };
        // [END phone_auth_callbacks]
    }

    private void startPhoneNumberVerification(String phoneNumber) {
        // [START start_phone_auth]
        phoneNumber = "+91"+phoneNumber;
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                getActivity(),               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
        // [END start_phone_auth]

        mVerificationInProgress = true;
        //mStatusText.setVisibility(View.INVISIBLE);
    }

    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        // [START verify_with_code]
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        // [END verify_with_code]
        signInWithPhoneAuthCredential(credential);
    }

    // [START resend_verification]
    private void resendVerificationCode(String phoneNumber, PhoneAuthProvider.ForceResendingToken token) {
        phoneNumber = "+91"+phoneNumber;
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                getActivity(),               // Activity (for callback binding)
                mCallbacks,         // OnVerificationStateChangedCallbacks
                token);             // ForceResendingToken from callbacks
    }
    // [END resend_verification]

    // [START sign_in_with_phone]
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            // [START_EXCLUDE]
                            updateUI(STATE_SIGNIN_SUCCESS, user);
                            // [END_EXCLUDE]
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                // [START_EXCLUDE silent]
                                mVerificationField.setError("Invalid code.");
                                // [END_EXCLUDE]
                            }
                            // [START_EXCLUDE silent]
                            // Update UI
                            updateUI(STATE_SIGNIN_FAILED);
                            // [END_EXCLUDE]
                        }
                    }
                });
    }
    // [END sign_in_with_phone]

    private void signOut() {
        mAuth.signOut();
        updateUI(STATE_INITIALIZED);
    }

    private void updateUI(int uiState) {
        updateUI(uiState, mAuth.getCurrentUser(), null);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            updateUI(STATE_SIGNIN_SUCCESS, user);
        } else {
            updateUI(STATE_INITIALIZED);
        }
    }

    private void updateUI(int uiState, FirebaseUser user) {
        updateUI(uiState, user, null);
    }

    private void updateUI(int uiState, PhoneAuthCredential cred) {
        updateUI(uiState, null, cred);
    }

    private void updateUI(int uiState, FirebaseUser user, PhoneAuthCredential cred) {
        switch (uiState) {
            case STATE_INITIALIZED:
                // Initialized state, show only the phone number field and start button
                //enableViews(mStartButton, mPhoneNumber);
                disableViews(mVerifyButton, mResendButton, mVerificationField);
                mDetailText.setText(null);
                break;
            case STATE_CODE_SENT:
                progressBar.setVisibility(View.INVISIBLE);
                // Code sent state, show the verification field, the
                enableViews(mVerifyButton, mResendButton, /*mPhoneNumberField,*/ mVerificationField);
                //disableViews(mStartButton);
                mDetailText.setText(R.string.status_code_sent);
                mDetailText.setTextColor(Color.parseColor("#43a047"));
                break;
            case STATE_VERIFY_FAILED:
                // Verification has failed, show all options
                enableViews(/*mStartButton,*/ mVerifyButton, mResendButton, /*mPhoneNumberField, */mVerificationField);
                mDetailText.setText(R.string.status_verification_failed);
                mDetailText.setTextColor(Color.parseColor("#dd2c00"));
                progressBar.setVisibility(View.INVISIBLE);
                break;
            case STATE_VERIFY_SUCCESS:
                // Verification has succeeded, proceed to firebase sign in
                disableViews(/*mStartButton,*/ mVerifyButton, mResendButton, /*mPhoneNumberField, */mVerificationField);
                mDetailText.setText("Verfication Sucessfull");
                mDetailText.setTextColor(Color.parseColor("#43a047"));
                progressBar.setVisibility(View.INVISIBLE);

                // Set the verification text based on the credential
                if (cred != null) {
                    if (cred.getSmsCode() != null) {
                        mVerificationField.setText(cred.getSmsCode());
                    } else {
                        mVerificationField.setText(R.string.instant_validation);
                        mVerificationField.setTextColor(Color.parseColor("#4bacb8"));
                    }
                }

                break;
            case STATE_SIGNIN_FAILED:
                // No-op, handled by sign-in check
                mDetailText.setText(R.string.status_sign_in_failed);
                mDetailText.setTextColor(Color.parseColor("#dd2c00"));
                progressBar.setVisibility(View.INVISIBLE);
                break;
            case STATE_SIGNIN_SUCCESS:
                // Np-op, handled by sign-in check
                //mStatusText.setText(R.string.signed_in);
                break;
        }

        if (user == null) {
            // Signed out
            mVerificationField.setVisibility(View.VISIBLE);
            //mSignedInViews.setVisibility(View.GONE);

            //mStatusText.setText(R.string.signed_out);;
        } else {
            // Signed in
            mVerificationField.setVisibility(View.GONE);
            /*
                mSignedInViews.setVisibility(View.VISIBLE);

                enableViews(mPhoneNumberField, mVerificationField);
                mPhoneNumberField.setText(null);
                mVerificationField.setText(null);

                mStatusText.setText(R.string.signed_in);
                mDetailText.setText(getString(R.string.firebase_status_fmt, user.getUid()));
             */
            /*
                Intent intent = new Intent(this, Hallfinder.class);
                startActivity(intent);
                finish();
            */
            signOut();

            if(isRegistration) {
                mListener.goToRegistrationPage();
            } else {
                boolean isForgotPassword  = true;
                mListener.goToChangePasswordPage(myProfile, isForgotPassword);
            }
        }
    }

    private boolean validatePhoneNumber() {
        //String phoneNumber = mPhoneNumberField.getText().toString();
        if (TextUtils.isEmpty(myProfile.mPhoneNumber)) {
            mVerificationField.setError("Invalid phone number.");
            //mPhoneNumberField.setTextColor(Color.parseColor("#ff1744"));
            return false;
        }

        return true;
    }

    private void enableViews(View... views) {
        for (View v : views) {
            v.setEnabled(true);
        }
    }

    private void disableViews(View... views) {
        for (View v : views) {
            try {
                v.setEnabled(false);
            } catch (Exception e) {

            }
        }
    }



    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

        if (mVerificationInProgress && validatePhoneNumber()) {
            startPhoneNumberVerification(myProfile.mPhoneNumber);
        }
        startVerification();

    }

    private void startVerification() {
        if (!validatePhoneNumber()) {
            return;
        }

        try {

            ///////hide keyboard start
            InputMethodManager inputManager = (InputMethodManager)
                    getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

            inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            /////////hide keyboard end
        } catch (Exception e) {
            e.printStackTrace();
        }


        //mStatusText.setText("Authenticating....!");
        progressBar.setVisibility(View.VISIBLE);
        startPhoneNumberVerification(myProfile.mPhoneNumber);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_VERIFY_IN_PROGRESS, mVerificationInProgress);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAuthenticationInteractionListener) {
            mListener = (OnAuthenticationInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAuthenticationInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
