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
public class PuzzleSolverTest {
    private File allDirectionFile;
    private File kataTestFile;
    private static PuzzleSolver subject;
    @Before
    public void initialize() throws URISyntaxException {
        allDirectionFile = new File(this.getClass().getResource("/alldirectionstest.txt").toURI());
        kataTestFile = new File(this.getClass().getResource("/katademowordsearch.txt").toURI());
        subject = new PuzzleSolver();
    }

    @Test
    public void PuzzleSolverCanSolvePuzzleWithAtLeastOneWordEachDirection() throws FileNotFoundException {
        assertEquals(subject.solveWordSearch(allDirectionFile),"ONE: (0,0),(0,1),(0,2)\n" +
                "TWO: (1,0),(2,0),(3,0)\n" +
                "THREE: (1,0),(2,1),(3,2),(4,3),(5,4)\n" +
                "FOUR: (0,4),(1,3),(2,2),(3,1)\n" +
                "FIVE: (4,4),(3,4),(2,4),(1,4)\n" +
                "SIX: (6,2),(6,1),(6,0)\n" +
                "SEVEN: (4,2),(3,3),(2,4),(1,5),(0,6)\n" +
                "EIGH: (4,5),(3,4),(2,3),(1,2)");
    }

    @Test
    public void PuzzleSolverOutputMatchesSampleTestInKata() throws FileNotFoundException {
        assertEquals(subject.solveWordSearch(kataTestFile),"BONES: (0,6),(0,7),(0,8),(0,9),(0,10)\n" +
                "KHAN: (5,9),(5,8),(5,7),(5,6)\n" +
                "KIRK: (4,7),(3,7),(2,7),(1,7)\n" +
                "SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)\n" +
                "SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)\n" +
                "SULU: (3,3),(2,2),(1,1),(0,0)\n" +
                "UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)");
    }
}
