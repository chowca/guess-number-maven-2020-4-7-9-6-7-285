package com.oocl;

import java.util.Scanner;

public class App {

    public static void main(String arg[]) {
        GuessNumber game = new GuessNumber();
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
                System.out.println(String.format("You Lose! Anser: %s", game.getAnswer()));
            }
            game.minusGameChanges();
        } while (game.getGameChanges() >= 0);
    }
}
