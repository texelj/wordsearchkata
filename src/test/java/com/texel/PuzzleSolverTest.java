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
    private static PuzzleSolver subject;
    @Before
    public void initialize() throws URISyntaxException {
        allDirectionFile = new File(this.getClass().getResource("/alldirectionstest.txt").toURI());
        subject = new PuzzleSolver();
    }

    @Test
    public void PuzzleSolverCanSolvePuzzleWithAtLeastOneWordEachDirection() throws FileNotFoundException {
        assertEquals(subject.solveWordSearch(allDirectionFile),"ONE: (0,0),(0,1),(0,2)" +
                "\nTWO: (1,0),(2,0),(3,0)\nTHREE: (1,0),(2,1),(3,2),(4,3),(5,4)\nFOUR: (0,4),(1,3),(2,2),(3,1)" +
                "\nFIVE: (4,4),(3,4),(2,4),(1,4)\nSIX: (6,2),(6,1),(6,0)\nSEVEN: (4,2),(3,3),(2,4),(1,5),(0,6)" +
                "\nEIGH: (4,5),(3,4),(2,3),(1,2)");
    }
}
