package chap07;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AutoDebitInfo {

    private String userId;
    private String cardNumber;
    private LocalDateTime now;

    public AutoDebitInfo() {

    }


    public AutoDebitInfo(String userId) {
        this.userId = userId;
    }

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime now) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.now = now;
    }

    public void changeCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
