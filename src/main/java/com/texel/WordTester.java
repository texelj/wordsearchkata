package com.texel;

import java.util.List;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordTester {
    private WordDirection direction;

    public void setDirection(WordDirection direction){
        this.direction = direction;
    }

    public boolean test(List<List<Character>> searchGrid, String word, int row, int column) {
        for(int charIndex = 0; charIndex<word.length(); charIndex++){
            if(row<0 || row>=searchGrid.size() || column<0 || column>=searchGrid.get(0).size())
                return false;
            if(word.charAt(charIndex)!=searchGrid.get(row).get(column))
                return false;
            column+=direction.columnDirection();
            row+=direction.rowDirection();
        }
        return true;
    }


}
