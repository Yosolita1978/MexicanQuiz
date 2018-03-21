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
        String[] questionOneAnswers = context.getResources().getStringArray(R.array.question1_answers);
        Question questionOne = new Question(context.getString(R.string.question1_question), questionOneChoices, questionOneAnswers);

        String[] questionTwoChoices = {};
        String[] questionTwoAnswers = {context.getString(R.string.question2_answer)};
        Question questionTwo = new Question(context.getString(R.string.question2_question), questionTwoChoices, questionTwoAnswers);

        String[] questionThreeChoices = context.getResources().getStringArray(R.array.question3_choices);
        String[] questionThreeAnswers = {context.getString(R.string.question3_answer)};
        Question questionThree = new Question(context.getString(R.string.question3_question), questionThreeChoices, questionThreeAnswers);

        String[] questionFourChoices = context.getResources().getStringArray(R.array.question4_choices);
        String[] questionFourAnswers = {context.getString(R.string.question4_answer)};
        Question questionFour = new Question(context.getString(R.string.question4_question), questionFourChoices, questionFourAnswers);



    }


}
