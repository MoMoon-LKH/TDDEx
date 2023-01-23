package com.test.testTdd.chap10.timeOfExcecution;

import lombok.Builder;
import lombok.Data;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Member {
    private LocalDateTime expiredDate;

    public boolean isExpiredWrong() {
        return expiredDate.isBefore(LocalDateTime.now());
    }

    public boolean passedExpiryDate(LocalDateTime time) {
        return expiredDate.isBefore(time);
    }

    public boolean isExpired() {
        return expiredDate.isBefore(BizClock.now());
    }
}
