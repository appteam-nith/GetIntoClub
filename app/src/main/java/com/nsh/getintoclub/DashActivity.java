package com.nsh.getintoclub;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.WindowManager;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.nsh.getintoclub.adapter.MainAdapter;
import com.nsh.getintoclub.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class DashActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    List<Quote> quoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initUI();
    }

    public void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        setupData();
    }

    public void setupData() {
        quoteList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            quoteList.add(new Quote("dddd", getDrawable(R.drawable.green_gradient), "Question.","Answer"));
            quoteList.add(new Quote("aaaa", getDrawable(R.drawable.red_gradient), "Skills.","Set"));
            quoteList.add(new Quote("ssss", getDrawable(R.drawable.blue_gradient), "Contact.","Info"));
        }
        mainAdapter = new MainAdapter(quoteList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.END);
        snapHelperStart.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.scrollToPosition(2);
    }
}
