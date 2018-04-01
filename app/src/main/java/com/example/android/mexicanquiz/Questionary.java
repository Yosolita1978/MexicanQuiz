package com.example.android.mexicanquiz;

import android.content.Context;

/**
 * Created by cristina on 3/20/18.
 */

public class Questionary {

    public static Questionary questionary = null;
    private Question[] mQuestions;
    private int mCurrentQuestionIndex = 0;
    private int mNumberCorrectAnswers = 0;

    public static Questionary getQuestionary(Context context){
        if(questionary == null){
            questionary = new Questionary(context);
        }
        return questionary;
    }


    private Questionary(Context context){
        mQuestions = new Question[4];

        String[] questionOneChoices = context.getResources().getStringArray(R.array.question1_choices);
        String[] questionOneAnswers = context.getResources().getStringArray(R.array.question1_answers);
        Question questionOne = new Question(context.getString(R.string.question1_question), questionOneChoices, questionOneAnswers);
        mQuestions[0] = questionOne;

        String[] questionTwoChoices = {};
        String[] questionTwoAnswers = {context.getString(R.string.question2_answer)};
        Question questionTwo = new Question(context.getString(R.string.question2_question), questionTwoChoices, questionTwoAnswers);
        mQuestions[1] = questionTwo;

        String[] questionThreeChoices = context.getResources().getStringArray(R.array.question3_choices);
        String[] questionThreeAnswers = {context.getString(R.string.question3_answer)};
        Question questionThree = new Question(context.getString(R.string.question3_question), questionThreeChoices, questionThreeAnswers);
        mQuestions[2] = questionThree;

        String[] questionFourChoices = context.getResources().getStringArray(R.array.question4_choices);
        String[] questionFourAnswers = {context.getString(R.string.question4_answer)};
        Question questionFour = new Question(context.getString(R.string.question4_question), questionFourChoices, questionFourAnswers);
        mQuestions[3] = questionFour;
    }

    public Question getCurrentQuestion(){
        return mQuestions[mCurrentQuestionIndex];
    }

    public  Question getNextQuestion(){
        if(mCurrentQuestionIndex == mQuestions.length - 1){
            return null;
        } else {
            mCurrentQuestionIndex += 1;
            return mQuestions[mCurrentQuestionIndex];
        }
    }

    public void checkAnswer(String[] answers){
        Question question = getCurrentQuestion();
        if(question.isCorrect(answers)){
            mNumberCorrectAnswers += 1;
        }
    }






}
