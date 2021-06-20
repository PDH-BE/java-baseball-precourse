package numberbaseballgame;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int NUMBER_OF_DIGITS = 3;

    public ArrayList<Integer> generate() {
        Set<Integer> digitSet = generateDigitSet();
        return new ArrayList<>(digitSet);
    }

    private Set<Integer> generateDigitSet() {
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
