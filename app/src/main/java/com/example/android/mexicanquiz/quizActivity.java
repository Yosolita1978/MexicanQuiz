package com.example.android.mexicanquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by cristina on 3/15/18.
 */
public class quizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.quiz_activity);
    }
}
