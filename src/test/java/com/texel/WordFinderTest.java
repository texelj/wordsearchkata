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

    @Test
    public void FinderReturnsStringWhenVerticalWordFound(){
        assertEquals(subject.findWord("ONE"),"ONE: (0,0),(0,1),(0,2)");
    }

    @Test
    public void FinderReturnsStringWhenDiagonallyDescendingWordFound(){
        assertEquals(subject.findWord("THREE"),"THREE: (1,0),(2,1),(3,2),(4,3),(5,4)");
    }

    @Test
    public void FinderReturnsStringWhenDiagonallyAscendingWordFound(){
        assertEquals(subject.findWord("FOUR"),"FOUR: (0,4),(1,3),(2,2),(3,1)");
    }

    @Test
    public void FinderReturnsStringWhenHorizontalBackwardsWordFound(){
        assertEquals(subject.findWord("FIVE"),"FIVE: (4,4),(3,4),(2,4),(1,4)");
    }

    @Test
    public void FinderReturnsStringWhenVerticalBackwardsWordFound(){
        assertEquals(subject.findWord("SIX"),"SIX: (6,2),(6,1),(6,0)");
    }

    @Test
    public void FinderReturnsStringWhenDiagonalDescendingBackwardWordFound(){
        assertEquals(subject.findWord("SEVEN"),"SEVEN: (4,2),(3,3),(2,4),(1,5),(0,6)");
    }

    @Test
    public void FinderReturnsStringWhenDiagonalAscendingBackwardWordFound(){
        assertEquals(subject.findWord("EIGH"),"EIGH: (4,5),(3,4),(2,3),(1,2)");
    }
}
