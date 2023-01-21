package com.test.testTdd.chap07.userRegister;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterMockTest {

    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker =
            Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier =
            Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker,
                fakeRepository,
                mockEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        BDDMockito
                // 모의 객체의 checkPasswordWeak 메서드 호출하면 결과로 true 반환
                .given(mockPasswordChecker.checkPasswordWeak("pw"))
                .willReturn(true);

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    @DisplayName("회원 가입 시 암호 검사 수행")
    @Test
    void checkPassword() {
        userRegister.register("id", "pw", "email");
        
        BDDMockito.then(mockPasswordChecker)
                // 특정 메서드가 호출되었는지 확인
                .should()
                .checkPasswordWeak(BDDMockito.anyString());
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendEmail() {
        userRegister.register("id", "pw", "email@email.com");

        // 모의 객체를 메서드 호출할 때 전달한 객체를 담은 기능
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        BDDMockito.then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);

    }
}
