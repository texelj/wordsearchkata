package com.texel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordSearchDataTest {
    WordSearchData subject;
    @Before public void initialize(){
        subject = new WordSearchData();
    }

    @Test
    public void GetReturnsSameWordArrayAfterSet(){
        List<String> words = new ArrayList<>();
        words.add("HELLO");
        words.add("WORLD");
        subject.setWords(words);
        assertEquals(subject.getWords(), Arrays.asList("HELLO", "WORLD"));
    }
}
