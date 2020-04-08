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
                if ((input.lastIndexOf(input.charAt(inputIndex)) != inputIndex) || (!Character.isDigit(input.charAt(inputIndex)))) {
                    eorrorMsg = ERROR_MSG;
                    break;
                }
            }
        }
        return eorrorMsg;
    }

    public boolean generateAnswer() {
        boolean isAnswerGenerated = false;
        String generatedAnswer = "";
        List<Integer> answerList = new ArrayList<Integer>();
        for (int answerListIndex = 0; answerListIndex < INPUT_LENGTH_LIMIT; answerListIndex++) {
            int random = (int) (Math.random() * 10);
            if (answerListIndex == 0) {
                answerList.add(random);
            } else {
                while (answerList.contains(random)) {
                    random = (int) (Math.random() * 10);
                }
                answerList.add(random);
            }
        }
        generatedAnswer = answerList.toString().replaceAll("[\\[, \\]]", "");
        if (generatedAnswer.length() == INPUT_LENGTH_LIMIT) {
            setAnswer(generatedAnswer);
            isAnswerGenerated = true;
        }
        return isAnswerGenerated;
    }
}
