package chap07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResult {

    CardValidity validity;

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(CardValidity.VALID);
    }
}
