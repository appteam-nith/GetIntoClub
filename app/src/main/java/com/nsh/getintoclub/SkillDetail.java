package com.nsh.getintoclub;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SkillDetail extends AppCompatActivity {
    public static String skill, interset, achievments;
    EditText skillet, intersetet, achievmentset;
    TextView doneSkill;
    View backView;
    int rollLength;
    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] subjects =
            {
                    "CSS", "HTML", "JAVA", "PHP", " C ", "C++", "PHOTOSHOP", "ANDROID", "PYTHON"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initUI();
    }

    public void initUI() {
        skillet = findViewById(R.id.skill);
        intersetet = findViewById(R.id.interset);
        achievmentset = findViewById(R.id.achievements);
        doneSkill = findViewById(R.id.doneSkill);
        backView = findViewById(R.id.backView);
        setupdata();
    }

    public void setupdata() {

//        backView.setAlpha(0f);
//        ObjectAnimator anim = ObjectAnimator.ofFloat(backView,"alpha",1);
//        anim.setDuration(1000); // duration 3 seconds
//        anim.setStartDelay(1000);
//        anim.start();
        skill = String.valueOf(skillet.getText());
        interset = String.valueOf(intersetet.getText());
        achievments = String.valueOf(achievmentset.getText());
        context = getApplicationContext();

        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        recylerViewLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(context, subjects);

        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void onClick(View view) {
        rollLength = skillet.length();
        if (rollLength == 0) {
            Toast.makeText(this, "Enter atleast one skill", Toast.LENGTH_SHORT).show();
        } else {

        }
    }
}
