package com.test.testTdd.chap10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// 변수나 필드를 사용해서
public class NoneVariableTest {


    @Test
    void dateFormat() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formatDate(date);
        assertEquals(date.getYear() + "년 " +
                date.getMonthValue() + "월 " +
                date.getDayOfMonth() + "일", dateStr);
    }

    // 기댓값을 바로 표현
    @Test
    void noneVariableDateFormat() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formatDate(date);
        // 복잡하지 않고 기대하는 값도 명확하게 표현이 가능한다
        // 변수를 사용할 때 처럼 메스드 잘못 사용할 일이 X, 테스트가 문제가 있다면 formatDate()만 확인하면 됨
        assertEquals("1945년 8월 15일", dateStr);

    }

    public String formatDate(LocalDate date) {
        return date.getYear() + "년 " +
                date.getMonthValue() + "월 " +
                date.getDayOfMonth() + "일";
    }
}
