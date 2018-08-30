package com.nsh.getintoclub;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button contact, skills, questions;
    CardView contactsmallCard,contactlargeCard,skillsmallCard,skilllargeCard,questionscontactsmallCard,questionscontactlargeCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }

    public void initUI() {
        contact = findViewById(R.id.contact);
        skills = findViewById(R.id.skills);
        questions = findViewById(R.id.questions);
        contactsmallCard = findViewById(R.id.contactsmallCard);
        contactlargeCard = findViewById(R.id.contactlargeCard);
        skillsmallCard = findViewById(R.id.skillsmallCard);
        skilllargeCard = findViewById(R.id.skilllargeCard);
        questionscontactsmallCard = findViewById(R.id.questionssmallCard);
        questionscontactlargeCard = findViewById(R.id.questionslargeCard);
        setupdata();
    }

    public void setupdata() {
        contact.setOnClickListener(this);
        skills.setOnClickListener(this);
        questions.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.contact:
                startActivity(new Intent(MainActivity.this, ContactDetail.class));
                break;
            case R.id.skills:
                startActivity(new Intent(MainActivity.this, SkillDetail.class));
                break;
            case R.id.questions:
                startActivity(new Intent(MainActivity.this, QuestionDetail.class));
                break;

        }
    }
}
