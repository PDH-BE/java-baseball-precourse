package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {
    private static final int NUMBER_OF_ANSWER_DIGITS = 3;

    public void validBaseballNumber(String baseballNumberString) throws IllegalArgumentException {
        if (!isNumber(baseballNumberString)) {
            throw new IllegalArgumentException("모두 숫자여야 합니다.");
        }
        if (!isThreeDigits(baseballNumberString)) {
            throw new IllegalArgumentException("세 자리의 숫자여야 합니다.");
        }
        if (isZeroInNumber(baseballNumberString)) {
            throw new IllegalArgumentException("0을 포함해서는 안됩니다.");
        }
        if (isSameDigit(baseballNumberString)) {
            throw new IllegalArgumentException("모두 다른 숫자여야 합니다.");
        }
    }

    public void validCodeForRestartOrNot(String codeForRestartOrNot) throws IllegalArgumentException {
        if (!(codeForRestartOrNot.equals("1") || codeForRestartOrNot.equals("2"))) {
            throw new IllegalArgumentException("재시작 여부 입력은 1 또는 2 여야 합니다.");
        }
    }

    private boolean isNumber(String baseballNumberString) {
        return baseballNumberString.chars().allMatch(Character::isDigit);
    }

    private boolean isThreeDigits(String baseballNumberString) {
        return baseballNumberString.length() == NUMBER_OF_ANSWER_DIGITS;
    }

    private boolean isZeroInNumber(String baseballNumberString) {
        char[] baseballNumberChars = baseballNumberString.toCharArray();
        for (char baseballNumberChar : baseballNumberChars) {
            if (baseballNumberChar == '0') {
                return true;
            }
        }
        return false;
    }

    private boolean isSameDigit(String baseballNumberString) {
        Set<Character> uniqueChars = new HashSet<>();
        char[] baseballNumberChars = baseballNumberString.toCharArray();
        for (char baseballNumberChar : baseballNumberChars) {
            uniqueChars.add(baseballNumberChar);
        }
        return uniqueChars.size() < NUMBER_OF_ANSWER_DIGITS;
    }
}
