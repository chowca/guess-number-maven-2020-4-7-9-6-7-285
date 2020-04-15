package com.oocl;

import com.constant.Config;

import java.util.ArrayList;
import java.util.List;

public class RandomAnswerGenerator implements AnswerGenerator {

    public static final int DIGIT_BOUND = 10;
    public static final String REGEX_RATTERN = "[\\[, \\]]";

    public String generate() {
        List<Integer> answerList = new ArrayList<Integer>();
        int random = (int) (Math.random() * DIGIT_BOUND);
        for (int answerListIndex = 0; answerListIndex < Config.INPUT_LENGTH_LIMIT; answerListIndex++) {
            while (answerList.contains(random)) {
                random = (int) (Math.random() * DIGIT_BOUND);
            }
            answerList.add(random);
        }
        return answerList.toString().replaceAll(REGEX_RATTERN, "");
    }
}
