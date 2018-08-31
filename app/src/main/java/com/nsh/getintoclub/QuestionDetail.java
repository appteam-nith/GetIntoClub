package com.nsh.getintoclub;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionDetail extends AppCompatActivity {
    public static String q1, q2, q3, q4;
    EditText ques1, ques2, ques3, ques4;
    TextView doneQuestion;
    View backView;
    int rollLength;
    public static String q1, q2, q3, q4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initUI();
    }

    public void initUI() {
        ques1 = findViewById(R.id.q1);
        ques2 = findViewById(R.id.q2);
        ques3 = findViewById(R.id.q3);
        ques4 = findViewById(R.id.q4);
        backView = findViewById(R.id.backView);
        setupdata();
    }

    public void setupdata() {
        q1 = String.valueOf(ques1.getText());
        q2 = String.valueOf(ques2.getText());
        q3 = String.valueOf(ques3.getText());
        q4 = String.valueOf(ques4.getText());
        doneQuestion = findViewById(R.id.donequestion);
    }

    public void onClick(View view) {
        rollLength = q1.length();
        if (rollLength == 0) {
            Toast.makeText(this, "Seems to be incomplete", Toast.LENGTH_SHORT).show();
        } else
            {
//        FirebaseDatabase.getInstance().getReference().child("RegistrationModel").child(userId)
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        Map<String, String> stringStringHashMap =(Map<String, String>) dataSnapshot.getValue();
//
//                        stringStringHashMap.put("refresh_token",refreshedToken);
//
//                        FirebaseDatabase.getInstance().getReference().child("RegistrationModel").child(userId)
//                                .setValue(stringStringHashMap);
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
        }
    }
}
