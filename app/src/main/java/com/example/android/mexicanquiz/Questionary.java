package com.example.android.mexicanquiz;

import android.content.Context;

/**
 * Created by cristina on 3/20/18.
 */

public class Questionary {

    public static Questionary questionary = null;
    private Question[] mQuestions;
    private int mCurrentQuestionIndex = 0;

    public static Questionary getQuestionary(Context context){
        if(questionary == null){
            questionary = new Questionary(context);
        }
        return questionary;
    }


    public Questionary(Context context){
        String[] questionOneChoices = context.getResources().getStringArray(R.array.question1_choices);
        String[] questionOneAnswers = {};
        Question questionOne = new Question(context.getString(R.string.question1_question), questionOneChoices, questionOneAnswers);
    }


}
