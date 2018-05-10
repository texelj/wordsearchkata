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
public class HorizontalTesterTest {
    WordSearchData testData;
    HorizontalTester subject;

    @Before public void initialize() throws FileNotFoundException, URISyntaxException {
        WordSearchFileParser parser = new WordSearchFileParser();
        testData = parser.parseFile(new File(this.getClass().getResource("/helloworldsearch.txt").toURI()));
        subject = new HorizontalTester();
    }

    @Test
    public void TesterShouldReturnTrueIfWordCanBeFoundAtCoordinates(){
        assertTrue(subject.test(testData.getSearchGrid(),"WORLD",4,0));
    }

    @Test
    public void TesterShouldReturnFalseIfWordCannotBeHorizontallyFoundAtCoordinates(){
        assertTrue(!subject.test(testData.getSearchGrid(),"WORLD",3,0));
    }

    @Test
    public void TesterShouldNotGoOutsideSearchGrid(){
        assertTrue(!subject.test(testData.getSearchGrid(),"ZZZZZZ",3,4));
    }
}
