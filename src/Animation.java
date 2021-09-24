import biuoop.DrawSurface;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public interface Animation {
    /**
     * this func does one frame of the animation.
     * @param d :the drawSurface of the frame.
     * */
    void doOneFrame(DrawSurface d);
    /**
     * @return this func returns true if the animation should stop and false otherwise.
     * */
    boolean shouldStop();
}