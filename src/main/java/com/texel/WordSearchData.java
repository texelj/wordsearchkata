package com.texel;

import java.util.List;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordSearchData {
    private List<String> words;
    private List<List<Character>> searchGrid;
    
    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public void setSearchGrid(List<List<Character>> searchGrid) {
        this.searchGrid = searchGrid;
    }

    public List<List<Character>> getSearchGrid() {
        return searchGrid;
    }
}
