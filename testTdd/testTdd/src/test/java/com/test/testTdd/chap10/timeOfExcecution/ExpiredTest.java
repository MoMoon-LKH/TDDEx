package com.test.testTdd.chap10.timeOfExcecution;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiredTest {

    @Test
    @Disabled
    // 실행시점이 고정된 경우
    void notExpiredWrong() {
        LocalDateTime expiry = LocalDateTime.of(2023, 12, 31, 0, 0, 0);
        Member m = Member.builder()
                .expiredDate(expiry)
                .build();
        assertFalse(m.isExpiredWrong());
    }

    @Test
    void notExpired() {
        LocalDateTime expiry = LocalDateTime.of(2019, 12, 31, 0, 0, 0);
        Member m = Member.builder()
                .expiredDate(expiry)
                .build();
        assertFalse(m.passedExpiryDate(LocalDateTime.of(2019, 12, 30, 0, 0, 0)));
    }

    @Test
    void expired_Only_1ms() {
        LocalDateTime expiry = LocalDateTime.of(2019, 12, 31, 0, 0, 0);
        Member m = Member.builder()
                .expiredDate(expiry)
                .build();
        assertTrue(m.passedExpiryDate(LocalDateTime.of(2019, 12, 31, 0, 0, 0, 1000000)));
    }


}
