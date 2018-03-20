package com.example.android.mexicanquiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.mexicanquiz.R;

public class quizTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the quizone_activity.xml layout file
        setContentView(R.layout.quiztwo_activity);
    }
}