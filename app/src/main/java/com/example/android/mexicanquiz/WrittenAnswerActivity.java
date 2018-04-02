package com.example.android.mexicanquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.mexicanquiz.R;

public class WrittenAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the multiple_answers_activity.xml layout file
        setContentView(R.layout.written_answer_activity);
        final Questionary questionary = Questionary.getQuestionary(this);
        Question currentQuestion = questionary.getCurrentQuestion();
        displayQuestion(currentQuestion.getQuestion());

        //Set up the progress Bar progress
        ProgressBar quizProgressBar=(ProgressBar)findViewById(R.id.determinateBar);
        quizProgressBar.setProgress(questionary.getProgress());

        //Set up the number of question and the current question
        TextView quizProgress=(TextView) findViewById(R.id.currentquestion_view);
        int totalQuestions = questionary.getTotalQuestions();
        int currentNumberQuestion = questionary.getNumberCurrentQuestion();
        quizProgress.setText(currentNumberQuestion + "/" + totalQuestions);


        // Create an event listener for the next button
        Button nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Get the Answers from the user */

                EditText userAnswers = (EditText)findViewById(R.id.user_text_input);
                String userAnswer =  userAnswers.getText().toString();

                ////Check the Answer before going to the next Question
                questionary.checkAnswer(userAnswer);
                Question nextQuestion = questionary.getNextQuestion();
                Intent nextIntent = new Intent(WrittenAnswerActivity.this, nextQuestion.getActivity());
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
}