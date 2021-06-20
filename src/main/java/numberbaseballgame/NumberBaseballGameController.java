package numberbaseballgame;

import java.util.ArrayList;

public class NumberBaseballGameController {
    private static final String CODE_FOR_EXIT = "2";
    private ArrayList<Integer> answerNumberList;

    private final BaseballNumberGenerator baseballNumberGenerator;
    private final NumberBaseballGameResultMatcher numberBaseballGameResultMatcher;

    public NumberBaseballGameController(BaseballNumberGenerator baseballNumberGenerator, NumberBaseballGameResultMatcher numberBaseballGameResultMatcher) {
        this.baseballNumberGenerator = baseballNumberGenerator;
        this.numberBaseballGameResultMatcher = numberBaseballGameResultMatcher;
    }

    public void startGame() {
        this.answerNumberList = baseballNumberGenerator.generate();
    }

    public boolean isCorrect(String guessBaseballNumber) {
        ArrayList<Integer> guessNumberList = parseStringToIntegerList(guessBaseballNumber);
        return numberBaseballGameResultMatcher.match(answerNumberList, guessNumberList);
    }

    public boolean exitGame(String codeForExitOrNot) {
        return codeForExitOrNot.equals(CODE_FOR_EXIT);
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
