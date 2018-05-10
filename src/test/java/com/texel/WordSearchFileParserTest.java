package com.texel;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordSearchFileParserTest {
    File testFile;
    WordSearchFileParser subject;

    @Before
    public void initialize() throws URISyntaxException {
        testFile = new File(this.getClass().getResource("/helloworldsearch.txt").toURI());
        subject = new WordSearchFileParser();
    }

    @Test
    public void ParserShouldProperlyInitializeWordsArrayFromFileAndReturnInDataObject() throws IOException {
        WordSearchData data = subject.parseFile(testFile);
        assertEquals(data.getWords(), Arrays.asList("HELLO","WORLD"));
    }

    @Test
    public void ParserShouldProperlyInitializeSearchGridFromFileAndReturnInDataObject() throws IOException {
        WordSearchData data = subject.parseFile(testFile);
        List<List<Character>>compareList = new ArrayList<>(5);
        compareList.add(Arrays.asList('Z','H','Z','Z','Z'));
        compareList.add(Arrays.asList('Z','E','Z','Z','Z'));
        compareList.add(Arrays.asList('Z','L','Z','Z','Z'));
        compareList.add(Arrays.asList('Z','L','Z','Z','Z'));
        compareList.add(Arrays.asList('W','O','R','L','D'));
        assertEquals(data.getSearchGrid(),compareList);
    }
}
