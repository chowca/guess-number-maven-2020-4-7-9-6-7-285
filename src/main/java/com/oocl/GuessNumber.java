package com.oocl;

import com.constant.Config;

public class GuessNumber {

    private String answer;
    private int gameChanges = Config.GAME_CHANGES_LIMIT;

    public GuessNumber(String answer) {
        this.answer = answer;
    }

    public static int getInputLengthLimit() {
        return Config.INPUT_LENGTH_LIMIT;
    }

    public int getGameChanges() {
        return gameChanges;
    }

    public void minusGameChanges() {
        gameChanges--;
    }

    public String getAnswer() {
        return answer;
    }

    public String check(String input) {
        String result = "";
        int a = 0;
        int b = 0;
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            if (answer.indexOf(input.charAt(inputIndex)) == inputIndex) {
                a++;
            } else if (answer.indexOf(input.charAt(inputIndex)) != -1) {
                b++;
            }
        }
        return result + String.format(Config.ANSWER_PATTERN, a, b);
    }

}
