package com.texel;

/**
 * Created by jacob on 5/12/2018.
 */
public class AnswerGenerator {
    public static String generate(WordDirection direction, String word, int row, int column){
        StringBuffer answer = new StringBuffer();
        answer.append(word);
        answer.append(": ");
        for(int i=0; i<word.length(); i++){
            answer.append("(").append(column).append(",").append(row).append(")");
            if(i<word.length()-1)
                answer.append(",");
            row+=direction.rowDirection();
            column+=direction.columnDirection();
        }
        answer.append("");
        return answer.toString();
    }
}
