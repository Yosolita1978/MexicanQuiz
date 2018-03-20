package com.example.android.mexicanquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by cristina on 3/15/18.
 */
public class quizOneActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    public static final String quest1ans1 = "quest1ans1";
    public static final String quest1ans2 = "quest1ans2";
    public static final String quest1ans3 = "quest1ans3";
    public static final String quest1ans4 = "quest1ans4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the quizone_activity.xml layout file
        setContentView(R.layout.quizone_activity);

        // Check the preferences function
        checkPreferences();

        // Create an event listener for the button
        Button nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Call the second question of the Quiz */
                Intent quiz2Intent = new Intent(quizOneActivity.this, quizTwoActivity.class);
                startActivity(quiz2Intent);

                //Save Preferences before going to the next Question
                savePreferences();
                finish();
            }
        });

    }

    private void checkPreferences() {

        CheckBox checkboxFirstOption = (CheckBox) findViewById(R.id.checkboxFirstOption);
        CheckBox checkboxSecondOption = (CheckBox) findViewById(R.id.checkboxSecondOption);
        CheckBox checkboxThirdOption = (CheckBox) findViewById(R.id.checkboxThirdOption);
        CheckBox checkboxFourOption = (CheckBox) findViewById(R.id.checkboxFourOption);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        //Get values from Preferences
        boolean questAns1 = sharedpreferences.getBoolean(quest1ans1, false);
        checkboxFirstOption.setChecked(questAns1);

        boolean questAns2 = sharedpreferences.getBoolean(quest1ans2, false);
        checkboxSecondOption.setChecked(questAns2);

        boolean questAns3 = sharedpreferences.getBoolean(quest1ans3, false);
        checkboxThirdOption.setChecked(questAns3);

        boolean questAns4 = sharedpreferences.getBoolean(quest1ans4,false);
        checkboxFourOption.setChecked(questAns4);

        editor.apply();
    }

    private void savePreferences() {

        CheckBox checkboxFirstOption = (CheckBox) findViewById(R.id.checkboxFirstOption);
        CheckBox checkboxSecondOption = (CheckBox) findViewById(R.id.checkboxSecondOption);
        CheckBox checkboxThirdOption = (CheckBox) findViewById(R.id.checkboxThirdOption);
        CheckBox checkboxFourOption = (CheckBox) findViewById(R.id.checkboxFourOption);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        // Get value from CheckBox First Option
        boolean questAns1 = checkboxFirstOption.isChecked();
        editor.putBoolean(quest1ans1, questAns1);

        // Get value from CheckBox Second Option
        boolean questAns2 = checkboxSecondOption.isChecked();
        editor.putBoolean(quest1ans2, questAns2);

        // Get value form CheckBox Third Option
        boolean questAns3 = checkboxThirdOption.isChecked();
        editor.putBoolean(quest1ans3, questAns3);

        // Get value form CheckBox Four Option
        boolean questAns4 = checkboxFourOption.isChecked();
        editor.putBoolean(quest1ans4, questAns4);

        //Apply changes to the sharedPreferences
        editor.apply();
    }

}
