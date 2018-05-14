package com.texel;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordTesterTest {
    WordSearchData testData;
    WordTester subject;

    @Before public void initialize() throws FileNotFoundException, URISyntaxException {
        testData = WordSearchFileParser.parseFile(new File(this.getClass().getResource("/helloworldsearch.txt").toURI()));
        subject = new WordTester(testData.getSearchGrid());
    }

    @Test
    public void TesterReturnsTrueWhenWordFoundHorizontally(){
        subject.setDirection(WordDirection.HORIZONTAL);
        assertTrue(subject.test("WORLD",4,0));
    }

    @Test
    public void TesterReturnsFalseWhenWordCannotBeHorizontally(){
        subject.setDirection(WordDirection.HORIZONTAL);
        assertFalse(subject.test("WORLD",3,0));
    }

    @Test
    public void TesterDoesNotThrowExceptionWhenIndexesOutOfBounds(){
        subject.setDirection(WordDirection.HORIZONTAL);
        assertFalse(subject.test("ZZZZZZ",-1,-1));
    }

    @Test
    public void TesterReturnsTrueWhenWordFoundVertically(){
        subject.setDirection(WordDirection.VERTICAL);
        assertTrue(subject.test("HELLO",0,1));
    }

    @Test
    public void TesterReturnsFalseWhenWordNotFoundVertically(){
        subject.setDirection(WordDirection.VERTICAL);
        assertFalse(subject.test("HELLO",1,1));
    }

    @Test
    public void TesterReturnsTrueWhenWordFoundDiagonallyDescending(){
        subject.setDirection(WordDirection.DIAGONAL_DESC);
        assertTrue(subject.test("ZEZZD",0,0));
    }

    @Test
    public void TesterReturnsFalseWhenWordNotFoundDiagonallyDescending(){
        subject.setDirection(WordDirection.DIAGONAL_DESC);
        assertFalse(subject.test( "ZEZZD",1,0));
    }

    @Test
    public void TesterReturnsTrueWhenWordFoundDiagonallyAscending(){
        subject.setDirection(WordDirection.DIAGONAL_ASC);
        assertTrue(subject.test("WLZZZ",4,0));
    }

    @Test
    public void TesterReturnsFalseWhenWordNotFoundDiagonallyAscending(){
        subject.setDirection(WordDirection.DIAGONAL_ASC);
        assertFalse(subject.test("WLZZZ",3,0));
    }

    @Test
    public void TesterShouldReturnTrueWhenWordFoundHorizontallyBackwards(){
        subject.setDirection(WordDirection.HORIZONTAL_BACK);
        assertTrue(subject.test("DLROW",4,4));
    }

    @Test
    public void TesterShouldReturnFalseWhenWordNotHorizontallyBackwards(){
        subject.setDirection(WordDirection.HORIZONTAL_BACK);
        assertFalse(subject.test("DLROW",4,3));
    }

    @Test
    public void TesterReturnsTrueWhenWordFoundVerticallyBackwards(){
        subject.setDirection(WordDirection.VERTICAL_BACK);
        assertTrue(subject.test("OLLEH",4,1));
    }

    @Test
    public void TesterReturnsFalseWhenWordNotFoundVerticallyBackwards(){
        subject.setDirection(WordDirection.VERTICAL_BACK);
        assertFalse(subject.test("OLLEH",3,1));
    }

    @Test
    public void TesterReturnsTrueWhenWordFoundDiagonallyDescendingBackwards(){
        subject.setDirection(WordDirection.DIAGONAL_DESC_BACK);
        assertTrue(subject.test("DZZEZ",4,4));
    }

    @Test
    public void TesterReturnsFalseWhenWordNotFoundDiagonallyDescendingBackwards(){
        subject.setDirection(WordDirection.DIAGONAL_DESC_BACK);
        assertFalse(subject.test("DZZEZ",4,3));
    }

    @Test
    public void TesterReturnsTrueWhenWordFoundDiagonallyAscendingBackwards(){
        subject.setDirection(WordDirection.DIAGONAL_ASC_BACK);
        assertTrue(subject.test("ZZZLW",0,4));
    }

    @Test
    public void TesterReturnsFalseWhenWordNotFoundDiagonallyAscendingBackwards(){
        subject.setDirection(WordDirection.DIAGONAL_ASC_BACK);
        assertFalse(subject.test("ZZZLW",1,4));
    }
}
