package com.oocl;

import com.constant.*;

import java.util.Scanner;


public class ConsoleInputReader implements InputReader {

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String verifyInput(String input) {
        String errorMsg = ErrorMsg.PASS_MSG;
        if (isInputLengthMatchAnswerLength(input)) {
            errorMsg = ErrorMsg.INPUT_LENGTH_NOT_MATCH_ERROR_MSG;
        } else {
            for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
                //check for not digit error
                if (!Character.isDigit(input.charAt(inputIndex))) {
                    errorMsg = ErrorMsg.INPUT_IS_NOT_DIGIT_ERROR_MSG;
                    break;
                }
                //check for duplicate digit error
                if ((input.lastIndexOf(input.charAt(inputIndex)) != inputIndex)) {
                    errorMsg = ErrorMsg.INPUT_DUPLICATE_DIGIT_ERROR_MSG;
                    break;
                }
            }
        }
        return errorMsg;
    }

    private boolean isInputLengthMatchAnswerLength(String input) {
        return input.length() != Config.INPUT_LENGTH_LIMIT;
    }
}
