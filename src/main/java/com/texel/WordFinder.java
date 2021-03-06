package com.texel;

import java.util.List;

/**
 * Created by jacob on 5/12/2018.
 */
public class WordFinder {
    private List<List<Character>> searchGrid;
    public WordFinder(List<List<Character>> searchGrid) {
        this.searchGrid=searchGrid;
    }


    public String findWord(String word) {
        WordTester tester = new WordTester(searchGrid);
        for(int row=0; row<searchGrid.size(); row++){
            for(int column=0; column<searchGrid.size();column++) {
                if (searchGrid.get(row).get(column).equals(word.charAt(0))) {
                    for (WordDirection direction : WordDirection.values()) {
                        tester.setDirection(direction);
                        if (tester.test(word,row,column))
                            return AnswerGenerator.generate(direction,word,row,column);
                    }
                }
            }
        }
        return "";
    }
}
