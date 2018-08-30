package com.nsh.getintoclub;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SkillDetail extends AppCompatActivity {
EditText skillet,intersetet,achievmentset;
TextView doneSkill;
View backView;
int rollLength;
public static String skill,interset,achievments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initUI();
    }
    public void initUI()
    {
        skillet=findViewById(R.id.skill);
        intersetet=findViewById(R.id.interset);
        achievmentset=findViewById(R.id.achievements);
        doneSkill=findViewById(R.id.doneSkill);
        backView=findViewById(R.id.backView);
        setupdata();
    }
    public void setupdata()
    {
        backView.setAlpha(0f);
        ObjectAnimator anim = ObjectAnimator.ofFloat(backView,"alpha",1);
        anim.setDuration(1000); // duration 3 seconds
        anim.setStartDelay(1000);
        anim.start();
        skill=String.valueOf(skillet.getText());
        interset=String.valueOf(intersetet.getText());
        achievments=String.valueOf(achievmentset.getText());
    }
    public void onClick(View view)
    {
        rollLength=skillet.length();
        if(rollLength==0)
        {
            Toast.makeText(this, "Enter atleast one skill", Toast.LENGTH_SHORT).show();
        }
        else
        {

        }
    }
}
