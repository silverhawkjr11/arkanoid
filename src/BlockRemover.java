/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * this is a constructor.
     * @param game : the game the our listener exists in.
     * @param removedBlocks : the amount of balls in our game.
     * */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;

    }

    /**
     * this func removes our block from our game when its called.
     * @param hitter : the ball that hit our block.
     * @param beingHit : the block that was hit.
     * */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBlocks.decrease(1);
        this.game.setRemainingBlocks(remainingBlocks);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
    }
}
