package com.texel;

import java.util.List;

/**
 * Created by jacob on 5/9/2018.
 */
public class HorizontalTester {
    public boolean test(List<List<Character>> searchGrid, String word, int row, int column) {
        for(int charIndex = 0; charIndex<word.length(); charIndex++){
            if(word.charAt(charIndex)!=searchGrid.get(row).get(column))
                return false;
            column++;
        }
        return true;
    }
}
