package com.test.testTdd.chap10.timeOfExcecution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    TestBizClock testClock = new TestBizClock();

    @AfterEach
    void resetClock() {
        testClock.reset();
    }

    @Test
    void notExpired() {
        testClock.setNow(LocalDateTime.of(2019, 1, 1, 13, 0, 0));
        LocalDateTime expiry = LocalDateTime.of(2019, 12, 31, 0, 0, 0);
        Member m = Member.builder()
                .expiredDate(expiry)
                .build();
        assertFalse(m.isExpired());
    }
}
