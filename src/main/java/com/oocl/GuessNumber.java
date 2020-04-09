package com.oocl;

public class GuessNumber {
    public static final String ERROR_MSG = "ERROR: Wrong Input, Input again";
    public static final int INPUT_LENGTH_LIMIT = 4;
    public static final int GAME_CHANGES_LIMIT = 6;
    public static final String ANSWER_PATTERN = "%dA%dB";

    private String answer;
    private int gameChanges = GAME_CHANGES_LIMIT;

    public GuessNumber(String answer) {
        this.answer = answer;
    }

    public static int getInputLengthLimit() {
        return INPUT_LENGTH_LIMIT;
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
        return result + String.format(ANSWER_PATTERN, a, b);
    }

}
