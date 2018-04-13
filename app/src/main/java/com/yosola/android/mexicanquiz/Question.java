package com.yosola.android.mexicanquiz;

import java.text.Normalizer;

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
        for(int i = 0; i < mAnswers.length; i++){
            mAnswers[i] = Normalizer.normalize(mAnswers[i], Normalizer.Form.NFC);
        }
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String[] getChoices() {
        return mChoices;
    }

    public boolean isCorrect(String answer) {
        answer = Normalizer.normalize(answer, Normalizer.Form.NFC);
        return mAnswers[0].equals(answer);
    }

    public boolean isCorrect(String[] answers){
        String answer;
        if(mAnswers.length != answers.length){
            return false;
        }
        for(int i = 0; i < answers.length; i++){
            answer = Normalizer.normalize(answers[i], Normalizer.Form.NFC);
            if(!answer.equals(mAnswers[i])){
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
        } else if(getChoices().length == 2){
            return TrueFalseActivity.class;
        } else if(getChoices().length > 2){
            return RadioAnswerActivity.class;
        } else{
            return WrittenAnswerActivity.class;
        }
    }



}