package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Computer computer = new Computer();
        final UserInputValidator user = new UserInputValidator();

        do {
            computer.createAnswerBaseballNumber();
            guess(computer, user, scanner);
            String userCodeForRestartOrNot = inputCodeForRestartOrNotUntilIsValid(scanner, user);
            computer.setCodeForRestartOrNot(userCodeForRestartOrNot);
        } while (computer.isRestart());
    }

    private static void guess(Computer computer, UserInputValidator user, Scanner scanner) {
        do {
            String userGuessBaseballNumber = inputBaseballNumberUntilIsValid(user, scanner);
            computer.printGuessResult(userGuessBaseballNumber);
        } while (computer.isWrongGuess());
    }

    private static String inputBaseballNumberUntilIsValid(UserInputValidator user, Scanner scanner) {
        while (true) {
            System.out.println("숫자를 입력하세요 : ");
            String userInput = scanner.next();
            try {
                user.validBaseballNumber(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputCodeForRestartOrNotUntilIsValid(Scanner scanner, UserInputValidator user) {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = scanner.next();
            try {
                user.validCodeForRestartOrNot(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}