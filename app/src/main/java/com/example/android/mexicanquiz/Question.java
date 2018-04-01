package com.example.android.mexicanquiz;

/**
 * Created by cristina on 3/20/18.
 */

/*
class Question to describe on question for test:
question itself, multiple choices to answer, and correct answer
if the correct answer is null, then the question had two corrects answers
*/

public class Question {

    private String mQuestion;
    private String[] mChoices;
    private String[] mAnswers;


    public Question(String question, String[] choices, String[] answers){
        this.mQuestion = question;
        this.mChoices = choices;
        this.mAnswers = answers;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String[] getChoices() {
        return mChoices;
    }

    public boolean isCorrect(String answer) {
        return mAnswers[0].equals(answer);
    }

    public boolean isCorrect(String[] answers){
        if(mAnswers.length != answers.length){
            return false;
        }
        for(int i = 0; i < answers.length; i++){
            if(!answers[i].equals(mAnswers[i])){
                return false;
            }
        }
        return true;
    }

    public int getAnswerCount(){
        return mAnswers.length;
    }

    public Class getActivity(){
        if(getAnswerCount() > 1){
            return MultipleAnswersActivity.class;
        } else{
            return WrittenAnswerActivity.class;
        }
    }



}