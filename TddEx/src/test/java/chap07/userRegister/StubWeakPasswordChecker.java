package chap07.userRegister;

import lombok.Data;

@Data
public class StubWeakPasswordChecker implements WeakPasswordChecker {

    private boolean weak;

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}
