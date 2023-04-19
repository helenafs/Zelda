package zelda.scenary;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Sprite;

import zelda.Link;
import zelda.Zelda;

public class Lake extends AbstractTile {
    private boolean isPlayerNearby = false;
    private Timer noiseTimer;
    private Sprite lakeSprite;
    private AnimatedSprite lakeRipples;
    private AnimatedSprite lakeGreenRipples;

    public Lake(Zelda game, int x, int y) {
        super(game, x, y, 42, 42);

        lakeSprite = new Sprite(game.getImage("res/sprites/scenery/BGDCSwhite.gif"));
        lakeRipples = new AnimatedSprite(game.getImage("res/sprites/scenery/BGDCSwhite_dot.gif"), 10, 10);
        lakeGreenRipples = new AnimatedSprite(game.getImage("res/sprites/scenery/BGDCSgreen_dot.gif"), 10, 10);

        this.add(lakeSprite);
        this.add(lakeRipples);
        this.add(lakeGreenRipples);

        noiseTimer = new Timer();
        noiseTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isPlayerNearby) {
                    game.playSound("res/sounds/lake_noise.wav");
                }
            }
        }, 0, 5000);
    }

    @Override
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        if (isPlayerNearby) {
            lakeSprite.setImage(game.getImage("res/sprites/scenery/BGDCSgreen.gif"));
            lakeRipples.setActive(false);
            lakeGreenRipples.setActive(true);
        } else {
            lakeSprite.setImage(game.getImage("res/sprites/scenery/BGDCSwhite.gif"));
            lakeRipples.setActive(true);
            lakeGreenRipples.setActive(false);
        }
    }

    public void collided(Sprite sprite) {
        if (sprite instanceof Link) {
            isPlayerNearby = true;
        }
    }

    public Point getTilePosition() {
        return new Point((int) (x / 42), (int) (y / 42));
    }

    public void finish() {
        noiseTimer.cancel();
    }
}
