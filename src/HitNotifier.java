/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl the new HitListener.
     * */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl : the HitListener which we wish to remove.
     * */
    void removeHitListener(HitListener hl);
}
