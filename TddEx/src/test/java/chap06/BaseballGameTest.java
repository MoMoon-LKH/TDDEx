package chap06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {

    private BaseballGame game;

    @BeforeEach
    void givenGame(){
        game = new BaseballGame("456");
    }

    @Test
    void exactMatch() {
//        //정답이 456인 상황
//        BaseballGame game = new BaseballGame("456");
        //실행
        Score score = game.guess("456");
        //결과확인
        assertEquals(3, score.strikes());
        assertEquals(0, score.balls());
    }

    @Test
    void noMatch() {
//        //정답이 123인 상황
//        BaseballGame game = new BaseballGame("123");
        //실행
        Score score = game.guess("456");
        //결과확인
        assertEquals(0, score.strikes());
        assertEquals(0, score.balls());
    }

    @Test
    void genGame_with_DupNumber_Then_Fail() {
        assertThrows(IllegalArgumentException.class,
                () -> new BaseballGame("110"));
    }
}
