package chap07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap07.CardValidity.*;
import static org.junit.jupiter.api.Assertions.*;

public class AutoDebitRegister_Sub_Test {
    
    /*
    * stub는 실제 검증 기능을 구현 X 대신 단순한 구현으로 실제 구현 대체
    * */

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        stubValidator.setTheftNo("12345678");

        AutoDebitReq req = new AutoDebitReq("user1", "12345678");
        RegisterResult result = this.register.register(req);

        assertEquals(THEFT, result.getValidity());
    }

    
}
