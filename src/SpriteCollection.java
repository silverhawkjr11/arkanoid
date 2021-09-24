import biuoop.DrawSurface;
import java.util.LinkedList;
import java.util.List;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class SpriteCollection {
    /**
     * this is a setter for sprites.
     * @param sprites1 the new sprites value.
     * */
    public void setSprites(List<Sprite> sprites1) {
        this.sprites = sprites1;
    }

    private List<Sprite> sprites;
    /**
     * @return this func returns our sprite collection.
     * */
    public List<Sprite> getSprites() {
        return sprites;
    }
    /**
     * this is a constructor.
     * */
    public SpriteCollection() {
        sprites = new LinkedList<Sprite>();
    }
    /**
     * this func adds a received sprite to our sprite collection.
     * @param s the new sprite.
     * */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }
    /**
     * call timePassed() on all sprites.
     * */
    public void notifyAllTimePassed() {
        for (int i = 0; i < sprites.size(); i++) {
            Sprite s = sprites.get(i);
            s.timePassed();
        }
    }
    /**
     * call drawOn(d) on all sprites.
     * @param d the drawSurface that we seek to draw our sprites on.
     * */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
    /**
     * this func removes a received sprite from our sprites list.
     * @param s the received sprite.
     * */
    void removeSprite(Sprite s) {
        try {
            this.sprites.remove(s);
        } catch (Exception e) {

        }
    }
}