package com.oocl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static final String ERROR_MSG = "ERROR: Wrong Input, Input again";
    public static final int INPUT_LENGTH_LIMIT = 4;
    public static final int GAME_CHANGES_LIMIT = 6;

    private String answer;
    private int gameChanges = GAME_CHANGES_LIMIT;

    public static int getInputLengthLimit() {
        return INPUT_LENGTH_LIMIT;
    }

    public int getGameChanges() {
        return gameChanges;
    }

    public void minusGameChanges() {
        gameChanges--;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public static void main(String arg[]) {
        App game = new App();
        game.generateAnswer();
        String inputString = "";
        String inputCheckResult = "";
        Scanner userInput = new Scanner(System.in);

        System.out.println(String.format("Welcome to Guess Number!\nThe answer is a %d digit number without duplicate digit.", game.getInputLengthLimit()));
        System.out.println(String.format("You have %d chances to guess.\nPlease input a %d digit number.", game.getGameChanges(), game.getInputLengthLimit()));
        do {
            inputCheckResult = "";
            while (!inputCheckResult.equals("PASS")) {
                inputString = userInput.nextLine();
                inputCheckResult = game.verifyInput(inputString);
                if (!inputCheckResult.equals("PASS")) {
                    System.out.println(inputCheckResult);
                }
            }

            if ((!game.check(inputString).equals(String.format("%dA0B", game.getInputLengthLimit()))) && (game.getGameChanges() > 0)) {
                System.out.println(String.format("%s\nYou have %d chances to guess.\nPlease input a %d digit number.", game.check(inputString), game.getGameChanges(), game.getInputLengthLimit()));
            } else if (game.check(inputString).equals(String.format("%dA0B", game.getInputLengthLimit()))) {
                System.out.println("You Win!");
                break;
            } else {
                System.out.println("You Lose");
            }
            game.minusGameChanges();
        } while (game.getGameChanges() >= 0);
    }
}
