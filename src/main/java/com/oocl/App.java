package com.oocl;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static final String ERROR_MSG = "ERROR: Wrong Input, Input again";
    public static final int INPUT_LENGTH_LIMIT = 4;
    private String answer;
    private List<String> guessNumbers = new ArrayList<String>();

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getInputs() {
        guessNumbers = new ArrayList<String>();
        guessNumbers = this.guessNumbers;
        return guessNumbers;
    }

    public void addGuessNumbers(String guessNumber) {
        this.guessNumbers.add(guessNumber);
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
        return result += String.format("%dA%dB", a, b);
    }

    public String verifyInput(String input) {
        String eorrorMsg = "PASS";
        if (input.length() != INPUT_LENGTH_LIMIT) {
            eorrorMsg = ERROR_MSG;
        } else {
            for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
                if((input.lastIndexOf(input.charAt(inputIndex)) != inputIndex) || (!Character.isDigit(input.charAt(inputIndex)))){
                    eorrorMsg = ERROR_MSG;
                    break;
                }
            }
        }
        return eorrorMsg;
    }
}
