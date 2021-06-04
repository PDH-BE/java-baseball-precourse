package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Computer {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int NUMBER_OF_ANSWER_DIGITS = 3;
    private static final String RESTART = "1";

    private final Map<Integer, Integer> answerNumberDigitMap;
    private final ArrayList<Integer> userNumberDigitList;
    private int strikes;
    private int balls;
    private boolean isWrong;
    private boolean isRestart;

    public Computer() {
        this.answerNumberDigitMap = new HashMap<>();
        this.userNumberDigitList = new ArrayList<>();
    }

    public void createAnswerBaseballNumber() {
        this.createAnswerNumberDigitMap();
    }

    public void printGuessResult(String userInput) {
        parseBaseballNumberStringToIntegerDigitList(userInput);
        processGuessResult();
    }

    public boolean isWrongGuess() {
        return this.isWrong;
    }

    public void setCodeForRestartOrNot(String userInput) {
        if (userInput.equals(RESTART)) {
            this.isRestart = true;
            return;
        }
        this.isRestart = false;
    }

    private void createAnswerNumberDigitMap() {
        answerNumberDigitMap.clear();
        while (answerNumberDigitMap.size() < NUMBER_OF_ANSWER_DIGITS) {
            int createdRandomNumberDigit = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (isInAnswerDigitMap(createdRandomNumberDigit)) {
                continue;
            }
            answerNumberDigitMap.put(createdRandomNumberDigit, answerNumberDigitMap.size());
        }
    }

    private boolean isInAnswerDigitMap(int guessDigitValue) {
        return answerNumberDigitMap.containsKey(guessDigitValue);
    }

    private void parseBaseballNumberStringToIntegerDigitList(String baseballNumberString) {
        char[] charDigits = baseballNumberString.toCharArray();
        userNumberDigitList.clear();
        for (char charDigit : charDigits) {
            int digit = charDigit - '0';
            userNumberDigitList.add(digit);
        }
    }

    private void processGuessResult() {
        strikes = 0;
        balls = 0;

        for (int index = 0; index < userNumberDigitList.size(); index++) {
            int userDigitValue = userNumberDigitList.get(index);
            competeStrikesAndBalls(index, userDigitValue);
        }

        printResult(strikes, balls);

        if (strikes == NUMBER_OF_ANSWER_DIGITS) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            this.isWrong = false;
        } else {
            this.isWrong = true;
        }
    }

    private void competeStrikesAndBalls(int index, int userDigitValue) {
        if (isInAnswerDigitMap(userDigitValue)) {
            if (isEqualIndexBetweenUserDigitAndAnswerDigit(index, userDigitValue)) {
                strikes++;
                return;
            }
            balls++;
        }
    }

    private boolean isEqualIndexBetweenUserDigitAndAnswerDigit(int index, int guessDigitValue) {
        return answerNumberDigitMap.get(guessDigitValue) == index;
    }

    private void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("Nothing");
            return;
        }
        if (strikes != 0 && balls == 0) {
            System.out.println(strikes + " strike");
            return;
        }
        if (strikes == 0 && balls != 0) {
            System.out.println(balls + " ball");
            return;
        }
        System.out.println(strikes + " strike, " + balls + " ball");
    }
}
