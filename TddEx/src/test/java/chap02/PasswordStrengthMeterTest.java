package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        assertEquals(meter.meter(password), expStr);
    }

    @Test
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){ // 글자 8글자 미만
        assertStrength("ab12!@A", PasswordStrength.NORMAL);

    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){ // 숫자가 없을 경우
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){ // 대문자가 없을 경우
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid(){ // null, 빈값일 경우
        assertStrength("", PasswordStrength.INVALID);
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Week(){ // 글자 수만 만족
        assertStrength("abdefght", PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyNumCriteria_Then_Weak(){ // 숫자 포함만 만족
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){ // 대문자만 만족
        assertStrength("ABCD", PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
