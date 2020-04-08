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
        String result = "";
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
        String result = "";
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
        String result = "";
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
        String result = "";
        //when
        game.setAnswer(answer);
        game.addGuessNumbers(input);
        //then
        assertThat(game.check(input), is("0A4B"));
    }
}
