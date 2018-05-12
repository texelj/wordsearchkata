package com.texel;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jacob on 5/12/2018.
 */
public class AnswerGeneratorTest {

    @Test
    public void AnswerGeneratorReturnsSeparatorString(){
        assertEquals(AnswerGenerator.generate(WordDirection.DIAGONAL_DESC,"",0,0),": ");
    }

    @Test
    public void AnswerGeneratorReturnsAnswerStringForWord(){
        assertEquals(AnswerGenerator.generate(WordDirection.DIAGONAL_ASC,"HELLO",4,0),"HELLO: (0,4),(1,3),(2,2),(3,1),(4,0)");
    }

}
