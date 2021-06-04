package baseball;

import java.util.ArrayList;

public class Computer {
    private static final String RESTART = "1";

    private boolean isRestart;
    private ArrayList<Integer> answerNumberList;

    private final BaseballNumberListGenerator baseballNumberListGenerator;
    private final BaseballGameResultMatcher baseballGameResultMatcher;

    public Computer() {
        this.baseballNumberListGenerator = new BaseballNumberListGenerator();
        this.baseballGameResultMatcher = new BaseballGameResultMatcher();
    }

    public void generateBaseballNumber() {
        this.answerNumberList = baseballNumberListGenerator.generateBaseballNumberList();
    }

    public void setGuessBaseballNumber(String guessBaseballNumber) {
        ArrayList<Integer> guessNumberList = parseStringToIntegerList(guessBaseballNumber);
        baseballGameResultMatcher.match(answerNumberList, guessNumberList);
        baseballGameResultMatcher.printBaseballGameResult();
    }

    public boolean isWrongGuess() {
        return !baseballGameResultMatcher.isCorrect();
    }

    public void setCodeForRestartOrNot(String userInput) {
        if (userInput.equals(RESTART)) {
            this.isRestart = true;
            return;
        }
        this.isRestart = false;
    }

    public boolean isRestart() {
        return this.isRestart;
    }

    private ArrayList<Integer> parseStringToIntegerList(String guessBaseballNumber) {
        char[] guessBaseballNumberChars = guessBaseballNumber.toCharArray();
        ArrayList<Integer> guessBaseballNumberList = new ArrayList<>();
        for (char guessBaseballNumberChar : guessBaseballNumberChars) {
            guessBaseballNumberList.add(guessBaseballNumberChar - '0');
        }
        return guessBaseballNumberList;
    }
}
