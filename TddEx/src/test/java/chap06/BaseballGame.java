package chap06;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGame {

    private String answer;

    public BaseballGame(String answer) {

        List<Character> list = answer.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toList());
        Set<Character> set = new HashSet<>(list);

        if(list.size() != set.size())
            throw  new IllegalArgumentException();

        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public Score guess(String correct) {
        Score score;

        if(correct.equals(answer)) {
            score = new Score(3, 0);
        } else {
            score = new Score(0, 0);
        }
        return score;
    }
}
