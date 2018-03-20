package com.example.android.mexicanquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.mexicanquiz.R;

public class quizTwoActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    public static final String quest2ans1 = "quest2ans1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the quizone_activity.xml layout file
        setContentView(R.layout.quiztwo_activity);
        checkPreferences();


        // Create an event listener for the next button
        Button nextButton = (Button) findViewById(R.id.nextButton);

        // Create an event listener for the previous button
        Button previousButton = (Button) findViewById(R.id.previousButton);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Call the second question of the Quiz */
                Intent quiz1Intent = new Intent(quizTwoActivity.this, quizOneActivity.class);
                startActivity(quiz1Intent);

                //Save Preferences before going to the next Question
                savePreferences();
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Call the second question of the Quiz */
                Intent quiz2Intent = new Intent(quizTwoActivity.this, quizTwoActivity.class);
                startActivity(quiz2Intent);

                //Save Preferences before going to the next Question
                savePreferences();
                finish();
            }
        });
    }

    private void checkPreferences() {

        EditText ideEditText = (EditText) findViewById(R.id.name_text_input);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        //Get value from Preferences if it exist
        String questAns1 = sharedpreferences.getString(quest2ans1,"");
        ideEditText.setText(questAns1);

        editor.apply();
    }

    private void savePreferences() {

        EditText ideEditText = (EditText) findViewById(R.id.name_text_input);
        String cleanIdeEditText = ideEditText.getText().toString().trim();

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        //Save clean value
        editor.putString(quest2ans1 ,cleanIdeEditText);

        //Apply changes to the sharedPreferences
        editor.apply();
    }
}