package com.oocl;

public class App {

    public static void main(String arg[]) {
        GuessNumber game = new GuessNumber();
        ConsoleInputReader inputReader = new ConsoleInputReader();
        game.generateAnswer();
        String inputString = "";
        String inputCheckResult = "";

        System.out.println(String.format("Welcome to Guess Number!\nThe answer is a %d digit number without duplicate digit.", game.getInputLengthLimit()));
        System.out.println(String.format("You have %d chances to guess.\nPlease input a %d digit number.", game.getGameChanges(), game.getInputLengthLimit()));
        do {
            game.minusGameChanges();
            inputCheckResult = "";
            while (!inputCheckResult.equals("PASS")) {
                inputString = inputReader.getInput();
                inputCheckResult = inputReader.verifyInput(inputString);
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
        } while (game.getGameChanges() >= 0);
    }
}
