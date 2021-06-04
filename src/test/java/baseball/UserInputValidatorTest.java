package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputValidatorTest {
    private static UserInputValidator userInputValidator;

    @BeforeAll
    static void initUser() {
        userInputValidator = new UserInputValidator();
    }

    @Test
    @DisplayName("유저로부터 입력받은 야구 숫자 값이 숫자가 아닐 때")
    void isNotNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userInputValidator.validBaseballNumber("abc");
        });

        assertEquals("모두 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유저로부터 입력받은 야구 숫자가 세자릿수가 아닐 때")
    void isNotThreeDigit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userInputValidator.validBaseballNumber("1234");
        });

        assertEquals("세 자리의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유저로부터 입력받은 야구 숫자 값이 0을 포함할 때")
    void isZeroInNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userInputValidator.validBaseballNumber("110");
        });

        assertEquals("0을 포함해서는 안됩니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유저로부터 입력받은 야구 숫자에 중복이 있을 때")
    void isSameDigit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userInputValidator.validBaseballNumber("112");
        });

        assertEquals("모두 다른 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유저로부터 입력받은 재시작 여부 값이 숫자가 아닐 때")
    void isNotNumberCode() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userInputValidator.validCodeForRestartOrNot("abc");
        });

        assertEquals("재시작 여부 입력은 1 또는 2 여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유저로부터 입력받은 재시작 여부 값이 1 또는 2가 아닌 숫자일 때")
    void isNotValidNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userInputValidator.validCodeForRestartOrNot("3");
        });

        assertEquals("재시작 여부 입력은 1 또는 2 여야 합니다.", exception.getMessage());
    }
}