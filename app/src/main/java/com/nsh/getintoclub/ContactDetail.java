package com.nsh.getintoclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactDetail extends AppCompatActivity {
    public static String name, roll, branch, mobile, email;
    EditText Name, RollNumber, Branch, Mobile, Email;
    TextView doneContact;
    View backView;
    int rollLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        initUI();
    }

    public void initUI() {

        Name = findViewById(R.id.name);
        RollNumber = findViewById(R.id.rollnumber);
        Branch = findViewById(R.id.branch);
        Mobile = findViewById(R.id.mobile);
        Email = findViewById(R.id.email);
        backView = findViewById(R.id.backView);
        setupdata();
    }

    public void setupdata() {

        name = String.valueOf(Name.getText());
        roll = String.valueOf(RollNumber.getText());
        branch = String.valueOf(Branch.getText());
        mobile = String.valueOf(Mobile.getText());
        email = String.valueOf(Email.getText());
        doneContact = findViewById(R.id.donecontact);

    }

    public void onClick(View view) {
        rollLength = name.length();
        if (rollLength == 0) {
            Toast.makeText(this, "Seems to be incomplete", Toast.LENGTH_SHORT).show();
        } else {

        }

    }
}
