package com.nsh.getintoclub.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.nsh.getintoclub.R;
import com.nsh.getintoclub.adapter.MainAdapter;
import com.nsh.getintoclub.model.Quote;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashActivity extends AppCompatActivity {

    CircleImageView image;
    Boolean doubleBackToExitPressedOnce = false;
    TextView knowApp;
    RelativeLayout topText;
    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    List<Quote> quoteList;
    CardView submitBtn, moreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)
            if (!hasNavigationBar()) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            } else {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        initUI();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @SuppressLint("PrivateApi")
    public static Boolean hasNavigationBar() {
        try {
            Class<?> serviceManager = Class.forName("android.os.ServiceManager");
            IBinder serviceBinder = (IBinder) serviceManager.getMethod("getService", String.class).invoke(serviceManager, "window");
            Class<?> stub = Class.forName("android.view.IWindowManager$Stub");
            Object windowManagerService = stub.getMethod("asInterface", IBinder.class).invoke(stub, serviceBinder);
            Method hasNavigationBar = windowManagerService.getClass().getMethod("hasNavigationBar");
            return (boolean) hasNavigationBar.invoke(windowManagerService);
        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Log.w("YOUR_TAG_HERE", "Couldn't determine whether the device has a navigation bar", e);
            return null;
        }
    }

    public void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        submitBtn = findViewById(R.id.submitBtn);
        knowApp = findViewById(R.id.knowApp);
        topText = findViewById(R.id.topText);
        image = findViewById(R.id.pic);
        moreBtn = findViewById(R.id.moreBtn);
        recyclerView.setAlpha(0f);
        DialogBox dialogBox = new DialogBox(this);
        dialogBox.show();
        dialogBox.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                String set = DialogBox.set;
                TextView clubname = findViewById(R.id.club);
                clubname.setText(set);
                if (set.equals("Pixonoids")) {
                    image.setImageDrawable((getDrawable(R.drawable.pixo)));
                } else if (set.equals("App Team")) {
                    image.setImageDrawable((getDrawable(R.drawable.logo)));
                }
                else if(set.equals("Public Relations")){
                    image.setImageDrawable((getDrawable(R.drawable.pr)));
                }
                else if (set.equals("English Club")){
                    image.setImageDrawable((getDrawable(R.drawable.english)));
                }
                else if (set.equals("Dramatics Club")){
                    image.setImageDrawable((getDrawable(R.drawable.dramatics)));
                }
                else if (set.equals("Fashion Parade")){
                    image.setImageDrawable((getDrawable(R.drawable.fashion)));
                }else if (set.equals("Discipline Club")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }else if (set.equals("Organization Club")){
                    image.setImageDrawable((getDrawable(R.drawable.organisation)));
                }else if (set.equals("Technical Club")){
                    image.setImageDrawable((getDrawable(R.drawable.technical)));
                }else if (set.equals("INS and Control Club")){
                    image.setImageDrawable((getDrawable(R.drawable.ins)));
                }else if (set.equals("Design and Decoration Club")){
                    image.setImageDrawable((getDrawable(R.drawable.design)));
                }else if (set.equals("FineArts Club")){
                    image.setImageDrawable((getDrawable(R.drawable.fine_arts)));
                }else if (set.equals("Informals Club")){
                    image.setImageDrawable((getDrawable(R.drawable.informals)));
                }else if (set.equals("Hindi Samiti")){
                    image.setImageDrawable((getDrawable(R.drawable.hindi)));
                }else if (set.equals("Cultural Club")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }else if (set.equals("Entrepreneurship")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }else if (set.equals("Music Club")){
                    image.setImageDrawable((getDrawable(R.drawable.music)));
                }else if (set.equals("Dance Club")){
                    image.setImageDrawable((getDrawable(R.drawable.dance)));
                }else if (set.equals("Treasurer")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }
            }
        });

        setupData();
    }

    public void setupData() {

        recyclerView.setAlpha(0f);

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(recyclerView, "alpha", 0, 1);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(recyclerView, "translationY", 100, 0);

        objectAnimator2.setDuration(750);
        objectAnimator2.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator3.setDuration(750);
        objectAnimator3.setInterpolator(new AnticipateOvershootInterpolator());

        objectAnimator3.setStartDelay(100);
        objectAnimator2.setStartDelay(100);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator2, objectAnimator3);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                recyclerView.setAlpha(1f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        quoteList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            quoteList.add(new Quote("\"It doesn't matter where you come from, what matters is what you choose to be.\"", getDrawable(R.drawable.blue_gradient), "Contact.", "Info"));
            quoteList.add(new Quote("\"I am so good at sleeping, I can do it with my eyes closed.\"", getDrawable(R.drawable.red_gradient), "Skills.", "Set"));
            quoteList.add(new Quote("\"If you choke a smurf, what color does it turn to?\"", getDrawable(R.drawable.green_gradient), "Question.", "Answers"));
        }
        mainAdapter = new MainAdapter(quoteList, DashActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
        snapHelperStart.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(mainAdapter);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContactDetail.roll.length() > 0 && SkillDetail.skillet.length() > 0) {
                    Toast.makeText(DashActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DashActivity.this, Database.class));
                } else
                    Toast.makeText(DashActivity.this, "Seams like you missed entering Roll Number or Skills.", Toast.LENGTH_SHORT).show();
            }
        });

        knowApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashActivity.this, AboutAppteam.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    public void onClick(View v) {
        DialogBox dialogBox = new DialogBox(this);
        dialogBox.show();
        dialogBox.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                String set = DialogBox.set;
                TextView clubname = findViewById(R.id.club);
                clubname.setText(set);
                if (set.equals("Pixonoids")) {
                    image.setImageDrawable((getDrawable(R.drawable.pixo)));
                } else if (set.equals("App Team")) {
                    image.setImageDrawable((getDrawable(R.drawable.logo)));
                }
                else if(set.equals("Public Relations")){
                    image.setImageDrawable((getDrawable(R.drawable.pr)));
                }
                else if (set.equals("English Club")){
                    image.setImageDrawable((getDrawable(R.drawable.english)));
                }
                else if (set.equals("Dramatics Club")){
                    image.setImageDrawable((getDrawable(R.drawable.dramatics)));
                }
                else if (set.equals("Fashion Parade")){
                    image.setImageDrawable((getDrawable(R.drawable.fashion)));
                }else if (set.equals("Discipline Club")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }else if (set.equals("Organization Club")){
                    image.setImageDrawable((getDrawable(R.drawable.organisation)));
                }else if (set.equals("Technical Club")){
                    image.setImageDrawable((getDrawable(R.drawable.technical)));
                }else if (set.equals("INS and Control Club")){
                    image.setImageDrawable((getDrawable(R.drawable.ins)));
                }else if (set.equals("Design and Decoration Club")){
                    image.setImageDrawable((getDrawable(R.drawable.design)));
                }else if (set.equals("FineArts Club")){
                    image.setImageDrawable((getDrawable(R.drawable.fine_arts)));
                }else if (set.equals("Informals Club")){
                    image.setImageDrawable((getDrawable(R.drawable.informals)));
                }else if (set.equals("Hindi Samiti")){
                    image.setImageDrawable((getDrawable(R.drawable.hindi)));
                }else if (set.equals("Cultural Club")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }else if (set.equals("Entrepreneurship")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }else if (set.equals("Music Club")){
                    image.setImageDrawable((getDrawable(R.drawable.music)));
                }else if (set.equals("Dance Club")){
                    image.setImageDrawable((getDrawable(R.drawable.dance)));
                }else if (set.equals("Treasurer")){
                    image.setImageDrawable((getDrawable(R.drawable.black)));
                }
            }
        });

//        setupData();
    }
}
