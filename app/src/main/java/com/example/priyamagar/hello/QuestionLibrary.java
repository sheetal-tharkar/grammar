package com.example.priyamagar.hello;

/**
 * Created by priyamagar on 11/3/18.
 */

public class QuestionLibrary {
    private String mQuestion [] = {
            "Boys _______ playing cricket",
            "She _____ a mango",
            "______ many times every winter in F",
            "Babies ____ when they are hungry",
            "Sorry,you can't borrow my pencil. I ______ it myself.",
            "Complete the idioms: My mother said 'Speak of the _____'as she saw him walking down the stairs.",
            "I ____sheetal",
            "They____do it",
            "she is dancing,___ she?",
            "He has ____ a letter.",
            "I am singing a song"
    };
    private String mChoices [][] = {
            {"is","are","am"},
            {"eats","eat","eating"},
            {"It snows", "It snowed","It is snowing"},
            {"cry","cries","cried"},
            {"using","use","am using"},
            {"man","devil","god"},
            {"am","is","are"},
            {"will","are","is"},
            {"isn't","aren't","is"},
            {"written","write","wrote"},
            {"simple present","continuous","perfect"}
    };
    private String  mCorrectAns [] = {"are", "eats", "It snows", "cry", "am using","devil","am","will","isn't","written","continuous"};




    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAns(int a){
        String ans = mCorrectAns[a];
        return ans;
    }
}
