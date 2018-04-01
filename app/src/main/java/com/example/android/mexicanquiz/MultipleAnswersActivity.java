package com.example.android.mexicanquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cristina on 3/15/18.
 */
public class MultipleAnswersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the multiple_answers_activity.xml layout file
        setContentView(R.layout.multiple_answers_activity);

        final Questionary questionary = Questionary.getQuestionary(this);
        Question currentQuestion = questionary.getCurrentQuestion();
        displayQuestion(currentQuestion.getQuestion());
        displayChoices(currentQuestion.getChoices());

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            /* Get the Answers from the user */
                int[] checkboxIds = {R.id.checkboxFirstOption, R.id.checkboxSecondOption, R.id.checkboxThirdOption, R.id.checkboxFourOption};
                ArrayList<String> userAnswers = new ArrayList<>();
                for (int i = 0; i < checkboxIds.length; i++) {
                    CheckBox answerText = (CheckBox) findViewById(checkboxIds[i]);
                    if (answerText.isChecked()) {
                        userAnswers.add(answerText.getText().toString());
                    }
                }

                //Check the Answer before going to the next Question
                questionary.checkAnswer(userAnswers.toArray(new String[0]));
                Question nextQuestion = questionary.getNextQuestion();
                Intent nextIntent = new Intent(MultipleAnswersActivity.this, nextQuestion.getActivity());
                startActivity(nextIntent);

                finish();
            }
        });


    }

    /**
     * Displays the given Question.
     */
    public void displayQuestion(String question) {
        TextView questionView = (TextView) findViewById(R.id.questionTextView);
        questionView.setText(question);
    }

    public void displayChoices(String[] choices){
        int[] answerIds = {R.id.checkboxFirstOption, R.id.checkboxSecondOption, R.id.checkboxThirdOption, R.id.checkboxFourOption};
        for(int i = 0; i < choices.length; i++){
            TextView answerView = (TextView) findViewById(answerIds[i]);
            answerView.setText(choices[i]);
        }
    }


}
