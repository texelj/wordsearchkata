package com.texel;

/**
 * Created by jacob on 5/12/2018.
 */
public class AnswerGenerator {
    public static String generate(WordDirection direction, String word, int row, int column){
        StringBuffer answer = new StringBuffer();
        answer.append(word);
        answer.append(": ");

        answer.append("");
        return answer.toString();
    }
}
