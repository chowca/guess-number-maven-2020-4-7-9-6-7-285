package com.oocl;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AppTest {
    @Test
    public void should_return_for_exact_answer() {
        //given
        App game = new App();
        String answer = "1234";
        String input = "1234";
        //when
        game.setAnswer(answer);
        game.addGuessNumbers(input);
        //then
        assertThat(game.check(input), is("4A0B"));
    }

    @Test
    public void should_return_for_totally_wrong_answer() {
        //given
        App game = new App();
        String answer = "1234";
        String input = "0987";
        //when
        game.setAnswer(answer);
        game.addGuessNumbers(input);
        assertThat(game.check(input), is("0A0B"));
    }

    @Test
    public void should_return_for_correct_number_and_position() {
        //given
        App game = new App();
        String answer = "1234";
        String input = "1289";
        //when
        game.setAnswer(answer);
        game.addGuessNumbers(input);
        //then
        assertThat(game.check(input), is("2A0B"));
    }

    @Test
    public void should_return_for_correct_number_not_position() {
        //given
        App game = new App();
        String answer = "1234";
        String input = "4321";
        //when
        game.setAnswer(answer);
        game.addGuessNumbers(input);
        //then
        assertThat(game.check(input), is("0A4B"));
    }

    @Test
    public void should_return_for_partial_correct_number_and_position() {
        //given
        App game = new App();
        String answer = "1234";
        String input = "1243";
        //when
        game.setAnswer(answer);
        game.addGuessNumbers(input);
        //then
        assertThat(game.check(input), is("2A2B"));
    }

    @Test
    public void should_verify_input_integrity() {
        //given
        App game = new App();
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
}
