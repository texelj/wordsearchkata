package com.texel;

import java.util.List;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordTester {
    private int columnDirection;

    public void WordTester(){
        columnDirection = 0;
    }

    public void setColumnDirection(int columnDirection){
        this.columnDirection = columnDirection;
    }

    public boolean test(List<List<Character>> searchGrid, String word, int row, int column) {
        for(int charIndex = 0; charIndex<word.length(); charIndex++){
            if(row<0 || row>=searchGrid.size() || column<0 || column>=searchGrid.get(0).size())
                return false;
            if(word.charAt(charIndex)!=searchGrid.get(row).get(column))
                return false;
            column+=columnDirection;
        }
        return true;
    }
}
