package baseball;

import numberbaseballgame.BaseballNumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberGeneratorTest {
    private static BaseballNumberGenerator baseballNumberGenerator;

    @BeforeAll
    static void init(){
        baseballNumberGenerator = new BaseballNumberGenerator();
    }

    @Test
    @DisplayName("서로 다른 세자릿수 리스트 생성 테스트")
    void generateThreeDigitIntegerList(){
        ArrayList<Integer> generatedList = baseballNumberGenerator.generate();
        Set<Integer> toSet = new HashSet<>(generatedList);

        assertEquals(3,toSet.size());
    }

}