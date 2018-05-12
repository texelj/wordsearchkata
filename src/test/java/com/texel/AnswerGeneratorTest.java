package com.texel;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jacob on 5/12/2018.
 */
public class AnswerGeneratorTest {

    @Test
    public void AnswerGeneratorReturnsString(){
        assertEquals(AnswerGenerator.generate(WordDirection.DIAGONAL_DESC,"",0,0),": ");
    }

}
