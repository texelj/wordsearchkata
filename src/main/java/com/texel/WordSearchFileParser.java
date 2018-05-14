package com.texel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jacob on 5/9/2018.
 */
public class WordSearchFileParser {
    public static WordSearchData parseFile(File parseFile) throws FileNotFoundException {
        WordSearchData data = new WordSearchData();
        FileReader filereader = new FileReader(parseFile);
        BufferedReader reader = new BufferedReader(filereader);

        try {
            data.setWords(parseWordsLine(reader));
            data.setSearchGrid(parseSearchGrid(reader));

        } catch (IOException e) {
            e.printStackTrace();
            data.setWords(new ArrayList<>());
            data.setSearchGrid(new ArrayList<>());
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

    private static List<String> parseWordsLine(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(","));
    }

    private static List<List<Character>> parseSearchGrid(BufferedReader reader) throws IOException {
        List<List<Character>> grid = new ArrayList<>();
        String gridLine = reader.readLine();
        while(gridLine!=null){
            String[] characters = gridLine.split(",");
            List<Character> lineList = new ArrayList<>(characters.length);
            for(int i=0; i<characters.length;i++){
                lineList.add(characters[i].charAt(0));
            }
            grid.add(lineList);
            gridLine=reader.readLine();
        }
        return grid;
    }
}
