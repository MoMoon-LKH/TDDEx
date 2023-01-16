package chap06;

public class Score {

    private int strikes;
    private int balls;


    public Score(int strikes, int balls){
        this.strikes = strikes;
        this.balls = balls;
    }

    public int balls() {
        return balls;
    }

    public int strikes() {
        return strikes;
    }
}
