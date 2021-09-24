/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param hitter : the ball that hit the block.
     * @param beingHit : the block that we hit.
     * */
    void hitEvent(Block beingHit, Ball hitter);
}

