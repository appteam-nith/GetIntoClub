package com.nsh.getintoclub;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;

import org.w3c.dom.Text;

public class ContactDetail extends AppCompatActivity {
EditText Name,RollNumber,Branch,Mobile,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initUI();
    }
    public void initUI()
    {

        Name = findViewById(R.id.name);
        RollNumber = findViewById(R.id.rollnumber);
        Branch = findViewById(R.id.branch);
        Mobile = findViewById(R.id.mobile);
        Email = findViewById(R.id.email);
    }

}
