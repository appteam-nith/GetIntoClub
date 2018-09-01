package com.nsh.getintoclub.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import static com.nsh.getintoclub.activity.ContactDetail.branch;
import static com.nsh.getintoclub.activity.ContactDetail.email;
import static com.nsh.getintoclub.activity.ContactDetail.mobile;
import static com.nsh.getintoclub.activity.ContactDetail.name;
import static com.nsh.getintoclub.activity.ContactDetail.roll;
import static com.nsh.getintoclub.activity.QuestionDetail.q1;
import static com.nsh.getintoclub.activity.QuestionDetail.q2;
import static com.nsh.getintoclub.activity.QuestionDetail.q3;
import static com.nsh.getintoclub.activity.QuestionDetail.q4;
import static com.nsh.getintoclub.activity.SkillDetail.achievments;
import static com.nsh.getintoclub.activity.SkillDetail.interset;
import static com.nsh.getintoclub.activity.SkillDetail.skill;

public class Database extends AppCompatActivity {

    private DatabaseReference mDatabase;
    String[] head = {"Name : ", "Roll No. : ", "Branch : ", "Mobile No. : ", "E-Mail : ", "Skills : ", "Area of Interest : ", "Achievments : ", "Why should we select you? ", "What will you do for our club? ", "What are your expectations from us?", "Do you prefer working independently or in a team? "};
    String[] val = {(name.equals("") ? " " : name), (roll.equals("") ? " " : roll), (branch.equals("") ? " " : branch), (mobile.equals("") ? " " : mobile), (email.equals("") ? " " : email), (skill.equals("") ? " " : skill), (interset.equals("") ? " " : interset), (achievments.equals("") ? " " : achievments), (q1.equals("") ? " " : q1), (q2.equals("") ? " " : q2), (q3.equals("") ? " " : q3), (q4.equals("") ? " " : q4)};
    private static final String TAG = "PdfCreatorActivity";
    private File pdfFile;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        try {
            createPdfWrapper();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void initUI() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        if (ContactDetail.RollLength == 0 || SkillDetail.skillet.length() == 0)
            Toast.makeText(this, "Please Enter Your Roll Number And At Least One Skill", Toast.LENGTH_SHORT).show();
        else
            writeNewUser(ContactDetail.roll);
    }

    private void writeNewUser(String roll) {

        mDatabase.child(roll).child("Name").setValue(ContactDetail.name);
        mDatabase.child(roll).child("Branch").setValue(ContactDetail.branch);
        mDatabase.child(roll).child("Email").setValue(ContactDetail.email);
        mDatabase.child(roll).child("Mobile").setValue(ContactDetail.mobile);
        mDatabase.child(roll).child("Skills").setValue(SkillDetail.skill);
        mDatabase.child(roll).child("Area of Interest").setValue(SkillDetail.interset);
        mDatabase.child(roll).child("Achievements").setValue(SkillDetail.achievments);
        mDatabase.child(roll).child("Ques1").setValue(QuestionDetail.q1);
        mDatabase.child(roll).child("Ques2").setValue(QuestionDetail.q2);
        mDatabase.child(roll).child("Ques3").setValue(QuestionDetail.q3);
        mDatabase.child(roll).child("Ques4").setValue(QuestionDetail.q4);
    }

    private void createPdfWrapper() throws FileNotFoundException, DocumentException {

        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_CONTACTS)) {
                    showMessageOKCancel("You need to allow access to Storage",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                                REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }

                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        } else {
            createPdf();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    try {
                        createPdfWrapper();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, "WRITE_EXTERNAL Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void createPdf() throws FileNotFoundException, DocumentException {

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
            Log.i(TAG, "Created a new directory for PDF");
        }

        pdfFile = new File(docsFolder.getAbsolutePath(), "MyCV.pdf");
        OutputStream output = new FileOutputStream(pdfFile);
        Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        Font bold = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
        Font bold1 = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.BOLDITALIC);
        Font regular = new Font(Font.FontFamily.HELVETICA, 18, Font.ITALIC);

        document.add(new Paragraph("CURRICULUM VITAE" + "\n\n", bold1));
        for (int i = 0; i < 12; i++) {
            document.add(new Paragraph(head[i], bold));
            document.add(new Paragraph(val[i] + "\n", regular));

        }
        document.close();
        Toast.makeText(Database.this, "MyCV.pdf created in Documents.", Toast.LENGTH_SHORT).show();
        finish();
        ContactDetail.name = "";
        ContactDetail.branch = "";
        ContactDetail.email = "";
        ContactDetail.mobile = "";
        SkillDetail.skill = "";
        SkillDetail.interset = "";
        SkillDetail.achievments = "";
        QuestionDetail.q1 = "";
        QuestionDetail.q2 = "";
        QuestionDetail.q3 = "";
        QuestionDetail.q4 = "";
        //        previewPdf();

    }

    private void previewPdf() {

        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(pdfFile);
            intent.setDataAndType(uri, "application/pdf");
            startActivity(intent);
        } else {
            Toast.makeText(this, "Download a PDF Viewer to see the generated PDF", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}


