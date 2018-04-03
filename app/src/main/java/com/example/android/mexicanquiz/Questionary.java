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
        mQuestions = new Question[10];

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

        String[] questionFiveChoices = context.getResources().getStringArray(R.array.question5_choices);
        String[] questionFiveAnswers = {context.getString(R.string.question5_answer)};
        Question questionFive = new Question(context.getString(R.string.question5_question), questionFiveChoices, questionFiveAnswers);
        mQuestions[4] = questionFive;

        String[] questionSixChoices = {};
        String[] questionSixAnswers = {context.getString(R.string.question6_answer)};
        Question questionSix = new Question(context.getString(R.string.question6_question), questionSixChoices, questionSixAnswers);
        mQuestions[5] = questionSix;

        String[] questionSevenChoices = context.getResources().getStringArray(R.array.question7_choices);
        String[] questionSevenAnswers = {context.getString(R.string.question7_answer)};
        Question questionSeven = new Question(context.getString(R.string.question7_question), questionSevenChoices, questionSevenAnswers);
        mQuestions[6] = questionSeven;

        String[] questionEightChoices = context.getResources().getStringArray(R.array.question8_choices);
        String[] questionEightAnswers = context.getResources().getStringArray(R.array.question8_answers);
        Question questionEight = new Question(context.getString(R.string.question8_question), questionEightChoices, questionEightAnswers);
        mQuestions[7] = questionEight;

        String[] questionNineChoices = context.getResources().getStringArray(R.array.question9_choices);
        String[] questionNineAnswers = {context.getString(R.string.question9_answer)};
        Question questionNine = new Question(context.getString(R.string.question9_question), questionNineChoices, questionNineAnswers);
        mQuestions[8] = questionNine;

        String[] questionTenChoices = context.getResources().getStringArray(R.array.question10_choices);
        String[] questionTenAnswers = {context.getString(R.string.question10_answer)};
        Question questionTen = new Question(context.getString(R.string.question10_question), questionTenChoices, questionTenAnswers);
        mQuestions[9] = questionTen;
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

    public void checkAnswer(String answer){
        Question question = getCurrentQuestion();
        if(question.isCorrect(answer)){
            mNumberCorrectAnswers += 1;
        }
    }

    public int getProgress(){
        int totalQuestions = mQuestions.length;
        int progress = (mCurrentQuestionIndex + 1) * 100 / totalQuestions;
        return  progress;
    }

    public int getNumberCurrentQuestion(){
        int currentQuestion = (mCurrentQuestionIndex + 1);
        return currentQuestion;
    }

    public int getTotalQuestions(){
        return mQuestions.length;
    }






}
