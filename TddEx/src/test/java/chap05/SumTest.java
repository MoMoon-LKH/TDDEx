package chap05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest {

    
    /*
      검사 메서드
        - assertEquals(expected, actual) : 실제 값(actual)이 기대하는 값(expected)과 같은지 검사
        - assertNotEquals(unexpected, actual) : 실제 값이 특정 값이 같지 않은지 검사
        - assertSame(Object expected, Object actual) : 두 객체가 동일한지 검사
        - assertNotSame(Object unexpected, Object actual) : 두 객체가 동일하지 않은 객체인지 검사
        - assertTrue(boolean condition) : 값이 true 인지 검사
        - assertFalse(boolean condition) : 값이 false 인지 검사
        - assertNull(Object actual) : 값이 null 인지 검사
        - assertNotNull(Object actual) : 값이 null 아닌지 검사
        - fail() : 테스트를 실패 처리

      Exception 발생 유무 검사 메서드
        - assertThrows(Class<T> expectedType, Executable executable) : executable 을 실행한 결과로 지정한 타입의 익셉션이 발생하는지 검사
        - assertDoesNotThrow(Executable executable) : executable 을 실행한 결과로 익셉션이 발생하지않는지 검사
     */
    
    @Test  // 해당 @Test를 붙힌 메서드는 private이면 안된다.
    void sum(){
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Disabled
    @Test
    void assertThrowsExceptionTest() {

        assertThrows(IllegalArgumentException.class,
                () -> {

                });
    }


}
