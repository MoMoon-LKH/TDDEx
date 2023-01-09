package chap05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest {

    @Test  // 해당 @Test를 붙힌 메서드는 private이면 안된다.
    void sum(){
        int result = 2 + 3;
        assertEquals(5, result);
    }
}
