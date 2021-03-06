package com.oocl;

import com.constant.*;

public class App {

    public static final int GAME_OVER = 0;

    public static void main(String arg[]) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        RandomAnswerGenerator answerGenerator = new RandomAnswerGenerator();
        GuessNumber game = new GuessNumber(answerGenerator.generate());
        String inputString = "";
        String inputCheckResult;

        System.out.println(String.format(GameMsg.WELCOME_MSG, Config.INPUT_LENGTH_LIMIT));
        System.out.println(String.format(GameMsg.CHANCES_AND_INPUT_MSG, game.getGameChances(), Config.INPUT_LENGTH_LIMIT));
        do {
            inputCheckResult = "";
            while (!inputCheckResult.equals(ErrorMsg.PASS_MSG)) {
                inputString = inputReader.getInput();
                inputCheckResult = inputReader.verifyInput(inputString);
                if (!inputCheckResult.equals(ErrorMsg.PASS_MSG)) {
                    System.out.println(inputCheckResult);
                }
            }
            game.minusGameChances();
            if ((!game.check(inputString).equals(String.format(Config.WINNING_PATTERN, Config.INPUT_LENGTH_LIMIT))) && (game.getGameChances() > GAME_OVER)) {
                System.out.println(game.check(inputString));
                System.out.println(String.format(GameMsg.CHANCES_AND_INPUT_MSG, game.getGameChances(), Config.INPUT_LENGTH_LIMIT));
            } else if (game.check(inputString).equals(String.format(Config.WINNING_PATTERN, Config.INPUT_LENGTH_LIMIT))) {
                System.out.println(GameMsg.WIN_MSG);
                break;
            } else {
                System.out.println(String.format(GameMsg.LOSE_MSG, game.getAnswer()));
            }
        } while (game.getGameChances() > GAME_OVER);
    }
}
