package com.texel;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jacob on 5/12/2018.
 */
public class WordFinderTest {
    private WordFinder subject;
    @Before
    public void initialize() throws FileNotFoundException, URISyntaxException {
        File testFile = new File(this.getClass().getResource("/alldirectionstest.txt").toURI());
        WordSearchFileParser parser = new WordSearchFileParser();
        WordSearchData data = parser.parseFile(testFile);
        subject = new WordFinder(data.getSearchGrid());
    }

    @Test
    public void FinderReturnsEmptyStringWhenWordNotFound(){
        assertEquals(subject.findWord("NOTTHERE"),"");
    }

    @Test
    public void FinderReturnsStringWhenHorizontalWordFound(){
        assertEquals(subject.findWord("TWO"),"TWO: (1,0),(2,0),(3,0)");
    }
}
