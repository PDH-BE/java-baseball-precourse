package baseball;

import java.util.ArrayList;

public class BaseballGameResultMatcher {
    private int strikes;
    private int balls;
    private boolean isCorrect;
    private int listSize;

    public void match(ArrayList<Integer> answerNumberList, ArrayList<Integer> guessNumberList) {
        initResources();
        this.listSize = answerNumberList.size();
        for (int index = 0; index < guessNumberList.size(); index++) {
            int curValue = guessNumberList.get(index);
            competeStrikesAndBalls(answerNumberList, index, curValue);
        }
        if (strikes == guessNumberList.size()) {
            this.isCorrect = true;
        }
    }

    public void printBaseballGameResult() {
        if (this.strikes == 0 && this.balls == 0) {
            System.out.println("Nothing");
            return;
        }
        if (this.strikes != 0 && this.balls == 0) {
            System.out.println(this.strikes + " strikes");
            if (this.strikes == this.listSize) {
                System.out.println("세 개의 숫자를 모두 맞췄습니다. 게임 종료");
            }
            return;
        }
        if (this.strikes == 0 && this.balls != 0) {
            System.out.println(this.balls + " balls");
            return;
        }
        System.out.println(this.strikes + " strikes, " + this.balls + " balls");
    }

    public boolean isCorrect() {
        return this.isCorrect;
    }

    private void initResources() {
        this.strikes = 0;
        this.balls = 0;
        this.isCorrect = false;
    }

    private void competeStrikesAndBalls(ArrayList<Integer> answerNumberList, int index, int curValue) {
        if (answerNumberList.contains(curValue)) {
            if (answerNumberList.indexOf(curValue) == index) {
                this.strikes++;
                return;
            }
            this.balls++;
        }
    }
}
