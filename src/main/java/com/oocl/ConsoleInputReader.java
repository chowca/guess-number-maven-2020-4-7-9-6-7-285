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
        String eorrorMsg = "PASS";
        if (input.length() != Config.INPUT_LENGTH_LIMIT) {
            eorrorMsg = ErrorMsg.ERROR_MSG;
        } else {
            for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
                if ((input.lastIndexOf(input.charAt(inputIndex)) != inputIndex) || (!Character.isDigit(input.charAt(inputIndex)))) {
                    eorrorMsg = ErrorMsg.ERROR_MSG;
                    break;
                }
            }
        }
        return eorrorMsg;
    }
}
