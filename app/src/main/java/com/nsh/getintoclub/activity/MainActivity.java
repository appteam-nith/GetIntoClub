package com.nsh.getintoclub.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.nsh.getintoclub.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView questions;
    Intent intent;
    ActivityOptions options;
    CardView skillsmallCard, contactlargeCard, skilllargeCard, questionssmallCard, questionslargeCard;
    CardView contactsmallCard;
    TextView contact, skills;

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
        questionssmallCard = findViewById(R.id.questionssmallCard);
        questionslargeCard = findViewById(R.id.questionslargeCard);
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
                options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,
                        Pair.create((View) contactsmallCard, "contactButton"),
                        Pair.create((View) contactlargeCard, "contactBack"));
                intent = new Intent(MainActivity.this, ContactDetail.class);
                MainActivity.this.startActivity(intent
                        .putExtra("shared_element_transition_name", v.getTransitionName()), options.toBundle());

                break;
            case R.id.skills:
                options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,
                        Pair.create((View) skillsmallCard, "skillButton"),
                        Pair.create((View) skilllargeCard, "skillBack"));
                intent = new Intent(MainActivity.this, SkillDetail.class);
                MainActivity.this.startActivity(intent
                        .putExtra("shared_element_transition_name", v.getTransitionName()), options.toBundle());
                break;
            case R.id.questions:
                options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,
                        Pair.create((View) questionssmallCard, "QuestionButton"),
                        Pair.create((View) questionslargeCard, "QuestionBack"));
                intent = new Intent(MainActivity.this, QuestionDetail.class);
                MainActivity.this.startActivity(intent
                        .putExtra("shared_element_transition_name", v.getTransitionName()), options.toBundle());
                break;
        }
    }
}
