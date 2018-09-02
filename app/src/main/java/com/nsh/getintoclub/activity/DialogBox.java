package com.nsh.getintoclub.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.nsh.getintoclub.R;

/**
 * Created by naman on 02-09-2018.
 */

public class DialogBox extends Activity {

    private RadioGroup Clubs;
    private RadioButton RadioClubButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogbox);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        Clubs = (RadioGroup) findViewById(R.id.clubs);
        int selectedId =Clubs.getCheckedRadioButtonId();
        RadioClubButton = (RadioButton) findViewById(selectedId);
        }

}
