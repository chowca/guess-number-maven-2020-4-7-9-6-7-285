package com.oocl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConsoleInputReaderTest {

    private ConsoleInputReader reader;

    @Before
    public void setUp() throws Exception {
        // before method
        reader = new ConsoleInputReader();
    }

    @Test
    public void should_return_input_when_get_input() {
        String expected = "1234";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);
        String input = reader.getInput();
        Assert.assertEquals(expected, input);
    }

    @Test
    public void should_verify_input_integrity() {
        //given
        String inputNormal = "1234";
        String inputLessDigit = "12";
        String inputExtraDigit = "12345";
        String inputDuplicateDigit = "1134";
        String inputNotdigit = "1$a\n";
        //when
        //then
        assertThat(reader.verifyInput(inputNormal), is("PASS"));
        assertThat(reader.verifyInput(inputLessDigit), is("ERROR: Wrong Input, Input again"));
        assertThat(reader.verifyInput(inputExtraDigit), is("ERROR: Wrong Input, Input again"));
        assertThat(reader.verifyInput(inputDuplicateDigit), is("ERROR: Wrong Input, Input again"));
        assertThat(reader.verifyInput(inputNotdigit), is("ERROR: Wrong Input, Input again"));
    }
}