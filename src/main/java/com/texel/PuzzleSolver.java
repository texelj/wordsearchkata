package com.texel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;

/**
 * Created by jacob on 5/12/2018.
 */
public class PuzzleSolver {
    public static String solveWordSearch(File wordSearchFile) throws FileNotFoundException {
        WordSearchFileParser parser = new WordSearchFileParser();
        WordSearchData data = parser.parseFile(wordSearchFile);
        WordFinder finder = new WordFinder(data.getSearchGrid());
        return data.getWords().stream().map(finder::findWord).collect(Collectors.joining("\n"));
    }
}
