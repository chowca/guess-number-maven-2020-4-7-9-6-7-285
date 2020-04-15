package com.oocl;

import com.constant.Config;

public class GuessNumber {

    public static final int CHAR_NOT_FOUND = -1;
    private String answer;
    private int gameChances = Config.GAME_CHANCES_LIMIT;

    public GuessNumber(String answer) {
        this.answer = answer;
    }

    public int getGameChances() {
        return gameChances;
    }

    public void minusGameChances() {
        gameChances--;
    }

    public String getAnswer() {
        return answer;
    }

    public String check(String input) {
        int numOfCorrectDigitCorrectPosition = 0;
        int numOfCorrectDigitWrongPosition = 0;
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            if (answer.indexOf(input.charAt(inputIndex)) == inputIndex) {
                numOfCorrectDigitCorrectPosition++;
            } else if (answer.indexOf(input.charAt(inputIndex)) != CHAR_NOT_FOUND) {
                numOfCorrectDigitWrongPosition++;
            }
        }
        return String.format(Config.ANSWER_PATTERN, numOfCorrectDigitCorrectPosition, numOfCorrectDigitWrongPosition);
    }

}
