package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballNumberListGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int NUMBER_OF_DIGITS = 3;

    public ArrayList<Integer> generateBaseballNumberList() {
        Set<Integer> threeDigitSet = generateThreeDigitSet();
        return new ArrayList<>(threeDigitSet);
    }

    private Set<Integer> generateThreeDigitSet() {
        Set<Integer> digitSet = new HashSet<>();
        while (digitSet.size() < NUMBER_OF_DIGITS) {
            int randomValue = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (digitSet.contains(randomValue)) {
                continue;
            }
            digitSet.add(randomValue);
        }
        return digitSet;
    }
}
