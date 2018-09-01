package com.nsh.getintoclub;

import android.Manifest;
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import static com.nsh.getintoclub.ContactDetail.branch;
import static com.nsh.getintoclub.ContactDetail.email;
import static com.nsh.getintoclub.ContactDetail.mobile;
import static com.nsh.getintoclub.ContactDetail.name;
import static com.nsh.getintoclub.ContactDetail.roll;
import static com.nsh.getintoclub.QuestionDetail.q1;
import static com.nsh.getintoclub.QuestionDetail.q2;
import static com.nsh.getintoclub.QuestionDetail.q3;
import static com.nsh.getintoclub.QuestionDetail.q4;
import static com.nsh.getintoclub.SkillDetail.achievments;
import static com.nsh.getintoclub.SkillDetail.interset;
import static com.nsh.getintoclub.SkillDetail.skill;

public class PdfCreatorActivity extends AppCompatActivity {

    String[] head = {"Name : ", "Roll No. : ", "Branch : ", "Mobile No. : ", "E-Mail : ", "Skills : ", "Area of Interest : ", "Achievments : ", "Why should we select you? ", "What will you do for our club? ", "What are your expectations from us?", "Do you prefer working independently or in a team? "};
    String[] val = {(name.equals("") ? " " : name), (roll.equals("") ? " " : roll), (branch.equals("") ? " " : branch), (mobile.equals("") ? " " : mobile), (email.equals("") ? " " : email), (skill.equals("") ? " " : skill), (interset.equals("") ? " " : interset), (achievments.equals("") ? " " : achievments), (q1.equals("") ? " " : q1), (q2.equals("") ? " " : q2), (q3.equals("") ? " " : q3), (q4.equals("") ? " " : q4)};
    private static final String TAG = "PdfCreatorActivity";
    private EditText mContentEditText;
    private Button mCreateButton;
    private File pdfFile;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_creator);

        mContentEditText = (EditText) findViewById(R.id.edit_text_content);
        mCreateButton = (Button) findViewById(R.id.button_create);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContentEditText.getText().toString().isEmpty()) {
                    mContentEditText.setError("Body is empty");
                    mContentEditText.requestFocus();
                    return;
                }
                try {
                    createPdfWrapper();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void createPdfWrapper() throws FileNotFoundException, DocumentException {

        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                    showMessageOKCancel("You need to allow access to Storage",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                                REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
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
                    // Permission Denied
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

        pdfFile = new File(docsFolder.getAbsolutePath(), "YourCV.pdf");
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
            document.add(new Paragraph(val[i], regular));

        }
        document.close();
        previewPdf();

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
        }
    }
}