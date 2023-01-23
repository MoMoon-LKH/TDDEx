package com.test.testTdd.chap10.timeOfExcecution;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
// 시간 클래스
public class BizClock {
    private static BizClock DEFAULT = new BizClock();
    private static BizClock instance = DEFAULT;

    public static void reset() {
        instance = DEFAULT;
    }

    public static LocalDateTime now() {
        return instance.timeNow();
    }

    public LocalDateTime timeNow() {
        return LocalDateTime.now();
    }

    public void setInstance(BizClock clock) {
        instance = clock;
    }
}
