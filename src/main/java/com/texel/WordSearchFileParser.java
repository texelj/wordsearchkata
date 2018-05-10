package com.texel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordSearchFileParser {
    public WordSearchData parseFile(File parseFile) throws FileNotFoundException {
        WordSearchData data = new WordSearchData();
        FileReader filereader = new FileReader(parseFile);
        BufferedReader reader = new BufferedReader(filereader);

        try {
            String wordLine = reader.readLine();

            data.setWords(Arrays.asList(wordLine.split(",")));

            
        } catch (IOException e) {
            e.printStackTrace();
            data.setWords(new ArrayList<String>());
        } finally {
            try {
                if (reader != null)
                    reader.close();

                if (filereader != null)
                    filereader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        return data;
    }
}
