package com.nsh.getintoclub.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.nsh.getintoclub.R;

import java.util.concurrent.TimeUnit;

public class OtpGenerator extends AppCompatActivity {
    CardView btnGenerateOTP, btnSignIn;
    String phoneNumber, otp;
    EditText etPhoneNumber, etOTP;
    FirebaseAuth auth;
    public static String phone = "";
    private String verificationCode;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_generator);
        SharedPreferences prefs = getSharedPreferences("number", Context.MODE_PRIVATE);
        String check = prefs.getString("mobile", "nullaaa");
        if (!check.equals("nullaaa")) {
            phone = check;
            startActivity(new Intent(OtpGenerator.this, DashActivity.class));
        }
        findViews();
        StartFirebaseLogin();
    }

    private void findViews() {
        btnGenerateOTP = findViewById(R.id.btn_generate_otp);
        btnSignIn = findViewById(R.id.btn_sign_in);

        etPhoneNumber = findViewById(R.id.et_phone_number);
        etOTP = findViewById(R.id.et_otp);
        setupdata();
    }

    public void setupdata() {
        phoneNumber = String.valueOf(etPhoneNumber.getText());
        btnGenerateOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = String.valueOf(etPhoneNumber.getText());
                if (phoneNumber.length() == 0) {
                    Toast.makeText(OtpGenerator.this, "Seems you have not enter phone number", Toast.LENGTH_SHORT).show();

                } else {
                    String final_number = phoneNumber.replaceAll("\\+91", "");
                    String final_number1 = final_number.replaceAll(" ", "");
                    String final_number2 = "+91 " + final_number1;
                    phoneNumber = final_number2;
                    phone = phoneNumber;

                    SharedPreferences sharedpreferences = getSharedPreferences("number", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("mobile", phoneNumber);
                    editor.commit();


                    //                    etOTP.setText(phone);
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phoneNumber,                     // Phone number to verify
                            60,                           // Timeout duration
                            TimeUnit.SECONDS,                // Unit of timeout
                            OtpGenerator.this,        // Activity (for callback binding)
                            mCallback);                      // OnVerificationStateChangedCallbacks
                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp = etOTP.getText().toString();
                if (otp.length() == 0) {
                    Toast.makeText(OtpGenerator.this, "Seems you have not enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
                    SigninWithPhone(credential);
                }
            }
        });
    }

    private void SigninWithPhone(PhoneAuthCredential credential) {

        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(OtpGenerator.this, DashActivity.class));
                            finish();
                        } else {
                            Toast.makeText(OtpGenerator.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void StartFirebaseLogin() {

        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(OtpGenerator.this, "verification completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(OtpGenerator.this, "verification failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                Toast.makeText(OtpGenerator.this, "Code sent", Toast.LENGTH_SHORT).show();
                btnSignIn.setVisibility(View.VISIBLE);
                btnGenerateOTP.setVisibility(View.GONE);
            }
        };
    }


}
