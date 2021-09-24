/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * this is a constructor.
     * @param game : the game the our listener exists in.
     * @param remainingBalls : the amount of balls in our game.
     * */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        remainingBalls.decrease(1);
        this.game.setRemainingBalls(remainingBalls);
    }
}
