package chap07;

import lombok.experimental.StandardException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap07.CardValidity.*;
import static org.junit.jupiter.api.Assertions.*;

public class AutoDebitRegisterTest {
    
    /*
        대역이 필요한 시점
        - 외부요인으로 인해 테스트 하기 어려운 경우
         ㄴ 테스트 대상에서 파일 사용 
         ㄴ DB로부터 데이터를 조회 및 데이터 추가
         ㄴ 외부의 HTTP 서버와 통신할 필요가 있을 경우
         
         대역 - 해당 외부 요인 대체 요소
         
         종류
         - 스텁
         - 가짜
         - 스파이
         - 모의 객체 
    */

    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(validator, repository);
    }

    @Test
    void validCard() {
        //업체에서 받은 테스트용 유효한 카드번호사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);
        assertEquals(VALID, result.getValidity());
    }

    @Test
    void theftCard() {
        AutoDebitReq req = new AutoDebitReq("user1", "123456799");
        RegisterResult result = this.register.register(req);
        assertEquals(THEFT, result.getValidity());
    }


}
