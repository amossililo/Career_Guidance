package com.career.guidance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;

public class displayProgramInfoActivity extends AppBaseActivity {
    WebView displayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_program_info);
        displayData = findViewById(R.id.webView);

        // Retrieving the value using its keys the file name
// must be same in both saving and retrieving the data
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

// The value will be default as empty string because for
// the very first time when the app is opened, there is nothing to show
        String selectctedProgram = sh.getString("selectedProgram", "");
        String nameOfHtmlFile = sh.getString("nameOfHtmlFile", getString(R.string.errorHtml));// the second parameter is a default value.
        //int a = sh.getInt("age", 0);


        displayData.loadUrl("file:///android_asset/" + nameOfHtmlFile);
    }
}