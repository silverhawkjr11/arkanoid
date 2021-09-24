/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * this is a constructor.
     * @param scoreCounter : the counter for our score in the game.
     * */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * this func increases the score by 5 whenever its called.
     * @param hitter : the ball that hit the block.
     * @param beingHit : the block that was hit.
     * */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}
