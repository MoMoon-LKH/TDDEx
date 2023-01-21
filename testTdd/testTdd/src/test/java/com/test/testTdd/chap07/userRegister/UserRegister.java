package com.test.testTdd.chap07.userRegister;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegister {

    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker checker) {
        this.passwordChecker = checker;
    }

    public UserRegister(WeakPasswordChecker checker, UserRepository userRepository) {
        this.passwordChecker = checker;
        this.userRepository = userRepository;
    }

    public void register(String id, String pw, String email) {
        if(passwordChecker.checkPasswordWeak(pw))
            throw new WeakPasswordException();

        User user = userRepository.findById(id);

        if (user != null) {
            throw new DupIdException();
        }

        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }

}
