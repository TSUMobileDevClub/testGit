package com.example.sgt_powell.superquiz;

/**
 * Created by SGT_POWELL on 10/29/2015.
 */
public class truthClass {
    private int questionIndex;
    private boolean questionAnswer;

    public truthClass(int q, boolean t){
        questionIndex = q;
        questionAnswer = t;

    }

    public int getQuestion(){
        return questionIndex;
    }

    public void setQuestionAnswer(int question){
        questionIndex = question;
    }

    public boolean getAnswer(){
        return questionAnswer;
    }

    public void getQuesitonAnswer(boolean t){
        questionAnswer = t;
    }

}
