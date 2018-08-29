package com.nsh.getintoclub;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;

public class QuestionDetail extends AppCompatActivity {
    EditText ques1,ques2,ques3,ques4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initUI();
    }
    public void initUI()
    {
        ques1=findViewById(R.id.q1);
        ques2=findViewById(R.id.q2);
        ques3=findViewById(R.id.q3);
        ques4=findViewById(R.id.q4);
    }
}
