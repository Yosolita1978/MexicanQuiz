package com.example.android.mexicanquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.button_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create Preferences file and clean it
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();

                // Call the beginning of the quiz.
                Intent quizIntent = new Intent(MainActivity.this, quizOneActivity.class);
                startActivity(quizIntent);

                //Finish View once the Question is called.
                finish();
            }
        });
    }
}
