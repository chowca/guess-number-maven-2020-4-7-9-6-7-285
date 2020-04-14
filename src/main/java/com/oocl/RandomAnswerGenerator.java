package com.oocl;

import com.constant.Config;

import java.util.ArrayList;
import java.util.List;

public class RandomAnswerGenerator implements AnswerGenerator {
    public String generate() {
        List<Integer> answerList = new ArrayList<Integer>();
        for (int answerListIndex = 0; answerListIndex < Config.INPUT_LENGTH_LIMIT; answerListIndex++) {
            int random = (int) (Math.random() * 10);
            if (answerListIndex != 0) {
                while (answerList.contains(random)) {
                    random = (int) (Math.random() * 10);
                }
            }
            answerList.add(random);
        }
        return answerList.toString().replaceAll("[\\[, \\]]", "");
    }
}
