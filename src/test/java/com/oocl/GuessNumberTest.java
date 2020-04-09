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
        String answer = "1234";
        game = new GuessNumber(answer);
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
}
