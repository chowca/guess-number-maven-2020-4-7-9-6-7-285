package com.oocl;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class GuessNumberTest {

    private GuessNumber game;

    @Before
    public void setUp() throws Exception {
        // before method
        game = new GuessNumber();
        String answer = "1234";
        game.setAnswer(answer);
    }

    @Test
    public void should_return_for_exact_answer() {
        //given
        String input = "1234";
        //when
        //then
        assertThat(game.check(input), is("4A0B"));
    }

    @Test
    public void should_return_for_totally_wrong_answer() {
        //given
        String input = "0987";
        //when
        assertThat(game.check(input), is("0A0B"));
    }

    @Test
    public void should_return_for_correct_number_and_position() {
        //given
        String input = "1289";
        //when
        //then
        assertThat(game.check(input), is("2A0B"));
    }

    @Test
    public void should_return_for_correct_number_not_position() {
        //given
        String input = "4321";
        //when
        //then
        assertThat(game.check(input), is("0A4B"));
    }

    @Test
    public void should_return_for_partial_correct_number_and_position() {
        //given
        String input = "1243";
        //when
        //then
        assertThat(game.check(input), is("2A2B"));
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
        assertThat(game.verifyInput(inputNormal), is("PASS"));
        assertThat(game.verifyInput(inputLessDigit), is("ERROR: Wrong Input, Input again"));
        assertThat(game.verifyInput(inputExtraDigit), is("ERROR: Wrong Input, Input again"));
        assertThat(game.verifyInput(inputDuplicateDigit), is("ERROR: Wrong Input, Input again"));
        assertThat(game.verifyInput(inputNotdigit), is("ERROR: Wrong Input, Input again"));
    }

    @Test
    public void should_return_random_answer() {
        //given
        //when
        //then
        assertEquals(true, game.generateAnswer());
    }
}
