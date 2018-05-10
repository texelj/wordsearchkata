package com.texel;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordSearchFileParserTest {
    File testFile;
    WordSearchFileParser subject;

    @Before
    public void initialize() throws URISyntaxException, MalformedURLException {
        testFile = new File(this.getClass().getResource("/helloworldsearch.txt").toURI());
        subject = new WordSearchFileParser();
    }

    @Test
    public void ParserShouldProperlyInitializeWordsArrayFromFileAndReturnInDataObject() throws IOException {
        WordSearchData data = subject.parseFile(testFile);
        assertEquals(data.getWords(), Arrays.asList("HELLO","WORLD"));
    }

}
