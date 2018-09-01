package com.nsh.getintoclub;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SkillDetail extends AppCompatActivity {

    public static String skill="", interset="", achievments="";
    public static EditText skillet, intersetet, achievmentset;
    public static String[] subjects =
            {
                    " CSS", " HTML", " JAVA", " PHP", " C ", " C++", " PHOTOSHOP", " ANDROID", " PYTHON"
//                    ,"NODE JS",
//                    "JANGO","MONGO DB","JAVASCRIPT","AWS"
//                    ,"REACT NATIVE","FLASK","RUBY","JQUERY","SQL","AFTER EFFECTS"
            };
    TextView doneSkill;
    View backView;
    int rollLength;
    ScrollView scrollView;
    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
        scrollView = findViewById(R.id.scrollView);
        setupdata();
    }

    public void setupdata() {

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout1);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recylerViewLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(context, subjects);
        recyclerView.setAdapter(recyclerViewAdapter);

        doneSkill.setAlpha(0f);
        scrollView.setAlpha(0f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(doneSkill, "alpha", 0, 1);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(scrollView, "alpha", 0, 1);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(scrollView, "translationY", 50, 0);
        objectAnimator.setDuration(500);
        objectAnimator2.setDuration(500);
        objectAnimator1.setDuration(500);
        objectAnimator2.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator1.setInterpolator(new AnticipateOvershootInterpolator());
        AnimatorSet animator = new AnimatorSet();
        animator.setStartDelay(100);
        animator.playTogether(objectAnimator, objectAnimator2, objectAnimator1);
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                scrollView.setAlpha(1f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void setupData() {

        skill = String.valueOf(skillet.getText());
        interset = String.valueOf(intersetet.getText());
        achievments = String.valueOf(achievmentset.getText());
        System.out.println(skill);
    }

    public void onClick(View view) {
        setupData();
        rollLength = skillet.length();
        if (rollLength == 0) {
            Toast.makeText(this, "Enter atleast one skill", Toast.LENGTH_SHORT).show();
        } else {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(scrollView, "alpha", 1, 0);
        objectAnimator.setDuration(200);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(doneSkill, "alpha", 1, 0);
        objectAnimator2.setDuration(200);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(scrollView, "translationY", 0, 50);
        objectAnimator1.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator, objectAnimator1, objectAnimator2);
        animatorSet.start();
    }
}
