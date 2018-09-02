package com.nsh.getintoclub.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.nsh.getintoclub.R;


public class DialogBox extends Dialog {

    private RadioGroup Clubs;
    private RadioButton RadioClubButton;
    RadioButton appteam, pr, dramatics, fashionparade, discipline, organisation, technical,
            ins, designdeco, finearts, informals, english, hindi, gogreen, humans, music, dance, pixonoids, finance;
    public static String set;

    public DialogBox(@NonNull Context context) {
        super(context);
        initUI();
    }


    public void initUI() {
        setContentView(R.layout.dialogbox);
        setContentView(R.layout.dialogbox);
        setCancelable(false);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0.3f;
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(false);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        appteam = findViewById(R.id.AppTeam);
        pr = findViewById(R.id.PublicRelations);
        dramatics = findViewById(R.id.Dramatics);
        fashionparade = findViewById(R.id.FashionParade);
        discipline = findViewById(R.id.DisciplineClub);
        organisation = findViewById(R.id.OrganizationClub);
        technical = findViewById(R.id.TechnicalClub);
        ins = findViewById(R.id.INSandControlClub);
        designdeco = findViewById(R.id.DesignandDecorationClub);
        finearts = findViewById(R.id.FineArtsClub);
        informals = findViewById(R.id.InformalsClub);
        english = findViewById(R.id.EnglishClub);
        hindi = findViewById(R.id.HindiClub);
        gogreen = findViewById(R.id.GoGreenClub);
        humans = findViewById(R.id.HumanValuesandEthicsCommittee);
        music = findViewById(R.id.MusicClub);
        dance = findViewById(R.id.DanceClub);
        pixonoids = findViewById(R.id.Pixonoids);
        finance = findViewById(R.id.TeamFinance);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.clubs);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.AppTeam:
                        String[] skilla = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilla;
                        set = "App Team";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.PublicRelations:
                        String[] skillp = {
                                "ABC", "BCD", "EFG", "FGH", "DJ", "fwkd", "enf", "ejfnj", "Prrm"
                                , "nkgdm"
                        };
                        SkillDetail.subjects = skillp;
                        set = "Public Relations";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.Dramatics:
                        String[] skilld = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilld;
                        set = "Dramatics Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.FashionParade:
                        String[] skille = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skille;
                        set = "Fashion Parade";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.DisciplineClub:
                        String[] skilldis = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilldis;
                        set = "Discipline Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.OrganizationClub:
                        String[] skillo = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillo;
                        set = "Organization Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.TechnicalClub:
                        String[] skilltec = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilltec;
                        set = "Technical Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.INSandControlClub:
                        String[] skillins = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillins;
                        set = "INS and Control Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.DesignandDecorationClub:
                        String[] skilldes = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilldes;
                        set = "Design and Decoration Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.FineArtsClub:
                        String[] skillfin = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillfin;
                        set = "FineArts Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.InformalsClub:
                        String[] skillin = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillin;
                        set = "Informals Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.EnglishClub:
                        String[] skilleng = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilleng;
                        set = "English Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.HindiClub:
                        String[] skillhin = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillhin;
                        set = "Hindi Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.GoGreenClub:
                        String[] skillgo = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillgo;
                        set = "Go Green Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.HumanValuesandEthicsCommittee:
                        String[] skillhv = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillhv;
                        set = "Human Values and Ethics Committee";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.MusicClub:
                        String[] skillmc = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillmc;
                        set = "Music Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.DanceClub:
                        String[] skilldc = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilldc;
                        set = "Dance Club";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.Pixonoids:
                        String[] skillpixo = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skillpixo;
                        set = "Pixonoids";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                    case R.id.TeamFinance:
                        String[] skilltf = {
                                "Css", "HTML", "Java", "PHP", "C", "C++", "Photoshop", "Android", "Python"
                                , "NodeJs",
                                "Django", "MongoDB", "Javascript", "AWS"
                                , "ReactNative", "Flask", "Ruby", "Jquery", "SQL", "AfterEffects"
                        };
                        SkillDetail.subjects = skilltf;
//                        result = R.id.TeamFinance;
                        set = "Team Finance";
                        Database.c = set.replace(" ","").toLowerCase();
                        dismiss();
                        break;
                }

            }
        });
    }

}
