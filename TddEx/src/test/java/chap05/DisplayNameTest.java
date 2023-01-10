package chap05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayNameTest {

    @DisplayName("값 같은지 비교")
    @Test
    void assertEqualsMethod(){
        assertEquals(1,1);
    }

    @Disabled // 특정 테스트 메서드 생략
    @Test
    void failMethod(){
        fail();
    }

    @DisplayName("익셉션 발생 여부 테스트")
    @Test
    void assertThrowsTest(){
        assertThrows(NullPointerException.class, null);
    }

}
