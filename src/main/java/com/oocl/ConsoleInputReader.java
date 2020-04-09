package com.oocl;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    public static final String ERROR_MSG = "ERROR: Wrong Input, Input again";
    public static final int INPUT_LENGTH_LIMIT = 4;

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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
}
