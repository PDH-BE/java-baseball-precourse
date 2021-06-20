package numberbaseballgame;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserInputValidator userInputValidator = new UserInputValidator();
    private static final NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController(new BaseballNumberGenerator(),new NumberBaseballGameResultMatcher());

    public static void main(String[] args) {
        do {
            numberBaseballGameController.startGame();
            while(!numberBaseballGameController.isCorrect(userInputBaseballNumberUntilIsValid()));
        } while (!numberBaseballGameController.exitGame(userInputCodeForExitOrNotUntilIsValid()));
    }

    private static String userInputBaseballNumberUntilIsValid() {
        while (true) {
            System.out.println("숫자를 입력하세요 : ");
            String userInput = scanner.next();
            try {
                userInputValidator.validBaseballNumber(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String userInputCodeForExitOrNotUntilIsValid() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = scanner.next();
            try {
                userInputValidator.validCodeForExitOrNot(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}