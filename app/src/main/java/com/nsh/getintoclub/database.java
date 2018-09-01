package com.nsh.getintoclub;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class database extends AppCompatActivity{
    Intent i = getIntent();
    private DatabaseReference mDatabase;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
       initUI();
    }
    public void initUI()
    {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        if (ContactDetail.RollLength == 0 || SkillDetail.skillet.length() == 0)
            Toast.makeText(this, "Please Enter Your Roll Number And At Least One Skill", Toast.LENGTH_SHORT).show();
        else
        writeNewUser(ContactDetail.roll);
    }
    private void writeNewUser(String roll) {

        mDatabase.child(roll).child("Name").setValue(ContactDetail.name);
        mDatabase.child(roll).child("Branch").setValue(ContactDetail.branch);
        mDatabase.child(roll).child("E-mail").setValue(ContactDetail.email);
        mDatabase.child(roll).child("Mobile").setValue(ContactDetail.mobile);
        mDatabase.child(roll).child("Skills").setValue(SkillDetail.skill);
        mDatabase.child(roll).child("Area of Interest").setValue(SkillDetail.interset);
        mDatabase.child(roll).child("Achievements").setValue(SkillDetail.achievments);
        mDatabase.child(roll).child("Ques.1").setValue(QuestionDetail.q1);
        mDatabase.child(roll).child("Ques.2").setValue(QuestionDetail.q2);
        mDatabase.child(roll).child("Ques.3").setValue(QuestionDetail.q3);
        mDatabase.child(roll).child("Ques.4").setValue(QuestionDetail.q4);
    }
}


