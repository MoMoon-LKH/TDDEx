package com.test.testTdd.chap10.timeOfExcecution;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TestBizClock extends BizClock {
    private LocalDateTime now;

    public TestBizClock() {
        setInstance(this);
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    @Override
    public LocalDateTime timeNow() {
        return  now != null ? now : super.now();
    }
}
