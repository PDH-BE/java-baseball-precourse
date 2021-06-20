package numberbaseballgame;

import java.util.ArrayList;

public class NumberBaseballGameResultMatcher {
    public boolean match(ArrayList<Integer> answerNumberList, ArrayList<Integer> guessNumberList) {
        int strikes = 0;
        int balls = 0;

        for (int guessIndex = 0; guessIndex < guessNumberList.size(); guessIndex++) {
            int guessValue = guessNumberList.get(guessIndex);
            if ((answerNumberList.contains(guessValue)) && (answerNumberList.indexOf(guessValue) == guessIndex)) {
                strikes++;
                continue;
            }
            if ((answerNumberList.contains(guessValue)) && (answerNumberList.indexOf(guessValue) != guessIndex)) {
                balls++;
            }
        }

        printBaseballGameResult(guessNumberList.size(), strikes, balls);

        return strikes == guessNumberList.size();
    }

    private void printBaseballGameResult(int guessNumberSize, int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("Nothing");
            return;
        }
        if (strikes != 0 && balls == 0) {
            System.out.println(strikes + " strikes");
            if (strikes == guessNumberSize) {
                System.out.println("세 개의 숫자를 모두 맞췄습니다. 게임 종료");
            }
            return;
        }
        if (strikes == 0 && balls != 0) {
            System.out.println(balls + " balls");
            return;
        }
        System.out.println(strikes + " strikes, " + balls + " balls");
    }
}
