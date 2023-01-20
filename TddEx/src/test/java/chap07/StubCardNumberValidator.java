package chap07;

import lombok.Data;
import org.junit.jupiter.api.Test;

@Data
public class StubCardNumberValidator extends CardNumberValidator {

    private String invalidNo;
    private String theftNo;

    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }

        if (theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.THEFT;
        }

        return CardValidity.VALID;
    }

}
