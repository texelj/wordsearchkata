package com.texel;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordTesterTest {
    WordSearchData testData;
    WordTester subject;

    @Before public void initialize() throws FileNotFoundException, URISyntaxException {
        WordSearchFileParser parser = new WordSearchFileParser();
        testData = parser.parseFile(new File(this.getClass().getResource("/helloworldsearch.txt").toURI()));
        subject = new WordTester();
    }

    @Test
    public void TesterShouldReturnTrueIfWordCanBeFoundHorizontallyAtCoordinates(){
        subject.setDirection(WordDirection.HORIZONTAL);
        assertTrue(subject.test(testData.getSearchGrid(),"WORLD",4,0));
    }

    @Test
    public void TesterShouldReturnFalseIfWordCannotBeHorizontallyFoundAtCoordinates(){
        subject.setDirection(WordDirection.HORIZONTAL);
        assertTrue(!subject.test(testData.getSearchGrid(),"WORLD",3,0));
    }

    @Test
    public void TesterShouldNotGoOutsideSearchGridHorizontally(){
        subject.setDirection(WordDirection.HORIZONTAL);
        assertTrue(!subject.test(testData.getSearchGrid(),"ZZZZZZ",3,4));
    }

    @Test
    public void TesterShouldReturnTrueIfWordCanBeFoundVerticallyAtCoordinates(){
        subject.setDirection(WordDirection.VERTICAL);
        assertTrue(subject.test(testData.getSearchGrid(),"HELLO",0,1));
    }

    @Test
    public void TesterShouldReturnFalseIfWordCannotBeFoundVerticallyAtCoordinates(){
        subject.setDirection(WordDirection.VERTICAL);
        assertTrue(!subject.test(testData.getSearchGrid(),"HELLO",1,1));
    }

    @Test
    public void TesterShouldReturnTueIfWordCanBeFoundDiagonallyDescending(){
        subject.setDirection(WordDirection.DIAGONAL_DESC);
        assertTrue(subject.test(testData.getSearchGrid(), "ZEZZD",0,0));
    }

    @Test
    public void TesterShouldReturnFalseIfWordCannotBeFoundDiagonallyDescending(){
        subject.setDirection(WordDirection.DIAGONAL_DESC);
        assertTrue(!subject.test(testData.getSearchGrid(), "ZEZZD",1,0));
    }
}
